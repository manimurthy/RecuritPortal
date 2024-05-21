package com.recuritportal.jspwebapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.JobPost1;
import com.recuritportal.jspwebapp.Repository.ApplyJobRepo;
import com.recuritportal.jspwebapp.Repository.JobFaqRepo;
import com.recuritportal.jspwebapp.Repository.JobPostRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ApplyJobService {
	@Autowired
	ApplyJobRepo applyjobRepo;
	JobFaqRepo jobPostRepo;
	
    @PersistenceContext
    private EntityManager entityManager;

    
	public ApplyJobService(ApplyJobRepo ajRepo , JobFaqRepo jpRepo) {
		this.applyjobRepo=ajRepo;
		this.jobPostRepo=jpRepo;
	}
	
    //public boolean insertApplyJob(Applyjob applyJob) {
	public boolean insertApplyJob(JobApplied applyJob) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	applyjobRepo.save(applyJob);
        return true;
    }
	
    // Get the list of jobdetails  the employee has already applied to
	public List<JobApplied> getJobApplicationsByEmployeeId(Integer empid) {
        List<JobApplied> apJobs= applyjobRepo.findByEmployee_Empid(empid);
        return apJobs;
    }

    // Get the list of job posting IDs the employee has already applied to
	public List<Integer> findJobIdsByEmployeeId(Integer empid) {
        List<Integer> listJobs= applyjobRepo.findJobIdsByEmployeeId(empid);
        return listJobs;
    }

 /*   public List<JobApplied> getJobApplicationsByPostingd(Integer jobpostingid) {
        List<JobApplied> apJobs= applyjobRepo.findByjobpostid(jobpostingid);
        return apJobs;
    }*/

    public JobPost1 getJobDtlsForApply(Integer jobpostingid) {
    	JobPost1 apJobs= jobPostRepo.findByjobpostingid(jobpostingid);
        return apJobs;
    }	
    
    public List<JobApplied> getJobApplicationsByPostingId(Integer jobpostingid) {
        String jpql = "SELECT ja FROM JobApplied ja JOIN FETCH ja.employee WHERE ja.jobPost.id = :jobpostingid";
        List<JobApplied> jobAppliedList = entityManager.createQuery(jpql, JobApplied.class)
                .setParameter("jobpostingid", jobpostingid)
                .getResultList();
        return jobAppliedList;
    }    

    @Transactional
    public void updateStatus(int jobApplyId, String status) {
    	applyjobRepo.updateStatusById(jobApplyId, status);
    }
}
