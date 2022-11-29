package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("login")
    @ResponseBody
    public String teacherLogin(@RequestBody Teacher teacher){
        String name = teacher.getUsername();
        String password = teacher.getPassword();
        return teacherService.checkLogin(name,password);
    }

    @RequestMapping("register")
    @ResponseBody
    public String teacherRegister(@RequestBody Teacher teacher){
        return teacherService.register(teacher);
    }

    @RequestMapping("update")
    @ResponseBody
    public String teacherUpdate(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Teacher> teacherSelect(){
        return teacherService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public String teacherDelete(@RequestBody Teacher teacher){
        return teacherService.delelte(teacher.getT_id());
    }
}
