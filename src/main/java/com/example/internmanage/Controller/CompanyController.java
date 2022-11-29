package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("login")
    @ResponseBody
    public String companyLogin(@RequestBody Company company){
        String name = company.getUsername();
        String password = company.getPassword();
        return companyService.checkLogin(name,password);
    }

    @RequestMapping("register")
    @ResponseBody
    public String companyRegister(@RequestBody Company company){
        return companyService.register(company);
    }

    @RequestMapping("update")
    @ResponseBody
    public String companyUpdate(@RequestBody Company company){
        return companyService.update(company);
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Company> companySelect(){
        return companyService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public String companyDelete(@RequestBody Company company){
        return companyService.delelte(company.getCpmy_id());
    }

}
