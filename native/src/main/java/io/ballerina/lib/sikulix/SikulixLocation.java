package io.ballerina.lib.sikulix;

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BError;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class SikulixLocation {
    public static final String LOCATION_OBJECT = "nativeLocationObject";
    public static final String ERROR_TYPE = "Error";

    public static void createLocation(BObject bLocation, int x, int y) {
        bLocation.addNativeData(LOCATION_OBJECT, new Location(x, y));
    }

    public static void click(BObject bLocation) {
        getLocation(bLocation).click();
    }

    public static void doubleClick(BObject bLocation) {
        getLocation(bLocation).doubleClick();
    }

    public static void rightClick(BObject bLocation) {
        getLocation(bLocation).rightClick();
    }

    public static void hover(BObject bLocation) {
        getLocation(bLocation).hover();
    }

    public static int getX(BObject bLocation) {
        return getLocation(bLocation).getX();
    }

    public static int getY(BObject bLocation) {
        return getLocation(bLocation).getY();
    }

    public static Object type(BObject bLocation, BString value) {
        Screen screen = new Screen();
        try {
            screen.type(getLocation(bLocation), value.toString());
            return null;
        } catch (Exception e) {
            return findFailedError(bLocation.toString());
        }
    }

    public static Object wheel(BObject bLocation, int direction, int noOfSteps) {
        Screen screen = new Screen();
        try {
            screen.wheel(getLocation(bLocation), direction, noOfSteps);
            return null;
        } catch (Exception e) {
            return findFailedError(bLocation.toString());
        }
    }

    private static Location getLocation(BObject bLocation) {
        return (Location) bLocation.getNativeData(LOCATION_OBJECT);
    }

    private static BError findFailedError(String imagePath) {
        BString message = StringUtils.fromString("Failed to find element: " + imagePath);
        return ErrorCreator.createError(ModuleUtils.getModule(), ERROR_TYPE, message, null, null);
    }


}
