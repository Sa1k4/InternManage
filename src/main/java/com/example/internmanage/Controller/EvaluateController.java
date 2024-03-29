package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Evaluate;
import com.example.internmanage.Services.EvaluateService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("evaluate")
public class EvaluateController {

    private EvaluateService evaluateService;
    @Autowired
    public void setEvaluateService(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    //学生查看老师给自己的评价
    @RequestMapping("studentSelectEvaT")
    public R studentSelectEvaT(@RequestBody Evaluate evaluate){
        int stu_id = evaluate.getStu_id();
        return evaluateService.studentSelectEvaT(stu_id);
    }

    //学生看企业给自己评价
    @RequestMapping("studentSelectEvaC")
    public R studentSelectEvaC(@RequestBody Evaluate evaluate){
        int stu_id = evaluate.getStu_id();
        return evaluateService.studentSelectEvaC(stu_id);
    }

    //管理员看所有老师给学生的评价
    @RequestMapping("adminSelectEvaT")
    public R adminSelectEvaT(){
        return evaluateService.adminSelectEvaT();
    }

    //管理员看所有企业给学生的评价
    @RequestMapping("adminSelectEvaC")
    public R adminSelectEvaC(){
        return evaluateService.adminSelectEvaC();
    }

    //老师根据学生ID(ID是学号)搜索自己给学生评价
    @RequestMapping("teacherEvaluateID")
    public R teacherEvaluateID(@RequestBody Evaluate evaluate){
        return evaluateService.selectEvaTbyId(evaluate);
    }

    //老师根据学生姓名模糊搜索评价（姓名无输入即为全部）
    @GetMapping("teacherEvaluateNAME")
    public R teacherEvaluateNAME(@RequestParam int t_id,@RequestParam String stu_name){
        return evaluateService.selectEvaTbyName(t_id,stu_name);
    }

    //企业根据ID。。。同上
    @GetMapping("companyEvaluateID")
    public R companyEvaluateID(@RequestParam int com_id,@RequestParam int stu_id){
        return evaluateService.selectEvaCbyId(com_id,stu_id);
    }

    //企业根据姓名。。。同上
    @GetMapping("companyEvaluateNAME")
    public R companyEvaluateNAME(@RequestParam int com_id,@RequestParam String stu_name){
        return evaluateService.selectEvaCbyName(com_id,stu_name);
    }

    //新增老师对学生评价
    @RequestMapping("insertEvaT")
    public R insertEvaT(@RequestBody Evaluate evaluate){
        return evaluateService.insertEvaT(evaluate);
    }

    //新增企业对学生评价
    @RequestMapping("insertEvaC")
    public R insertEvaC(@RequestBody Evaluate evaluate){
        return evaluateService.insertEvaC(evaluate);
    }

    @RequestMapping("selectEvaC")
    public R selectEvaC(@RequestBody Evaluate evaluate){
        return evaluateService.selectEvaC(evaluate);
    }

    @RequestMapping("selectEvaT")
    public R selectEvaT(@RequestBody Evaluate evaluate){
        return evaluateService.selectEvaT(evaluate);
    }

    //删除老师对学生评价
    @RequestMapping("deleteEvaT{id}")
    public R deleteEvaT(@PathVariable int id){
        return evaluateService.deleteEvaT(id);
    }

    @PostMapping("/deleteEvaTMultiple")
    public R deleteEvaT(@RequestBody List<Integer> ids){
        return evaluateService.deleteEvaTMultiple(ids);
    }

    //删除企业对学生评价
    @RequestMapping("deleteEvaC{id}")
    public R deleteEvaC(@PathVariable int id){
        return evaluateService.deleteEvaC(id);
    }

    @PostMapping("/deleteEvaCMultiple")
    public R deleteEvaC(@RequestBody List<Integer> ids){
        return evaluateService.deleteEvaCMultiple(ids);
    }

    //修改老师对学生评价
    @RequestMapping("updateEvaT")
    public R updateEvaT(@RequestBody Evaluate evaluate){
        return evaluateService.updateEvaT(evaluate);
    }

    //修改企业对学生评价
    @RequestMapping("updateEvaC")
    public R updateEvaC(@RequestBody Evaluate evaluate){
        return evaluateService.updateEvaC(evaluate);
    }

}
