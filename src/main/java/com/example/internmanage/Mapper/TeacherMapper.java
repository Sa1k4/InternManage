package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface TeacherMapper {
    @Select("select password from teacher where t_id = #{username}")
    String checkLogin(String username);

    @Insert("insert into teacher (t_id,username,password) values (#{t_id},#{username},#{password})")
    int register(Teacher teacher);

    @Update("update teacher set t_id = #{t_id},username = #{username},password = #{password},sex = #{sex},phone = #{phone},academy = #{academy} ")
    int update(Teacher teacher);

    @Select("select * from teacher")
    List<Teacher> selectAll();

    @Delete("delete from teacher where t_id = #{t_id}")
    int delete(int t_id);
}
