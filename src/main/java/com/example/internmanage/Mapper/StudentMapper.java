package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface StudentMapper {
    @Select("select password from student where stu_id = #{username}")
    String checkLogin(String username);

    @Insert("insert into student (stu_id,username,password) values (#{stu_id},#{username},#{password})")
    int register(Student student);

    @Update("update student set stu_id = #{stu_id},username = #{username},password = #{password},specialty = #{specialty},classname = #{classname},academy = #{academy},sex = #{sex},phone = #{phone} ")
    int update(Student student);

    @Select("select * from student")
    List<Student> selectAll();

    @Delete("delete from company where stu_id = #{stu_id}")
    int delete(int stu_id);
}
