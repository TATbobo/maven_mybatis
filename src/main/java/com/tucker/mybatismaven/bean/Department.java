package com.tucker.mybatismaven.bean;

import lombok.Data;

import java.util.List;

@Data
public class Department {

    private Integer id;
    private String last_name;
    private List<Employee> emps;
}
