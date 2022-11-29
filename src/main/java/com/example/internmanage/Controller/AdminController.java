package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Admin;
import com.example.internmanage.Services.AdminService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public R adminLogin(@RequestBody Admin admin){
        String name = admin.getName();
        String password = admin.getPassword();
        return adminService.checkLogin(name,password);
    }
}
