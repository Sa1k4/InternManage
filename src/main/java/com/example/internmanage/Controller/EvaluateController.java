package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Evaluate;
import com.example.internmanage.Services.EvaluateService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    //学生查看老师给自己的评价
    @RequestMapping("studentSelectEvaT")
    @ResponseBody
    public List<Evaluate> studentSelectEvaT(@RequestBody Evaluate evaluate){
        int stu_id = evaluate.getStu_id();
        return evaluateService.studentSelectEvaT(stu_id);
    }

    //学生看企业给自己评价
    @RequestMapping("studentSelectEvaC")
    @ResponseBody
    public List<Evaluate> studentSelectEvaC(@RequestBody Evaluate evaluate){
        int stu_id = evaluate.getStu_id();
        return evaluateService.studentSelectEvaC(stu_id);
    }

    //管理员看所有老师给学生的评价
    @RequestMapping("adminSelectEvaT")
    @ResponseBody
    public List<Evaluate> adminSelectEvaT(){
        return evaluateService.adminSelectEvaT();
    }

    //管理员看所有企业给学生的评价
    @RequestMapping("adminSelectEvaC")
    @ResponseBody
    public List<Evaluate> adminSelectEvaC(){
        return evaluateService.adminSelectEvaC();
    }

    //老师根据学生ID(ID是学号)搜索自己给学生评价
    @RequestMapping("teacherEvaluateID")
    @ResponseBody
    public List<Evaluate> teacherEvaluateID(HttpServletRequest request){
        int t_id = Integer.parseInt(request.getParameter("t_id"));
        int stu_id = Integer.parseInt(request.getParameter("stu_id"));
        Evaluate evaluate = new Evaluate();
        evaluate.setT_id(t_id);
        evaluate.setStu_id(stu_id);
        return evaluateService.selectEvaTbyId(evaluate);
    }

    //老师根据学生姓名模糊搜索评价（姓名无输入即为全部）
    @RequestMapping("teacherEvaluateNAME")
    @ResponseBody
    public List<Evaluate> teacherEvaluateNAME(HttpServletRequest request){
        int t_id = Integer.parseInt(request.getParameter("t_id"));
        String stu_name = request.getParameter("stu_name");
        return evaluateService.selectEvaTbyName(t_id,stu_name);
    }

    //企业根据ID。。。同上
    @RequestMapping("companyEvaluateID")
    @ResponseBody
    public List<Evaluate> companyEvaluateID(HttpServletRequest request){
        int com_id = Integer.parseInt(request.getParameter("com_id"));
        int stu_id = Integer.parseInt(request.getParameter("stu_id"));
        return evaluateService.selectEvaCbyId(com_id,stu_id);
    }

    //企业根据姓名。。。同上
    @RequestMapping("companyEvaluateNAME")
    @ResponseBody
    public List<Evaluate> companyEvaluateNAME(HttpServletRequest request){
        int com_id = Integer.parseInt(request.getParameter("com_id"));
        String stu_name = request.getParameter("stu_name");
        return evaluateService.selectEvaCbyName(com_id,stu_name);
    }

    //新增老师对学生评价
    @RequestMapping("insertEvaT")
    @ResponseBody
    public R insertEvaT(HttpServletRequest request){
        Evaluate evaluate = new Evaluate();
        evaluate.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
        evaluate.setT_id(Integer.parseInt(request.getParameter("t_id")));
        evaluate.setEva_content(request.getParameter("eva_content"));
        evaluate.setEva_date(request.getParameter("eva_date"));
        return evaluateService.insertEvaT(evaluate);
    }

    //新增企业对学生评价
    @RequestMapping("insertEvaC")
    @ResponseBody
    public R insertEvaC(HttpServletRequest request){
        Evaluate evaluate = new Evaluate();
        evaluate.setStu_id(Integer.parseInt(request.getParameter("stu_id")));
        evaluate.setCom_id(Integer.parseInt(request.getParameter("com_id")));
        evaluate.setEva_content(request.getParameter("eva_content"));
        evaluate.setEva_date(request.getParameter("eva_date"));
        return evaluateService.insertEvaC(evaluate);
    }

    //删除老师对学生评价
    @RequestMapping("deleteEvaT")
    @ResponseBody
    public R deleteEvaT(HttpServletRequest request){
        int eva_id  = Integer.parseInt(request.getParameter("eva_id"));
        return evaluateService.deleteEvaT(eva_id);
    }

    //删除企业对学生评价
    @RequestMapping("deleteEvaC")
    @ResponseBody
    public R deleteEvaC(HttpServletRequest request){
        int eva_id  = Integer.parseInt(request.getParameter("eva_id"));
        return evaluateService.deleteEvaC(eva_id);
    }

    //修改老师对学生评价
    @RequestMapping("updateEvaT")
    @ResponseBody
    public R updateEvaT(HttpServletRequest request){
        String eva_date = request.getParameter("eva_date");
        String eva_content = request.getParameter("eva_content");
        int eva_id = Integer.parseInt(request.getParameter("eva_id"));
        return evaluateService.updateEvaT(eva_date,eva_content,eva_id);
    }

    //修改企业对学生评价
    @RequestMapping("updateEvaC")
    @ResponseBody
    public R updateEvaC(HttpServletRequest request){
        String eva_date = request.getParameter("eva_date");
        String eva_content = request.getParameter("eva_content");
        int eva_id = Integer.parseInt(request.getParameter("eva_id"));
        return evaluateService.updateEvaC(eva_date,eva_content,eva_id);
    }

}
