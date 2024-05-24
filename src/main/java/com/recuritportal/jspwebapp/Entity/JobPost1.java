package com.recuritportal.jspwebapp.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class JobPost1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobpostingid;
	@Column
	private int firmunqid;
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
	private int yearsofexp;
	@Column
	private int expweightpercent;
	@Column
	private int eduweightpercent;
	@Column
	private int expskills;	
	
    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL)
    private List<JobPostFAQ> faqs;
    
	public int getJobpostingid() {
		return jobpostingid;
	}

	public void setJobpostingid(int jobpostingid) {
		this.jobpostingid = jobpostingid;
	}

	public int getFirmunqid() {
		return firmunqid;
	}

	public void setFirmunqid(int firmunqid) {
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

	public int getYearsofexp() {
		return yearsofexp;
	}

	public void setYearsofexp(int yearsofexp) {
		this.yearsofexp = yearsofexp;
	}

	public int getExpweightpercent() {
		return expweightpercent;
	}

	public void setExpweightpercent(int expweightpercent) {
		this.expweightpercent = expweightpercent;
	}

	public int getEduweightpercent() {
		return eduweightpercent;
	}

	public void setEduweightpercent(int eduweightpercent) {
		this.eduweightpercent = eduweightpercent;
	}

	public int getExpskills() {
		return expskills;
	}

	public void setExpskills(int expskills) {
		this.expskills = expskills;
	}

	public List<JobPostFAQ> getFaqs() {
		return faqs;
	}

	public void setFaqs(List<JobPostFAQ> faqs) {
		this.faqs = faqs;
	}
}