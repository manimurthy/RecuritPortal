package com.recuritportal.jspwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recuritportal.jspwebapp.Repository.*;
import com.recuritportal.jspwebapp.Entity.*;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;

    public boolean validateCredentials(String empemail, String password) {
        Employee employee = employeeRepository.findByEmpemailAndPassword(empemail, password);
        return employee != null;
    }
}