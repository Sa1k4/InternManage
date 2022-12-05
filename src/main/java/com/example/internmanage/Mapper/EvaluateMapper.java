package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Evaluate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvaluateMapper {
    @Select("select e.*,t.username as t_name from evaluate_t e left join teacher t on t.t_id = e.t_id where e.stu_id = #{stu_id} and e.del = 0")
    List<Evaluate> studentSelectEvaT(int stu_id);

    @Select("select e.*,c.company_name as com_name from evaluate_c e left join company c on c.cpmy_id = e.com_id where e.stu_id = #{stu_id} and e.del = 0")
    List<Evaluate> studentSelectEvaC(int stu_id);

    @Select("select e.*,t.username as t_name from evaluate_t e left join teacher t on t.t_id = e.t_id where e.del = 0")
    List<Evaluate> adminSelectEvaT();

    @Select("select e.*,c.company_name as com_name from evaluate_c e left join company c on c.cpmy_id = e.com_id where e.del = 0")
    List<Evaluate> adminSelectEvaC();

    @Select("select e.*,s.username as stu_name from evaluate_t e left join student s on s.stu_id = e.stu_id where e.t_id = #{t_id} and e.stu_id = #{stu_id} and e.del = 0")
    List<Evaluate> selectEvaTbyId(Evaluate evaluate);

    @Select("select e.*,s.username as stu_name from evaluate_t e left join student s on s.stu_id = e.stu_id where e.t_id = #{t_id} and s.username like #{stu_name} and e.del = 0")
    List<Evaluate> selectEvaTbyName(int t_id,String stu_name);

    @Select("select e.*,s.username as stu_name from evaluate_c e left join student s on s.stu_id = e.stu_id where e.com_id = #{com_id} and e.stu_id = #{stu_id} and e.del = 0")
    List<Evaluate> selectEvaCbyId(int com_id,int stu_id);

    @Select("select e.*,s.username as stu_name from evaluate_c e left join student s on s.stu_id = e.stu_id where e.com_id = #{com_id} and s.username like #{stu_name} and e.del = 0")
    List<Evaluate> selectEvaCbyName(int com_id,String stu_name);

    @Insert("insert into evaluate_t (stu_id,t_id,eva_date,eva_content) values (#{stu_id},#{t_id},#{eva_date},#{eva_content})")
    int insertEvaT(Evaluate evaluate);

    @Insert("insert into evaluate_c (stu_id,com_id,eva_date,eva_content) values (#{stu_id},#{com_id},#{eva_date},#{eva_content})")
    int insertEvaC(Evaluate evaluate);

    @Select("select * from evaluate_c where stu_id = #{stu_id} and com_id = #{com_id}")
    Evaluate selectEvaC(Evaluate evaluate);

    @Select("select * from evaluate_t where stu_id = #{stu_id} and t_id = #{t_id}")
    Evaluate selectEvaT(Evaluate evaluate);

    @Update("update evaluate_t set del = 1 where eva_id = #{eva_id}")
    int deleteEvaT(int eva_id);

    @Update("update evaluate_c set del = 1 where eva_id = #{eva_id}")
    int deleteEvaC(int eva_id);

    @Update("update evaluate_t set eva_date = #{eva_date} , eva_content = #{eva_content} where stu_id = #{stu_id} and t_id = #{com_id}")
    int updateEvaT(Evaluate evaluate);

    @Update("update evaluate_c set eva_date = #{eva_date} , eva_content = #{eva_content} where stu_id = #{stu_id} and com_id = #{com_id}")
    int updateEvaC(Evaluate evaluate);

}
