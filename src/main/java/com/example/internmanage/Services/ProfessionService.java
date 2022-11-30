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


    public R delCProfession(Profession profession) {
        if (professionMapper.delCProfession(profession) != 0) {
            return R.success().data("return", "删除成功");
        }
        return R.success().data("return", "删除失败");
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

    /**
     * 复用
     *
     * @param total 记录数
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
        if (professionMapper.addProfession(profession) != 0) {
            return R.success().data("return", "新增成功");
        }
        return R.failed().data("return", "新增失败");
    }

    public R delProfession(Profession profession) {
        if (professionMapper.delProfession(profession) != 0) {
            return R.success().data("return", "删除成功");
        }
        return R.failed().data("return", "删除失败");
    }

    public R updateProfession(Profession profession) {
        if (professionMapper.updateProfession(profession) != 0) {
            return R.success().data("return", "更新成功");
        }
        return R.failed().data("return", "更新失败");
    }

    public R openOrCloseProfession(Profession profession) {
        if (professionMapper.openOrCloseProfession(profession) != 0) {
            return R.success().data("return", "切换成功");
        }
        return R.failed().data("return", "切换失败");
    }
}
