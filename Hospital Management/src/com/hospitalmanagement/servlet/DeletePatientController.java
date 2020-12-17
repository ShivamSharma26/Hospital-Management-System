package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospitalmanagement.util.DatabaseUtil;

/**
 * Servlet implementation class DeletePatientController
 */
@WebServlet("/DeletePatientController")
public class DeletePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatientController() {
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
		try{ 
			
			String id=request.getParameter("pid");
			System.out.println("Delete "+id);
			String sql ="Delete FROM PatientInfo where id="+id;
			ps=con.prepareStatement(sql);
		    int r=ps.executeUpdate();
		    if(r>0) {
			PrintWriter out=response.getWriter();
			request.setAttribute("message", "Patient Data Deleted Successfully");
			request.getRequestDispatcher("success.jsp");
			out.println("Patient Record Successfully Deleted");
		}
		    else{
		    	request.setAttribute("errMessage", "Some error Occured");
				request.getRequestDispatcher("error.jsp");
		    	}
		}catch (Exception e) {
		    }
			
			
			finally{
				
			}
			
			
	}
	}

