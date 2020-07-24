package com.example.em.service.impl;

import com.example.em.dao.EmployeeDao;
import com.example.em.pojo.EmployeeVO;
import com.example.em.service.IEmployeeSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSVImpl implements IEmployeeSV {
    @Autowired
    private EmployeeDao employeeDao;

    //获取所有员工信息
    @Override
    public List<EmployeeVO> getAll() {
        return employeeDao.getAll();
    }

    //获取所有部门信息
    @Override
    public List<EmployeeVO> getAllDepartment() {
        return employeeDao.getAllDepartment();
    }

    //新增员工
    @Override
    public void addEmployee(EmployeeVO employeeVO) {
        employeeDao.addEmployee(employeeVO);
    }

    //根据id查询员工信息
    @Override
    public EmployeeVO getInfoByEId(Long eId) {
        return employeeDao.getInfoByEId(eId);
    }

    //修改员工信息
    @Override
    public void updateEmployee(EmployeeVO employeeVO) {
        employeeDao.updateEmployeeByEId(employeeVO);
    }

    //删除员工
    @Override
    public void delEmployee(Long eId) {
        employeeDao.delEmployee(eId);
    }
}
