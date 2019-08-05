package com.tucker.mybatismaven.dao;

import com.tucker.mybatismaven.bean.Department;

import java.util.List;

public interface IDepartmentMapper {

    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);

    Department getDeptByIdStep(Integer id);
}
