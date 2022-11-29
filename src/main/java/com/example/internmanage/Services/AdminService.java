package com.example.internmanage.Services;

import com.example.internmanage.Mapper.AdminMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public R checkLogin(String name,String password){
        if(password.equals(adminMapper.checkLogin(name)))
            return R.success();
//            return "loginSuccess";
        else return R.failed();
//            return "loginFailed";
    }
}
