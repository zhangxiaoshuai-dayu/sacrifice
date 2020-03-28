package com.clound.sacrifice.module;

import java.util.Objects;

/**
 * 注册用户名单
 *
 * @author zxs
 * @version 1.0
 * @date 2020/3/28 11:23
 */
public class SacrificeRegister {
	public Integer id;
	public String sex;
	public String username;
	public String pwd;
	public String phoneNum;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SacrificeRegister that = (SacrificeRegister) o;
		return id.equals(that.id) &&
				sex.equals(that.sex) &&
				username.equals(that.username) &&
				pwd.equals(that.pwd) &&
				phoneNum.equals(that.phoneNum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, sex, username, pwd, phoneNum);
	}

	@Override
	public String toString() {
		return "SacrificeRegister{" +
				"id=" + id +
				", sex='" + sex + '\'' +
				", username='" + username + '\'' +
				", pwd='" + pwd + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				'}';
	}
}