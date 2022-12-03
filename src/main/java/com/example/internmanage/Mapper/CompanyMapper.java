package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Company;
import com.example.internmanage.Entity.ProStu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("select password from company where username = #{username} and del = 0")
    String checkLogin(String username);

    @Select("select * from company where username = #{username} and del = 0")
    Company selectCompany(String username);

    @Insert("insert into company (company_name,company_legal,company_licence,username,password) values (#{company_name},#{company_legal},#{company_licence},#{username},#{password})")
    int register(Company company);

    @Update("update company set company_name = #{company_name},company_legal = #{company_legal},company_licence = #{company_licence},username = #{username},password = #{password} where cpmy_id = #{cpmy_id}")
    int update(Company company);

    @Select("select * from company where company_name like concat('%',#{company_name},'%') and del = 0 limit #{pageNum},#{pageSize}")
    List<Company> selectAll(String company_name, Integer pageNum, Integer pageSize);

    @Select("select count(*) from company where company_name like concat('%',#{company_name},'%') and del = 0")
    Integer selectAllTotal(String company_name);

    @Update("update company set del = 1 where cpmy_id = #{cpmy_id}")
    int delete(int cpmy_id);

    /**
     * 根据岗位id 查询 相应公司的详细信息
     *
     * @param id 岗位id
     * @return 相应公司的详细信息
     */
    @Select("select * from company where cpmy_id = (select com_id from profession where id = #{id})")
    Company selectOfCompany(int id);

    /**
     * 显示所有的申请(分页)
     *
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @return 分页数据
     */
    @Select("select * from pro_stu where del = 0 limit #{pageNum},#{pageSize}")
    List<ProStu> selectAllOfProStu(Integer pageNum, Integer pageSize);

    /**
     * 显示所有的申请的总记录数
     *
     * @return 总记录数
     */
    @Select("select count(*) from pro_stu where del = 0")
    Integer selectAllOfProStuTotal();

    /**
     * 同意学生的申请
     *
     * @param id pro_stu表的id(申请记录的id)
     * @return 大于等于0 修改成功
     */
    @Update("update pro_stu set apply_com = 1 where id = #{id}")
    int applyOfStudentYes(int id);

    /**
     * 拒绝学生的申请
     *
     * @param id pro_stu表的id(申请记录的id)
     * @return 大于等于0 修改成功
     */
    @Update("update pro_stu set apply_com = 1 where id = #{id}")
    int applyOfStudentNo(int id);

    /**
     * 不允许重复申请(检查数据库是否有相同数据)
     *
     * @param stu_id 学生id
     * @param pro_id 岗位id
     * @return count(*) 等于1就不再允许申请
     */
    @Select("select count(*) from pro_stu where stu_id=#{stu_id} and pro_id = #{pro_id} and del = 0")
    int checkApplyOfStudent(int stu_id, int pro_id);

    /**
     * 在同意的情况下同时删除其学生的其他申请
     *
     * @param stu_id 学生id
     * @return 大于等于0 删除成功
     */
    @Delete("delete from pro_stu where stu_id = #{stu_id} and del = 0 and apply_com != 1")
    int deleteAllApplyOfStudent(int stu_id);

}
