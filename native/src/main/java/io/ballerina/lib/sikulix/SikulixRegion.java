package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.creators.TypeCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.types.ArrayType;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BError;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SikulixRegion {

    public static final String REGION_OBJECT = "nativeRegionObject";
    public static final String ERROR_TYPE = "Error";
    public static final String LOCATION_OBJECT_TYPE = "Location";
    public static final String LOCATION_OBJECT = "nativeLocationObject";
    public static final String MATCH_OBJECT_TYPE = "Match";
    public static final String MATCH_OBJECT = "nativeMatchObject";
    private static final Logger log = LoggerFactory.getLogger(SikulixRegion.class);

    public static void createRegion(BObject bRegion, BMap<BString, Object> rectangle) {
        int x = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftX")));
        int y = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("topLeftY")));
        int w = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("width")));
        int h = Math.toIntExact(rectangle.getIntValue(StringUtils.fromString("height")));
        bRegion.addNativeData(REGION_OBJECT, new Region(x, y, w, h));
    }

    public static void click(BObject bRegion) {
        getRegion(bRegion).click();
    }

    public static void hover(BObject bRegion) {
        getRegion(bRegion).hover();
    }

    public static void doubleClick(BObject bRegion) {
        getRegion(bRegion).doubleClick();
    }

    public static void rightClick(BObject bRegion) {
        getRegion(bRegion).rightClick();
    }

    public static Object dragDrop(BObject bRegion, BString imagePath1, BString imagePath2) {
        try {
            getRegion(bRegion).dragDrop(imagePath1, imagePath2);
            return null;
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static boolean exists(BObject bRegion, BString imagePath) {
        Match match = getRegion(bRegion).exists(imagePath);
        return match != null;
    }

    public static void keyDown(BObject bRegion, BString key) {
        getRegion(bRegion).keyDown(key.toString());
    }

    public static void keyUp(BObject bRegion, BString key) {
        getRegion(bRegion).keyUp(key.toString());
    }

    public static void type(BObject bRegion, BString value) {
        getRegion(bRegion).type(value.toString());
    }

    public static void wheel(BObject bRegion, int direction, int steps) {
        getRegion(bRegion).wheel(direction, steps);
    }

    public static boolean existsText(BObject bRegion, BString text) {
        Match match = getRegion(bRegion).existsText(text.toString());
        return match != null;
    }

    public static int getBottomLeftX(BObject bRegion) {
        Location location = getRegion(bRegion).getBottomLeft();
        return location.getX();
    }

    public static int getBottomLeftY(BObject bRegion) {
        Location location = getRegion(bRegion).getBottomLeft();
        return location.getY();
    }

    public static int getBottomRightX(BObject bRegion) {
        Location location = getRegion(bRegion).getBottomRight();
        return location.getX();
    }

    public static int getBottomRightY(BObject bRegion) {
        Location location = getRegion(bRegion).getBottomRight();
        return location.getY();
    }

    public static int getTopLeftX(BObject bRegion) {
        Location location = getRegion(bRegion).getTopLeft();
        return location.getX();
    }

    public static int getTopLeftY(BObject bRegion) {
        Location location = getRegion(bRegion).getTopLeft();
        return location.getY();
    }

    public static int getTopRightX(BObject bRegion) {
        Location location = getRegion(bRegion).getTopRight();
        return location.getX();
    }

    public static int getTopRightY(BObject bRegion) {
        Location location = getRegion(bRegion).getTopRight();
        return location.getY();
    }

    public static int getCenterX(BObject bRegion) {
        Location location = getRegion(bRegion).getCenter();
        return location.getX();
    }

    public static int getCenterY(BObject bRegion) {
        Location location = getRegion(bRegion).getCenter();
        return location.getY();
    }

    public static int getX(BObject bRegion) {
        return getRegion(bRegion).getX();
    }

    public static int getY(BObject bRegion) {
        return getRegion(bRegion).getY();
    }

    public static int getW(BObject bRegion) {
        return getRegion(bRegion).getW();
    }

    public static int getH(BObject bRegion) {
        return getRegion(bRegion).getH();
    }

    public static BString getText(BObject bRegion) {
        return StringUtils.fromString(getRegion(bRegion).text());
    }

    public static Object find(BObject bRegion, BString imagePath) {
        try {
            Match match = getRegion(bRegion).find(imagePath.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static Object findText(BObject bRegion, BString text) {
        try {
            Match match = getRegion(bRegion).findText(text.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static Object findAll(BObject bRegion, BString imagePath) {
        try {
            Iterator<Match> matches = getRegion(bRegion).findAll(imagePath.toString());
            return ValueCreator.createArrayValue(getMatchBObjectArr(matches), getMatchArrayType());
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    private static BObject[] getMatchBObjectArr(Iterator<Match> matches) {
        List<Match> matchList = new ArrayList<>();
        while (matches.hasNext()) {
            matchList.add(matches.next());
        }
        BObject[] matchArr = new BObject[matchList.size()];
        for (int i = 0; i < matchList.size(); i++) {
            matchArr[i]  = getMatchBObject(matchList.get(i));
        }
        return matchArr;
    }

    public static ArrayType getMatchArrayType() {
        Type type = TypeCreator.createObjectType(MATCH_OBJECT_TYPE, ModuleUtils.getModule(), 0);
        return TypeCreator.createArrayType(type);
    }

    private static BError findFailedError(String imagePath) {
        BString message = StringUtils.fromString("Failed to find element: " + imagePath);
        return ErrorCreator.createError(ModuleUtils.getModule(), ERROR_TYPE, message, null, null);
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
