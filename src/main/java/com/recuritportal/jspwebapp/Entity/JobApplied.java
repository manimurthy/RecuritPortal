package com.recuritportal.jspwebapp.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobApplied {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobapplyid;
	
    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "jobpostingid", referencedColumnName="jobpostingid")
    private JobPost1 jobPost;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "empid" , referencedColumnName="empid" )
    private Employee employee;
	
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
    
    @Column(nullable = true)
    private Integer calcTotalWeight;
	
	public int getJobapplyid() {
		return jobapplyid;
	}
	public void setJobapplyid(int jobapplyid) {
		this.jobapplyid = jobapplyid;
	}
	public JobPost1 getJobPost() {
		return jobPost;
	}
	public void setJobPost(JobPost1 jobPost) {
		this.jobPost = jobPost;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
    public Integer getCalcTotalWeight() {
        return calcTotalWeight;
    }

    public void setCalcTotalWeight(Integer calcTotalWeight) {
        this.calcTotalWeight = calcTotalWeight;
    }
    
}