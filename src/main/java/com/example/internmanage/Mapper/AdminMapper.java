package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@ResponseBody
public interface AdminMapper {
    @Select("select password from admin where username = #{name}")
    String checkLogin(String name);

    @Select("select * from admin where username = #{name}")
    Admin selectAdmin(String name);
}
