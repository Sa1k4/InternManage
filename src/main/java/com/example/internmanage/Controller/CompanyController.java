package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Services.CompanyService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("login")
    public R companyLogin(@RequestBody Company company) {
        String name = company.getUsername();
        String password = company.getPassword();
        return companyService.checkLogin(name, password);
    }

    @RequestMapping("register")
    public R companyRegister(@RequestBody Company company) {
        return companyService.register(company);
    }

    @RequestMapping("update")
    public R companyUpdate(@RequestBody Company company) {
        return companyService.update(company);
    }

    @GetMapping("select")
    public R companySelect(String company_name, Integer pageNum, Integer pageSize) {
        return companyService.selectAll(company_name, pageNum, pageSize);
    }

    @RequestMapping("delete")
    public R companyDelete(@RequestBody Company company) {
        return companyService.delete(company.getCpmy_id());
    }

    @PostMapping("/deleteMultiple")
    public R deleteCompany(@RequestBody List<Integer> ids) {
        return companyService.deleteMultiple(ids);
    }

}
