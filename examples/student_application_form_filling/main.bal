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

import ballerina/file;
import ballerina/io;
import ballerina/lang.runtime;
import ballerina/os;
import xlibb/sikulix;

string basePath = file:getCurrentDir();
string imagespath = basePath + "/resources";
string appPath = basePath + "/student_app.jar";

public function main() returns error? {

    // Open the application
    _ = check os:exec({value: "java", arguments: ["-jar", appPath]});
    runtime:sleep(1);

    // Prepare the data
    Data data = check getData();

    sikulix:Screen screen = check new ();

    // Enter details
    check screen.'type(data.fullName + "\t");
    check screen.'type(data.nameWithInitials + "\t");
    check screen.'type(data.dob + "\t");
    check screen.'type(data.age + "\t");
    check screen.'type(data.nationality);
    check scrollToBottom(screen);
    check (check screen.find(string `${imagespath}/${data.gender}.png`)).click();
    check (check screen.find(string `${imagespath}/address.png`)).'type(data.address + "\t");
    check screen.'type(data.mobile);
    sikulix:Match districtMatch = check screen.find(imagespath + "/district.png"); 
    check districtMatch.click();
    sikulix:Region dropDownRegion = check new ({
        topLeftX: check districtMatch.getTopLeftX(),
        topLeftY: check districtMatch.getTopLeftY(),
        width: 200,
        height: 20
    });
    int count = 0;
    while dropDownRegion.getText() != data.district && count <= 25 {
        check screen.keyPress(sikulix:DOWN);
        dropDownRegion = check new ({
            topLeftX: check districtMatch.getTopLeftX(),
            topLeftY: check districtMatch.getTopLeftY(),
            width: 200,
            height: 20
        });
        count = count + 1;
    }
    check screen.keyPress(sikulix:ENTER);
    check screen.'type("\t" + data.gramaSevaka + "\t");
    check screen.'type((data.nic ?: "") + "\t");
    check screen.'type(data.passport ?: "");
    check (check screen.find(string `${imagespath}/finish.png`)).click();

    io:println("Data entered successsfully!");
}

function scrollToBottom(sikulix:Screen screen) returns sikulix:Error? {
    sikulix:Match|sikulix:Error nextBtn = screen.find(string `${imagespath}/next.png`);
    while nextBtn is sikulix:FindFailedError { 
        check screen.wheel(1, 3);
        nextBtn = screen.find(string `${imagespath}/finish.png`);
    }
}
