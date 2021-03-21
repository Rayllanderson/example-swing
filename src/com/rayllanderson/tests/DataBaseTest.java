package com.rayllanderson.tests;

import com.rayllanderson.model.dao.impl.UserDao;
import com.rayllanderson.model.entities.User;
import com.rayllanderson.model.entities.enums.Perfil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataBaseTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private static UserDao userDao = new UserDao();

    public static void main(String[] args) throws SQLException, ParseException {
        //734420109
//        saveUser();
//        findByCpf();
//        System.out.println("------------------------");
//        findALL();
//        System.out.println("------------------------");
//        deleteByCpf();
//        findByCpf(); //must be null
//        updateUser();
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

    public static void updateUser() throws ParseException {
        User oldUser = userDao.findByCpf(734420108);
        System.out.println(oldUser.getName().equals("João Lucas Costa Silva")); //nome antigo
        User user = new User();
        user.setCpf(734420108);
        user.setName("João upgradado Costa Silva");
        user.setEmail("joao242424242424@email.com");
        user.setBirthdate(sdf.parse("20-03-1941"));
        user.setPerfil(Perfil.PREPOSTO);
        user.setActive(false);
        userDao.update(user);
        User newUser = userDao.findByCpf(734420108);
        System.out.println(newUser.getName().equals("João upgradado Costa Silva")); //novo nome
    }


}
