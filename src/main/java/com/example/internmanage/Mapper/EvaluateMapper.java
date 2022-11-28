package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Evaluate;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface EvaluateMapper {
    @Select("select e.*,t.name as t_name from evaluate_t e left join teacther t on t.t_id = e.t_id where e.stu_id = #{stu_id}")
    List<Evaluate> studentSelectEvaT(int stu_id);

    @Select("select e.*,c.company_name as com_name from evaluate_c e left join company c on c.cpmy_id = e.com_id where e.stu_id = #{stu_id}")
    List<Evaluate> studentSelectEvaC(int stu_id);

    @Select("select e.*,t.name as t_name from evaluate_t e left join teacther t on t.t_id = e.t_id")
    List<Evaluate> adminSelectEvaT();

    @Select("select e.*,c.company_name as com_name from evaluate_c e left join company c on c.cpmy_id = e.com_id")
    List<Evaluate> adminSelectEvaC();

    @Select("select e.*,s.username as stu_name from evaluate_t e left join student s on s.stu_id = e.stu_id where e.t_id = #{t_id} and e.stu_id = #{stu_id}")
    List<Evaluate> selectEvaTbyId(Evaluate evaluate);

    @Select("select e.*,s.username as stu_name from evaluate_t e left join student s on s.stu_id = e.stu_id where e.t_id = #{t_id} and s.username like #{stu_name}")
    List<Evaluate> selectEvaTbyName(int t_id,String stu_name);

    @Select("select e.*,s.username as stu_name from evaluate_c e left join student s on s.stu_id = e.stu_id where e.com_id = #{com_id} and e.stu_id = #{stu_id}")
    List<Evaluate> selectEvaCbyId(int com_id,int stu_id);

    @Select("select e.*,s.username as stu_name from evaluate_c e left join student s on s.stu_id = e.stu_id where e.com_id = #{com_id} and s.username like #{stu_name}")
    List<Evaluate> selectEvaCbyName(int com_id,String stu_name);

    @Insert("insert into evaluate_t (stu_id,t_id,eva_date,eva_content) values (#{stu_id},#{t_id},#{eva_date},#{eva_content})")
    int insertEvaT(Evaluate evaluate);

    @Insert("insert into evaluate_c (stu_id,com_id,eva_date,eva_content) values (#{stu_id},#{com_id},#{eva_date},#{eva_content})")
    int insertEvaC(Evaluate evaluate);

    @Delete("delete from evaluate_t where eva_id = #{eva_id}")
    int deleteEvaT(int eva_id);

    @Delete("delete from evaluate_c where eva_id = #{eva_id}")
    int deleteEvaC(int eva_id);

    @Update("update evaluate_t set eva_date = #{eva_date} , eva_content = #{eva_content} where eva_id = #{eva_id}")
    int updateEvaT(String eva_date,String eva_content,int eva_id);

    @Update("update evaluate_c set eva_date = #{eva_date} , eva_content = #{eva_content} where eva_id = #{eva_id}")
    int updateEvaC(String eva_date,String eva_content,int eva_id);

}
