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

    public boolean validateCredentials(String empemail, String password) {
        Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
        return employee != null;
    }
    public boolean insertEmployeeDetails(Employee emp) {
        //Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
    	employeeRepository.save(emp);
        return true;
    }    
/*    public boolean validatefirmCredentials(String firmemail, String password) {
        Firm firm= firmRepo.findByFirmemailAndPassword(firmemail, password);
        return firm != null;
    }*/    
}