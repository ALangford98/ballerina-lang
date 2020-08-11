/*
 * Copyright (c) 2020, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ballerinalang.formatter.core;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Test formatting for actions.
 *
 * @since 2.0.0
 */
public class ActionsTest {

    private void testFile(String path, String filePath) throws IOException {
        FormatterTestUtils.test(Paths.get("actions/", path), Paths.get("actions/", filePath));
    }

    @Test(description = "Test the formatting of checking actions")
    public void testCheckingActions() throws IOException {
        testFile("source/checking-actions.bal", "expected/checking-actions.bal");
    }

    @Test(description = "Test the formatting of flush actions")
    public void testFlushActions() throws IOException {
        testFile("source/flush-actions.bal", "expected/flush-actions.bal");
    }

    @Test(description = "Test the formatting of query actions")
    public void testQueryActions() throws IOException {
        testFile("source/query-actions.bal", "expected/query-actions.bal");
    }

    @Test(description = "Test the formatting of receive actions")
    public void testReceiveActions() throws IOException {
        testFile("source/receive-actions.bal", "expected/receive-actions.bal");
    }

    @Test(description = "Test the formatting of send actions")
    public void testSendActions() throws IOException {
        testFile("source/send-actions.bal", "expected/send-actions.bal");
    }

    @Test(description = "Test the formatting of start actions")
    public void testStartActions() throws IOException {
        testFile("source/start-actions.bal", "expected/start-actions.bal");
    }

    @Test(description = "Test the formatting of trap actions")
    public void testTrapActions() throws IOException {
        testFile("source/trap-actions.bal", "expected/trap-actions.bal");
    }

    @Test(description = "Test the formatting of wait actions")
    public void testWaitActions() throws IOException {
        testFile("source/wait-actions.bal", "expected/wait-actions.bal");
    }

    @Test(description = "Test the formatting of type cast actions")
    public void testTypeCastActions() throws IOException {
        testFile("source/type-cast-actions.bal", "expected/type-cast-actions.bal");
    }

    @Test(description = "Test the formatting of remote method call actions")
    public void testRemoteMethodCallActions() throws IOException {
        testFile("source/remote-method-call-actions.bal", "expected/remote-method-call-actions.bal");
    }
}
