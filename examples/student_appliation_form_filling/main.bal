import ballerina/io;
import ballerina/lang.runtime;
import ballerina/file;
import ballerina/os;
import xlibb/sikulix;

string imagespath = file:getCurrentDir() + "/resources";
string appPath = file:getCurrentDir() + "/student_application.jar";

public function main() returns error? {

    // Opening the application
    _ = check os:exec({value: "java", arguments: ["-jar", appPath]});
    runtime:sleep(1);

    // Preparing the data
    Data data = check getData();

    sikulix:Region r = new(100, 100, 100, 200);
    io:println(r.getBottomLeft().getX());
    
    // sikulix:Screen screen = new();

    // // 1. Personal details
    // screen.'type(data.fullName + "\t"); // Tab key is used to focus next input field
    // screen.'type(data.nameWithInitials + "\t");
    // screen.'type(data.dob + "\t");
    // screen.'type(data.age + "\t");
    // screen.'type(data.nationality);
    // while !screen.exists(string `${imagespath}/next.png`) { // Scroll the screen until, find next button
    //     check screen.wheel(1, 5);
    // }
    // (check screen.find(string `${imagespath}/${data.gender}.png`)).click();
    // (check screen.find(string `${imagespath}/address.png`)).'type(data.address + "\t");
    // screen.'type(data.mobile);

    // sikulix:Match districtMatch = check screen.find(imagespath + "/district.png"); // Scroll the dropdown, until find relevent district name, once found click enter
    // districtMatch.click();
    // sikulix:Region dropDownRegion = new(districtMatch.getTopLeft().getX(), districtMatch.getTopLeft().getY(), 200, 20);
    // int count = 0;
    // while dropDownRegion.getText() != data.district && count <= 25 {
    //     screen.'type(sikulix:keyDOWN());
    //     dropDownRegion = new(districtMatch.getTopLeft().getX(), districtMatch.getTopLeft().getY(), 200, 20);
    //     count = count + 1;
    // }
    // screen.'type(sikulix:keyENTER());
    // screen.'type(sikulix:keyTAB());
    // screen.'type(data.gramaSevaka + "\t");
    // screen.'type((data.nic ?: "") + "\t");
    // screen.'type(data.passport ?: "");
    // (check screen.find(string `${imagespath}/next.png`)).click();

    // // 2. Emergency contact
    // (check screen.find(string `${imagespath}/emergencyName.png`)).'type(data.emergency.name + "\t");
    // screen.'type(data.emergency.address + "\t");
    // screen.'type(data.emergency.mobile + "\t");
    // screen.'type(data.emergency.relationship + "\t");
    // screen.'type(data.emergency.email + "\t");
    // (check screen.find(string `${imagespath}/next.png`)).click();

    // // 3. O/L results
    // (check screen.find(string `${imagespath}/OLSchool.png`)).'type(data.olResults.school + "\t");
    // screen.'type(data.olResults.year + "\t");
    // screen.'type(data.olResults.index + "\t");
    // while !screen.exists(string `${imagespath}/next.png`) { // Scroll the screen until, find next button
    //     check screen.wheel(1, 5);
    // }
    // foreach ResultsItem item in data.olResults.results {
    //     (check screen.find(string `${imagespath}/olsubject.png`)).'type(item.subject + "\t");
    //     screen.'type(item.grade);
    //     (check screen.find(string `${imagespath}/addResult.png`)).click();
    // }
    // (check screen.find(string `${imagespath}/next.png`)).click();

    // // 4. A/L results
    // (check screen.find(string `${imagespath}/alSchool.png`)).'type(data.alResults.school + "\t");
    // screen.'type(data.alResults.year + "\t");
    // screen.'type(data.alResults.index + "\t");
    // screen.'type(data.alResults.zScore + "\t");
    // screen.click();
    // while !screen.exists(string `${imagespath}/next.png`) { // Scroll the screen until, find next button
    //     check screen.wheel(1, 5);
    // }
    // foreach ResultsItem item in data.alResults.results {
    //     (check screen.find(string `${imagespath}/alSubject.png`)).'type(item.subject + "\t");
    //     screen.'type(item.grade);
    //     (check screen.find(string `${imagespath}/addResult.png`)).click();
    // }
    // (check screen.find(string `${imagespath}/next.png`)).click();


    // // 5. Other qualifications
    // foreach OtherQualificationsItem item in data.otherQualifications {
    //     (check screen.find(string `${imagespath}/course.png`)).'type(item.course + "\t");
    //     screen.'type(item.nvqLevel + "\t");
    //     screen.'type(item.institute + "\t");
    //     screen.'type(item.year + "\t");
    //     screen.'type(item.result + "\t");
    //     (check screen.find(string `${imagespath}/addResult.png`)).click();
    // }
    // check screen.wheel(1, 3);
    // (check screen.find(string `${imagespath}/next.png`)).click();

    // // 7. References
    // foreach RefreesItem item in data.refrees {
    //     (check screen.find(string `${imagespath}/refereeName.png`)).'type(item.name + "\t");
    //     screen.'type(item.designation + "\t");
    //     screen.'type(item.address + "\t");
    //     screen.'type(item.mobile + "\t");
    //     (check screen.find(string `${imagespath}/addReferee.png`)).click();
    // }

    // // finish button
    // (check screen.find(string `${imagespath}/finish.png`)).click();

    // io:println("Data entered successsfully!");
}
