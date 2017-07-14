package com.jason.user;

import com.jason.ann.Classann;
import com.jason.ann.Production;

@Classann(tablename="tb_goods$")
public class production {
	@Production(colname="pid")
	int pid;
	@Production(colname="address")
	String url;
	public production() {
		super();
	}
	@Production(colname="pname")
	String name;
	@Production(colname="salenumbers")
	int salenum;
	@Production(colname="inprice")
	int inprice;
	@Production(colname="outprice")
	int outprice;
	@Production(colname="picture")
	String picture;
	@Override
	public String toString() {
		return "production [pid=" + pid + ", url=" + url + ", name=" + name + ", salenum=" + salenum + ", inprice="
				+ inprice + ", outprice=" + outprice + "]";
	}
	public String getpicture() {
		return picture;
	}
	public void setpicture(String prcture) {
		this.picture = prcture;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalenum() {
		return salenum;
	}
	public void setSalenum(int salenum) {
		this.salenum = salenum;
	}
	public int getInprice() {
		return inprice;
	}
	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
	public int getOutprice() {
		return outprice;
	}
	public void setOutprice(int outprice) {
		this.outprice = outprice;
	}
	public production(int pid, String url, String name, int salenum, int inprice, int outprice,String picture) {
		super();
		this.pid = pid;
		this.url = url;
		this.name = name;
		this.salenum = salenum;
		this.inprice = inprice;
		this.outprice = outprice;
		this.picture=picture;
	}
	

}
