package com.example.internmanage.Services;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Mapper.StudentMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public R checkLogin(String username, String password) {
        if (password.equals(studentMapper.checkLogin(username)))
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

    public R delelte(int stu_id) {
        if (studentMapper.delete(stu_id) != 0)
            return R.success();
        else return R.failed();
    }
}
