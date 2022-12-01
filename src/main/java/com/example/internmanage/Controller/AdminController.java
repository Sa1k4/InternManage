package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Admin;
import com.example.internmanage.Services.AdminService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("login")
    public R adminLogin(@RequestBody Admin admin){
        String name = admin.getUsername();
        String password = admin.getPassword();
        return adminService.checkLogin(name,password);
    }
}
