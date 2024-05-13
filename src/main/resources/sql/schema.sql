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