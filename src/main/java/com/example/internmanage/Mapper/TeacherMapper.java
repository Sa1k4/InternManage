package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select password from teacher where t_id = #{t_id} and del = 0")
    String checkLogin(int t_id);

    @Select("select * from teacher where t_id = #{t_id} and del = 0")
    Teacher selectTeacher(int t_id);

    @Select("select * from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and apply = #{apply} and stu_id in (select stu_id from stu_t where t_id = #{t_id}) and del = 0 limit #{pageNum},#{pageSize}")
    List<Student> selectApply(int apply,int t_id,Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id);

    @Select("select count(*) from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and apply = #{apply} and stu_id in (select stu_id from stu_t where t_id = #{t_id}) and del = 0")
    int selectApplyTotal(int apply,int t_id, String student_name, String student_class, String student_id);

    @Select("select * from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and stu_id not in (select stu_id from stu_t where t_id = #{t_id}) and del = 0 limit #{pageNum},#{pageSize}")
    List<Student> findStudentF(int t_id,Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id);

    @Select("select count(*) from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and stu_id not in (select stu_id from stu_t where t_id = #{t_id}) and del = 0")
    int findStudentFC(int t_id, String student_name, String student_class, String student_id);

    @Select("select * from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and stu_id in (select stu_id from stu_t where t_id = #{t_id}) and del = 0 limit #{pageNum},#{pageSize}")
    List<Student> findStudent(int t_id,Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id);

    @Select("select count(*) from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and stu_id in (select stu_id from stu_t where t_id = #{t_id}) and del = 0")
    int findStudentC(int t_id, String student_name, String student_class, String student_id);

    @Insert("insert into stu_t (stu_id, t_id) values (#{stu_id},#{t_id})")
    int addStudent(int stu_id,int t_id);

    @Delete("delete from stu_t where stu_id = #{stu_id} and t_id = #{t_id}")
    int deleteStu(int stu_id,int t_id);

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
