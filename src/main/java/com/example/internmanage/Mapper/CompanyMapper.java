package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface CompanyMapper {
    @Select("select password from company where username = #{username}")
    String checkLogin(String username);

    @Insert("insert into company (company_name,company_legal,company_licence,username,password) values (#{company_name},#{company_legal},#{company_licence},#{username},#{password})")
    int register(Company company);

    @Update("update company set company_name = #{company_name},company_legal = #{company_legal},company_licence = #{company_licence},username = #{username},password = #{password}")
    int update(Company company);

    @Select("select * from company")
    List<Company> selectAll();

    @Delete("delete from company where cpmy_id = #{cpmy_id}")
    int delete(int cpmy_id);

}
