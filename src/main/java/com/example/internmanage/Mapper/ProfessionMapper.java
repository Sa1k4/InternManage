package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Profession;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProfessionMapper {
    /**
     * 查询所有企业的岗位信息 或 查询所有企业被删除的岗位信息
     * 角色：管理员
     *
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @param del      删除与否的状态
     * @return 所有企业的岗位信息 或 所有企业被删除的岗位信息
     */
    @Select("select * from profession where del = #{del} limit #{pageNum},#{pageSize}")
    List<Profession> selectAllAndDel(Integer pageNum, Integer pageSize, Integer del);

    /**
     * 查询所有企业的岗位信息记录数 或 查询所有企业被删除的岗位信息记录数
     * 角色：管理员
     *
     * @param del 删除与否的状态
     * @return 记录总条数
     */
    @Select("select count(*) from profession where del = #{del}")
    Integer selectAllAndDelTotal(Integer del);

    /**
     * 通过岗位id删除岗位记录(彻底删除)
     * 角色：管理员
     *
     * @param id 岗位id
     * @return 0或1
     */
    @Delete("delete from profession where id = #{id}")
    int delCProfession(int id);

    /**
     * 查询相应企业的岗位信息
     * 角色：企业
     *
     * @param com_id   企业id
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @return 岗位信息
     */
    @Select("select * from profession where com_id = #{com_id} and del = 0 limit #{pageNum},#{pageSize}")
    List<Profession> selectAllOfCom(Integer com_id, Integer pageNum, Integer pageSize);

    /**
     * 查询相应企业岗位信息的总记录条数
     * 角色：企业
     *
     * @param com_id 企业id
     * @return 记录总条数
     */
    @Select("select count(*) from profession where com_id = #{com_id} and del = 0")
    Integer selectAllOfComTotal(Integer com_id);

    /**
     * 根据条件查询岗位信息
     * 角色：企业
     *
     * @param com_id   企业id
     * @param name     岗位名称
     * @param status   状态
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @return 岗位信息
     */
    @Select("select * from profession where name like concat('%',#{name},'%') and status= #{status} and com_id=#{com_id} and del = 0 limit #{pageNum},#{pageSize}")
    List<Profession> conditionQuery(Integer com_id, String name, Integer status, Integer pageNum, Integer pageSize);

    @Select("select * from profession where name like concat('%',#{name},'%') and status= #{status} and del = 0 limit #{pageNum},#{pageSize}")
    List<Profession> conditionQueryA(String name, Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据条件查询岗位信息的总记录条数
     * 角色：企业
     *
     * @param com_id 企业id
     * @param name   岗位名称
     * @param status 状态
     * @return 记录总条数
     */
    @Select("select count(*) from profession where name like concat('%',#{name},'%') and status= #{status} and com_id=#{com_id} and del = 0")
    Integer conditionQueryTotal(Integer com_id, String name, Integer status);

    @Select("select count(*) from profession where name like concat('%',#{name},'%') and status= #{status} and del = 0")
    Integer conditionQueryTotalA(String name, Integer status);

    /**
     * 通过实体类新增岗位信息
     * 角色：企业
     *
     * @param profession 岗位实体类
     * @return 0或1
     */
    @Insert("insert into profession(name,salary,introduce,apply_num,com_id) values (#{name},#{salary},#{introduce},#{apply_num},#{com_id})")
    int addProfession(Profession profession);

    /**
     * 通过岗位id删除岗位记录(假删除)
     * 角色：企业
     *
     * @param id 岗位id
     * @return 0或1
     */
    @Update("update profession set del = 1 where id = #{id}")
    int delProfession(int id);

    /**
     * 根据实体类的信息来更新数据库的岗位记录(整条一起修改)
     * 角色：企业
     *
     * @param profession 岗位实体类
     * @return 0或1
     */
    @Update("update profession set name=#{name},salary=#{salary},introduce=#{introduce},apply_num=#{apply_num},status=#{status} where id = #{id}")
    int updateProfession(Profession profession);

    /**
     * 开启或关闭岗位
     * 角色：企业
     *
     * @param profession 只含岗位id与status状态
     * @return 0或1
     */
    @Update("update profession set status=#{status} where id=#{id}")
    int openOrCloseProfession(Profession profession);


    /**
     * profession表与pro_stu对比，排除pro_stu表里确认的岗位(分页、根据岗位名称模糊搜索)
     *
     * @param stu_id   学生id
     * @param name     岗位名称
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @return 岗位信息
     */
    @Select("SELECT * FROM profession where id not in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 or apply_com = 0 and del = 0) and name like concat('%',#{name},'%') and status = 1 and del = 0 limit #{pageNum},#{pageSize}")
    List<Profession> selectPfToPsNotPsProId(int stu_id, String name, Integer pageNum, Integer pageSize);

    /**
     * profession表与pro_stu对比，排除pro_stu表里确认的岗位(分页、根据岗位名称模糊搜索) 的 总记录数
     *
     * @param stu_id 学生id
     * @param name   岗位名称
     * @return 总记录数
     */
    @Select("SELECT count(*) FROM profession where id not in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 or apply_com = 0 and del = 0) and name like concat('%',#{name},'%') and status = 1 and del = 0")
    Integer selectPfToPsNotPsProIdTotal(int stu_id, String name);

    //申请中的岗位
    @Select("SELECT * FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 0 and del = 0) and name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<Profession> selectPsOf0(int stu_id, String name, Integer pageNum, Integer pageSize);

    @Select("SELECT count(*) FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 0 and del = 0) and name like concat('%',#{name},'%')")
    Integer selectPsOf0Total(int stu_id, String name);

    //历史岗位
    @Select("SELECT * FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 and del = 1) and name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<Profession> selectPsOfPast(int stu_id, String name, Integer pageNum, Integer pageSize);

    @Select("SELECT count(*) FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 and del = 1) and name like concat('%',#{name},'%')")
    Integer selectPsOfPastTotal(int stu_id, String name);

    /**
     * 在stu_pro表里面查出未通过的岗位(分页、根据岗位名称模糊搜索)
     *
     * @param stu_id 学生id
     * @param name 岗位名称
     * @param pageNum 当前页
     * @param pageSize 页大小
     * @return 未通过的岗位
     */
    @Select("SELECT * FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 2 and del = 0) and name like concat('%',#{name},'%') limit #{pageNum},#{pageSize}")
    List<Profession> selectPsOfNo(int stu_id, String name, Integer pageNum, Integer pageSize);

    /**
     * 在stu_pro表里面查出未通过的岗位(分页、根据岗位名称模糊搜索) 的 总记录数
     *
     * @param stu_id 学生id
     * @param name 岗位名称
     * @return 总记录数
     */
    @Select("SELECT count(*) FROM profession where id in (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 2 and del = 0) and name like concat('%',#{name},'%')")
    Integer selectPsOfNoTotal(int stu_id, String name);

    /**
     * 在stu_pro表里面查出通过的岗位(分页、根据岗位名称模糊搜索)
     *
     * @param stu_id 学生id
     * @return 通过的岗位
     */
    @Select("SELECT * FROM profession where id = (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 and del = 0)")
    Profession selectPsOfYes(int stu_id);

    /**
     * 在stu_pro表里面查出通过的岗位(分页、根据岗位名称模糊搜索) 的 总记录数
     *
     * @param stu_id 学生id
     * @return 总记录数
     */
    @Select("SELECT count(*) FROM profession where id = (select pro_id from pro_stu where stu_id = #{stu_id} and apply_com = 1 and del = 0)")
    Integer selectPsOfYesTotal(int stu_id);
}
