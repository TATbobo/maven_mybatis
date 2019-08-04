package com.tucker.mybatismaven.dao;

import com.tucker.mybatismaven.bean.User;
import lombok.Data;

import java.util.List;

public interface IUserMapper {

    List<User> getAll();

    User getUserById(Integer id);

    void deleteUserById(Integer id);

    void updateUserById(User user);

    void  insertUser(User user);

    List<User> getUserByName(String name);

    Integer getCount();
}
