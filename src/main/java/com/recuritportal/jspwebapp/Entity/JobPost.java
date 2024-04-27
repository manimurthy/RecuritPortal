package com.recuritportal.jspwebapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobpostingid;
	@Column
	private String firmunqid;
	@Column
	private String jobtitle;
	@Column
	private String jobdesc;
	@Column
	private String dept;
	@Column
	private String admin_in_charge;
	@Column
	private String applybydate;
	@Column
	private String yearsofexp;
	@Column
	private String expweightpercent;
	@Column
	private String eduweightpercent;
	@Column
	private String expskills;	

	public int getJobpostingid() {
		return jobpostingid;
	}
	public void setJobpostingid(int jobpostingid) {
		this.jobpostingid = jobpostingid;
	}
	public String getFirmunqid() {
		return firmunqid;
	}
	public void setFirmunqid(String firmunqid) {
		this.firmunqid = firmunqid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAdmin_in_charge() {
		return admin_in_charge;
	}
	public void setAdmin_in_charge(String admin_in_charge) {
		this.admin_in_charge = admin_in_charge;
	}
	public String getApplybydate() {
		return applybydate;
	}
	public void setApplybydate(String applybydate) {
		this.applybydate = applybydate;
	}
	public String getYearsofexp() {
		return yearsofexp;
	}
	public void setYearsofexp(String yearsofexp) {
		this.yearsofexp = yearsofexp;
	}
	public String getExpweightpercent() {
		return expweightpercent;
	}
	public void setExpweightpercent(String expweightpercent) {
		this.expweightpercent = expweightpercent;
	}
	public String getEduweightpercent() {
		return eduweightpercent;
	}
	public void setEduweightpercent(String eduweightpercent) {
		this.eduweightpercent = eduweightpercent;
	}
	public String getExpskills() {
		return expskills;
	}
	public void setExpskills(String expskills) {
		this.expskills = expskills;
	}
	
	@Override
	public String toString() {
		return "JobPost [jobpostingid=" + jobpostingid + ", firmunqid=" + firmunqid + ", jobtitle=" + jobtitle
				+ ", jobdesc=" + jobdesc + ", dept=" + dept + ", admin_in_charge=" + admin_in_charge + ", applybydate="
				+ applybydate + ", yearsofexp=" + yearsofexp + ", expweightpercent=" + expweightpercent
				+ ", eduweightpercent=" + eduweightpercent + ", expskills=" + expskills + "]";
	}
}
