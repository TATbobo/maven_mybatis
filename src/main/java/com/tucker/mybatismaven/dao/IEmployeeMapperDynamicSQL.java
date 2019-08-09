package com.tucker.mybatismaven.dao;

import com.tucker.mybatismaven.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeMapperDynamicSQL {

    Employee getEmpByCondition(Employee emp);

    Employee getEmpByOneCondition(Employee emp);

    void BulkInsertEmp(@Param("emps") List<Employee> employees);

    List<Employee> getEmpPageByd_id(Integer d_id);
}
