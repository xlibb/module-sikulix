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

package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.Utils;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.List;

import static io.ballerina.lib.sikulix.SikulixLocation.getLocation;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchArrayType;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchBObject;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchBObjectArr;

/**
 * Provide APIs to interact with a rectangular area within a Screen.
 *
 * @since 0.1.0
 */
public class SikulixRegion {
    private static final String REGION_OBJECT = "nativeRegionObject";

    public static Object createRegion(BObject bRegion, BMap<BString, Object> rectangle) {
        try {
            int x = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftX")));
            int y = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftY")));
            int w = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("width")));
            int h = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("height")));
            bRegion.addNativeData(REGION_OBJECT, new Region(x, y, w, h));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object click(BObject bRegion) {
        try {
            getRegion(bRegion).click();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object hover(BObject bRegion) {
        try {
            getRegion(bRegion).hover();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object doubleClick(BObject bRegion) {
        try {
            getRegion(bRegion).doubleClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object rightClick(BObject bRegion) {
        try {
            getRegion(bRegion).rightClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object dragDropByImage(BObject bRegion, BString sourceImagePath, BString destinationImagePath) {
        try {
            getRegion(bRegion).dragDrop(sourceImagePath, destinationImagePath);
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object dragDropByLocation(BObject bScreen, BObject sourceLocation, BObject destinationLocation) {
        try {
            getRegion(bScreen).dragDrop(getLocation(sourceLocation), getLocation(destinationLocation));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object exists(BObject bRegion, BString imagePath) {
        try {
            Match match = getRegion(bRegion).exists(imagePath);
            return match != null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyDown(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).keyDown(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyUp(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).keyUp(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyPress(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).type(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object type(BObject bRegion, BString value) {
        try {
            getRegion(bRegion).type(value.toString());
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object wheel(BObject bRegion, int direction, int steps) {
        try {
            getRegion(bRegion).wheel(direction, steps);
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object existsText(BObject bRegion, BString text) {
        try {
            Match match = getRegion(bRegion).existsText(text.toString());
            return match != null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getCenter();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getCenter();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getX(BObject bRegion) {
        try {
            return getRegion(bRegion).getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getY(BObject bRegion) {
        try {
            return getRegion(bRegion).getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getW(BObject bRegion) {
        try {
            return getRegion(bRegion).getW();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getH(BObject bRegion) {
        try {
            return getRegion(bRegion).getH();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getText(BObject bRegion) {
        try {
            return StringUtils.fromString(getRegion(bRegion).text());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object find(BObject bRegion, BString imagePath) {
        try {
            Match match = getRegion(bRegion).find(imagePath.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findAll(BObject bRegion, BString imagePath) {
        try {
            List<Match> matches = getRegion(bRegion).findAllList(imagePath.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findText(BObject bRegion, BString text) {
        try {
            Match match = getRegion(bRegion).findText(text.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findAllText(BObject bScreen, BString text) {
        try {
            List<Match> matches = getRegion(bScreen).findAllText(text.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    private static Region getRegion(BObject bRegion) {
        return (Region) bRegion.getNativeData(REGION_OBJECT);
    }

}
