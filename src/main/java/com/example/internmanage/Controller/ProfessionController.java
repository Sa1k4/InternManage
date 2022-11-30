package com.example.internmanage.Controller;

import com.example.internmanage.Entity.Profession;
import com.example.internmanage.Services.ProfessionService;
import com.example.internmanage.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profession")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;

    @RequestMapping("selectAll")
    public R professionSelectAll() {
        return professionService.selectAll();
    }

    @RequestMapping("selectAllOfCom")
    public R professionSelectAllOfCom(@RequestBody Profession profession) {
        return professionService.selectAllOfCom(profession);
    }

    @RequestMapping("conditionQuery")
    public R professionConditionQuery(@RequestBody Profession profession) {
        return professionService.conditionQuery(profession);
    }

    @RequestMapping("addProfession")
    public R professionAddProfession(@RequestBody Profession profession) {
        return professionService.addProfession(profession);
    }

    @RequestMapping("delProfession")
    public R professionDelProfession(@RequestBody Profession profession) {
        return professionService.delProfession(profession);
    }

    @RequestMapping("updateProfession")
    public R professionUpdateProfession(@RequestBody Profession profession) {
        return professionService.updateProfession(profession);
    }

    @RequestMapping("openOrCloseProfession")
    public R professionOpenOrCloseProfession(@RequestBody Profession profession) {
        return professionService.openOrCloseProfession(profession);
    }

}
