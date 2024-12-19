import ballerina/io;

# The function reads JSON file and maps the data to Data record type.
# + return - return converted Data object if conversion successful, otherwise return error 
public function getData() returns Data|error {
    json inputs = check io:fileReadJson("modules/resources/data.json");
    Data data = check inputs.cloneWithType();
    return data;
}