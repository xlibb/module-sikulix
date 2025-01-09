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
    public isolated function click() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Clicks on the element represents by `Match` object. twice.
    public isolated function doubleClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Right clicks on the element represents by `Match` object.
    public isolated function rightClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Drags the mouse from the current location to the given element represents by `Match` object.
    public isolated function hover() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Types the given string at the location.
    #
    # + value - The string to be typed.
    public isolated function 'type(string value) = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the text of the element represents by `Match` object.
    #
    # + return - Returns `string` represents the text of the element.
    public isolated function getText() returns string = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the bottom-left corner.
    #
    # + return - Returns `int` represents X coordinate of the bottom-left corner.
    public isolated function getBottomLeftX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the bottom-left corner.
    #
    # + return - Returns `int` represents Y coordinate of the bottom-left corner.
    public isolated function getBottomLeftY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the bottom-right corner.
    #
    # + return - Returns `int` represents X coordinate of the bottom-right corner.
    public isolated function getBottomRightX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the bottom-right corner.
    #
    # + return - Returns `int` represents Y coordinate of the bottom-right corner.
    public isolated function getBottomRightY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the top-left corner.
    #
    # + return - Returns `int` represents X coordinate of the top-left corner.
    public isolated function getTopLeftX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the top-left corner.
    #
    # + return - Returns `int` represents Y coordinate of the top-left corner.
    public isolated function getTopLeftY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the top-right corner.
    #
    # + return - Returns `int` represents X coordinate of the top-right corner.
    public isolated function getTopRightX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the top-right corner.
    #
    # + return - Returns `int` represents Y coordinate of the top-right corner.
    public isolated function getTopRightY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the X coordinate of the center.
    #
    # + return - Returns `int` represents X coordinate of the center.
    public isolated function getCenterX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the Y coordinate of the center.
    #
    # + return - Returns `int` represents Y coordinate of the center.
    public isolated function getCenterY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;
}
