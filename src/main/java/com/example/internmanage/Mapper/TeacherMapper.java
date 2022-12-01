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

    @Select("select * from teacher where username like concat('%',#{username},'%') and academy like concat('%',#{academy},'%') limit #{pageNum},#{pageSize}")
    List<Teacher> selectAll(String username, String academy, Integer pageNum, Integer pageSize);

    @Select("select count(*) from teacher where username like concat('%',#{username},'%') and academy like concat('%',#{academy},'%') ")
    Integer selectAllTotal(String username, String academy);

    @Delete("delete from teacher where t_id = #{t_id}")
    int delete(int t_id);
}
