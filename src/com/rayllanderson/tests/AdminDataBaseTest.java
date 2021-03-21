package com.rayllanderson.tests;

import com.rayllanderson.model.dao.impl.AdminDao;
import com.rayllanderson.model.dao.utils.Assert;
import com.rayllanderson.model.entities.Admin;

import java.text.ParseException;

public class AdminDataBaseTest {

    private static AdminDao adminDao = new AdminDao();

    public static void main(String[] args) throws ParseException {
//        register();
//        findById(); ok
//        findALL(); ok
//        deleteById();
    }

    public static void register() throws ParseException {
        Admin admin = new Admin(null, "rayaal", "123");
        Assert.usernameNotExists(admin.getUsername());
        adminDao.save(admin);
    }

    public static void findById(){
        System.out.println(adminDao.findById(2L));
    }

    public static void findALL(){
        adminDao.findAll().forEach(System.out::println);
    }

    public static void deleteById(){
        adminDao.deleteById(5L);
    }
}
