package com.example.internmanage.Services;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.internmanage.Mapper.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public String checkLogin(String username,String password){
        if(password.equals(studentMapper.checkLogin(username)))
            return "loginSuccess";
        else return "loginFailed";
    }

    public String register(Student student){
        if (studentMapper.register(student)!=0)
            return "regSuccess";
        else return "regFailed";
    }

    public String update(Student student){
        if (studentMapper.update(student)!=0)
            return "updateSuccess";
        else return "updateFailed";
    }

    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

    public String delelte(int stu_id){
        if(studentMapper.delete(stu_id)!=0)
            return "delSuccess";
        else return "delFailed";
    }
}
