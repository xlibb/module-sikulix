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

    # Returns the location of the bottom-left corner of the element represented by the `Match` object.
    #
    # + return - Returns `Location` object represents bottom-left corner of the element.
    public isolated function getBottomLeft() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the location of the bottom-right corner of the element represented by the `Match` object.     
    # 
    # + return - Returns `Location` object represents bottom-right corner of the element.
    public isolated function getBottomRight() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the location of the top-left corner of the element represented by the `Match` object.
    # 
    # + return - Returns `Location` object represents top-left corner of the element.
    public isolated function getTopLeft() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the location of the top-right corner of the element represented by the `Match` object.
    # 
    # + return - Returns `Location` object represents top-right corner of the element.
    public isolated function getTopRight() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the location of the center of the element represented by the `Match` object.
    # 
    # + return - Returns `Location` object represents center of the element.
    public isolated function getCenter() returns Location = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the height of the element represented by the `Match` object.  
    # 
    # + return - Returns `int` represents the height of the element.
    public isolated function getH() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

    # Returns the width of the element represented by the `Match` object.
    # 
    # + return - Returns `int` represents the width of the element.
    public isolated function getW() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixMatch"
    } external;

}
