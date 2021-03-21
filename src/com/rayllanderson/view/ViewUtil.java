package com.rayllanderson.view;

import com.rayllanderson.model.entities.User;
import com.rayllanderson.model.entities.enums.Perfil;
import com.rayllanderson.model.utils.Assert;
import com.rayllanderson.model.utils.Generate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ViewUtil {

    public static void validateFields(User user){
        Assert.cpfIsValid(user.getCpf());
        Assert.notNull(user.getName(), "Nome");
        Assert.notNull(user.getEmail(), "Email");
        Assert.notNull(user.getBirthdate(), "Data de nascimento");
        Assert.notNull(user.getPerfil(), "Perfil");
    }

    public static DefaultTableModel createTableModal(){
        DefaultTableModel model = new DefaultTableModel() {
            boolean[] canEdit = new boolean [] {
                    false, true, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        model.setColumnIdentifiers(new String[]{"CPF", "Nome", "Email", "Perfil"});
        return model;
    }

}
