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

package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.lib.sikulix.utils.Utils;
import io.ballerina.runtime.api.creators.TypeCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.types.ArrayType;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SikulixRegion {

    public static final String REGION_OBJECT = "nativeRegionObject";
    public static final String ERROR_TYPE = "Error";
    public static final String MATCH_OBJECT_TYPE = "Match";
    public static final String MATCH_OBJECT = "nativeMatchObject";

    public static Object createRegion(BObject bRegion, BMap<BString, Object> rectangle) {
        try {
            int x = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftX")));
            int y = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftY")));
            int w = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("width")));
            int h = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("height")));
            bRegion.addNativeData(REGION_OBJECT, new Region(x, y, w, h));
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object click(BObject bRegion) {
        try {
            getRegion(bRegion).click();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object hover(BObject bRegion) {
        try {
            getRegion(bRegion).hover();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object doubleClick(BObject bRegion) {
        try {
            getRegion(bRegion).doubleClick();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object rightClick(BObject bRegion) {
        try {
            getRegion(bRegion).rightClick();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object dragDrop(BObject bRegion, BString imagePath1, BString imagePath2) {
        try {
            getRegion(bRegion).dragDrop(imagePath1, imagePath2);
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object exists(BObject bRegion, BString imagePath) {
        try {
            Match match = getRegion(bRegion).exists(imagePath);
            return match != null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object keyDown(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).keyDown(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object keyUp(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).keyUp(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object keyPress(BObject bRegion, BString keyText) {
        try {
            getRegion(bRegion).type(SikulixKey.getKey(keyText.toString()));
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object type(BObject bRegion, BString value) {
        try {
            getRegion(bRegion).type(value.toString());
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object wheel(BObject bRegion, int direction, int steps) {
        try {
            getRegion(bRegion).wheel(direction, steps);
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object existsText(BObject bRegion, BString text) {
        try {
            Match match = getRegion(bRegion).existsText(text.toString());
            return match != null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getBottomRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getTopRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getCenterX(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getCenter();
            return location.getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getCenterY(BObject bRegion) {
        try {
            Location location = getRegion(bRegion).getCenter();
            return location.getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getX(BObject bRegion) {
        try {
            return getRegion(bRegion).getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getY(BObject bRegion) {
        try {
            return getRegion(bRegion).getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getW(BObject bRegion) {
        try {
            return getRegion(bRegion).getW();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getH(BObject bRegion) {
        try {
            return getRegion(bRegion).getH();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getText(BObject bRegion) {
        try {
            return StringUtils.fromString(getRegion(bRegion).text());
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object find(BObject bRegion, BString imagePath) {
        try {
            Match match = getRegion(bRegion).find(imagePath.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object findText(BObject bRegion, BString text) {
        try {
            Match match = getRegion(bRegion).findText(text.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object findAll(BObject bRegion, BString imagePath) {
        try {
            Iterator<Match> matches = getRegion(bRegion).findAll(imagePath.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    private static BObject[] getMatchBObjectArr(Iterator<Match> matches) {
        List<Match> matchList = new ArrayList<>();
        while (matches.hasNext()) {
            matchList.add(matches.next());
        }
        BObject[] matchArr = new BObject[matchList.size()];
        for (int i = 0; i < matchList.size(); i++) {
            matchArr[i] = getMatchBObject(matchList.get(i));
        }
        return matchArr;
    }

    public static ArrayType getMatchArrayType() {
        Type type = TypeCreator.createObjectType(MATCH_OBJECT_TYPE, ModuleUtils.getModule(), 0);
        return TypeCreator.createArrayType(type);
    }

    private static Region getRegion(BObject bRegion) {
        return (Region) bRegion.getNativeData(REGION_OBJECT);
    }

    private static BObject getMatchBObject(Match match) {
        BObject matchBObj = ValueCreator.createObjectValue(ModuleUtils.getModule(), MATCH_OBJECT_TYPE, (Object) null);
        matchBObj.addNativeData(MATCH_OBJECT, match);
        return matchBObj;
    }

}
