## Overview

This module automates desktop applications across Windows, Mac and Linux operating systems. 

## Quickstart

SikuliX enables image-based automation via screenshots, supports precise coordinate-based interactions, and offers OCR capabilities for text recognition.

### Class `App`

In SikuliX, the App class is used to interact with desktop applications. It allows you to launch, bring focus to, and manage the lifecycle of applications. 

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    sikulix:App calc = sikulix:newApp2("C:/Windows/System32/calc.exe"); // Creates calculator app instance
    _ = calc.open(); // Opens calculator
    _ = calc.focus(); // Brings calculator to the front
    _ = calc.close(); // Closes calculator
}
```

### Class `Screen`

The Screen instance represents the entire monitor which operates on the entire visible screen area. `Screen` extends class [`Region`](#class-region).

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    sikulix:Screen screen = sikulix:newScreen1(); // Initialize a new Sikuli screen object to interact with the desktop.

    sikulix:Match submitButton = check screen.find1("button.png"); // Locate the "button.png" element on the screen and return its Match object.

    _ = check screen.click4("button.png"); // Click on the element represented by "button.png".
    _ = check screen.type7("textinput.png", "Hello word"); // Focus on the "textinput.png" element and type "Hello word".
    _ = check screen.wheel4("dropdown.png", 1, 2); // Scroll down on the "dropdown.png" element with 2 steps in the forward direction.
    _ = check screen.rightClick4("icon1.png"); // Perform a right-click on the element represented by "icon1.png".
    _ = check screen.doubleClick4("icon2.png"); // Perform a double-click on the element represented by "icon2.png".
    _ = check screen.dragDrop4("icon3.png", "icon4.png"); // Drag the element represented by "icon3.png" and drop it onto "icon4.png".
    _ = check screen.hover3("icon5.png"); // Hover on the element represented by "icon5.png".
}
```

### Class `Region`

A Region is a rectangular area on a Screen, and is defined by,

1. Its upper left corner (x, y) being the pixel with this offset relative to the upper left corner of the screen (usually (0, 0) ) and
2. Its dimension (w, h) as its width and height in pixels.

`Region` is More efficient than `Screen` because `Region` limits searches to a smaller area, where `Screen` searches in entire screen. `Region` is useful when you know the location of the target or want to focus on a specific part of the screen.

You can use `find()`, to search a given image/text within the Region. If this Visual is found in the Region, It returns a [`Match`](#class-match) object.

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    int topLeftX = 300;
    int topLeftY = 100;
    int height = 300;
    int width = 600;

    sikulix:Region someRegion = sikulix:newRegion2(topLeftX, topLeftY, height, width);
    sikulix:Match icon = check someRegion.find1("image.png");
    _ = icon.click();
}
```

### Class `Location`

This class is to handle single points on the screen directly by its position (x, y).

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    int x = 300;
    int y = 400;
    sikulix:Location someLocation = sikulix:newLocation2(x, y);
    _ = someLocation.click();
}
```

### Class `Pattern`

A Pattern represents a visual element that SikuliX searches for on the screen. It is primarily used as a search template with additional features like similarity settings and offsets.

The `similar()` method is used to set the similarity threshold for image matching. SikuliX searches for elements on the screen by comparing the provided image or pattern with what is displayed on the screen. The similarity value determines how closely the screen element must match the pattern to be considered a valid match. The value ranges from 0.0 (no similarity required) to 1.0 (perfect match).

The `targetOffset()` method adjusts the point of interaction relative to the center of the matched region. By default, SikuliX performs actions (e.g., clicks) at the center of the matched element. With a pattern object, you can define a different click point relative to the center using `targetOffset()`.

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    sikulix:Screen screen = sikulix:newScreen1();
    sikulix:Pattern pattern = sikulix:newPattern6("image.png").similar(0.5).targetOffset(10, 10);
    _ = check screen.click2(pattern);
}
```

### Class `Match`

Match represents the result of a successful find operation. class   `Match` extends class `Region`. It provides coordinates (x, y), dimensions (width, height), and used for further actions (e.g., clicking, dragging, or analyzing the match region).

If the find operation fails, it returns an error `FindFailed`.

```ballerina
import xlibb/sikulix.script as sikulix;

