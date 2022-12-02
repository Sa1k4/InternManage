package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select password from student where stu_id = #{username} and del = 0")
    String checkLogin(int username);

    @Select("select * from student where stu_id = #{stu_id} and del = 0")
    Student selectStudent(int stu_id);

    @Insert("insert into student (stu_id,username,password,specialty,classname,academy,sex,phone) values (#{stu_id},#{username},#{password},#{specialty},#{classname},#{academy},#{sex},#{phone})")
    int register(Student student);

    @Update("update student set username = #{username},password = #{password},specialty = #{specialty},classname = #{classname},academy = #{academy},sex = #{sex},phone = #{phone} where stu_id = #{stu_id}")
    int update(Student student);

    @Select("select * from student where del = 0")
    List<Student> selectAll();

    @Select("select * from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and del = 0 limit #{pageNum},#{pageSize}")
    List<Student> selectPage(Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id);

    @Select("select count(*) from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and del = 0")
    Integer selectTotal(@Param("student_name") String student_name,@Param("student_class") String student_class,@Param("student_id") String student_id);


    @Update("update student set del = 1 where stu_id = #{stu_id}")
    int delete(int stu_id);
}
