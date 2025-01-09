package io.ballerina.lib.sikulix;

import org.sikuli.script.Key;

public class SikulixKey {

    public static String getKey(String keyText) {
        return switch (keyText) {
            case "SPACE" -> Key.SPACE;
            case "ENTER" -> Key.ENTER;
            case "BACKSPACE" -> Key.BACKSPACE;
            case "TAB" -> Key.TAB;
            case "ESC" -> Key.ESC;
            case "UP" -> Key.UP;
            case "RIGHT" -> Key.RIGHT;
            case "DOWN" -> Key.DOWN;
            case "LEFT" -> Key.LEFT;
            case "PAGE_UP" -> Key.PAGE_UP;
            case "PAGE_DOWN" -> Key.PAGE_DOWN;
            case "DELETE" -> Key.DELETE;
            case "END" -> Key.END;
            case "HOME" -> Key.HOME;
            case "INSERT" -> Key.INSERT;
            case "F1" -> Key.F1;
            case "F2" -> Key.F2;
            case "F3" -> Key.F3;
            case "F4" -> Key.F4;
            case "F5" -> Key.F5;
            case "F6" -> Key.F6;
            case "F7" -> Key.F7;
            case "F8" -> Key.F8;
            case "F9" -> Key.F9;
            case "F10" -> Key.F10;
            case "F11" -> Key.F11;
            case "F12" -> Key.F12;
            case "SHIFT" -> Key.SHIFT;
            case "CTRL" -> Key.CTRL;
            case "ALT" -> Key.ALT;
            case "WIN" -> Key.WIN;
            case "PRINTSCREEN" -> Key.PRINTSCREEN;
            case "SCROLL_LOCK" -> Key.SCROLL_LOCK;
            case "PAUSE" -> Key.PAUSE;
            case "CAPS_LOCK" -> Key.CAPS_LOCK;
            case "SEPARATOR" -> Key.SEPARATOR;
            case "NUM_LOCK" -> Key.NUM_LOCK;
            default -> null;
        };
    }

}
