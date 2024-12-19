import ballerina/io;
import ballerina/lang.runtime;
import ballerina/file;
import ballerina/os;
import xlibb/sikulix.script as sikuli;

string imagespath = file:getCurrentDir() + "/resources";
string appPath = file:getCurrentDir() + "/student_application.jar";

public function main() returns error? {

    // Opening the application
    _ = check os:exec({value: "java", arguments: ["-jar", appPath]});
    runtime:sleep(1);

    // Preparing the data
    Data data = check getData();
    
    sikuli:Screen screen = sikuli:newScreen1();

    // 1. Personal details
    _ = screen.type4(data.fullName + "\t"); // Tab key is used to focus next input field
    _ = screen.type4(data.nameWithInitials + "\t");
    _ = screen.type4(data.dob + "\t");
    _ = screen.type4(data.age + "\t");
    _ = screen.type4(data.nationality);
    while screen.find1(imagespath + "/next.png") is error { // Scroll the screen until, find next button
        _ = screen.wheel(1, 5);
    }
    _ = check screen.click4(imagespath + "/" + data.gender + ".png");
    _ = check screen.type7(imagespath + "/address.png", data.address + "\t");
    _ = screen.type4(data.mobile);

    sikuli:Match m = check screen.find1(imagespath + "/district.png"); // Scroll the dropdown, until find relevent district name, once found click enter
    _ = check screen.click2(m);
    sikuli:Region drop = sikuli:newRegion2(m.getX(), m.getY(), 200, 20);
    int count = 0;
    while drop.text() != data.district && count <= 25 {
        _ = screen.type4(sikuli:Key_getDOWN());
        drop = sikuli:newRegion2(m.getX(), m.getY(), 200, 20);
        count = count + 1;
    }
    _ = screen.type4(sikuli:Key_getENTER());
    _ = screen.type4(sikuli:Key_getTAB());
    _ = screen.type4(data.gramaSevaka + "\t");
    _ = screen.type4((data.nic ?: "") + "\t");
    _ = screen.type4(data.passport ?: "");
    _ = check screen.click4(imagespath + "/next.png");

    // 2. Emergency contact
    _ = check screen.type7(imagespath + "/emergencyName.png", data.emergency.name + "\t");
    _ = screen.type4(data.emergency.address + "\t");
    _ = screen.type4(data.emergency.mobile + "\t");
    _ = screen.type4(data.emergency.relationship + "\t");
    _ = screen.type4(data.emergency.email + "\t");
    _ = check screen.click4(imagespath + "/next.png");

    // 3. O/L results
    _ = check screen.type7(imagespath + "/OLSchool.png", data.olResults.school + "\t");
    _ = screen.type4(data.olResults.year + "\t");
    _ = screen.type4(data.olResults.index + "\t");
    while screen.find1(imagespath + "/next.png") is error { // Scroll the screen until, find next button
        _ = screen.wheel(1, 5);
    }
    foreach ResultsItem item in data.olResults.results {
        _ = check screen.type7(imagespath + "/olsubject.png", item.subject + "\t");
        _ = screen.type4(item.grade);
        _ = check screen.click4(imagespath + "/addResult.png");
    }
    _ = check screen.click4(imagespath + "/next.png");

    // 4. A/L results
    _ = check screen.type7(imagespath + "/alSchool.png", data.alResults.school + "\t");
    _ = screen.type4(data.alResults.year + "\t");
    _ = screen.type4(data.alResults.index + "\t");
    _ = screen.type4(data.alResults.zScore + "\t");
    _ = screen.click();
    while screen.find1(imagespath + "/next.png") is error { // Scroll the screen until, find next button
        _ = screen.wheel(1, 5);
    }
    foreach ResultsItem item in data.alResults.results {
        _ = check screen.type7(imagespath + "/alSubject.png", item.subject + "\t");
        _ = screen.type4(item.grade);
        _ = check screen.click4(imagespath + "/addResult.png");
    }
    _ = check screen.click4(imagespath + "/next.png");

    // 5. Other qualifications
    foreach OtherQualificationsItem item in data.otherQualifications {
        _ = check screen.type7(imagespath + "/course.png", item.course + "\t");
        _ = screen.type4(item.nvqLevel + "\t");
        _ = screen.type4(item.institute + "\t");
        _ = screen.type4(item.year + "\t");
        _ = screen.type4(item.result + "\t");
        _ = check screen.click4(imagespath + "/addResult.png");
    }
    _ = screen.wheel(1, 3);
    _ = check screen.click4(imagespath + "/next.png");

    // 7. References
    foreach RefreesItem item in data.refrees {
        _ = check screen.type7(imagespath + "/refereeName.png", item.name + "\t");
        _ = screen.type4(item.designation + "\t");
        _ = screen.type4(item.address + "\t");
        _ = screen.type4(item.mobile + "\t");
        _ = check screen.click4(imagespath + "/addReferee.png");
    }

    // finish button
    _ = check screen.click4(imagespath + "/finish.png");

    io:println("Data entered successsfully!");
}
