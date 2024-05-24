package com.recuritportal.jspwebapp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public void calcWeightandUpdate(JobPost1 jp1, JobApplied jobApplied ) {
    	
    	int workExWeight = clacWorkExWeight (jp1.getExpweightpercent(), jobApplied.getNoofyearsofexp());
    	int eduQualWeight =calcEduQualWeight(jp1.getEduweightpercent(), jobApplied.getEduqualify());
    	int skillsExWeight = calcSkillsWeight(jp1.getExpskills(),jobApplied.getExpinskills());
    	
        // Calculate total weight
        int totalWeight = workExWeight + eduQualWeight + skillsExWeight;
        
        // Update the calcTotalWeight column using the repository method
        applyjobRepo.updateTotalWeightById(jobApplied.getJobapplyid(), totalWeight);    	
    	
    }
    
    private int clacWorkExWeight(int jobPostWorkExWeight, int appliedWorkEx) {
        // Define the table as an array of arrays where each sub-array represents {years, weight percentage}
        int[][] weightTable = {
            {3, 0},
            {4, 30},
            {5, 60},
            {6, 90},
            {Integer.MAX_VALUE, 100} // Represents >=6 years
        };

        // Determine the weight percentage based on appliedWorkEx
        int derivedWeightPercentage = 0;
        for (int[] row : weightTable) {
            if (appliedWorkEx < row[0]) {
                derivedWeightPercentage = row[1];
                break;
            }
        }

        // Calculate the final weight
        int finalWeight = (jobPostWorkExWeight * derivedWeightPercentage) / 100;

        return finalWeight;
    }
    
    private int calcEduQualWeight(int jobPostEduWeight, String eduQualification) {
        // Define the table as a map where each key is the education level and value is the weight percentage
        Map<String, Integer> eduWeightTable = new HashMap<>();
        eduWeightTable.put("High School", 0);
        eduWeightTable.put("Under Graduate", 20);
        eduWeightTable.put("Graduate", 40);
        eduWeightTable.put("Post Graduate", 60);
        eduWeightTable.put("Doctrate", 100);

        // Determine the weight percentage based on eduQualification
        Integer derivedWeightPercentage = eduWeightTable.get(eduQualification);
        if (derivedWeightPercentage == null) {
            throw new IllegalArgumentException("Invalid education qualification: " + eduQualification);
        }

        // Calculate the final weight
        int finalWeight = (jobPostEduWeight * derivedWeightPercentage) / 100;

        return finalWeight;
    }    
    private int calcSkillsWeight(int jobPostSkillsWeight, int skillsWorkEx) {
        // Define the table as an array of arrays where each sub-array represents {years, weight percentage}
        int[][] weightTable = {
            {2, 0},
            {3, 20},
            {4, 40},
            {5, 60},
            {6, 80},
            {Integer.MAX_VALUE, 100} // Represents >=7 years
        };

        // Determine the weight percentage based on skillsWorkEx
        int derivedWeightPercentage = 0;
        for (int[] row : weightTable) {
            if (skillsWorkEx < row[0]) {
                derivedWeightPercentage = row[1];
                break;
            }
        }

        // Calculate the final weight
        int finalWeight = (jobPostSkillsWeight * derivedWeightPercentage) / 100;

        return finalWeight;
    }    
}
