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

