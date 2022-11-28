package com.example.internmanage.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@ResponseBody
public interface AdminMapper {
    @Select("select password from admin where name = #{name}")
    String checkLogin(String name);
}
