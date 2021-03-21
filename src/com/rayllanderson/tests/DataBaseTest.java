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
    }

    public static void saveUser() throws ParseException {
        User user = new User();
        user.setCpf(05361456213);
        user.setName("João");
        user.setEmail("joao@email.com");
        user.setBirthdate(sdf.parse("20-03-2021"));
        user.setPerfil(Perfil.AUXILIAR);
        user.setActive(true);
        userDao.save(user);
    }

    public static void findByCpf(){
        User user = userDao.findByCpf(734420109);
        System.out.println(user);
    }
}
