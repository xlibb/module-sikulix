package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.creators.TypeCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.types.ArrayType;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BError;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SikulixScreen {

    public static final String SCREEN_OBJECT = "nativeScreenObject";
    public static final String ERROR_TYPE = "Error";
    public static final String LOCATION_OBJECT_TYPE = "Location";
    public static final String LOCATION_OBJECT = "nativeLocationObject";
    public static final String MATCH_OBJECT_TYPE = "Match";
    public static final String MATCH_OBJECT = "nativeMatchObject";

    public static void createScreen(BObject bScreen) {
        bScreen.addNativeData(SCREEN_OBJECT, new Screen());
    }

    public static void click(BObject bScreen) {
        getScreen(bScreen).click();
    }

    public static void hover(BObject bScreen) {
        getScreen(bScreen).hover();
    }

    public static void doubleClick(BObject bScreen) {
        getScreen(bScreen).doubleClick();
    }

    public static void rightClick(BObject bScreen) {
        getScreen(bScreen).rightClick();
    }

    public static Object dragDrop(BObject bScreen, BString imagePath1, BString imagePath2) {
        try {
            getScreen(bScreen).dragDrop(imagePath1, imagePath2);
            return null;
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static boolean exists(BObject bScreen, BString imagePath) {
        try {
            Match match = getScreen(bScreen).find(imagePath.toString());
            return match.isValid();
        } catch (Exception e) {
            return false;
        }
    }

    public static void keyDown(BObject bScreen, BString key) {
        getScreen(bScreen).keyDown(key.toString());
    }

    public static void keyUp(BObject bScreen, BString key) {
        getScreen(bScreen).keyUp(key.toString());
    }

    public static void type(BObject bScreen, BString value) {
        getScreen(bScreen).type(value.toString());
    }

    public static void wheel(BObject bScreen, int direction, int steps) {
        getScreen(bScreen).wheel(direction, steps);
    }

    public static boolean existsText(BObject bScreen, BString text) {
        Match match = getScreen(bScreen).existsText(text.toString());
        return match != null;
    }

    public static int getBottomLeftX(BObject bScreen) {
        Location location = getScreen(bScreen).getBottomLeft();
        return location.getX();
    }

    public static int getBottomLeftY(BObject bScreen) {
        Location location = getScreen(bScreen).getBottomLeft();
        return location.getY();
    }

    public static int getBottomRightX(BObject bScreen) {
        Location location = getScreen(bScreen).getBottomRight();
        return location.getX();
    }

    public static int getBottomRightY(BObject bScreen) {
        Location location = getScreen(bScreen).getBottomRight();
        return location.getY();
    }

    public static int getTopLeftX(BObject bScreen) {
        Location location = getScreen(bScreen).getTopLeft();
        return location.getX();
    }

    public static int getTopLeftY(BObject bScreen) {
        Location location = getScreen(bScreen).getTopLeft();
        return location.getY();
    }

    public static int getTopRightX(BObject bScreen) {
        Location location = getScreen(bScreen).getTopRight();
        return location.getX();
    }

    public static int getTopRightY(BObject bScreen) {
        Location location = getScreen(bScreen).getTopRight();
        return location.getY();
    }

    public static int getCenterX(BObject bScreen) {
        Location location = getScreen(bScreen).getCenter();
        return location.getX();
    }

    public static int getCenterY(BObject bScreen) {
        Location location = getScreen(bScreen).getCenter();
        return location.getY();
    }

    public static int getX(BObject bScreen) {
        return getScreen(bScreen).getX();
    }

    public static int getY(BObject bScreen) {
        return getScreen(bScreen).getY();
    }

    public static int getW(BObject bScreen) {
        return getScreen(bScreen).getW();
    }

    public static int getH(BObject bScreen) {
        return getScreen(bScreen).getH();
    }

    public static Object find(BObject bScreen, BString imagePath) {
        try {
            Match match = getScreen(bScreen).find(imagePath.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static Object findText(BObject bScreen, BString text) {
        try {
            Match match = getScreen(bScreen).findText(text.toString());
            return getMatchBObject(match);
        } catch (Exception e) {
            return findFailedError(e.getMessage());
        }
    }

    public static Object findAll(BObject bScreen, BString imagePath) {
        try {
            Iterator<Match> matches = getScreen(bScreen).findAll(imagePath.toString());
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

    private static Screen getScreen(BObject bScreen) {
        return (Screen) bScreen.getNativeData(SCREEN_OBJECT);
    }

    private static BObject getMatchBObject(Match match) {
        BObject matchBObj = ValueCreator.createObjectValue(ModuleUtils.getModule(), MATCH_OBJECT_TYPE, (Object) null);
        matchBObj.addNativeData(MATCH_OBJECT, match);
        return matchBObj;
    }

}
