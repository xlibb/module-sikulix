package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;

public class SikulixMatch {

    public static final String MATCH_OBJECT = "nativeMatchObject";
    public static final String ERROR_TYPE = "Error";
    public static final String LOCATION_OBJECT_TYPE = "Location";
    public static final String LOCATION_OBJECT = "nativeLocationObject";

    public static void click(BObject bMatch) {
        Match match = (Match) getMatch(bMatch);
        match.click();
    }

    public static void doubleClick(BObject bMatch) {
        Match match = (Match) getMatch(bMatch);
        match.doubleClick();
    }

    public static void rightClick(BObject bMatch) {
        Match match = (Match) getMatch(bMatch);
        match.rightClick();
    }

    public static void hover(BObject bMatch) {
        Match match = (Match) getMatch(bMatch);
        match.hover();
    }

    public static void type(BObject bMatch, BString text) {
        Match match = (Match) getMatch(bMatch);
        match.type(text.toString());
    }

    public static BString getText(BObject bMatch) {
        Match match = (Match) getMatch(bMatch);
        return StringUtils.fromString(match.getText());
    }

    public static BObject getBottomLeft(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomLeft();
        return getLocationBObject(location);
    }

    public static BObject getBottomRight(BObject bMatch) {
        Location location = getMatch(bMatch).getBottomRight();
        return getLocationBObject(location);
    }

    public static BObject getTopLeft(BObject bMatch) {
        Location location = getMatch(bMatch).getTopLeft();
        return getLocationBObject(location);
    }

    public static BObject getTopRight(BObject bMatch) {
        Location location = getMatch(bMatch).getTopRight();
        return getLocationBObject(location);
    }

    public static BObject getCenter(BObject bMatch) {
        Location location = getMatch(bMatch).getCenter();
        return getLocationBObject(location);
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

    private static BObject getLocationBObject(Location location) {
        BObject locationBObj = ValueCreator.createObjectValue(ModuleUtils.getModule(), 
        LOCATION_OBJECT_TYPE, (Object) null);
        locationBObj.addNativeData(LOCATION_OBJECT, location);
        return locationBObj;
    }


}
