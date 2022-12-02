package com.example.internmanage.Services;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Mapper.CompanyMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public R checkLogin(String username, String password) {
        if (password.equals(companyMapper.checkLogin(username)))
            return R.success().data("userinfo",companyMapper.selectCompany(username));
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

    public R selectAll(String company_name,Integer pageNum,Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = companyMapper.selectAllTotal(company_name);
        List<Company> result = companyMapper.selectAll(company_name,pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R delete(int cpmy_id) {
        if (companyMapper.delete(cpmy_id) != 0)
            return R.success();
//            return "delSuccess";
        else return R.failed();
//        else return "delFailed";
    }

    public R deleteMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (companyMapper.delete(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

}
