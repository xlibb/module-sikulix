// Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).

// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied. See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/jballerina.java;

# Represents the result of a successful find operation.
public class Match {

    # Clicks on the element represents by `Match` object.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function click() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Clicks on the element represents by `Match` object. twice.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function doubleClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Right clicks on the element represents by `Match` object.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function rightClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Drags the mouse from the current location to the given element represents by `Match` object.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function hover() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Types the given string at the location.
    #
    # + value - The string to be typed.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function 'type(string value) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the text of the element represents by `Match` object.
    #
    # + return - Returns `string` represents the text of the element if operation successful, otherwise returns `Error`.
    public isolated function getText() returns string|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the bottom-left corner.
    #
    # + return - Returns `int` represents X coordinate of the bottom-left corner if operation successful, otherwise returns `Error`.
    public isolated function getBottomLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the bottom-left corner.
    #
    # + return - Returns `int` represents Y coordinate of the bottom-left corner if operation successful, otherwise returns `Error`.
    public isolated function getBottomLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the bottom-right corner.
    #
    # + return - Returns `int` represents X coordinate of the bottom-right corner if operation successful, otherwise returns `Error`.
    public isolated function getBottomRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the bottom-right corner.
    #
    # + return - Returns `int` represents Y coordinate of the bottom-right corner if operation successful, otherwise returns `Error`.
    public isolated function getBottomRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the top-left corner.
    #
    # + return - Returns `int` represents X coordinate of the top-left corner if operation successful, otherwise returns `Error`.
    public isolated function getTopLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the top-left corner.
    #
    # + return - Returns `int` represents Y coordinate of the top-left corner if operation successful, otherwise returns `Error`.
    public isolated function getTopLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the top-right corner.
    #
    # + return - Returns `int` represents X coordinate of the top-right corner if operation successful, otherwise returns `Error`.
    public isolated function getTopRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the top-right corner.
    #
    # + return - Returns `int` represents Y coordinate of the top-right corner if operation successful, otherwise returns `Error`.
    public isolated function getTopRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the center.
    #
    # + return - Returns `int` represents X coordinate of the center if operation successful, otherwise returns `Error`.
    public isolated function getCenterX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the center.
    #
    # + return - Returns `int` represents Y coordinate of the center if operation successful, otherwise returns `Error`.
    public isolated function getCenterY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;
}
