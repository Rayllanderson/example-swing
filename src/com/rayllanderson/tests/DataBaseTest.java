package com.rayllanderson.tests;

import com.rayllanderson.model.dao.UserDao;
import com.rayllanderson.model.entities.User;
import com.rayllanderson.model.entities.enums.Perfil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataBaseTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static UserDao userDao = new UserDao();

    public static void main(String[] args) throws SQLException, ParseException {
//        saveUser();
        findByCpf();
        System.out.println("------------------------");
        findALL();
        System.out.println("------------------------");
        deleteByCpf();
        findByCpf();
    }

    public static void saveUser() throws ParseException {
        User user = new User();
        user.setCpf(05361456244);
        user.setName("João Lucas Costa Silva");
        user.setEmail("jooooao@email.com");
        user.setBirthdate(sdf.parse("20-03-1941"));
        user.setPerfil(Perfil.PREPOSTO);
        user.setActive(true);
        userDao.save(user);
    }

    public static void findByCpf(){
        User user = userDao.findByCpf(05361456244);
        System.out.println(user);
    }

    public static void findALL(){
        userDao.findAll().forEach(System.out::println);
    }

    public static void deleteByCpf(){
        userDao.deleteByCpf(05361456244);
    }
}