public function main returns error? {
    sikulix:Screen screen = sikulix:newScreen1();
    // Locate the element represented by "image.png" 
    // on the screen and store the match details.
    sikulix:Match|sikulix:FindFailed myMatch = screen.find1("image.png"); 

    if myMatch is sikulix:FindFailed {
        io:println("The element not found in the screen.");
    } else {
        // Click at a location offset by 200 pixels to the right (X-axis) and 100 pixels down (Y-axis) 
        // from the top-left corner of the matched image.
        _ = check screen.click2(sikulix:newLocation2(myMatch.getX() + 200, myMatch.getY() + 100)); 
    }
}
```

### Class `Key`
The methods supporting the use of special keys are `type()` `keyDown()` and `keyUp()`.

```ballerina
import xlibb/sikulix.script as sikulix;

public function main() returns sikulix:FindFailed? {

    sikulix:Screen screen = sikulix:newScreen1();
    _ = screen.type6("inputfield.png", "Hello world\t"); // Type "Hello world" into an input field represented by "image.png" and focus next input field.
    _ = screen.type4("Ballerina"); // Type the text "Ballerina" at the current cursor location.
    _ = check screen.'type(sikulix:newLocation2(300, 600), "Hello world"); // Type "Hello world" into an input field or perform an action, using x, y coordinates as a reference for location.
    _ = screen.type4(sikulix:Key_getENTER()); // Pressing the ENTER key.
    screen.keyDown2(sikulix:Key_getCTRL()); // Press and hold the CTRL key.
    _ = screen.type4("a"); // pressing the "A" key (e.g., to select all text).
    screen.keyUp3(sikulix:Key_getCTRL()); // Release the CTRL key.

}
```

### Working with text and using OCR features

```ballerina
import xlibb/sikulix.script as sikulix;

public function main() returns sikulix:FindFailed? {

    sikulix:Region r = sikulix:newRegion2(100, 100, 400, 200);
    string text1 = r.text(); // Extract and store the text content from the defined region.

    sikulix:Screen screen = sikulix:newScreen1();
    sikulix:Match myMatch = check screen.find1("image.png");
    string text2 = myMatch.getText(); // Extract and store the text content from the region where the image "image.png" was found.
    sikulix:Match textMatch2 = check screen.findText("ballerina"); // Search for the text "ballerina" on the screen and store the matching region if found.

}
```
### Sikulix IDE 

To use images with the features of SikuliX like click(someImage), you need to store these images as image files in the PNG format (someImage.png) somewhere on the file system or somewhere in the internet.

Using the **SikuliX IDE**, you can setup and maintain such visual workflows including capturing and organizing the needed images and finding x, y coordinate points.

Go to the [SikuliX download page](https://launchpad.net/sikuli/+download) and download the latest version of the SikuliX IDE acccording to your operating system.

The IDE is only available as jar-file, that can be double-clicked to start it, usage in a command window: `java -jar <path-to>/sikulix.jar`

> To use the SikuliX IDE you need a valid Java runtime installation of at least version 8 (OpenJDK or Oracle JRE/JDK).

- Use `Take Screenshot` option to capture screenshots. 
- Use `Region` option to find x, y, w, h properties of a region.
- Use `Location` option to find the coordinates of a single point in the screen.
- Use `Offset` option to find height and width of a visual element.

Save the screenshot images in a directory, preferably within your project folder, and reference these images and coordinate points in your automation code.
 
### Notes

> **Real Screen needed - The system running SikuliX scripts must have a real screen connected.**

> **While running SikuliX scripts, usually one cannot work on this system in parallel, not even on another monitor, since normally SikuliX will "use" mouse and/or keyboard and watches the screen according to the running SikuliX workflow.**

> **SikuliX relies on image-based automation, which uses pixel-perfect image matching to interact with the user interface. If the screen resolution or scaling differs between machines, the script may fail because the images captured on one machine may not match the UI elements on another machine. To avoid script failures, Ensure both machines have the same screen resolution and scaling. If this is not possible, capture new screenshots on other machine.**

## Examples

The `sikulix` connector provides practical examples illustrating usage in various scenarios. Explore these [examples](https://github.com/xlibb/module-sikulix/tree/main/examples/), covering the following use cases:

1. [Automating the Filling of Student Application Form desktop Application.](https://github.com/xlibb/module-sikulix/tree/main/examples/student_applciation_form_filling). 
