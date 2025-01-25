# Automating the filling of student application form.

## Overview
This guide demonstrates automating the process of filling out student application form [A desktop application] using the Ballerina Sikuli module.

## Implementation

The example project automates data entry by retrieving student information from a [JSON file](./modules/resources/data.json) and populating it into a [desktop application](./student_app.jar).


>This example demonstrates image-based automation using SikuliX. 
It relies on pixel-perfect image matching to interact with the user interface. 
Note that differences in screen resolution or scaling between machines may cause 
the script to fail, as the images captured on one machine may not match the UI 
elements on another machine. If you encounter a `FindFailedError` during automation, 
recapture the screenshots for the [specified images](./resources/) on your machine and use them.

## Run the Example

```ballerina 
cd .\examples\student_application_form_filling
bal run
```
