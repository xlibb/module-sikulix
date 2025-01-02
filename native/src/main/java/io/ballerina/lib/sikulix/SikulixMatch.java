package io.ballerina.lib.sikulix;

import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class SikulixMatch {

    public static final String MATCH_OBJECT = "nativeMatchObject";
    public static final String ERROR_TYPE = "Error";
    public static final String LOCATION_OBJECT_TYPE = "Location";
    public static final String LOCATION_OBJECT = "nativeLocationObject";

    public static void click(BObject bMatch) {
        Match match = getMatch(bMatch);
        match.click();
    }

    public static void doubleClick(BObject bMatch) {
        Match match = getMatch(bMatch);
        match.doubleClick();
    }

    public static void rightClick(BObject bMatch) {
        Match match = getMatch(bMatch);
        match.rightClick();
    }

    public static void hover(BObject bMatch) {
        Match match = getMatch(bMatch);
        match.hover();
    }

    public static void type(BObject bMatch, BString text) {
        Match match = getMatch(bMatch);
        match.click();
        Screen screen = new Screen();
        screen.type(text.toString());
    }

    public static BString getText(BObject bMatch) {
        Match match = getMatch(bMatch);
        return StringUtils.fromString(match.getText());
    }

    public static int getBottomLeftX(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomLeft();
        return location.getX();
    }

    public static int getBottomLeftY(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomLeft();
        return location.getY();
    }

    public static int getBottomRightX(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomRight();
        return location.getX();
    }

    public static int getBottomRightY(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomRight();
        return location.getY();
    }

    public static int getTopLeftX(BObject bMatch) {
        Location location = getMatch(bMatch).getTopLeft();
        return location.getX();
    }

    public static int getTopLeftY(BObject bMatch) {
        Location location = getMatch(bMatch).getTopLeft();
        return location.getY();
    }

    public static int getTopRightX(BObject bMatch) {
        Location location = getMatch(bMatch).getTopRight();
        return location.getX();
    }

    public static int getTopRightY(BObject bMatch) {
        Location location = getMatch(bMatch).getTopRight();
        return location.getY();
    }

    public static int getCenterX(BObject bMatch) {
        Location location = getMatch(bMatch).getCenter();
        return location.getX();
    }

    public static int getCenterY(BObject bMatch) {
        Location location = getMatch(bMatch).getCenter();
        return location.getY();
    }

    public static int getX(BObject bMatch) {
        return getMatch(bMatch).getX();
    }

    public static int getY(BObject bMatch) {
        return getMatch(bMatch).getY();
    }

    public static int getW(BObject bMatch) {
        return getMatch(bMatch).getW();
    }

    public static int getH(BObject bMatch) {
        return getMatch(bMatch).getH();
    }

    private static Match getMatch(BObject bMatch) {
        return (Match) bMatch.getNativeData(MATCH_OBJECT);
    }

}
