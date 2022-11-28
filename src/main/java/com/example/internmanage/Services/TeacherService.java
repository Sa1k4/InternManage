package com.example.internmanage.Services;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.Teacher;
import com.example.internmanage.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public String checkLogin(String username,String password){
        if(password.equals(teacherMapper.checkLogin(username)))
            return "loginSuccess";
        else return "loginFailed";
    }

    public String register(Teacher teacher){
        if (teacherMapper.register(teacher)!=0)
            return "regSuccess";
        else return "regFailed";
    }

    public String update(Teacher teacher){
        if (teacherMapper.update(teacher)!=0)
            return "updateSuccess";
        else return "updateFailed";
    }

    public List<Teacher> selectAll(){
        return teacherMapper.selectAll();
    }

    public String delelte(int t_id){
        if(teacherMapper.delete(t_id)!=0)
            return "delSuccess";
        else return "delFailed";
    }
}
