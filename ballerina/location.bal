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

# Represents a location on the screen.
public class Location {

    # Initializes the Location object with the given x and y coordinates.
    # + point - The coordinates of the location.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function init(Point point) returns Error? {
        check self.createLocation(point);
    }

    private isolated function createLocation(Point point) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Clicks on the Location.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function click() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Clicks on the Location twice.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function doubleClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Right clicks on the Location.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function rightClick() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Drags the mouse from the current location to the given location.
    # 
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function hover() returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Returns the x-coordinate of the location.
    #
    # + return - Returns `int` x-coordinate of the location.
    public isolated function getX() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Returns the y-coordinate of the location.
    #
    # + return - Returns `int` y-coordinate of the location.
    public isolated function getY() returns int|Error= @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Types the given string at the location.
    #
    # + value - The string to be typed.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function 'type(string value) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Scrolls the mouse wheel.
    #
    # + direction - The direction of the scroll. 1 for scrolling down and 0 for scrolling up.
    # + noOfSteps - The number of steps to scroll.
    # + return - Returns `()` if operation successful, otherwise returns `Error`.
    public isolated function wheel(int direction, int noOfSteps) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

}
