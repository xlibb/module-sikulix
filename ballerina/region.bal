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

// remove exists ------------------------------------------------------------- done
// replace region init arguments to record ----------------------------------- done
// replace location init arguments to record --------------------------------- done
// change keys to enum ------------------------------------------------------- done
// change docs when find -> if multiple elements returns first one
// update build.gradle for libs instead connectors --------------------------- done
// update workflows ---------------------------------------------------------- done
// error handling
// add testing
// App class

# Represents a rectangular area on a Screen.
public class Region {

    # Initializes the `Region` object.
    #
    # + rectangle - The rectangle that defines the region.
    public isolated function init(Rectangle rectangle) returns Error? {
        check self.createRegion(rectangle);
    }
    
    private isolated function createRegion(Rectangle rectangle) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Clicks on the center of the Region.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function click() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Clicks on the center of the Region twice.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function doubleClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Right clicks on the center of the Region.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function rightClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Drags the mouse from the current location to the center of t
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.he Region.
    public isolated function hover() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Drags an element from one location to another inside the corresponding `Region`.
    #
    # + imagePath1 - The path to the image of the element to be dragged.
    # + imagePath2 - The path to the image of the location to drop the element.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function dragDrop(string imagePath1, string imagePath2) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Checks whether the given image exists in the `Region`.
    #
    # + imagePath - The path to the image to be checked.
    # + return - Returns `boolean` if operation successful, otherwise returns `Error`    
    public isolated function exists(string imagePath) returns boolean|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Press and hold the given key.
    #
    # + key - The key to be pressed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyDown(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Release the given key.
    #
    # + key - The key to be released.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyUp(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Press the given key.
    #
    # + key - The key to be pressed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function keyPress(Key key) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Types the given string.
    #
    # + value - The string to be typed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function 'type(string value) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Scrolls the mouse wheel.
    #
    # + direction - The direction of the scroll. 1 for scrolling down and 0 for scrolling up.
    # + noOfSteps - The number of steps to scroll.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function wheel(int direction, int noOfSteps) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Checks whether the given text exists in the `Region`.
    #
    # + text - The text to be checked.
    # + return - Returns `boolean` if operation successful, otherwise returns `Error`.  
    public isolated function existsText(string text) returns boolean|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the X coordinate of the bottom-left corner of the `Region`.
    #
    # + return - Returns `int` represents X coordinate of the bottom-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the Y-coordinate of the bottom-left corner of the `Region`.
    #
    # + return - Returns `int` represents Y-coordinate of the bottom-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the X-coordinate of the bottom-right corner of the `Region`.
    #
    # + return - Returns `int` represents X-coordinate of the bottom-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the Y-coordinate of the bottom-right corner of the `Region`.
    #
    # + return - Returns `int` represents Y-coordinate of the bottom-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getBottomRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the X-coordinate of the top-left corner of the `Region`.
    #
    # + return - Returns `int` represents X-coordinate of the top-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopLeftX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the Y-coordinate of the top-left corner of the `Region`.
    #
    # + return - Returns `int` represents Y-coordinate of the top-left corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopLeftY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the X-coordinate of the top-right corner of the `Region`.
    #
    # + return - Returns `int` represents X-coordinate of the top-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopRightX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the Y-coordinate of the top-right corner of the `Region`.
    #
    # + return - Returns `int` represents Y-coordinate of the top-right corner if successful,
    # otherwise returns `Error`.
    public isolated function getTopRightY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the X-coordinate of the center of the `Region`.
    #
    # + return - Returns `int` represents X-coordinate of the center.
    public isolated function getCenterX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the Y-coordinate of the center of the `Region`.
    #
    # + return - Returns `int` represents Y-coordinate of the center if operation successful, otherwise returns `Error`    
    public isolated function getCenterY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the height of the `Region`.  
    #
    # + return - Returns `int` represents the height of the `Region` if operation successful, otherwise returns `Error`    
    public isolated function getH() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the width of the `Region`.
    #
    # + return - Returns `int` represents the width of the `Region` if operation successful, otherwise returns `Error`    
    public isolated function getW() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the text inside the region.
    #
    # + return - Returns `string` represents the text if operation successful, otherwise returns `Error`    
    public isolated function getText() returns string|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the `Match` object similar to an image within the `Region`.
    #
    # + imagePath - The path to the image to be found.
    # + return - Returns `Match` object if the image found, otherwise returns `Error`.
    public isolated function find(string imagePath) returns Match|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns the `Match` object similar to a text within the `Region`.
    #
    # + text - The text to be found.
    # + return - Returns `Match` object if the text found, otherwise returns `Error`.
    public isolated function findText(string text) returns Match|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

    # Returns an array of `Match` objects similar to image within the `Region`.
    #
    # + imagePath - The path to the image to be found.
    # + return - Returns an array of `Match` objects if the image found, otherwise returns `Error`.
    public isolated function findAll(string imagePath) returns Match[]|Error = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixRegion"
    } external;

}
