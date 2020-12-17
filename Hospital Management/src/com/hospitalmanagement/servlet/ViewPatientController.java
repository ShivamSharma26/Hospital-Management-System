package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospitalmanagement.util.DatabaseUtil;

/**
 * Servlet implementation class ViewPatientController
 */
@WebServlet("/ViewPatientController")
public class ViewPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con = null;
		con = DatabaseUtil.getConnection();

		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		PrintWriter out=response.getWriter();
		
		try{ 
			String id=request.getParameter("pId");
			System.out.println("Patient id on Search screen is"+id);
			
			String sql ="SELECT * FROM PatientInfo where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			resultSet = ps.executeQuery();
			while(resultSet.next()){ 
				System.out.println("Patient id "+resultSet.getString("id"));
				//if(id==resultSet.getString("id"))
				//{
					//out.println("Patient Found");
					
					String pid= resultSet.getString("id");
					String name=resultSet.getString("name");
					int age=resultSet.getInt("age");
					String date1=resultSet.getString("admissiondate");
					String tob=resultSet.getString("bedtype");
					String addr=resultSet.getString("address");
					String st=resultSet.getString("state");
					String ct=resultSet.getString("city");
					
					request.setAttribute("pid", pid);
					request.setAttribute("pname", name);
					request.setAttribute("age", age);
					request.setAttribute("DOJ", date1);
					request.setAttribute("tob", tob);
					request.setAttribute("address", addr);
					request.setAttribute("state", st);
					request.setAttribute("city", ct);
					request.getRequestDispatcher("searchPatient.jsp").forward(request, response);
				//}
				//else{
					//out.println("Patient Not Found");
				//}
			}

			} catch (Exception e) {
			e.printStackTrace();
			}
			finally{
				out.close();
			}
		
		
		
	}
	}


