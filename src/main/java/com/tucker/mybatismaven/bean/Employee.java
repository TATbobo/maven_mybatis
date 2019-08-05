package com.tucker.mybatismaven.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String last_name;
    private Integer age;
    private Integer d_id;
    private Department dept;


    public Employee(Integer id, String last_name, Integer age, Integer d_id) {
        this.id = id;
        this.last_name = last_name;
        this.age = age;
        this.d_id = d_id;
    }
}
