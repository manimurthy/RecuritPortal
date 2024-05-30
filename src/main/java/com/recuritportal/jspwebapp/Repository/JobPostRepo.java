package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.recuritportal.jspwebapp.Entity.JobPost;

public interface JobPostRepo extends CrudRepository<JobPost, Integer>{
	
	JobPost  findByjobpostingid( Integer jobPostingId);
	List<JobPost>  findByjobtitle( String jobTitle);
	List<JobPost> findByjobdesc(String jobDesc);
	List<JobPost> findByfirmunqid(int firmunqid);
	//JobPost  findByjobtitleanddesc(String jobDesc);
    @Query("SELECT j FROM JobPost j WHERE j.jobdesc LIKE %:keyword%")
    List<JobPost> findByJobDescriptionContaining(String keyword);
    @Query("SELECT j FROM JobPost j ")
    List<JobPost> findByAllJobs();
}
