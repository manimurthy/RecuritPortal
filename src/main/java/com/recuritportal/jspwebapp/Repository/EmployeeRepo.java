package com.recuritportal.jspwebapp.Repository;

import org.springframework.data.repository.CrudRepository;
import com.recuritportal.jspwebapp.Entity.*;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	Employee findByEmpemailAndPassword(String empemail, String password);
}
