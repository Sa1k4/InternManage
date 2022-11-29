package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Services.CompanyService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("login")
    @ResponseBody
    public R companyLogin(@RequestBody Company company){
        String name = company.getUsername();
        String password = company.getPassword();
        return companyService.checkLogin(name,password);
    }

    @RequestMapping("register")
    @ResponseBody
    public R companyRegister(@RequestBody Company company){
        return companyService.register(company);
    }

    @RequestMapping("update")
    @ResponseBody
    public R companyUpdate(@RequestBody Company company){
        return companyService.update(company);
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Company> companySelect(){
        return companyService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public R companyDelete(@RequestBody Company company){
        return companyService.delete(company.getCpmy_id());
    }

}
