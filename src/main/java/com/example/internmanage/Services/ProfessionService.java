package com.example.internmanage.Services;

import com.example.internmanage.Entity.Profession;
import com.example.internmanage.Mapper.ProfessionMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;

    public R selectAllAndDel(Integer pageNum, Integer pageSize, Integer del) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.selectAllAndDelTotal(del);
        List<Profession> result = professionMapper.selectAllAndDel(pageNum, pageSize, del);
        return getR(total, result);
    }


    public R delCProfession(int id) {
        HashMap<String, Object> ret = new HashMap<>();
        if (professionMapper.delCProfession(id) != 0) {
            ret.put("status", true);
            ret.put("msg", "删除成功");
        } else {
            ret.put("status", false);
            ret.put("msg", "删除失败");
        }
        return R.success().data(ret);
    }

    public R deleteCMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (professionMapper.delCProfession(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R selectAllOfCom(Integer pageNum, Integer pageSize, Integer com_id) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.selectAllOfComTotal(com_id);
        List<Profession> result = professionMapper.selectAllOfCom(com_id, pageNum, pageSize);
        return getR(total, result);
    }

    public R conditionQuery(Integer pageNum, Integer pageSize, Integer com_id, String name, Integer status) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.conditionQueryTotal(com_id, name, status);
        List<Profession> result = professionMapper.conditionQuery(com_id, name, status, pageNum, pageSize);
        return getR(total, result);
    }

    public R conditionQueryA(Integer pageNum, Integer pageSize, String name, Integer status) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.conditionQueryTotalA(name, status);
        List<Profession> result = professionMapper.conditionQueryA(name, status, pageNum, pageSize);
        return getR(total, result);
    }

    /**
     * 复用
     *
     * @param total  记录数
     * @param result 数据库返回结果
     * @return 统一接口数据
     */
    private R getR(Integer total, List<Profession> result) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R addProfession(Profession profession) {
        HashMap<String, Object> ret = new HashMap<>();
        if (professionMapper.addProfession(profession) != 0) {
            ret.put("status", true);
            ret.put("msg", "新增成功");
        } else {
            ret.put("status", false);
            ret.put("msg", "新增失败");
        }
        return R.success().data(ret);
    }

    public R delProfession(int id) {
        HashMap<String, Object> ret = new HashMap<>();
        if (professionMapper.delProfession(id) != 0) {
            ret.put("status", true);
            ret.put("msg", "删除成功");
        } else {
            ret.put("status", false);
            ret.put("msg", "删除失败");
        }
        return R.success().data(ret);
    }

    public R deleteMultiple(List<Integer> ids) {
        int count = 0;
        for (int i = 0; i < ids.size(); i++) {
            if (professionMapper.delProfession(ids.get(i)) > 0) count++;
        }
        if (count == ids.size())
            return R.success();
        else return R.failed();
    }

    public R updateProfession(Profession profession) {
        HashMap<String, Object> ret = new HashMap<>();
        if (professionMapper.updateProfession(profession) != 0) {
            ret.put("status", true);
            ret.put("msg", "更新成功");
        } else {
            ret.put("status", false);
            ret.put("msg", "更新失败");
        }
        return R.success().data(ret);
    }

    public R openOrCloseProfession(Profession profession) {
        HashMap<String, Object> ret = new HashMap<>();
        if (professionMapper.openOrCloseProfession(profession) != 0) {
            ret.put("status", true);
            ret.put("msg", "切换成功");
        }else {
            ret.put("status", false);
            ret.put("msg", "切换失败");
        }
        return R.success().data(ret);
    }

    public R selectPfToPsNotPsProId(int stu_id, String name, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.selectPfToPsNotPsProIdTotal(stu_id, name);
        List<Profession> result = professionMapper.selectPfToPsNotPsProId(stu_id, name, pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R selectPsOfNo(int stu_id, String name, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.selectPsOfNoTotal(stu_id, name);
        List<Profession> result = professionMapper.selectPsOfNo(stu_id, name, pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }

    public R selectPsOfYes(int stu_id, String name, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = professionMapper.selectPsOfYesTotal(stu_id, name);
        List<Profession> result = professionMapper.selectPsOfYes(stu_id, name, pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", result);
        return R.success().data(res);
    }


}
