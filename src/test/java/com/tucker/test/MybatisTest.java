package com.tucker.test;

import com.tucker.mybatismaven.bean.Department;
import com.tucker.mybatismaven.bean.Employee;
import com.tucker.mybatismaven.bean.User;
import com.tucker.mybatismaven.dao.IDepartmentMapper;
import com.tucker.mybatismaven.dao.IEmployeeMapper;
import com.tucker.mybatismaven.dao.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserMapper userMapper;
    private IEmployeeMapper empMapper;
    private IDepartmentMapper deptMapper;

    /*public static SqlSessionFactory getSqlSessionFactory() throws Exception{
        String resource = "mybatisConfig/mybatis-config.xml";

        InputStream in = Resources.getResourceAsStream(resource);

        return new SqlSessionFactoryBuilder().build(in);
    }*/
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("mybatisConfig/mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        sqlSession = factory.openSession(true);

        userMapper = sqlSession.getMapper(IUserMapper.class);

        empMapper = sqlSession.getMapper(IEmployeeMapper.class);

        deptMapper = sqlSession.getMapper(IDepartmentMapper.class);
    }

    @After
    public void destroy() throws IOException {
       /* sqlSession.commit();*/
        sqlSession.close();
        in.close();
    }

  @Test
    public void findAll(){
            List<User> users = userMapper.getAll();
            for (User user:users){
                System.out.println(user);}

    }

    @Test
    public void getOne(){
          Department dept = deptMapper.getDeptById(1);
            System.out.println(dept);
    }

    @Test
    public void insertUser() throws ParseException {
        String birthday = "1999-12-26";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birthday);
        User user = new User();
        user.setUsername("坤坤");
        user.setSex("男");
        user.setBirthday(date);
        user.setAddress("潼南");

        userMapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void deleteUser(){

        userMapper.deleteUserById(7);
    }

    @Test
    public void updateUser() throws ParseException {
        String birthday = "1999-12-26";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birthday);
        User user = new User();
        user.setId(6);
        user.setUsername("小猩猩");
        user.setSex("女");
        user.setBirthday(date);
        user.setAddress("潼南");

        userMapper.updateUserById(user);
    }

    @Test
    public void getUserByName(){

       List<User>  users = userMapper.getUserByName("%猩%");
       for(User user:users){
           System.out.println(user);
       }
    }

    @Test
    public void getCount(){
        Integer count = userMapper.getCount();
        System.out.println(count);
    }

    @Test
    public void getEmpById(){
       Employee employee = empMapper.getEmpById(3);
        System.out.println(employee);

    }

    @Test
    public void getEmpWithDept(){
        List<Employee> employees = empMapper.getEmpWithDep(1);
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Test
    public void getEmpByIdStep(){
        Employee employee = empMapper.getEmpByIdStep(3);
        System.out.println(employee);
        System.out.println(employee.getDept());
    }
}
