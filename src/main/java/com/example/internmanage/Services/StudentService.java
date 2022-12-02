package com.example.internmanage.Services;

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
}
