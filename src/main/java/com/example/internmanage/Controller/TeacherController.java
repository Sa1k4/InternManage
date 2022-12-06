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
    public R teacherLogin(@RequestParam Integer username,
                          @RequestParam String password) {
        return teacherService.checkLogin(username, password);
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
    public R deleteTeacher(@RequestBody List<Integer> ids) {
        return teacherService.deleteMultiple(ids);
    }

    @GetMapping("/applyOfNo{id}")
    public R teacherApplyOfNo(@PathVariable int id) {
        return teacherService.applyOfNo(id);
    }

    @GetMapping("/applyOfYes{id}")
    public R teacherApplyOfYes(@PathVariable int id) {
        return teacherService.applyOfYes(id);
    }

    @GetMapping("selectApply")
    public R selectApply(@RequestParam(defaultValue = "1") int apply,
                         @RequestParam int t_id,
                         @RequestParam Integer pageNum,
                         @RequestParam Integer pageSize,
                         @RequestParam String student_name,
                         @RequestParam String student_class,
                         @RequestParam String student_id
    ) {
        return teacherService.selectApply(apply, t_id, pageNum, pageSize, student_name, student_class, student_id);
    }

    //NOTE: 老师查看未添加的学生
    @GetMapping("findStudentF")
    public R findStudentF(@RequestParam int t_id,
                          @RequestParam Integer pageNum,
                          @RequestParam Integer pageSize,
                          @RequestParam String student_name,
                          @RequestParam String student_class,
                          @RequestParam String student_id
    ){
        return teacherService.findStudentF(t_id, pageNum, pageSize, student_name, student_class, student_id);
    }

    //NOTE: 老师查看添加的学生
    @GetMapping("findStudent")
    public R findStudent(@RequestParam int t_id,
                          @RequestParam Integer pageNum,
                          @RequestParam Integer pageSize,
                          @RequestParam String student_name,
                          @RequestParam String student_class,
                          @RequestParam String student_id
    ){
        return teacherService.findStudent(t_id, pageNum, pageSize, student_name, student_class, student_id);
    }

    //NOTE: 老师添加学生
    @GetMapping("addStudent")
    public R addStudent(@RequestParam Integer stu_id,@RequestParam Integer t_id){return teacherService.addStudent(stu_id,t_id);}

    @PostMapping("addStudentMultiple")
    public R addStudentMultiple(@RequestBody List<Integer> ids){
        int length = ids.size();
        int t_id = ids.get(length-1);
        ids.remove(length-1);
        return teacherService.addStudentMultiple(ids,t_id);
    }

    //NOTE: 老师删除学生
    @GetMapping("delStudent")
    public R delStudent(@RequestParam Integer stu_id,@RequestParam Integer t_id){return teacherService.deleteStu(stu_id,t_id);}

    @PostMapping("delStudentMultiple")
    public R delStudentMultiple(@RequestBody List<Integer> ids){
        int length = ids.size();
        int t_id = ids.get(length-1);
        ids.remove(length-1);
        return teacherService.deleteStuMultiple(ids,t_id);
    }

    @GetMapping("selectTSLeave")
    public R selectTSLeave(int t_id, String username, int apply, Integer pageNum, Integer pageSize) {
        return teacherService.selectTSLeave(t_id, username, apply, pageNum, pageSize);
    }

}
