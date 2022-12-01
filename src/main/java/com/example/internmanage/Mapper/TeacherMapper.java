package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select password from teacher where t_id = #{username}")
    String checkLogin(String username);

    @Insert("insert into teacher (t_id,username,password) values (#{t_id},#{username},#{password})")
    int register(Teacher teacher);

    @Update("update teacher set username = #{username},password = #{password},sex = #{sex},phone = #{phone},academy = #{academy} where t_id = #{t_id}")
    int update(Teacher teacher);

    @Select("select * from teacher limit #{pageNum},#{pageSize}")
    List<Teacher> selectAll(Integer pageNum, Integer pageSize);

    @Select("select count(*) from teacher")
    Integer selectAllTotal();

    @Delete("delete from teacher where t_id = #{t_id}")
    int delete(int t_id);
}
