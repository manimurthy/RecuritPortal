package com.recuritportal.jspwebapp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.recuritportal.jspwebapp.Entity.LikedJobs;

public interface LikedJobsRepo  extends CrudRepository<LikedJobs, Integer>{
    List<LikedJobs> findByEmpID(Integer empID);
}
