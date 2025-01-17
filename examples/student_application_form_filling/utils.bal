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

import ballerina/io;

# The function reads JSON file and maps the data to Data record type.
# + return - return converted Data object if conversion successful, otherwise return error 
public function getData() returns Data|error {
    json inputs = check io:fileReadJson("modules/resources/data.json");
    Data data = check inputs.cloneWithType();
    return data;
}
