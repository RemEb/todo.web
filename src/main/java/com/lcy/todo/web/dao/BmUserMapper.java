package com.lcy.todo.web.dao;

import com.lcy.todo.web.dataobject.BmUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BmUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user
     *
     * @mbg.generated Wed Jan 23 21:15:15 CST 2019
     */
    @Delete({
        "delete from bm_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user
     *
     * @mbg.generated Wed Jan 23 21:15:15 CST 2019
     */
    @Insert({
        "insert into bm_user (id, email, ",
        "reg_time, gender, ",
        "birthday, pwd, ",
        "salt, status, gmt_modified, ",
        "gmt_created)",
        "values (#{id,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{regTime,jdbcType=TIMESTAMP}, #{gender,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=TIMESTAMP}, #{pwd,jdbcType=VARCHAR}, ",
        "#{salt,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{gmtCreated,jdbcType=TIMESTAMP})"
    })
    int insert(BmUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user
     *
     * @mbg.generated Wed Jan 23 21:15:15 CST 2019
     */
    @Select({
        "select",
        "id, email, reg_time, gender, birthday, pwd, salt, status, gmt_modified, gmt_created",
        "from bm_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP)
    })
    BmUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user
     *
     * @mbg.generated Wed Jan 23 21:15:15 CST 2019
     */
    @Select({
        "select",
        "id, email, reg_time, gender, birthday, pwd, salt, status, gmt_modified, gmt_created",
        "from bm_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_created", property="gmtCreated", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BmUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_user
     *
     * @mbg.generated Wed Jan 23 21:15:15 CST 2019
     */
    @Update({
        "update bm_user",
        "set email = #{email,jdbcType=VARCHAR},",
          "reg_time = #{regTime,jdbcType=TIMESTAMP},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "gmt_created = #{gmtCreated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BmUser record);
}