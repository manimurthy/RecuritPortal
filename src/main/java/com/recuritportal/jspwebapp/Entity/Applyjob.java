package com.recuritportal.jspwebapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Applyjob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobapplyid;
	@Column
	private int empid;
	@Column
	private int jobid;
	@Column
	private String applieddate;
	@Column
	private int noofyearsofexp;
	@Column
	private String eduqualify;
	@Column
	private int	expinskills;
	@Column
	private String miscinfo;
	@Column
	private String status;
	
	public int getJobapplyid() {
		return jobapplyid;
	}
	public void setJobapplyid(int jobapplyid) {
		this.jobapplyid = jobapplyid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getApplieddate() {
		return applieddate;
	}
	public void setApplieddate(String applieddate) {
		this.applieddate = applieddate;
	}
	public int getNoofyearsofexp() {
		return noofyearsofexp;
	}
	public void setNoofyearsofexp(int noofyearsofexp) {
		this.noofyearsofexp = noofyearsofexp;
	}
	public String getEduqualify() {
		return eduqualify;
	}
	public void setEduqualify(String eduqualify) {
		this.eduqualify = eduqualify;
	}
	public int getExpinskills() {
		return expinskills;
	}
	public void setExpinskills(int expinskills) {
		this.expinskills = expinskills;
	}
	public String getMiscinfo() {
		return miscinfo;
	}
	public void setMiscinfo(String miscinfo) {
		this.miscinfo = miscinfo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
