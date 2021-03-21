package com.rayllanderson.view;

import com.rayllanderson.model.entities.User;
import com.rayllanderson.model.entities.enums.Perfil;
import com.rayllanderson.model.utils.Assert;
import com.rayllanderson.model.utils.Generate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

public class ViewUtil {

    public static User getUser(JTextField textName, JTextField textEmail, JComboBox<String> genderBox){
        String name = textName.getText();
        String email = textEmail.getText();
        String sex = Objects.requireNonNull(genderBox.getSelectedItem()).toString();
        return new User();
    }

    public static void validateFields(User user){
        Assert.notNull(user.getName(), "Nome");
        Assert.notNull(user.getEmail(), "Email");
//        Assert.notNull(user.getGender().toString(), "Sexo");
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
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Email", "Sexo"});
        return model;
    }

}
