# Represents a point in a 2D coordinate system.
#
# + x - The x-coordinate of the point.
# + y - The y-coordinate of the point.
public type Point record {|
    int x;
    int y;
|};

# Represents a rectangle with its top-left corner coordinates, width, and height.
#
# + topLeftX - The x-coordinate of the top-left corner of the rectangle
# + topLeftY - The y-coordinate of the top-left corner of the rectangle
# + width - The width of the rectangle
# + height - The height of the rectangle
public type Rectangle record {|
    int topLeftX;
    int topLeftY;
    int width;
    int height;
|};
