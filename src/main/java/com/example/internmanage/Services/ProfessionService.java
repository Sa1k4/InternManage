package com.example.internmanage.Services;

import com.example.internmanage.Entity.Profession;
import com.example.internmanage.Mapper.ProfessionMapper;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;

    public R selectAll() {
        List<Profession> result = professionMapper.selectAll();
        if (result != null) {
            return R.success().data("profession", result);
        }
        return R.success().data("return", "未查询到相应记录");
    }

    public R selectAllDel() {
        List<Profession> result = professionMapper.selectAllDel();
        if (result != null) {
            return R.success().data("professionDel", result);
        }
        return R.success().data("return", "未查询到相应记录");
    }

    public R delCProfession(Profession profession) {
        if (professionMapper.delCProfession(profession) != 0) {
            return R.success().data("return", "删除成功");
        }
        return R.success().data("return", "删除失败");
    }

    public R selectAllOfCom(Profession profession) {
        List<Profession> result = professionMapper.selectAllOfCom(profession);
        if (result != null) {
            return R.success().data("profession", result);
        }
        return R.success().data("return", "未查询到相应记录");
    }

    public R conditionQuery(Profession profession) {
        List<Profession> result = professionMapper.conditionQuery(profession);
        if (result != null) {
            return R.success().data("conditionQuery", result);
        }
        return R.success().data("return", "未查询到相应记录");
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
