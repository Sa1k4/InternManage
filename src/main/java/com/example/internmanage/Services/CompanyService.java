package com.example.internmanage.Services;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public String checkLogin(String username,String password){
        if(password.equals(companyMapper.checkLogin(username)))
            return "loginSuccess";
        else return "loginFailed";
    }

    public String register(Company company){
        if (companyMapper.register(company)!=0)
            return "regSuccess";
        else return "regFailed";
    }

    public String update(Company company){
        if (companyMapper.update(company)!=0)
            return "updateSuccess";
        else return "updateFailed";
    }

    public List<Company> selectAll(){
        return companyMapper.selectAll();
    }

    public String delelte(int cpmy_id){
        if(companyMapper.delete(cpmy_id)!=0)
            return "delSuccess";
        else return "delFailed";
    }

}
