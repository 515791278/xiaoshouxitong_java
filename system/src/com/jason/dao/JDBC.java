package com.jason.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC{
	// ������� ip �˿ں� ���ݿ���[ÿ�����ݿ�urlд����һ��] �û��� ����
	// url��ʽ:jdbc:mysql://ip��ַ:�˿ں�/���ݿ���
	public static final String url = "jdbc:mysql://127.0.0.1/xiaoshouxitong";
	
	public static final String classname = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";
	
	public Connection conn = null;
	public PreparedStatement pst = null;
	
	public  Connection getConnection() throws Exception {
		// ��������
		Class.forName(classname);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public static void close(ResultSet rs, Statement st, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

