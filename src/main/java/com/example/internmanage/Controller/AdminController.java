package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Admin;
import com.example.internmanage.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public String adminLogin(@RequestBody Admin admin){
        String name = admin.getName();
        String password = admin.getPassword();
        return adminService.checkLogin(name,password);
    }
}
