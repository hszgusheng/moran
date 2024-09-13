package com.situ.chronicmange.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 档案表
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
public class Rhr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0:未知; 1:男; 2:女;
     */
    private Integer gender;

    /**
     * 疾病史 0:无; 1:高血压; 2:糖尿病; 3:高糖
     */
    private String diseaseHis;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDiseaseHis() {
        return diseaseHis;
    }

    public void setDiseaseHis(String diseaseHis) {
        this.diseaseHis = diseaseHis;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Rhr{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", gender=" + gender +
            ", diseaseHis=" + diseaseHis +
            ", userId=" + userId +
            ", userName=" + userName +
            ", createTime=" + createTime +
        "}";
    }
}
