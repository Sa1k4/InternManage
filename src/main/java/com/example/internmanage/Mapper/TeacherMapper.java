package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Student;
import com.example.internmanage.Entity.TSLeave;
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

    @Select("select sinle.*,sfc.`name`,sfc.salary,sfc.introduce,sfc.company_name,sfc.company_legal from (select si.stu_id,si.username,si.specialty,si.classname,si.academy,si.sex,si.phone,sl.content,sl.start_time,sl.end_time,sl.apply,sl.id from (select s.* from stu_t st left join student s on st.stu_id = s.stu_id where t_id = #{t_id}) as si right join stu_leave sl on si.stu_id = sl.stu_id) as sinle left join (select sf.*,cp.company_name,cp.company_legal from (select ps.stu_id,pfs.* from pro_stu ps left join profession pfs on ps.pro_id = pfs.id) as sf left join company cp on sf.com_id = cp.cpmy_id) as sfc on sinle.stu_id = sfc.stu_id where sinle.username like concat('%',#{username},'%') and sinle.apply = #{apply} limit #{pageNum},#{pageSize}")
    List<TSLeave> selectTSLeave(int t_id,String username,int apply,Integer pageNum,Integer pageSize);

    @Select("select count(*) from (select si.stu_id,si.username,si.specialty,si.classname,si.academy,si.sex,si.phone,sl.content,sl.start_time,sl.end_time,sl.apply from (select s.* from stu_t st left join student s on st.stu_id = s.stu_id where t_id = #{t_id}) as si right join stu_leave sl on si.stu_id = sl.stu_id) as sinle left join (select sf.*,cp.company_name,cp.company_legal from (select ps.stu_id,pfs.* from pro_stu ps left join profession pfs on ps.pro_id = pfs.id) as sf left join company cp on sf.com_id = cp.cpmy_id) as sfc on sinle.stu_id = sfc.stu_id where sinle.username like concat('%',#{username},'%') and sinle.apply = #{apply}")
    int selectTSLeaveTotal(int t_id,String username,int apply);

    @Update("update stu_leave set apply = 1 where id = #{id}")
    int stuLeave21(int id);

    @Update("update stu_leave set apply = 2 where id = #{id}")
    int stuLeave22(int id);
}
