package com.jason.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jason.user.production;
import com.jason.algorithm.*;

public class SelectProductions {
	public 	JDBC jdbc = new JDBC();
	public production [] tuijiandao(String username){
		Connection cnn =null;
		Statement ps=null;
		ResultSet rs =null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		production [] li= new production [3];
		try {
			cnn=jdbc.getConnection();
			cnn.setAutoCommit(false);
			ps=cnn.createStatement();
			String sql="SELECT production FROM tb_users$ WHERE username LIKE '%"+username+"%';";
			rs=ps.executeQuery(sql);
			rs.next();
			String pro=rs.getString("production");
			tuijian tj =new tuijian();
			int[] c =tj.recommend(pro);
			String sql3="select * FROM tb_goods$ WHERE pid = "+c[0]+" ;";
			rs2=ps.executeQuery(sql3);
			rs2.next();
			 int  pid1=(int)rs2.getDouble("pid");
//				System.out.println(pid);
				String url1=rs2.getString("address");
				String name1=rs2.getString("pname");
				int salenum1=(int)rs2.getDouble("salenumbers");
				int inprice1=(int)rs2.getDouble("inprice");
				int outprice1=(int)rs2.getDouble("outprice");
				String picture1=rs2.getString("picture");	
				production p2 =new production(pid1, url1, name1, salenum1, inprice1, outprice1, picture1);
				li[2]=p2;
			
			sql="SELECT * FROM tb_goods$ WHERE pid IN (SELECT simpro FROM tb_goods$ WHERE pid IN ("+c[0]+","+c[1]+"));";
			rs1=ps.executeQuery(sql);
			int i =0;
			while(rs1.next())
			{  int  pid=(int)rs1.getDouble("pid");
//			System.out.println(pid);
			String url=rs1.getString("address");
			String name=rs1.getString("pname");
			int salenum=(int)rs1.getDouble("salenumbers");
			int inprice=(int)rs1.getDouble("inprice");
			int outprice=(int)rs1.getDouble("outprice");
			String picture=rs1.getString("picture");	
			production p1 =new production(pid, url, name, salenum, inprice, outprice, picture);
			li[i]=p1;
			i++;
			
			}
			cnn.commit();
			cnn.setAutoCommit(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			JDBC.close(rs, ps, cnn);
		try {
			rs1.close();
			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				cnn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
		return li;}
//	 public static void main(String[] args){
//		
//		SelectProductions sp=new SelectProductions();
//		production [] li = sp.tuijiandao("zy");
//		System.out.println(li[0].toString());
//	}
}
