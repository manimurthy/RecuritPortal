package com.recuritportal.jspwebapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Repository.JobPostRepo;
import com.recuritportal.jspwebapp.Repository.LikedJobsRepo;
import com.recuritportal.jspwebapp.Entity.JobPost;
import com.recuritportal.jspwebapp.Entity.LikedJobs;

@Service
public class LikedJobService {
	@Autowired
	private JobPostRepo jobpostRepo;
	private LikedJobsRepo likedJobRepo;
	
	public LikedJobService (JobPostRepo jpRepo, LikedJobsRepo  ljRepo) {
		this.jobpostRepo = jpRepo;
		this.likedJobRepo = ljRepo;
	}
    public List<JobPost> getLikedJobsForEmployee(Integer empID) {
        List<LikedJobs> empLikedJobs = likedJobRepo.findByEmpID(empID);
        List<JobPost> likedJobs = new ArrayList<>();
        for (LikedJobs empLikedJob : empLikedJobs) {
            JobPost jobPost = jobpostRepo.findByjobpostingid(empLikedJob.getJobID());
            if (jobPost != null) {
                likedJobs.add(jobPost);
            }
        }
        return likedJobs;
    }
}
