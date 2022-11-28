package com.example.internmanage.Services;

import com.example.internmanage.Entity.Evaluate;
import com.example.internmanage.Mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    public List<Evaluate> studentSelectEvaT(int stu_id){
        return evaluateMapper.studentSelectEvaT(stu_id);
    }

    public List<Evaluate> studentSelectEvaC(int stu_id){
        return evaluateMapper.studentSelectEvaC(stu_id);
    }

    public List<Evaluate> adminSelectEvaT(){
        return evaluateMapper.adminSelectEvaT();
    }

    public List<Evaluate> adminSelectEvaC(){
        return evaluateMapper.adminSelectEvaC();
    }

    public List<Evaluate> selectEvaTbyId(Evaluate evaluate){
        return evaluateMapper.selectEvaTbyId(evaluate);
    }

    public List<Evaluate> selectEvaTbyName(int t_id,String stu_name){
        stu_name = '%'+stu_name+'%';
        return evaluateMapper.selectEvaTbyName(t_id,stu_name);
    }

    public List<Evaluate> selectEvaCbyId(int com_id,int stu_id){
        return evaluateMapper.selectEvaCbyId(com_id,stu_id);
    }

    public List<Evaluate> selectEvaCbyName(int com_id,String stu_name){
        stu_name = '%'+stu_name+'%';
        return evaluateMapper.selectEvaCbyName(com_id,stu_name);
    }

    public String insertEvaT(Evaluate evaluate){
        if(evaluateMapper.insertEvaT(evaluate)!=0)
        return "insertSuccess";
        else return "insertFailed";
    }

    public String insertEvaC(Evaluate evaluate){
        if (evaluateMapper.insertEvaC(evaluate)!=0)
        return "insertSuccess";
        else return "insertFailed";
    }

    public String deleteEvaT(int eva_id){
        if (evaluateMapper.deleteEvaT(eva_id)!=0)
        return "deleteSuccess";
        else return "deleteFailed";
    }

    public String deleteEvaC(int eva_id){
        if (evaluateMapper.deleteEvaC(eva_id)!=0)
        return "deleteSuccess";
        else return "deleteFailed";
    }

    public String updateEvaT(String eva_date,String eva_content,int eva_id){
        if (evaluateMapper.updateEvaT(eva_date,eva_content,eva_id)!=0)
        return "updateSuccess";
        else return "updateFailed";
    }

    public String updateEvaC(String eva_date,String eva_content,int eva_id){
        if (evaluateMapper.updateEvaC(eva_date,eva_content,eva_id)!=0)
        return "updateSuccess";
        else return "updateFailed";
    }

}
