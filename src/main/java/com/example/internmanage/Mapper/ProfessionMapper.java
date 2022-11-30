package com.example.internmanage.Mapper;

import com.example.internmanage.Entity.Profession;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProfessionMapper {
    /**
     * 查询所有企业的岗位信息
     * 角色：管理员
     *
     * @return 所有岗位信息
     */
    @Select("select * from profession where del = 0")
    Profession selectAll();

    /**
     * 查询所有企业被删除的岗位信息
     * 角色：管理员
     *
     * @return 所有被删除的岗位信息
     */
    @Select("select * from profession where del = 1")
    Profession selectAllDel();

    /**
     * 通过岗位id删除岗位记录(彻底删除)
     * 角色：管理员
     *
     * @param profession 只包含岗位id
     * @return 0或1
     */
    @Delete("delete from profession where id = #{id}")
    int delCProfession(Profession profession);

    /**
     * 查询相应企业的岗位信息
     * 角色：企业
     *
     * @return 相应企业的岗位信息
     */
    @Select("select * from profession where com_id = #{com_id} and del = 0")
    Profession selectAllOfCom(Profession profession);

    /**
     * 根据条件查询岗位信息
     * 角色：企业
     *
     * @param profession 岗位信息实体类
     * @return 筛选后的岗位信息
     */
    @Select("select * from profession where name=#{name} or status=#{status} and com_id=#{com_id} and del = 0")
    Profession conditionQuery(Profession profession);

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
     * @param profession 只包含岗位id
     * @return 0或1
     */
    @Update("update profession set del = 1 where id = #{id}")
    int delProfession(Profession profession);

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

}
