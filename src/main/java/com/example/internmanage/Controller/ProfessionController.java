package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Profession;
import com.example.internmanage.Services.ProfessionService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profession")
public class ProfessionController {
    private ProfessionService professionService;

    @Autowired
    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @GetMapping("selectAllAndDel")
    public R professionSelectAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                 @RequestParam Integer del) {
        return professionService.selectAllAndDel(pageNum, pageSize, del);
    }

    @RequestMapping("delCProfession{id}")
    public R professionDelCProfession(@PathVariable int id) {
        return professionService.delCProfession(id);
    }

    @PostMapping("/deleteCMultiple")
    public R deleteCProfession(@RequestBody List<Integer> ids) {
        return professionService.deleteCMultiple(ids);
    }

    @GetMapping("selectAllOfCom")
    public R professionSelectAllOfCom(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                      @RequestParam Integer com_id) {
        return professionService.selectAllOfCom(pageNum, pageSize, com_id);
    }

    @GetMapping("conditionQuery")
    public R professionConditionQuery(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                      @RequestParam Integer com_id, @RequestParam String name, @RequestParam(defaultValue = "1") Integer status) {
        System.out.println(name);
        return professionService.conditionQuery(pageNum, pageSize, com_id, name, status);
    }

    @GetMapping("conditionQueryA")
    public R professionConditionQueryA(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                      @RequestParam String name, @RequestParam(defaultValue = "1") Integer status) {
        System.out.println(name);
        return professionService.conditionQueryA(pageNum,pageSize,name,status);
    }

    @RequestMapping("addProfession")
    public R professionAddProfession(@RequestBody Profession profession) {
        return professionService.addProfession(profession);
    }

    @RequestMapping("delProfession{id}")
    public R professionDelProfession(@PathVariable int id) {
        return professionService.delProfession(id);
    }

    @PostMapping("/deleteMultiple")
    public R deleteProfession(@RequestBody List<Integer> ids) {
        return professionService.deleteMultiple(ids);
    }

    @RequestMapping("updateProfession")
    public R professionUpdateProfession(@RequestBody Profession profession) {
        return professionService.updateProfession(profession);
    }

    @RequestMapping("openOrCloseProfession")
    public R professionOpenOrCloseProfession(@RequestBody Profession profession) {
        return professionService.openOrCloseProfession(profession);
    }

    // NOTE: profession表与pro_stu对比，排除pro_stu表里确认的岗位(分页、根据岗位名称模糊搜索)
    @GetMapping("selectPfToPsNotPsProId")
    public R selectPfToPsNotPsProId(@RequestParam int stu_id, @RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return professionService.selectPfToPsNotPsProId(stu_id, name, pageNum, pageSize);
    }

    // NOTE: 在stu_pro表里面查出未通过的岗位(分页、根据岗位名称模糊搜索)
    @GetMapping("selectPsOfNo")
    public R selectPsOfNo(@RequestParam int stu_id, @RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return professionService.selectPsOfNo(stu_id, name, pageNum, pageSize);
    }

    // NOTE: 在stu_pro表里面查出通过的岗位(分页、根据岗位名称模糊搜索)
    @GetMapping("selectPsOfYes")
    public R selectPsOfYes(@RequestParam int stu_id, @RequestParam String name, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return professionService.selectPsOfYes(stu_id, name, pageNum, pageSize);
    }

}
