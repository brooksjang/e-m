package com.example.em.controller;

import com.alibaba.fastjson.JSON;
import com.example.em.pojo.EmployeeVO;
import com.example.em.service.IEmployeeSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    Logger logger = (Logger) LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeSV employeeSV;

    /**
     * 获取所有员工基本信息：Json格式
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<EmployeeVO> findAll() {
        List<EmployeeVO> returnList = new ArrayList<>();
        try {
            returnList = employeeSV.getAll();
        } catch (Exception e) {
            logger.info("获取所有员工信息出错", e);
            throw new RuntimeException();
        }
        return returnList;
    }

    /**
     * 获取所有员工基本信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<EmployeeVO> returnList = employeeSV.getAll();
        model.addAttribute("employeeList", returnList);
        return "emps/list";
    }

    /**
     * 跳转到“新增员工界面”
     *
     * @param model
     * @return
     */
    @RequestMapping("/addEmployeeUI")
    public String addEmployeeUI(Model model) {
        List<EmployeeVO> list = employeeSV.getAllDepartment();
        model.addAttribute("deptList", list);
        return "emps/add";
    }

    /**
     * 展示所有的部门
     *
     * @return
     */
    @RequestMapping("/showDepartment")
    @ResponseBody
    public List<EmployeeVO> showDepartment() {
        return employeeSV.getAllDepartment();
    }

    /**
     * 新增员工
     *
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(EmployeeVO employeeVO) {
        logger.info("新增员工入参：" + JSON.toJSONString(employeeVO));
        employeeVO.seteCrtTime(new Date());
        employeeSV.addEmployee(employeeVO);
        return "redirect:/employee/getAll";
    }

    /**
     * 进入编辑员工界面，获取员工信息
     *
     * @return
     */
    @RequestMapping("/updateInfoUI/{eId}")
    public String updateEmployeeUI(@PathVariable Long eId, Model model) {
        EmployeeVO employeeVO = employeeSV.getInfoByEId(eId);
        model.addAttribute("employeeInfo", employeeVO);
        List<EmployeeVO> list = employeeSV.getAllDepartment();
        model.addAttribute("deptList", list);
        return "emps/update";
    }

    /**
     * 编辑员工
     *
     * @return
     */
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(EmployeeVO employeeVO) {
        logger.info("编辑员工入参：" + JSON.toJSONString(employeeVO));
        employeeSV.updateEmployee(employeeVO);
        return "redirect:/employee/getAll";
    }

    /**
     * 编辑员工
     *
     * @return
     */
    @RequestMapping(value = "/delEmployee/{eId}")
    public String delEmployee(@PathVariable Long eId) {
        employeeSV.delEmployee(eId);
        return "redirect:/employee/getAll";
    }


}
