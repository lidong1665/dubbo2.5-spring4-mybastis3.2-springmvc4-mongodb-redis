package com.lidong.dubbo.model.user;

import java.io.Serializable;
/**
 * @className :User
 * @desc      :
 * @author    :lidong
 * @createTime:2017/1/8 下午8:29
 * @company   :chni
 * @QQ        :1561281670
 * @email     :lidong1665@163.com
 */
public class User implements Serializable {


    private Integer id;

    private String name;

    private String password;

    private Integer age;

    public User() {
    }

    public User(Integer id, String name, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
