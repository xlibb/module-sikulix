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
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

public class SikulixLocation {
    public static final String LOCATION_OBJECT = "nativeLocationObject";
    public static final String ERROR_TYPE = "Error";

    public static Object createLocation(BObject bLocation, BMap<BString, Object> point) {
        try {
            long x = point.getIntValue(StringUtils.fromString("x"));
            long y = point.getIntValue(StringUtils.fromString("y"));
            bLocation.addNativeData(LOCATION_OBJECT, new Location(x, y));
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object click(BObject bLocation) {
        try {
            getLocation(bLocation).click();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object doubleClick(BObject bLocation) {
        try {
            getLocation(bLocation).doubleClick();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object rightClick(BObject bLocation) {
        try {
            getLocation(bLocation).rightClick();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object hover(BObject bLocation) {
        try {
            getLocation(bLocation).hover();
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getX(BObject bLocation) {
        try {
            return getLocation(bLocation).getX();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object getY(BObject bLocation) {
        try {
            return getLocation(bLocation).getY();
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object type(BObject bLocation, BString value) {
        try {
            Screen screen = new Screen();
            screen.type(getLocation(bLocation), value.toString());
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    public static Object wheel(BObject bLocation, int direction, int noOfSteps) {
        Screen screen = new Screen();
        try {
            screen.wheel(getLocation(bLocation), direction, noOfSteps);
            return null;
        } catch (Exception e) {
            return Utils.getBError(e.getMessage(), e);
        }
    }

    private static Location getLocation(BObject bLocation) {
        return (Location) bLocation.getNativeData(LOCATION_OBJECT);
    }

}
