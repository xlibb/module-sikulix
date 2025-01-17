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

# Represents represents the entire monitor which operates on the entire visible screen area.
public class Screen {

    # Initializes the `Screen` object.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function init() returns Error? {
        check self.createScreen();
    }

    private isolated function createScreen() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Clicks on the center of the `Screen`.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function click() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Clicks on the center of the Screen twice.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function doubleClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Right clicks on the center of the `Screen`.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function rightClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Drags the mouse from the current location to the center of the `Screen`.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function hover() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Drags an element from one location to another inside the corresponding `Screen`.
    #
    # + imagePath1 - The path to the image of the element to be dragged.
    # + imagePath2 - The path to the image of the location to drop the element.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function dragDrop(string imagePath1, string imagePath2) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Press and hold the given key.
    #
    # + key - The key to be pressed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyDown(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Release the given key.
    #
    # + key - The key to be released.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyUp(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Press the given key.
    #
    # + key - The key to be pressed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyPress(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Types the given string.
    #
    # + value - The string to be typed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function 'type(string value) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Scrolls the mouse wheel.
    #
    # + direction - The direction of the scroll. 1 for scrolling down and 0 for scrolling up.
    # + noOfSteps - The number of steps to scroll.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function wheel(int direction, int noOfSteps) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Checks whether the given image exists in the `Screen`.
    #
    # + imagePath - The path to the image to be checked.
    # + return - Returns `boolean` if operation successful, otherwise returns `Error`. 
    public isolated function exists(string imagePath) returns boolean|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Checks whether the given text exists in the `Screen`.
    #
    # + text - The text to be checked.
    # + return - Returns `boolean` if operation successful, otherwise returns `Error`. 
    public isolated function existsText(string text) returns boolean|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the X coordinate of the bottom-left corner of the `Screen`.
    #
    # + return - Returns `int` represents X coordinate of the bottom-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the Y-coordinate of the bottom-left corner of the `Screen`.
    #
    # + return - Returns `int` represents Y-coordinate of the bottom-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the X-coordinate of the bottom-right corner of the `Screen`.
    #
    # + return - Returns `int` represents X-coordinate of the bottom-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the Y-coordinate of the bottom-right corner of the `Screen`.
    #
    # + return - Returns `int` represents Y-coordinate of the bottom-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the X-coordinate of the top-left corner of the `Screen`.
    #
    # + return - Returns `int` represents X-coordinate of the top-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the Y-coordinate of the top-left corner of the `Screen`.
    #
    # + return - Returns `int` represents Y-coordinate of the top-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the X-coordinate of the top-right corner of the `Screen`.
    #
    # + return - Returns `int` represents X-coordinate of the top-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the Y-coordinate of the top-right corner of the `Screen`.
    #
    # + return - Returns `int` represents Y-coordinate of the top-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the X-coordinate of the center of the `Screen`.
    #
    # + return - Returns `int` represents X-coordinate of the center if successful,
    # otherwise returns `Error`.
    public isolated function getCenterX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the Y-coordinate of the center of the `Screen`.
    #
    # + return - Returns `int` represents Y-coordinate of the center if successful,
    # otherwise returns `Error`.
    public isolated function getCenterY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the `Match` object similar to an image within the `Screen`.
    #
    # + imagePath - The path to the image to be found.
    # + return - Returns `Match` object if the image found, otherwise returns `Error`.
    public isolated function find(string imagePath) returns Match|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the `Match` object similar to a text within the `Screen`.
    #
    # + text - The text to be found.
    # + return - Returns `Match` object if the text found, otherwise returns `Error`.
    public isolated function findText(string text) returns Match|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns an array of `Match` objects similar to image within the `Screen`.
    #
    # + imagePath - The path to the image to be found.
    # + return - Returns an array of `Match` objects if the image found, otherwise returns `Error`.
    public isolated function findAll(string imagePath) returns Match[]|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

}
