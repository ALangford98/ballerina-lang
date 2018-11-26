function testNullInForkJoin () returns (string, string)|error {
    string m = "";
    fork {
        worker foo {
            string resp1 = "";
            resp1 -> fork;
        }

        worker bar {
            string resp2 = "";
            resp2 -> fork;
        }
    } join (all) (map<any> allReplies) {
        any[] temp;
        temp = check <any[]> allReplies.foo;
        string m1;
        m1 = <string> temp[0];
        temp = check <any[]> allReplies.bar;
        string m2;
        m2 = <string> temp[0];
        return (m1,m2);
    } timeout (30000) (map<any> msgs) {

    }
}