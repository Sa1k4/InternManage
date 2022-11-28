package com.example.internmanage.Services;

import com.example.internmanage.Mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public String checkLogin(String name,String password){
        if(password.equals(adminMapper.checkLogin(name)))
            return "loginSuccess";
        else return "loginFailed";
    }
}
