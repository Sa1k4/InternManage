package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Services.StudentService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping("login")
    public R studentLogin(@RequestParam Integer username,
                          @RequestParam String password) {
        return studentService.checkLogin(username, password);
    }

    @PostMapping("upload")
    public R upload(@RequestBody Student student){
        return studentService.upload(student);
    }

    @RequestMapping("register")
    public R studentRegister(@RequestBody Student student) {
        return studentService.register(student);
    }

    @RequestMapping("update")
    public R studentUpdate(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping("select")
    public List<Student> studentSelect() {
        return studentService.selectAll();
    }

    @GetMapping("page")
    public R findPage(@RequestParam Integer pageNum,
                      @RequestParam Integer pageSize,
                      @RequestParam String username,
                      @RequestParam String classname,
                      @RequestParam String stu_id) {
        return studentService.selectPage(pageNum, pageSize, username, classname, stu_id);
    }

    @RequestMapping("delete{id}")
    public R studentDelete(@PathVariable Integer id) {
        return studentService.delete(id);
    }

    @PostMapping("/deleteMultiple")
    public R deleteStudent(@RequestBody List<Integer> ids) {
        return studentService.deleteMultiple(ids);
    }

    @GetMapping("/apply{id}")
    public R studentApply(@PathVariable int id) {
        return studentService.apply(id);
    }
}
