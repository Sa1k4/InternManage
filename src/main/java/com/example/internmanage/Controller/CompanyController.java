package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("companyLogin")
    @ResponseBody
    public String companyLogin(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        return companyService.checkLogin(name,password);
    }

    @RequestMapping("companyRegister")
    @ResponseBody
    public String companyRegister(HttpServletRequest request){
        Company company = new Company();
        company.setCompany_name(request.getParameter("company_name"));
        company.setCompany_legal(request.getParameter("company_legal"));
        company.setCompany_licence(request.getParameter("company_licence"));
        company.setUsername(request.getParameter("username"));
        company.setPassword(request.getParameter("password"));
        return companyService.register(company);
    }

    @RequestMapping("companyUpdate")
    @ResponseBody
    public String companyUpdate(HttpServletRequest request){
        Company company = new Company();
        company.setCompany_name(request.getParameter("company_name"));
        company.setCompany_legal(request.getParameter("company_legal"));
        company.setCompany_licence(request.getParameter("company_licence"));
        company.setUsername(request.getParameter("username"));
        company.setPassword(request.getParameter("password"));
        return companyService.update(company);
    }

    @RequestMapping("companySelect")
    @ResponseBody
    public List<Company> companySelect(){
        return companyService.selectAll();
    }

    @RequestMapping("companyDelete")
    @ResponseBody
    public String companyDelete(HttpServletRequest request){
        return companyService.delelte(Integer.parseInt(request.getParameter("cpmy_id")));
    }

}
