# module-sikulix
This repository contains the source code of the Ballerina sikulix library package

[![Build](https://github.com/xlibb/module-sikulix/actions/workflows/ci.yml/badge.svg)](https://github.com/xlibb/module-sikulix/actions/workflows/ci.yml)
[![Trivy](https://github.com/xlibb/module-sikulix/actions/workflows/trivy-scan.yml/badge.svg)](https://github.com/xlibb/module-sikulix/actions/workflows/trivy-scan.yml)
[![GraalVM Check](https://github.com/xlibb/module-sikulix/actions/workflows/build-with-bal-test-graalvm.yml/badge.svg)](https://github.com/xlibb/module-sikulix/actions/workflows/build-with-bal-test-graalvm.yml)
[![GitHub Last Commit](https://img.shields.io/github/last-commit/xlibb/module-sikulix.svg)](https://github.com/xlibb/module-sikulix/commits/master)
[![GitHub Issues](https://img.shields.io/github/issues/ballerina-platform/ballerina-library/module/sikulix.svg?label=Open%20Issues)](https://github.com/ballerina-platform/ballerina-library/labels/module%sikulix)

## Overview

This module automates desktop applications across Windows, Mac and Linux operating systems. 

## Quickstart

SikuliX enables image-based automation via screenshots, supports precise coordinate-based interactions, and offers OCR capabilities for text recognition.

### Class `Screen`

The Screen instance represents the entire monitor which operates on the entire visible screen area.

```ballerina
import xlibb/sikulix;

public function main() returns error? {
    sikulix:Screen screen = check new(); // Initialize a new Sikuli screen object to interact
    _ = check screen.click(); // Click on the center of the screen.
}
```

### Class `Region`

A Region is a rectangular area on a Screen, and is defined by,

1. Its upper left corner (x, y) being the pixel with this offset relative to the upper left corner of the screen (usually (0, 0) ) and
2. Its dimension (w, h) as its width and height in pixels.

`Region` is More efficient than `Screen` because `Region` limits searches to a smaller area, where `Screen` searches in entire screen. `Region` is useful when you know the location of the target or want to focus on a specific part of the screen.

You can use `find()`, to search a given image/text within the Region. If this Visual is found in the Region, It returns a [`Match`](#class-match) object.

```ballerina
import xlibb/sikulix;

public function main returns error? {
    int topLeftX = 300;
    int topLeftY = 100;
    int height = 300;
    int width = 600;

    sikulix:Region someRegion = check new ({topLeftX, topLeftY, height, width});
    _ = check someRegion.click(); // Click on the center of the region.
}
```

### Class `Location`

This class is to handle single points on the screen directly by its position (x, y).

```ballerina
import xlibb/sikulix;

public function main returns error? {
    int x = 300;
    int y = 400;
    sikulix:Location someLocation = check new ({x, y});
    check someLocation.click();
}
```

### Class `Match`

Match represents the result of a successful find operation. It used for further actions (e.g., clicking, or analyzing the match region).

If the find operation fails, it returns an error `FindFailedError`.

```ballerina
import xlibb/sikulix;

public function main returns error? {
    sikulix:Screen screen = check new ();
    // Locate the element represented by "image.png" 
    // on the screen and store the match details.
    sikulix:Match myMatch = check screen.find("image.png");
    check myMatch.click()
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


## Build from the source

### Setting up the prerequisites

1. Download and install Java SE Development Kit (JDK) version 17. You can download it from either of the following sources:

    * [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
    * [OpenJDK](https://adoptium.net/)

   > **Note:** After installation, remember to set the `JAVA_HOME` environment variable to the directory where JDK was installed.
2. Download and install [Ballerina Swan Lake](https://ballerina.io/).

3. Download and install [Docker](https://www.docker.com/get-started).

   > **Note**: Ensure that the Docker daemon is running before executing any tests.
4. Export Github Personal access token with read package permissions as follows,

    ```bash
    export packageUser=<Username>
    export packagePAT=<Personal access token>
    ```

### Build options

Execute the commands below to build from the source.

1. To build the package:

   ```bash
   ./gradlew clean build
   ```

2. To run the tests:

   ```bash
   ./gradlew clean test
   ```

3. To build the without the tests:

   ```bash
   ./gradlew clean build -x test
   ```

4. To run tests against different environments:

   ```bash
   ./gradlew clean test -Pgroups=<Comma separated groups/test cases>
   ```

5. To debug the package with a remote debugger:

   ```bash
   ./gradlew clean build -Pdebug=<port>
   ```

6. To debug with the Ballerina language:

   ```bash
   ./gradlew clean build -PbalJavaDebug=<port>
   ```

7. Publish the generated artifacts to the local Ballerina Central repository:

    ```bash
    ./gradlew clean build -PpublishToLocalCentral=true
    ```

8. Publish the generated artifacts to the Ballerina Central repository:

   ```bash
   ./gradlew clean build -PpublishToCentral=true
   ```

## Contribute to Ballerina

As an open-source project, Ballerina welcomes contributions from the community.

For more information, go to the [contribution guidelines](https://github.com/ballerina-platform/ballerina-lang/blob/master/CONTRIBUTING.md).

## Code of conduct

All the contributors are encouraged to read the [Ballerina Code of Conduct](https://ballerina.io/code-of-conduct).
