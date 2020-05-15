/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerinalang.compiler.syntax.tree;

import io.ballerinalang.compiler.internal.parser.tree.STNode;

/**
 * This is a generated syntax tree node.
 *
 * @since 1.3.0
 */
public class TableConstructorExpressionNode extends ExpressionNode {

    public TableConstructorExpressionNode(STNode internalNode, int position, NonTerminalNode parent) {
        super(internalNode, position, parent);
    }

    public Token tableKeyword() {
        return childInBucket(0);
    }

    public KeySpecifierNode KeySpecifier() {
        return childInBucket(1);
    }

    public Token openBracket() {
        return childInBucket(2);
    }

    public SeparatedNodeList<Node> mappingConstructors() {
        return new SeparatedNodeList<>(childInBucket(3));
    }

    public Token closeBracket() {
        return childInBucket(4);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T apply(NodeTransformer<T> visitor) {
        return visitor.transform(this);
    }

    @Override
    protected String[] childNames() {
        return new String[]{
                "tableKeyword",
                "KeySpecifier",
                "openBracket",
                "mappingConstructors",
                "closeBracket"};
    }

    public TableConstructorExpressionNode modify(
            Token tableKeyword,
            KeySpecifierNode KeySpecifier,
            Token openBracket,
            SeparatedNodeList<Node> mappingConstructors,
            Token closeBracket) {
        if (checkForReferenceEquality(
                tableKeyword,
                KeySpecifier,
                openBracket,
                mappingConstructors.underlyingListNode(),
                closeBracket)) {
            return this;
        }

        return NodeFactory.createTableConstructorExpressionNode(
                tableKeyword,
                KeySpecifier,
                openBracket,
                mappingConstructors,
                closeBracket);
    }
}
