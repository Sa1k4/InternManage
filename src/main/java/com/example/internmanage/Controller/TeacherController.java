package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Services.TeacherService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("login")
    @ResponseBody
    public R teacherLogin(@RequestBody Teacher teacher){
        String name = teacher.getUsername();
        String password = teacher.getPassword();
        return teacherService.checkLogin(name,password);
    }

    @RequestMapping("register")
    @ResponseBody
    public R teacherRegister(@RequestBody Teacher teacher){
        return teacherService.register(teacher);
    }

    @RequestMapping("update")
    @ResponseBody
    public R teacherUpdate(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Teacher> teacherSelect(){
        return teacherService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public R teacherDelete(@RequestBody Teacher teacher){
        return teacherService.delete(teacher.getT_id());
    }
}
