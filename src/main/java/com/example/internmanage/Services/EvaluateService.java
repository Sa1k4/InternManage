package com.example.internmanage.Services;

import com.example.internmanage.Entity.Evaluate;
import com.example.internmanage.Mapper.EvaluateMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    public R studentSelectEvaT(int stu_id){
        List<Evaluate> result = evaluateMapper.studentSelectEvaT(stu_id);
        return R.success().data("data", result);
    }

    public R studentSelectEvaC(int stu_id){
        List<Evaluate> result = evaluateMapper.studentSelectEvaC(stu_id);
        return R.success().data("data", result);
    }

    public R adminSelectEvaT(){
        List<Evaluate> result = evaluateMapper.adminSelectEvaT();
        return R.success().data("data", result);
    }

    public R adminSelectEvaC(){
        List<Evaluate> result = evaluateMapper.adminSelectEvaC();
        return R.success().data("data", result);
    }

    public R selectEvaTbyId(Evaluate evaluate){
        List<Evaluate> result = evaluateMapper.selectEvaTbyId(evaluate);
        return R.success().data("data", result);
    }

    public R selectEvaTbyName(int t_id,String stu_name){
        stu_name = '%'+stu_name+'%';
        List<Evaluate> result = evaluateMapper.selectEvaTbyName(t_id, stu_name);
        return R.success().data("data", result);
    }

    public R selectEvaCbyId(int com_id,int stu_id){
        List<Evaluate> result = evaluateMapper.selectEvaCbyId(com_id, stu_id);
        return R.success().data("data", result);
    }

    public R selectEvaCbyName(int com_id,String stu_name){
        stu_name = '%'+stu_name+'%';
        List<Evaluate> result = evaluateMapper.selectEvaCbyName(com_id, stu_name);
        return R.success().data("data", result);
    }

    public R insertEvaT(Evaluate evaluate){
        if(evaluateMapper.insertEvaT(evaluate)!=0)
        return R.success();
        else return R.failed();
    }

    public R insertEvaC(Evaluate evaluate){
        if (evaluateMapper.insertEvaC(evaluate)!=0)
        return R.success();
        else return R.failed();
    }

    public R deleteEvaT(int eva_id){
        if (evaluateMapper.deleteEvaT(eva_id)!=0)
        return R.success();
        else return R.failed();
    }

    public R deleteEvaTMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (evaluateMapper.deleteEvaT(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R deleteEvaC(int eva_id){
        if (evaluateMapper.deleteEvaC(eva_id)!=0)
        return R.success();
        else return R.failed();
    }

    public R deleteEvaCMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (evaluateMapper.deleteEvaC(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R updateEvaT(String eva_date,String eva_content,int eva_id){
        if (evaluateMapper.updateEvaT(eva_date,eva_content,eva_id)!=0)
        return R.success();
        else return R.failed();
    }

    public R updateEvaC(String eva_date,String eva_content,int eva_id){
        if (evaluateMapper.updateEvaC(eva_date,eva_content,eva_id)!=0)
        return R.success();
        else return R.failed();
    }

}
