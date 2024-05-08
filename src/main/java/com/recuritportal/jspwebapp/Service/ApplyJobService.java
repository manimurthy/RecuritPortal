package com.recuritportal.jspwebapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Repository.ApplyJobRepo;

@Service
public class ApplyJobService {
	@Autowired
	ApplyJobRepo applyjobRepo;
	
	public ApplyJobService(ApplyJobRepo ajRepo) {
		this.applyjobRepo=ajRepo;
	}
	
    //public boolean insertApplyJob(Applyjob applyJob) {
	public boolean insertApplyJob(JobApplied applyJob) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	applyjobRepo.save(applyJob);
        return true;
    }
	
    public List<JobApplied> getJobApplicationsByEmployeeId(Integer empid) {
        List<JobApplied> apJobs= applyjobRepo.findByEmployee_Empid(empid);
        return apJobs;
    }	
}
