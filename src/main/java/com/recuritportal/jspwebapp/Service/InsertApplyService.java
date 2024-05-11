package com.recuritportal.jspwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recuritportal.jspwebapp.Entity.Applyjob;
import com.recuritportal.jspwebapp.Repository.InsertApplyjobRepo;

@Service
public class InsertApplyService {
	@Autowired
	InsertApplyjobRepo applyjobRepo;
	
	public InsertApplyService(InsertApplyjobRepo ajRepo) {
		this.applyjobRepo = ajRepo;	
	}
		
    public boolean insertApplyJob(Applyjob applyJob) {

    	applyjobRepo.save(applyJob);
        return true;
    }
	
}
