package com.hospitalmanagement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiagnotistServlet
 */
@WebServlet("/DiagnotistServlet")
public class DiagnotistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnotistServlet() {
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
		String id=request.getParameter("patientId");
		String test = request.getParameter("testname");
		int amt= Integer.parseInt(request.getParameter("testcost"));
		String driverName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "testdb";
		String userId = "root";
		String password = "Shivam";
		try {
		Class.forName(driverName);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}

		Connection connection = null;
		Statement statement = null;
		
        PrintWriter out=response.getWriter();
		
		try{ 
			connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
			statement=connection.createStatement();
			String sql ="insert into PatientDetails(pId,Test,Amount) values("+id+","+test+","+amt+")";

		    statement.executeQuery(sql);
			out.println("Diagnostics Added Successfully");
			request.setAttribute("pid", id);
			request.setAttribute("testname", test);
			request.setAttribute("amt", amt);
			request.getRequestDispatcher("TestDisplay.jsp").forward(request, response);
			 
		} catch (Exception e) {
			e.printStackTrace();
			}
			finally{
				out.close();
			}
		
	}

}

	


