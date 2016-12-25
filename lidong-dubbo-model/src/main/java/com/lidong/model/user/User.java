package com.lidong.model.user; 

import java.io.Serializable;

public class User implements Serializable{  
    /**
	 * 
	 */
	private static final long serialVersionUID = -5895085396798553805L;

	private Integer id;  
  
    private String name;  
  
    private String password;  
  
    private Integer age;  
  
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
        this.password = password == null ? null : password.trim();  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", age=" + age + "]";
	}  
    
    
    
}  