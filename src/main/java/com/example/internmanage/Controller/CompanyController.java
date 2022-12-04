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

    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("login")
    public R companyLogin(@RequestParam String username,
                          @RequestParam String password) {
        return companyService.checkLogin(username, password);
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

    // NOTE: 根据岗位id 查询 相应公司的详细信息
    @GetMapping("/selectOfCompany")
    public R selectOfCompany(@RequestParam int id) {
        return companyService.selectOfCompany(id);
    }

    // NOTE: 显示所有的申请(分页)
    @GetMapping("/selectAllOfProStu")
    public R selectAllOfProStu(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return companyService.selectAllOfProStu(pageNum, pageSize);
    }

    //NOTE: 显示所有该岗位下的学生申请
    @GetMapping("/selectApply")
    public R selectApply(@RequestParam Integer pro_id,@RequestParam String username,@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return companyService.selectApply(pro_id,username,pageNum,pageSize);
    }

    //NOTE: 显示所有该岗位下的学生
    @GetMapping("/selectApply1")
    public R selectApply1(@RequestParam Integer pro_id,@RequestParam String username,@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return companyService.selectApply1(pro_id,username,pageNum,pageSize);
    }

    //NOTE: 显示所有该岗位下不通过的学生
    @GetMapping("/selectApply2")
    public R selectApply2(@RequestParam Integer pro_id,@RequestParam String username,@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return companyService.selectApply2(pro_id,username,pageNum,pageSize);
    }

    //NOTE: 显示所有该岗位下离职的学生
    @GetMapping("/selectApply3")
    public R selectApply3(@RequestParam Integer pro_id,@RequestParam String username,@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return companyService.selectApply3(pro_id,username,pageNum,pageSize);
    }

    // NOTE: 同意学生的申请
    @GetMapping("/applyOfStudentYes")
    public R applyOfStudentYes(@RequestParam int stu_id, @RequestParam int pro_id) {
        return companyService.applyOfStudentYes(stu_id, pro_id);
    }

    // NOTE: 拒绝学生的申请
    @GetMapping("applyOfStudentNo")
    public R applyOfStudentNo(@RequestParam int stu_id, @RequestParam int pro_id) {
        return companyService.applyOfStudentNo(stu_id, pro_id);
    }

    // NOTE: 重新审核
    @GetMapping("applyOfStudent")
    public R applyOfStudent(@RequestParam int stu_id, @RequestParam int pro_id) {
        return companyService.applyOfStudent(stu_id, pro_id);
    }

    // NOTE: 不允许重复申请(检查数据库是否有相同数据)
    @GetMapping("checkApplyOfStudent")
    public R checkApplyOfStudent(@RequestParam int stu_id,@RequestParam int pro_id) {
        return companyService.checkApplyOfStudent(stu_id, pro_id);
    }

}
