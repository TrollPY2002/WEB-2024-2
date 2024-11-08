package com.web2024_2.dto;

import com.web2024_2.model.Employee;
import com.web2024_2.model.Role;

import lombok.Data;
@Data
public class EmployeeRoleDTO {

    private Long employeeId;
    private String employeeName;
    private String roleName;

    // Constructor
    public EmployeeRoleDTO(Employee employee, Role role) {
        this.employeeId = employee.getId();
        this.employeeName = employee.getFirst_name() + " " + employee.getLast_name();
        this.roleName = role.getName();
    }

}
