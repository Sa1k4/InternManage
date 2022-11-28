package com.example.internmanage.Controller;

import com.example.internmanage.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("adminLogin")
    @ResponseBody
    public String adminLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        return adminService.checkLogin(name,password);
    }
}
