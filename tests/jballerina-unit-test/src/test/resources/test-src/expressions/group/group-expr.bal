type PersonObj object {
    public int age = 20;
    public string name = "Person Name";

    function getName() returns string {
        return self.name;
    }

    function getAge() returns int {
        return self.age;
    }
};

type PersonRec record {
    int age;
    string name;
};

function getIntMap() returns map<int> {
    map<int> dataMap = {
        "a": 1,
        "b": 2,
        "c": 3
    };
    return dataMap;
}

function getIntArray() returns int[] {
    int[] intArray = [1, 2, 3];
    return intArray;
}

function testGroupedMapRef() returns boolean {
    map<int> dataMap = getIntMap();
    int a = <int> (dataMap)["a"];
    return a == (getIntMap())["a"];
}

function testGroupedArrayRef() returns boolean {
    int[] intArray = getIntArray();
    int a = (intArray)[1];
    return a == (getIntArray())[1];
}

function testGroupedFieldVariableRef() returns boolean {
    PersonObj po = new;
    PersonRec pr = {age: 20, name: "Person Name"};
    return pr.name === (pr).name && po.name === (po).name;
}

function testGroupedQuotedStringRef() returns boolean {
    return "string value".toUpperAscii() == ("string value").toUpperAscii();
}

function testGroupedInvocationRef() returns boolean {
    PersonObj p = new;
    return p.getName() === (p).getName();
}

function testGroupedTypeDescRef() returns boolean {
    map<anydata> personData = {
        "age": 20,
        "name": "Person Name"
    };
    PersonRec p1 = <PersonRec>PersonRec.constructFrom(personData);
    PersonRec p2 = <PersonRec>(PersonRec).constructFrom(personData);
    return p1 == p2;
}

type Foo record {|
    string s;
|};

type Bar record {|
    float f;
|};

function testGroupedTypedescLibInvocation() returns boolean {
    map<anydata> data= { s: "test string" };
    Foo|Bar|error f = (Foo|Bar).constructFrom(data);
    return f is Foo && f.s == data["s"];
}

// isNaN() invocation on (0.0/0.0) expression is not supported yet.
function testGroupedBuiltInInvocationRef() returns boolean {
    float f = 0.0/0.0;
    return f.isNaN() && (f).isNaN(); // && (0.0/0.0).isNaN();
}

// function testGroupedLangLibInvocationRef() returns boolean {
//     string x = "value";
//     return (("string " + x)).length() == 12;
// }

// function testNestedGroupedInvocationRef() returns boolean {
//     PersonObj p = new;
//     map<PersonObj> dataMap = {"a": p};
//     return p.getName() === (<PersonObj>(dataMap)["a"]).getName();
// }
