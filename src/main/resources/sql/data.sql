insert into EMPLOYEE (empemail,   firstname ,  lastname ,  address1 , address2 , pincode , contact , password ) values 
('yy@y.com','Anjali','Gupta', 'Lodhar Paradise','Kakapuri Chowk, Loni','421012','91-22-36465000','asdf'),
('qq@y.com','Pratik','Thapa', '11, Rosewell Street','Park Street','421012','91-9874650008','asdf');
insert into Firm   (firmemail , firmname,    address1,    address2 ,    contactnumber,    contactperson ,    password ) values ('yy@y.com','Tech Pro Solutions','Plot 5, Sector24','Navi Mumbai','91-22-54675532','HR Team Person','asdf');
insert into Job_Post (firmunqid,jobtitle,jobdesc,dept,admin_in_charge,applybydate,yearsofexp,expweightpercent,eduweightpercent,expskills, mineduqualify, minexpskills, yearly_expweight, yearlyeduweightpercent,	yearlyexpskills, skillname) values 
(1,'Data Entry Operater','This is a job for data entry operator which need candidates to work with a hard copy. Required typing skills are 4-wpm', 'Operation','Mir Mafatlal', '2024-06-24',3,40,30,30, 'High School', 4,20,20,25,'Speed Typo'),
(1,'Lathe Machine Operater','This is a job for lathe operator which need candidates to work with a metals. Required typing skills are lited below....', 'Production','Mir Mafatlal', '2024-06-24',3,40,30,30, 'Under Graduate', 4,20,20,25,'Domestic Wiring'),
(1,'Support Executive','Work includes working with customers and resolving there issues, should have smooth talking personality to handle irritated customers', 'Operation','Anand Shahy', '2024-06-24',3,40,30,30, 'Post Graduate', 4,20,20,25,'Electromagnetic Radiation ');
insert into Job_PostFAQ (job_post_id, question, answer) values(1, 'First Question','First Answer');
insert into Job_PostFAQ(job_post_id, question, answer) values (1,'Second Question','Second Answer');
INSERT INTO Job_Applied (jobpostingid, empid, applieddate, noofyearsofexp, eduqualify, expinskills, miscinfo, status,calc_total_weight)
VALUES 
    (1, 1, '2024-05-20', 5, 'Under Graduate', 8, 'Experienced in DEO at 3 places including medical typing', 'Applied',0),
    (1, 2, '2024-05-25', 5, 'High School', 12, 'Experienced in DEO at 6 places on various domains, like medical, engineering', 'Applied',0);