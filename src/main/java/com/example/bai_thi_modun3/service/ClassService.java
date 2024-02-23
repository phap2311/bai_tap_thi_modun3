package com.example.bai_thi_modun3.service;

import com.example.bai_thi_modun3.models.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassService implements IClassService {
    @Override
    public List<Classes> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Classes> classesList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from classes");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idClass = resultSet.getInt("id_class");
                String nameClass = resultSet.getString("name_class");
                Classes classes = new Classes(idClass, nameClass);
                classesList.add(classes);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classesList;
    }
}
