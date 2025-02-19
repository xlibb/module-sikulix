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

import io.ballerina.lib.sikulix.utils.ModuleUtils;
import io.ballerina.lib.sikulix.utils.Utils;
import io.ballerina.runtime.api.creators.TypeCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.types.ArrayType;
import io.ballerina.runtime.api.types.Type;
import io.ballerina.runtime.api.utils.StringUtils;
import io.ballerina.runtime.api.values.BObject;
import io.ballerina.runtime.api.values.BString;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import java.util.List;

/**
 * Provide APIs to interact with the result of a successful find operation.
 *
 * @since 0.1.0
 */
public class SikulixMatch {

    private static final String MATCH_OBJECT = "nativeMatchObject";
    private static final String MATCH_OBJECT_TYPE = "Match";

    public static Object click(BObject bMatch) {
        try {
            Match match = getMatch(bMatch);
            match.click();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object doubleClick(BObject bMatch) {
        try {
            Match match = getMatch(bMatch);
            match.doubleClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object rightClick(BObject bMatch) {
        try {
            Match match = getMatch(bMatch);
            match.rightClick();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object hover(BObject bMatch) {
        try {
            Match match = getMatch(bMatch);
            match.hover();
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object type(BObject bMatch, BString text) {
        try {
            Match match = getMatch(bMatch);
            match.click();
            Screen screen = new Screen();
            screen.type(text.toString());
            return null;
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getText(BObject bMatch) {
        try {
            Match match = getMatch(bMatch);
            return StringUtils.fromString(match.getText());
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftX(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getBottomLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomLeftY(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getBottomLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightX(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getBottomRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getBottomRightY(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getBottomRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftX(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getTopLeft();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopLeftY(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getTopLeft();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightX(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getTopRight();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getTopRightY(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getTopRight();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterX(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getCenter();
            return location.getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getCenterY(BObject bMatch) {
        try {
            Location location = getMatch(bMatch).getCenter();
            return location.getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getX(BObject bMatch) {
        try {
            return getMatch(bMatch).getX();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getY(BObject bMatch) {
        try {
            return getMatch(bMatch).getY();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getW(BObject bMatch) {
        try {
            return getMatch(bMatch).getW();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    public static Object getH(BObject bMatch) {
        try {
            return getMatch(bMatch).getH();
        } catch (Exception e) {
            return Utils.createBError(e.getMessage(), e);
        }
    }

    private static Match getMatch(BObject bMatch) {
        return (Match) bMatch.getNativeData(MATCH_OBJECT);
    }

    public static BObject getMatchBObject(Match match) {
        BObject matchBObj = ValueCreator.createObjectValue(ModuleUtils.getModule(), MATCH_OBJECT_TYPE, (Object) null);
        matchBObj.addNativeData(MATCH_OBJECT, match);
        return matchBObj;
    }

    public static ArrayType getMatchArrayType() {
        Type type = TypeCreator.createObjectType(MATCH_OBJECT_TYPE, ModuleUtils.getModule(), 0);
        return TypeCreator.createArrayType(type);
    }

    public static BObject[] getMatchBObjectArr(List<Match> matches) {
        BObject[] matchArr = new BObject[matches.size()];
        for (int i = 0; i < matches.size(); i++) {
            matchArr[i] = getMatchBObject(matches.get(i));
        }
        return matchArr;
    }
}
