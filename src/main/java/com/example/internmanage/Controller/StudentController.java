package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Entity.Student;
import com.example.internmanage.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("studentLogin")
    @ResponseBody
    public String studentLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        return studentService.checkLogin(name,password);
    }

    @RequestMapping("studentRegister")
    @ResponseBody
    public String studentRegister(HttpServletRequest request){
        Student student = new Student();
        student.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
        student.setUsername(request.getParameter("username"));
        student.setPassword(request.getParameter("password"));
        return studentService.register(student);
    }

    @RequestMapping("studentUpdate")
    @ResponseBody
    public String studentUpdate(HttpServletRequest request){
        Student student = new Student();
        student.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
        student.setUsername(request.getParameter("username"));
        student.setPassword(request.getParameter("password"));
        student.setSpecialty(request.getParameter("specialty"));
        student.setClassname(request.getParameter("classname"));
        student.setAcademy(request.getParameter("academy"));
        student.setSex(request.getParameter("sex"));
        student.setPhone(request.getParameter("phone"));
        return studentService.update(student);
    }

    @RequestMapping("studentSelect")
    @ResponseBody
    public List<Student> studentSelect(){
        return studentService.selectAll();
    }

    @RequestMapping("studentDelete")
    @ResponseBody
    public String studentDelete(HttpServletRequest request){
        return studentService.delelte(Integer.parseInt(request.getParameter("stu_id")));
    }
}
