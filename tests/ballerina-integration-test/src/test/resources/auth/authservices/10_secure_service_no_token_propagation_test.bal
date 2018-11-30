import ballerina/http;
import ballerina/io;

// token propagation is set to false by default
http:AuthProvider basicAuthProvider10 = {
    scheme:"basic",
    authStoreProvider:"config"
};

listener http:Listener listener10_1 = new(9190, config = {
    authProviders:[basicAuthProvider10],
    secureSocket: {
        keyStore: {
            path: "${ballerina.home}/bre/security/ballerinaKeystore.p12",
            password: "ballerina"
        }
    }
});

// client will not propagate JWT
http:Client nyseEP = new( "https://localhost:9195");

@http:ServiceConfig {basePath:"/passthrough"}
service passthroughService on listener10_1 {

    @http:ResourceConfig {
        methods:["GET"],
        path:"/"
    }
    resource function passthrough(http:Caller caller, http:Request clientRequest) {
        var response = nyseEP -> get("/nyseStock/stocks", message = untaint clientRequest);
        if (response is http:Response) {
                _ = caller -> respond(response);
        } else if (response is error) {
                http:Response errorResponse = new;
                json errMsg = {"error":"error occurred while invoking the service"};
                errorResponse.setJsonPayload(errMsg);
                _ = caller -> respond(errorResponse);
        }
    }
}

http:AuthProvider jwtAuthProvider10 = {
    scheme: "jwt",
    issuer: "ballerina",
    audience: "ballerina",
    certificateAlias: "ballerina",
    trustStore: {
        path: "${ballerina.home}/bre/security/ballerinaTruststore.p12",
        password: "ballerina"
    }
};

listener http:Listener listener10_2 = new(9195, config = {
    authProviders:[jwtAuthProvider10],
    secureSocket: {
        keyStore: {
            path: "${ballerina.home}/bre/security/ballerinaKeystore.p12",
            password: "ballerina"
        }
    }
});

@http:ServiceConfig {basePath:"/nyseStock"}
service nyseStockQuote on listener10_2 {

    @http:ResourceConfig {
        methods:["GET"],
        path:"/stocks"
    }
    resource function stocks (http:Caller caller, http:Request clientRequest) {
        http:Response res = new;
        json payload = {"exchange":"nyse", "name":"IBM", "value":"127.50"};
        res.setJsonPayload(payload);
        _ = caller -> respond(res);
    }
}
