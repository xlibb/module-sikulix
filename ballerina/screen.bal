import ballerina/jballerina.java;

# Represents represents the entire monitor which operates on the entire visible screen area.
public class Screen {

    # Initializes the `Screen` object.
    public isolated function init() {
        self.createScreen();
    }

    # Creates a new `Screen` object.
    private isolated function createScreen() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Clicks on the center of the Screen.
    public isolated function click() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Clicks on the center of the Screen twice.
    public isolated function doubleClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Right clicks on the center of the Screen.
    public isolated function rightClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Drags the mouse from the current location to the center of the Screen.
    public isolated function hover() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Drags an element from one location to another inside the corresponding `Screen`.
    # 
    # + imagePath1 - The path to the image of the element to be dragged.
    # + imagePath2 - The path to the image of the location to drop the element.
    # + return - Returns `()` is successful, otherwise returns `Error`.
    public isolated function dragDrop(string imagePath1, string imagePath2) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Checks whether the given image exists in the `Screen`.
    # 
    # + imagePath - The path to the image to be checked.
    # + return - Returns `true` if the image exists, otherwise returns `false`.
    public isolated function exists(string imagePath) returns boolean = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Press and hold the given key.
    # 
    # + key - The key to be pressed.
    public isolated function keyDown(string key) = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Release the given key.
    # 
    # + key - The key to be released.
    public isolated function keyUp(string key) = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Types the given string.
    #
    # + value - The string to be typed.
    public isolated function 'type(string value) = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Scrolls the mouse wheel.
    # 
    # + direction - The direction of the scroll. 1 for scrolling down and 0 for scrolling up.
    # + noOfSteps - The number of steps to scroll.
    # + return - Returns `Error` if an error occurs while scrolling.
    public isolated function wheel(int direction, int noOfSteps) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Checks whether the given text exists in the `Screen`.
    # 
    # + text - The text to be checked.
    # + return - Returns `true` if the text exists, otherwise returns `false`.
    public isolated function existsText(string text) returns boolean = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the location of the bottom-left corner of the `Screen`.
    #
    # + return - Returns `Location` object represents bottom-left corner of the `Screen`.
    public isolated function getBottomLeft() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the location of the bottom-right corner of the `Screen`.     
    # 
    # + return - Returns `Location` object represents bottom-right corner of the `Screen`.
    public isolated function getBottomRight() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the location of the top-left corner of the `Screen`.
    # 
    # + return - Returns `Location` object represents top-left corner of the `Screen`.
    public isolated function getTopLeft() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the location of the top-right corner of the `Screen`.
    # 
    # + return - Returns `Location` object represents top-right corner of the `Screen`.
    public isolated function getTopRight() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the location of the center of the `Screen`.
    # 
    # + return - Returns `Location` object represents center of the `Screen`.
    public isolated function getCenter() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the height of the `Screen`.  
    # 
    # + return - Returns `int` represents the height of the `Screen`.
    public isolated function getH() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixScreen"
    } external;

    # Returns the width of the `Screen`.
    # 
    # + return - Returns `int` represents the width of the `Screen`.
    public isolated function getW() returns int = @java:Method {
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