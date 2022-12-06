package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.StuLPRW;
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

    @Update("update student set vitae = #{vitae} where stu_id = #{stu_id}")
    int upload(Student student);

    @Select("select * from student where del = 0")
    List<Student> selectAll();

    @Select("select * from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and del = 0 limit #{pageNum},#{pageSize}")
    List<Student> selectPage(Integer pageNum, Integer pageSize, String student_name, String student_class, String student_id);

    @Select("select count(*) from student where username like concat('%', #{student_name}, '%') and classname like concat('%', #{student_class}, '%') and stu_id like concat('%', #{student_id}, '%') and del = 0")
    Integer selectTotal(@Param("student_name") String student_name, @Param("student_class") String student_class, @Param("student_id") String student_id);


    @Update("update student set del = 1 where stu_id = #{stu_id}")
    int delete(int stu_id);

    @Update("update student set apply = 1 where stu_id = #{stu_id}")
    int apply(int stu_id);

    /**
     * 学生提交岗位申请
     *
     * @param stu_id 学生id
     * @param id     岗位id
     * @return 1 成功
     */
    @Insert("insert into pro_stu(stu_id, pro_id) VALUES (#{stu_id},#{id} )")
    int applyPro(int stu_id, int id);

    /**
     * 检查学生是否就职
     *
     * @param stu_id 学生id
     * @return count 0或1
     */
    @Select("select count(*) from pro_stu where apply_com = 1 and del = 0")
    int checkPro(int stu_id);

    @Select("select * from stu_leave where stu_id = #{stu_id} and apply = #{apply} limit #{pageNum},#{pageSize}")
    List<StuLPRW> stuLeave(int stu_id,int apply,int pageNum,int pageSize);
    @Select("select count(*) from stu_leave where stu_id = #{stu_id} and apply = #{apply}")
    Integer stuLeaveC(int stu_id,int apply);

    @Select("select * from stu_leave where stu_id = #{stu_id} limit #{pageNum},#{pageSize}")
    List<StuLPRW> stuLeaveS(int stu_id,int pageNum,int pageSize);
    @Select("select count(*) from stu_leave where stu_id = #{stu_id}")
    Integer stuLeaveSC(int stu_id);

    @Select("select * from stu_week where stu_id = #{stu_id} limit #{pageNum},#{pageSize}")
    List<StuLPRW> stuWeekS(int stu_id,int pageNum,int pageSize);
    @Select("select count(*) from stu_week where stu_id = #{stu_id}")
    Integer stuWeekSC(int stu_id);

    @Select("select * from stu_plan where stu_id = #{stu_id} limit #{pageNum},#{pageSize}")
    List<StuLPRW> stuPlanS(int stu_id,int pageNum,int pageSize);
    @Select("select count(*) from stu_plan where stu_id = #{stu_id}")
    Integer stuPlanSC(int stu_id);

    @Select("select * from stu_repo where stu_id = #{stu_id} limit #{pageNum},#{pageSize}")
    List<StuLPRW> stuRepoS(int stu_id,int pageNum,int pageSize);
    @Select("select count(*) from stu_repo where stu_id = #{stu_id}")
    Integer stuRepoSC(int stu_id);

    @Insert("insert into stu_leave(stu_id, content,start_time,end_time) VALUES (#{stu_id},#{content},#{start_time},#{end_time} )")
    int stuLeaveI(StuLPRW stuLPRW);

    @Insert("insert into stu_week(stu_id, content,start_time,end_time) VALUES (#{stu_id},#{content},#{start_time},#{end_time} )")
    int stuWeek(StuLPRW stuLPRW);

    @Insert("insert into stu_plan(stu_id, content,start_time) VALUES (#{stu_id},#{content},#{start_time})")
    int stuPlan(StuLPRW stuLPRW);

    @Insert("insert into stu_repo(stu_id, content,start_time) VALUES (#{stu_id},#{content},#{start_time})")
    int stuRepo(StuLPRW stuLPRW);

    @Update("update stu_leave set apply = #{apply}, where id = #{id}")
    int updateLeave(int apply,int id);
}
