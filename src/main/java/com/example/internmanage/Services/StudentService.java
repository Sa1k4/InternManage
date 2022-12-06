package com.example.internmanage.Services;

import com.example.internmanage.Entity.StuLPRW;
import com.example.internmanage.Entity.Student;
import com.example.internmanage.Mapper.StudentMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public R checkLogin(Integer username, String password) {
        if (password.equals(studentMapper.checkLogin(username)))
            return R.success().data("userinfo", studentMapper.selectStudent(username));
        else return R.failed();
    }

    public R upload(Student student) {
        if (studentMapper.upload(student) !=0)
            return R.success();
        else return R.failed();
    }

    public R register(Student student) {
        if (studentMapper.register(student) != 0)
            return R.success();
        else return R.failed();
    }

    public R update(Student student) {
        if (studentMapper.update(student) != 0)
            return R.success();
        else return R.failed();
    }

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public R selectPage(Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.selectTotal(student_name, student_class, student_id);
        List<Student> result = studentMapper.selectPage(pageNum, pageSize, student_name, student_class, student_id);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R deleteMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (studentMapper.delete(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R delete(int stu_id) {
        if (studentMapper.delete(stu_id) != 0)
            return R.success();
        else return R.failed();
    }

    public R apply(int stu_id) {
        if (studentMapper.apply(stu_id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R applyPro(int stu_id, int id) {
        if (studentMapper.applyPro(stu_id, id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R checkPro(int stu_id) {
        return R.success().data("checkPro", studentMapper.checkPro(stu_id));
    }

    public R stuLeaveS(int stu_id,int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.stuLeaveSC(stu_id);
        List<StuLPRW> result = studentMapper.stuLeaveS(stu_id,pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R stuWeekS(int stu_id,int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.stuWeekSC(stu_id);
        List<StuLPRW> result = studentMapper.stuWeekS(stu_id,pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R stuPlanS(int stu_id,int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.stuPlanSC(stu_id);
        List<StuLPRW> result = studentMapper.stuPlanS(stu_id,pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R stuRepoS(int stu_id,int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.stuRepoSC(stu_id);
        List<StuLPRW> result = studentMapper.stuRepoS(stu_id,pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R stuLeaveI(StuLPRW stuLPRW) {
        if (studentMapper.stuLeaveI(stuLPRW) != 0)
            return R.success();
        else return R.failed();
    }

    public R stuWeek(StuLPRW stuLPRW) {
        if (studentMapper.stuWeek(stuLPRW) != 0)
            return R.success();
        else return R.failed();
    }

    public R stuPlan(StuLPRW stuLPRW) {
        if (studentMapper.stuPlan(stuLPRW) != 0)
            return R.success();
        else return R.failed();
    }

    public R stuRepo(StuLPRW stuLPRW) {
        if (studentMapper.stuRepo(stuLPRW) != 0)
            return R.success();
        else return R.failed();
    }

    public R stuLeave(int stu_id,int apply,int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = studentMapper.stuLeaveC(stu_id,apply);
        List<StuLPRW> result = studentMapper.stuLeave(stu_id,apply,pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", result);
        res.put("total", total);
        return R.success().data(res);
    }

    public R updateLeave(int apply,int id) {
        if (studentMapper.updateLeave(apply,id) != 0)
            return R.success();
        else return R.failed();
    }
}
