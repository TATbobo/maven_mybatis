package com.tucker.mybatismaven.dao;

import com.tucker.mybatismaven.bean.Employee;

import java.util.List;

public interface IEmployeeMapper {

    Employee getEmpById(Integer id);

    List<Employee> getEmpWithDep(Integer id);

    Employee getEmpByIdStep(Integer id);
}
