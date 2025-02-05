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
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import java.util.List;

import static io.ballerina.lib.sikulix.SikulixLocation.getLocation;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchArrayType;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchBObject;
import static io.ballerina.lib.sikulix.SikulixMatch.getMatchBObjectArr;

/**
 * Provide APIs to interact with the entire visible screen area.
 *
 * @since 0.1.0
 */
public class SikulixScreen {

    private static final String SCREEN_OBJECT = "nativeScreenObject";

    public static Object createScreen(BObject bScreen) {
        try {
            bScreen.addNativeData(SCREEN_OBJECT, new Screen());
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object click(BObject bScreen) {
        try {
            getScreen(bScreen).click();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object hover(BObject bScreen) {
        try {
            getScreen(bScreen).hover();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object doubleClick(BObject bScreen) {
        try {
            getScreen(bScreen).doubleClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object rightClick(BObject bScreen) {
        try {
            getScreen(bScreen).rightClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object dragDropByImage(BObject bScreen, BString sourceImagePath, BString destinationImagePath) {
        try {
            getScreen(bScreen).dragDrop(sourceImagePath, destinationImagePath);
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object dragDropByLocation(BObject bScreen, BObject sourceLocation, BObject destinationLocation) {
        try {
            getScreen(bScreen).dragDrop(getLocation(sourceLocation), getLocation(destinationLocation));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object exists(BObject bScreen, BString imagePath) {
        try {
            Match match = getScreen(bScreen).find(imagePath.toString());
            return match.isValid();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyDown(BObject bScreen, BString keyText) {
        try {
            getScreen(bScreen).keyDown(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyUp(BObject bScreen, BString keyText) {
        try {
            getScreen(bScreen).keyUp(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object keyPress(BObject bScreen, BString keyText) {
        try {
            getScreen(bScreen).type(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object type(BObject bScreen, BString value) {
        try {
            getScreen(bScreen).type(value.toString());
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object wheel(BObject bScreen, int direction, int steps) {
        try {
            getScreen(bScreen).wheel(direction, steps);
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object existsText(BObject bScreen, BString text) {
        try {
            Match match = getScreen(bScreen).existsText(text.toString());
            return match != null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftX(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getBottomLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftY(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getBottomLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightX(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getBottomRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightY(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getBottomRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftX(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getTopLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftY(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getTopLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightX(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getTopRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightY(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getTopRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterX(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getCenter();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterY(BObject bScreen) {
        try {
            Location location = getScreen(bScreen).getCenter();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getX(BObject bScreen) {
        try {
            return getScreen(bScreen).getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getY(BObject bScreen) {
        try {
            return getScreen(bScreen).getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getW(BObject bScreen) {
        try {
            return getScreen(bScreen).getW();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getH(BObject bScreen) {
        try {
            return getScreen(bScreen).getH();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object find(BObject bScreen, BString imagePath) {
        try {
            Match match = getScreen(bScreen).find(imagePath.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findAll(BObject bScreen, BString imagePath) {
        try {
            List<Match> matches = getScreen(bScreen).findAllList(imagePath.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findText(BObject bScreen, BString text) {
        try {
            Match match = getScreen(bScreen).findText(text.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object findAllText(BObject bScreen, BString text) {
        try {
            List<Match> matches = getScreen(bScreen).findAllText(text.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    private static Screen getScreen(BObject bScreen) {
        return (Screen) bScreen.getNativeData(SCREEN_OBJECT);
    }

}
