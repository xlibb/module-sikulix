// Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).

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

type Emergency record {
    string name;
    string address;
    string mobile;
    string relationship;
    string email;
};

type ResultsItem record {
    string subject;
    string grade;
};

type OlResults record {
    string school;
    string year;
    string index;
    ResultsItem[] results;
};

type AlResults record {
    string school;
    string year;
    string index;
    string zScore;
    ResultsItem[] results;
};

type OtherQualificationsItem record {
    string course;
    string nvqLevel;
    string institute;
    string year;
    string result;
};

type RefreesItem record {
    string name;
    string designation;
    string address;
    string mobile;
};

type Data record {
    string fullName;
    string nameWithInitials;
    string dob;
    string age;
    string nationality;
    string gender;
    string address;
    string mobile;
    string district;
    string gramaSevaka;
    string|() nic;
    string|() passport;
    Emergency emergency;
    OlResults olResults;
    AlResults alResults;
    OtherQualificationsItem[] otherQualifications;
    string extraCurricularActivities;
    RefreesItem[] refrees;
};
