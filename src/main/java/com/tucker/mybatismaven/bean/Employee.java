package com.tucker.mybatismaven.bean;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String last_name;
    private Integer age;
    private Integer d_id;
    private Department dept;
}
