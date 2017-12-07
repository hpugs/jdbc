package com.hpugs.mian.po;

import java.util.Date;

/**
 * @Description 用户对象
 * @author 高尚
 * @version 1.0
 * @date 创建时间：2017年12月7日 上午11:31:11
 */
public class User {

	private Integer id;
	private String name;
	private String phone;
	private String mobile;
	private String email;
	private String pwd;
	private Date birthday;
	private String address;
	private Integer state;
	private String remark;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", mobile=" + mobile + ", email=" + email
				+ ", pwd=" + pwd + ", birthday=" + birthday + ", address=" + address + ", state=" + state + ", remark="
				+ remark + "]";
	}
	
}
