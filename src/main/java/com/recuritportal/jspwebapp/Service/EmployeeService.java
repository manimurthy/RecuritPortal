package com.recuritportal.jspwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recuritportal.jspwebapp.Repository.*;
import com.recuritportal.jspwebapp.Entity.*;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;
//    private FirmRepo firmRepo ;

    public Employee validateCredentials(String empemail, String password) {
        Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
        return employee ;
    }
    public boolean checkEmployeeExists(String  empemail) {
    	 Employee employee = employeeRepository.findByEmpemail(empemail);
        return  employee != null;
    }       
    public boolean insertEmployeeDetails(Employee emp) {
      
    	employeeRepository.save(emp);
        return true;
    }    
    public Employee getEmployeeById(Integer empid) {
        return employeeRepository.findById(empid).orElse(null);
    }   
    public boolean updatetEmployeeDetails(Employee emp) {
        
    	employeeRepository.save(emp);
        return true;
    }        
}