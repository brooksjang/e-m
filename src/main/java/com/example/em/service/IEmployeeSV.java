package com.example.em.service;

import com.example.em.pojo.EmployeeVO;

import java.util.List;

public interface IEmployeeSV {
    List<EmployeeVO> getAll();

    List<EmployeeVO> getAllDepartment();

    void addEmployee(EmployeeVO employeeVO);

    EmployeeVO getInfoByEId(Long eId);

    void updateEmployee(EmployeeVO employeeVO);

    void delEmployee(Long eId);
}
