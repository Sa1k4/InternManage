package com.example.internmanage.Services;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.TSLeave;
import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Mapper.TeacherMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public R checkLogin(Integer username, String password) {
        if (password.equals(teacherMapper.checkLogin(username)))
            return R.success().data("userinfo", teacherMapper.selectTeacher(username));
        else return R.failed();
    }

    public R register(Teacher teacher) {
        if (teacherMapper.register(teacher) != 0)
            return R.success();
        else return R.failed();
    }

    public R update(Teacher teacher) {
        if (teacherMapper.update(teacher) != 0)
            return R.success();
        else return R.failed();
    }

    public R selectAll(String username, String academy, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = teacherMapper.selectAllTotal(username, academy);
        List<Teacher> result = teacherMapper.selectAll(username, academy, pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R delete(int t_id) {
        if (teacherMapper.delete(t_id) != 0)
            return R.success();
        else return R.failed();
    }

    public R deleteMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (teacherMapper.delete(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R applyOfNo(int stu_id) {
        if (teacherMapper.applyOfNo(stu_id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R applyOfYes(int stu_id) {
        if (teacherMapper.applyOfYes(stu_id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R stuLeave21(int id) {
        if (teacherMapper.stuLeave21(id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R stuLeave22(int id) {
        if (teacherMapper.stuLeave22(id) != 0) {
            return R.success();
        } else return R.failed();
    }

    public R selectApply(int apply, int t_id, Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = teacherMapper.selectApplyTotal(apply, t_id, student_name, student_class, student_id);
        List<Student> result = teacherMapper.selectApply(apply, t_id, pageNum, pageSize, student_name, student_class, student_id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R findStudentF(int t_id, Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = teacherMapper.findStudentFC(t_id, student_name, student_class, student_id);
        List<Student> result = teacherMapper.findStudentF(t_id, pageNum, pageSize, student_name, student_class, student_id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R findStudent(int t_id, Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = teacherMapper.findStudentC(t_id, student_name, student_class, student_id);
        List<Student> result = teacherMapper.findStudent(t_id, pageNum, pageSize, student_name, student_class, student_id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R addStudent(int stu_id,int t_id) {
        if (teacherMapper.addStudent(stu_id, t_id) != 0)
            return R.success();
        else return R.failed();
    }

    public R addStudentMultiple(List<Integer> ids,int t_id) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (teacherMapper.addStudent(ids.get(i),t_id) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R deleteStu(int stu_id,int t_id) {
        if (teacherMapper.deleteStu(stu_id, t_id) != 0)
            return R.success();
        else return R.failed();
    }

    public R deleteStuMultiple(List<Integer> ids,int t_id) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (teacherMapper.deleteStu(ids.get(i),t_id) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R selectTSLeave(int t_id,String username,int apply,Integer pageNum,Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = teacherMapper.selectTSLeaveTotal(t_id, username, apply);
        List<TSLeave> result = teacherMapper.selectTSLeave(t_id, username, apply, pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

}
