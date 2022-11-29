package com.example.internmanage.Services;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Mapper.CompanyMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public R checkLogin(String username, String password) {
        if (password.equals(companyMapper.checkLogin(username)))
            return R.success();
//            return "loginSuccess";
        else return R.failed();
//        else return "loginFailed";
    }

    public R register(Company company) {
        if (companyMapper.register(company) != 0)
            return R.success();
//            return "regSuccess";
        else return R.failed();
//        else return "regFailed";
    }

    public R update(Company company) {
        if (companyMapper.update(company) != 0)
            return R.success();
//            return "updateSuccess";
        else return R.failed();
//        else return "updateFailed";
    }

    public List<Company> selectAll() {
        return companyMapper.selectAll();
    }

    public R delete(int cpmy_id) {
        if (companyMapper.delete(cpmy_id) != 0)
            return R.success();
//            return "delSuccess";
        else return R.failed();
//        else return "delFailed";
    }

}
