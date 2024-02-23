package com.example.bai_thi_modun3.service;

import com.example.bai_thi_modun3.models.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IStudentService {
    List<Student> findAll(HttpServletRequest req, HttpServletResponse resp);

    void save(Student student);

    void delete(int id);

    List<Student> findByName(String nameStudent);

    Student findById(int id);
}
