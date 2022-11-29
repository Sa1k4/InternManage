package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Services.StudentService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("login")
    @ResponseBody
    public R studentLogin(@RequestBody Student student){
        String name = student.getUsername();
        String password = student.getPassword();
        return studentService.checkLogin(name,password);
    }

    @RequestMapping("register")
    @ResponseBody
    public R studentRegister(@RequestBody Student student){
        return studentService.register(student);
    }

    @RequestMapping("update")
    @ResponseBody
    public R studentUpdate(@RequestBody Student student){
        return studentService.update(student);
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Student> studentSelect(){
        return studentService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public R studentDelete(@RequestBody Student student){
        return studentService.delete(student.getStu_id());
    }
}
