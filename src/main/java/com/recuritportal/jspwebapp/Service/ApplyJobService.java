package com.recuritportal.jspwebapp.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Entity.JobApplied;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Exception.CustomApplicationException;
import com.recuritportal.jspwebapp.Repository.ApplyJobRepo;
import com.recuritportal.jspwebapp.Repository.JobFaqRepo;
import com.recuritportal.jspwebapp.Repository.JobPostRepo;
import com.recuritportal.jspwebapp.Util.ConfigReader;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ApplyJobService {
	@Autowired
	ApplyJobRepo applyjobRepo;
	JobFaqRepo jobPostRepo;
	ConfigReader configReader;
	
    @PersistenceContext
    private EntityManager entityManager;

    
    
    
	public ApplyJobService(ApplyJobRepo ajRepo , JobFaqRepo jpRepo, ConfigReader configReader) {
		this.applyjobRepo=ajRepo;
		this.jobPostRepo=jpRepo;
		this.configReader =configReader;
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

    public JobPost getJobDtlsForApply(Integer jobpostingid) {
    	JobPost apJobs= jobPostRepo.findByjobpostingid(jobpostingid);
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
    
    public JobApplied getJobApplicationById(int jobapplyid) {
        return applyjobRepo.findById(jobapplyid).orElse(null);
    }

    public void calcWeightandUpdate(JobPost jp1, JobApplied jobApplied ) {
    	try {
			    	int workExWeight = clacWorkExWeight (jp1.getYearsofexp(),jp1.getYearlyExpweight(), jp1.getExpweightpercent(), jobApplied.getNoofyearsofexp());
			    	    	
			    	int eduQualWeight =calcEduQualWeight(jp1.getMineduqualify(),jp1.getYearlyeduweightpercent(), jp1.getEduweightpercent(), jobApplied.getEduqualify());
			    	int skillsExWeight = calcSkillsWeight(jp1.getMinexpskills(), jp1.getYearlyexpskills(), jp1.getExpskills(),jobApplied.getExpinskills());
			    	
			        // Calculate total weight
			        int totalWeight = workExWeight + eduQualWeight + skillsExWeight;
			        
			        // Update the calcTotalWeight column using the repository method
			        applyjobRepo.updateTotalWeightById(jobApplied.getJobapplyid(), totalWeight);    	
		    } catch (Exception e) {
		        throw e;
		    }          	
    }
    
    private int clacWorkExWeight( int minWorkExYearRequired , int eachWorkYearWeight,int jobPostsWorkExWeight, int applicantsWorkEx) {
    	int finalWorkExWeight;
    	try {
	    	//Check if the candidates years at skill is eligible. If not the weight to be 0
	        if (applicantsWorkEx > minWorkExYearRequired) {
	        	finalWorkExWeight= (applicantsWorkEx-minWorkExYearRequired) * eachWorkYearWeight;
	        	finalWorkExWeight=Math.min(finalWorkExWeight, 100);
	        } else {
	            // If the applicant's qualification is less than or equal to the minimum qualification index, return 0
	        	finalWorkExWeight = 0;
	        }
	        // Calculate the final weight
	        int finalWeight = (jobPostsWorkExWeight * finalWorkExWeight) / 100;
	
	        return finalWeight;
	    } catch (Exception e) {
	    	String errorMessage = "Error calculating weight and updating for clacWorkExWeight with values: Min Work Ex Req " + minWorkExYearRequired 
	    			+ " and Each Work Year Weight: " + eachWorkYearWeight 
	    			+ " and Work Ex Weight for job: " + jobPostsWorkExWeight 
	    			+ " and Applicant Work Ex: " + applicantsWorkEx
	    			+  "<br>Error Message:  " + e.getMessage();
           throw new CustomApplicationException(errorMessage, e);
	    }        
    }    

    public int calcEduQualWeight(String minQualification, int eachQualWeightage, int jobPostEduWeight, String applicantsEduQual) {

    	 int finalEduCalcWeight;
    	 try {
	    	int minQualificationIndex = configReader.getEduIndex(minQualification);
	    	// Convert the applicant's education qualification to an index
	        int applicantsEduQualIndex = configReader.getEduIndex(applicantsEduQual);
	        
	        // Ensure the weightage to be applied does not exceed 100
	        eachQualWeightage = Math.min(eachQualWeightage, 100);
	        
	        // Calculate the weightage if the applicant's education qualification is greater than the minimum qualification index
	        if (applicantsEduQualIndex > minQualificationIndex) {
	            finalEduCalcWeight = (applicantsEduQualIndex - minQualificationIndex) * eachQualWeightage;
	
	            // Ensure the final calculated weight does not exceed 100
	            finalEduCalcWeight = Math.min(finalEduCalcWeight, 100);
	        } else {
	            // If the applicant's qualification is less than or equal to the minimum qualification index, set value to 0
	        	finalEduCalcWeight = 0;
	        }
	        
	        // Calculate the final weight
	        int finalWeight = (jobPostEduWeight * finalEduCalcWeight) / 100;
	
	        return finalWeight;
	    } catch (Exception e) {
	        String errorMessage = "Error calculating Education Qualification Weight with values: Min. Qualification: " + minQualification
	                + ", Each Qualification Weight: " + eachQualWeightage 
	                + ", Weightage as per job: " + jobPostEduWeight 
	                + ", Applicant Edu. Qualification: " + applicantsEduQual 
	                + " <br>Error Message:  " + e.getMessage();	    	
	        throw new CustomApplicationException(errorMessage, e);
	    }        
    }
    private int calcSkillsWeight( int minSkillYearRequired , int eachskillYearWeight,int jobPostSkillsWeight, int applicantsSkillsWorkEx) {
    	int finalSkillWeight;
    	
    	try {
		    	//Check if the candidates years at skill is eligible. If not the weight to be 0
			        if (applicantsSkillsWorkEx > minSkillYearRequired) {
			        	finalSkillWeight= (applicantsSkillsWorkEx-minSkillYearRequired) * eachskillYearWeight;
			        	finalSkillWeight=Math.min(finalSkillWeight, 100);
			        } else {
			            // If the applicant's qualification is less than or equal to the minimum qualification index, return 0
			        	finalSkillWeight = 0;
			        }
			        // Calculate the final weight
			        int finalWeight = (jobPostSkillsWeight * finalSkillWeight) / 100;
			
			        return finalWeight;
		    } catch (Exception e) {
		    	String errorMessage = "Error calculating Skills Weight with values: Min. Skill Years Reqd" + minSkillYearRequired 
		    			+ " and Each Skill Year Weight: " + eachskillYearWeight 
		    			+ " and Skill Weight as per  job: " + jobPostSkillsWeight 
		    			+ " and Applicant Years in Skill : " + applicantsSkillsWorkEx
                		+ " <br>Error Message:  " + e.getMessage();
		    	throw new CustomApplicationException(errorMessage, e);
		    }
    }    
    
}
