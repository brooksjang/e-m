package com.example.em.dao;

import com.example.em.pojo.EmployeeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    List<EmployeeVO> getAll();

    List<EmployeeVO> getAllDepartment();

    void addEmployee(EmployeeVO employeeVO);

    EmployeeVO getInfoByEId(@Param("eId") Long eId);

    void updateEmployeeByEId(EmployeeVO employeeVO);

    void delEmployee(@Param("eId")Long eId);
}
