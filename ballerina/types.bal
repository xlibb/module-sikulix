// Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).

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
