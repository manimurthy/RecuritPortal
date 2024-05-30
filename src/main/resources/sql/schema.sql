CREATE TABLE Firm (
    firmid INT AUTO_INCREMENT PRIMARY KEY,
    firmemail VARCHAR(255),
    firmname VARCHAR(255),
    address1 VARCHAR(255),
    address2 VARCHAR(255),
    contactnumber VARCHAR(255),
    contactperson VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE Employee (
    empid INT AUTO_INCREMENT PRIMARY KEY,
    empemail VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    address1 VARCHAR(255),
    address2 VARCHAR(255),
    pincode VARCHAR(10),
    contact VARCHAR(15),
    password VARCHAR(255) NOT NULL
);
CREATE TABLE Job_Post (
    jobpostingid INT AUTO_INCREMENT PRIMARY KEY,
    firmunqid VARCHAR(255),
    jobtitle VARCHAR(255),
    jobdesc VARCHAR(255),
    dept VARCHAR(255),
    admin_in_charge VARCHAR(255),
    applybydate VARCHAR(255),
    yearsofexp INT,
    expweightpercent INT,
    eduweightpercent INT,
    expskills INT,
    mineduqualify varchar(255),
    minexpskills INT,
    yearly_expweight INT,
    yearlyeduweightpercent INT,	
    yearlyexpskills INT,
    skillname VARCHAR(255)
);
CREATE TABLE Job_PostFAQ (
    faqid INT AUTO_INCREMENT PRIMARY KEY,
    job_post_id INT,
    question TEXT,
    answer TEXT,
    FOREIGN KEY (job_post_id) REFERENCES Job_Post(jobpostingid)
);
CREATE TABLE Job_Applied (
    jobapplyid INT AUTO_INCREMENT PRIMARY KEY,
    jobpostingid INT NOT NULL,
    empid INT NOT NULL,
    applieddate VARCHAR(255),
    noofyearsofexp INT,
    eduqualify VARCHAR(255),
    expinskills INT,
    miscinfo VARCHAR(255),
    status VARCHAR(255),
    calc_total_weight INT,
    FOREIGN KEY (jobpostingid) REFERENCES Job_Post(jobpostingid),
    FOREIGN KEY (empid) REFERENCES Employee(empid)
);