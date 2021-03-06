/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.langlib.string;

import org.ballerinalang.jvm.api.BErrorCreator;
import org.ballerinalang.jvm.api.BStringUtils;

/**
 * Extern function lang.string:startsWith(string, string).
 *
 * @since 1.0
 */
public class FromCodePointInt {

    public static Object fromCodePointInt(long codePoint) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.appendCodePoint(((Long) codePoint).intValue());
            return BStringUtils.fromString(builder.toString());
        } catch (IllegalArgumentException e) {
            return BErrorCreator.createError(BStringUtils.fromString("Invalid codepoint: " + codePoint));
        }
    }
}
