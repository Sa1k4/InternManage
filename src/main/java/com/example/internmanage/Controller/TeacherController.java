package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("teacherLogin")
    @ResponseBody
    public String teacherLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        return teacherService.checkLogin(name,password);
    }

    @RequestMapping("teacherRegister")
    @ResponseBody
    public String teacherRegister(HttpServletRequest request){
        Teacher teacher = new Teacher();
        teacher.setT_id(Integer.parseInt(request.getParameter("t_id")));
        teacher.setUsername(request.getParameter("username"));
        teacher.setPassword(request.getParameter("password"));
        return teacherService.register(teacher);
    }

    @RequestMapping("teacherUpdate")
    @ResponseBody
    public String teacherUpdate(HttpServletRequest request){
        Teacher teacher = new Teacher();
        teacher.setT_id(Integer.parseInt(request.getParameter("t_id")));
        teacher.setUsername(request.getParameter("username"));
        teacher.setPassword(request.getParameter("password"));
        teacher.setAcademy(request.getParameter("academy"));
        teacher.setSex(request.getParameter("sex"));
        teacher.setPhone(request.getParameter("phone"));
        return teacherService.update(teacher);
    }

    @RequestMapping("teacherSelect")
    @ResponseBody
    public List<Teacher> teacherSelect(){
        return teacherService.selectAll();
    }

    @RequestMapping("teacherDelete")
    @ResponseBody
    public String teacherDelete(HttpServletRequest request){
        return teacherService.delelte(Integer.parseInt(request.getParameter("t_id")));
    }
}
