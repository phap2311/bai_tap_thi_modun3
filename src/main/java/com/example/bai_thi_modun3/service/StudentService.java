package com.example.bai_thi_modun3.service;

import com.example.bai_thi_modun3.models.Classes;
import com.example.bai_thi_modun3.models.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    @Override
    public List<Student> findAll(HttpServletRequest req, HttpServletResponse resp) {
        Connection connection = DBConnection.getConnection();
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select students.id, students.name_student,students.email, students.date_birth, students.address, students.phone_number,classes.name_class from students join classes on classes.id_class = students.id_class;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameStudent = resultSet.getString("name_student");
                String email = resultSet.getString("email");
                String dateBirth = resultSet.getString("date_birth");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone_number");

                String nameClass = resultSet.getString("name_class");
                Classes classes = new Classes(nameClass);
                Student student = new Student(id, nameStudent, email, dateBirth, address, phoneNumber, classes);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into students(name_student,email,date_birth,address,phone_number,id_class) values (?,?,?,?,?,?)");
            statement.setString(1, student.getNameStudent());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateBirth());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getPhoneNumber());
            statement.setInt(6, student.getClasses().getIdClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from students where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findByName(String nameStudent) {
        Connection connection = DBConnection.getConnection();
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select students.id,students.name_student,students.email, students.date_birth, students.address, students.phone_number,classes.name_class from students join classes on classes.id_class = students.id_class\n" +
                    "where students.name_student ?;\n" +
                    ";");
            statement.setString(1, nameStudent);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameStudents = resultSet.getString("name_student");
                String email = resultSet.getString("email");
                String dateBirth = resultSet.getString("date_birth");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone_number");

                String nameClass = resultSet.getString("name_class");
                Classes classes = new Classes(nameClass);
                Student student = new Student(id, nameStudents, email, dateBirth, address, phoneNumber, classes);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Connection connection = DBConnection.getConnection();
        Student student = null;
        try {
        PreparedStatement statement = connection.prepareStatement("select * from  students where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            String nameStudents = resultSet.getString("name_student");
            String email = resultSet.getString("email");
            String dateBirth = resultSet.getString("date_birth");
            String address = resultSet.getString("address");
            int phoneNumber = resultSet.getInt("phone_number");
            int idClass = resultSet.getInt("id_class");
            Classes classes = new Classes(idClass);
            student = new Student(id, nameStudents, email, dateBirth, address, phoneNumber, classes);

        }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
