package com.example.bai_thi_modun3.controllers;

import com.example.bai_thi_modun3.models.Classes;
import com.example.bai_thi_modun3.models.Student;
import com.example.bai_thi_modun3.service.ClassService;
import com.example.bai_thi_modun3.service.IClassService;
import com.example.bai_thi_modun3.service.IStudentService;
import com.example.bai_thi_modun3.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    IClassService iClassService = new ClassService();
    IStudentService iStudentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "edit":
                showFormEdit(req,resp);
                break;

            default:
                showFormList(req, resp);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit");
        int id = Integer.parseInt(req.getParameter("id"));
        List<Classes>classesList = iClassService.findAll();
        req.setAttribute("classes",classesList);
        Student student = iStudentService.findById(id);
        req.setAttribute("student",student);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        String nameStudent = req.getParameter("nameStudent");
        List<Classes> classesList = iClassService.findAll();
        req.setAttribute("classes", classesList);
        List<Student> studentList = iStudentService.findByName(nameStudent);
        req.setAttribute("student", studentList);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        iStudentService.delete(id);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        List<Classes> classesList = iClassService.findAll();
        req.setAttribute("classes", classesList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<Student> studentList = iStudentService.findAll(req, resp);
        req.setAttribute("student", studentList);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "delete":
                // deleteStudent(req,resp);
                break;
            case "edit":
                editStudent(req,resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                showFormList(req, resp);
                break;
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String nameStudent = req.getParameter("nameStudent");
        String email = req.getParameter("email");
        String dateBirth = req.getParameter("dateBirth");
        String address = req.getParameter("address");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        int idClass = Integer.parseInt(req.getParameter("idClass"));
        String nameClass = req.getParameter("nameClass");
        Classes classes = new Classes(idClass, nameClass);
        Student student = new Student(id,nameStudent, email, dateBirth, address, phoneNumber, classes);
        iStudentService.save(student);
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) {
        String nameStudent = req.getParameter("nameStudent");
        String email = req.getParameter("email");
        String dateBirth = req.getParameter("dateBirth");
        String address = req.getParameter("address");
        int phoneNumber = Integer.parseInt(req.getParameter("phoneNumber"));
        int idClass = Integer.parseInt(req.getParameter("idClass"));
        String nameClass = req.getParameter("nameClass");
        Classes classes = new Classes(idClass, nameClass);
        Student student = new Student(nameStudent, email, dateBirth, address, phoneNumber, classes);
        iStudentService.save(student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
