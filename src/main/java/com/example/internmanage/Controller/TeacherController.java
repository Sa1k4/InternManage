package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Services.TeacherService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private TeacherService teacherService;
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("login")
    public R teacherLogin(@RequestBody Teacher teacher) {
        String name = teacher.getUsername();
        String password = teacher.getPassword();
        return teacherService.checkLogin(name, password);
    }

    @RequestMapping("register")
    public R teacherRegister(@RequestBody Teacher teacher) {
        return teacherService.register(teacher);
    }

    @RequestMapping("update")
    public R teacherUpdate(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    @GetMapping("select")
    public R teacherSelect(@RequestParam String username, @RequestParam String academy, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return teacherService.selectAll(username, academy, pageNum, pageSize);
    }

    @RequestMapping("delete{id}")
    public R teacherDelete(@PathVariable Integer id) {
        return teacherService.delete(id);
    }

    @PostMapping("/deleteMultiple")
    public R deleteTeacher(@RequestBody List<Integer> ids){
        return teacherService.deleteMultiple(ids);
    }
}
