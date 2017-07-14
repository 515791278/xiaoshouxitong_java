package com.jason.service;



import com.jason.dao.SelectProductions;
import com.jason.user.production;

public class searchProductions {
public production [] searchProduction(String uname){

	SelectProductions sp=new SelectProductions();
	production [] li = sp.tuijiandao(uname);
	return li;
	
}
//static  public void main(String [] args ){
//	searchProductions sp=new searchProductions();
//	production [] li = sp.searchProduction("zy");
//	System.out.println(li[0].toString());
//	
//}
}
