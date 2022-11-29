package com.example.internmanage.Services;

import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Mapper.TeacherMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public R checkLogin(String username, String password){
        if(password.equals(teacherMapper.checkLogin(username)))
            return R.success();
        else return R.failed();
    }

    public R register(Teacher teacher){
        if (teacherMapper.register(teacher)!=0)
            return R.success();
        else return R.failed();
    }

    public R update(Teacher teacher){
        if (teacherMapper.update(teacher)!=0)
            return R.success();
        else return R.failed();
    }

    public List<Teacher> selectAll(){
        return teacherMapper.selectAll();
    }

    public R delete(int t_id){
        if(teacherMapper.delete(t_id)!=0)
            return R.success();
        else return R.failed();
    }
}
