package com.lidong.dubbo.model.user;

import java.io.Serializable;

/**
 * @className :UserInfo
 * @desc      :
 * @author    :lidong
 * @createTime:2017/1/8 下午8:30
 * @company   :chni
 * @QQ        :1561281670
 * @email     :lidong1665@163.com
 */
public class UserInfo implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String userpassword;
    private String userid;
    private String num;
    private String randomcode;
    private String state;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getRandomcode() {
        return randomcode;
    }
    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    public UserInfo(String username, String userpassword, String userid,
                    String num, String randomcode, String state) {
        super();
        this.username = username;
        this.userpassword = userpassword;
        this.userid = userid;
        this.num = num;
        this.randomcode = randomcode;
        this.state = state;
    }
    @Override
    public String toString() {
        return "UserInfo [username=" + username + ", userpassword="
                + userpassword + ", userid=" + userid + ", num=" + num
                + ", randomcode=" + randomcode + ", state=" + state + "]";
    }
}
