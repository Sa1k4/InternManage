package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("select password from company where username = #{username}")
    String checkLogin(String username);

    @Insert("insert into company (company_name,company_legal,company_licence,username,password) values (#{company_name},#{company_legal},#{company_licence},#{username},#{password})")
    int register(Company company);

    @Update("update company set company_name = #{company_name},company_legal = #{company_legal},company_licence = #{company_licence},username = #{username},password = #{password} where cpmy_id = #{cpmy_id}")
    int update(Company company);

    @Select("select * from company limit #{pageNum},#{pageSize}")
    List<Company> selectAll(Integer pageNum, Integer pageSize);

    @Select("select count(*) from company")
    Integer selectAllTotal();

    @Delete("delete from company where cpmy_id = #{cpmy_id}")
    int delete(int cpmy_id);

}
