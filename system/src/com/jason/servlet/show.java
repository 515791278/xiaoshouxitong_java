package com.jason.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import net.sf.json.JSONArray;  
import net.sf.json.JSONFunction;  
import net.sf.json.JSONObject; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jason.service.searchProductions;
import com.jason.user.production;



/**
 * Servlet implementation class show
 */
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchProductions  pro =new searchProductions();
		
    	String  uname=(String ) request.getAttribute("uname");
    	
	    if(uname==null){
			uname="zy";}
		System.out.println("post.....");
		production[] li=pro.searchProduction(uname);
		
		JSONArray js = JSONArray.fromObject(li);
		System.out.println(js.toString());
		PrintWriter out =response.getWriter();
		out.print(js.toString());
		out.flush();
		out.close();
	
	
	}

}
