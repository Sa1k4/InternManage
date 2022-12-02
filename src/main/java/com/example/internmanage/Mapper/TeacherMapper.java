package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select password from teacher where t_id = #{username} and del = 0")
    String checkLogin(int username);

    @Select("select * from teacher where t_id = #{username} and del = 0")
    Teacher selectTeacher(int username);

    @Insert("insert into teacher (t_id,username,password,sex,phone,academy) values (#{t_id},#{username},#{password},#{sex},#{phone},#{academy})")
    int register(Teacher teacher);

    @Update("update teacher set username = #{username},password = #{password},sex = #{sex},phone = #{phone},academy = #{academy} where t_id = #{t_id}")
    int update(Teacher teacher);

    @Select("select * from teacher where username like concat('%',#{username},'%') and academy like concat('%',#{academy},'%') and del = 0 limit #{pageNum},#{pageSize} ")
    List<Teacher> selectAll(String username, String academy, Integer pageNum, Integer pageSize);

    @Select("select count(*) from teacher where username like concat('%',#{username},'%') and academy like concat('%',#{academy},'%') and del = 0")
    Integer selectAllTotal(String username, String academy);

    @Update("update teacher set del = 1 where t_id = #{t_id}")
    int delete(int t_id);

    @Update("update student set apply = 0 where stu_id = #{stu_id}")
    int applyOfNo(int stu_id);

    @Update("update student set apply = 2 where stu_id = #{stu_id}")
    int applyOfYes(int stu_id);
}
