import ballerina/jballerina.java;

# Represents a location on the screen.
public class Location {

    # Initializes the Location object with the given x and y coordinates.
    #
    # Represents a point in a 2D space.
    #
    # + point - The coordinates of the location.
    public isolated function init(Point point) {
        self.createLocation(point);
    }

    # Creates a new location object.
    #
    # + point - The coordinates of the location.
    private isolated function createLocation(Point point) = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Clicks on the Location.
    public isolated function click() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Clicks on the Location twice.
    public isolated function doubleClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Right clicks on the Location.
    public isolated function rightClick() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Drags the mouse from the current location to the given location.
    public isolated function hover() = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Returns the x-coordinate of the location.
    # 
    # + return - Returns `int` x-coordinate of the location.
    public isolated function getX() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Returns the y-coordinate of the location.
    # 
    # + return - Returns `int` y-coordinate of the location.
    public isolated function getY() returns int = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Types the given string at the location.
    # 
    # + value - The string to be typed.
    # + return - Returns `Error` if an error occurs while typing, Otherwise returns `()`.
    public isolated function 'type(string value) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

    # Scrolls the mouse wheel.
    # 
    # + direction - The direction of the scroll. 1 for scrolling down and 0 for scrolling up.
    # + noOfSteps - The number of steps to scroll.
    # + return - Returns `Error` if an error occurs while scrolling, Otherwise returns `()`.
    public isolated function wheel(int direction, int noOfSteps) returns Error? = @java:Method {
        'class: "io.ballerina.lib.sikulix.SikulixLocation"
    } external;

}
