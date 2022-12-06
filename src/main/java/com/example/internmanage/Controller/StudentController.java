package com.example.internmanage.Controller;

import com.example.internmanage.Entity.StuLPRW;
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
    public R upload(@RequestBody Student student) {
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

    // NOTE: 学生提交岗位申请
    @GetMapping("applyPro")
    public R studentApplyPro(@RequestParam int stu_id, @RequestParam int id) {
        return studentService.applyPro(stu_id, id);
    }

    // NOTE: 检查学生是否就职
    @GetMapping("checkPro")
    public R studentCheckPro(@RequestParam int stu_id) {
        return studentService.checkPro(stu_id);
    }

    //NOTE: 学生实习请假申请查看(学生端)
    @GetMapping("stuLeaveS")
    public R stuLeaveS(@RequestParam int stu_id,
                      @RequestParam int pageNum,
                      @RequestParam int pageSize) {
        return studentService.stuLeaveS(stu_id,pageNum,pageSize);
    }

    //NOTE: 学生周报
    @GetMapping("stuWeekS")
    public R stuWeekS(@RequestParam int stu_id,
                       @RequestParam int pageNum,
                       @RequestParam int pageSize) {
        return studentService.stuWeekS(stu_id,pageNum,pageSize);
    }

    //NOTE: 学生计划
    @GetMapping("stuPlanS")
    public R stuPlanS(@RequestParam int stu_id,
                       @RequestParam int pageNum,
                       @RequestParam int pageSize) {
        return studentService.stuPlanS(stu_id,pageNum,pageSize);
    }

    //NOTE: 学生报告
    @GetMapping("stuRepoS")
    public R stuRepoS(@RequestParam int stu_id,
                       @RequestParam int pageNum,
                       @RequestParam int pageSize) {
        return studentService.stuRepoS(stu_id,pageNum,pageSize);
    }

    //NOTE: 学生实习请假申请(学生端)
    @PostMapping("stuLeaveI")
    public R stuLeaveI(@RequestBody StuLPRW stuLPRW) {
        return studentService.stuLeaveI(stuLPRW);
    }

    //NOTE: 学生实习周报新增
    @PostMapping("stuWeek")
    public R stuWeek(@RequestBody StuLPRW stuLPRW) {
        return studentService.stuWeek(stuLPRW);
    }

    //NOTE: 学生实习计划新增
    @PostMapping("stuPlan")
    public R stuPlan(@RequestBody StuLPRW stuLPRW) {
        return studentService.stuPlan(stuLPRW);
    }

    //NOTE: 学生实习报告新增
    @PostMapping("stuRepo")
    public R stuRepo(@RequestBody StuLPRW stuLPRW) {
        return studentService.stuRepo(stuLPRW);
    }

    //NOTE: 学生实习请假申请
    @GetMapping("stuLeave")
    public R stuLeave(@RequestParam int stu_id,
                      @RequestParam int apply,
                      @RequestParam int pageNum,
                      @RequestParam int pageSize) {
        return studentService.stuLeave(stu_id,apply,pageNum,pageSize);
    }

    //NOTE: 审核申请
    @GetMapping("updateLeave")
    public R updateLeave(@RequestParam int apply,
                         @RequestParam int id){
        return studentService.updateLeave(apply, id);
    }

}
