package com.jason.user;

import com.jason.ann.Classann;
import com.jason.ann.Production;

@Classann(tablename="tb_users$")
public class user {
	@Production(colname="uid")
	int uid;
	@Production(colname="username")
	String username;
	@Production(colname="sex")
	String sex;
	@Production(colname="password")
	int password;
	@Production(colname="age")
	int age;
	@Production(colname="location")
	String location;
	@Production(colname="production")
	String production;	
	@Production(colname="money")
	int money;
	@Production(colname="qid")
	int qid ;
	public user() {
		super();
	}
	public user(int uid, String username, String sex, int password, int age, String location, String production,
			int money, int qid) {
		super();
		this.uid = uid;
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.age = age;
		this.location = location;
		this.production = production;
		this.money = money;
		this.qid = qid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getqid() {
		return qid;
	}
	public void setqid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "user [uid=" + uid + ", username=" + username + ", sex=" + sex + ", password=" + password + ", age="
				+ age + ", location=" + location + ", production=" + production + ", money=" + money + ", qid=" + qid
				+ "]";
	}
	
	

}
