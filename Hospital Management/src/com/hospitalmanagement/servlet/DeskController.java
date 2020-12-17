package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.service.DeskService;
import com.hospitalmanagement.util.DateUtil;

@WebServlet("/DeskController")
public class DeskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeskController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//HttpSession session = request.getSession(false);
		
		
		 if(action.equals("addPatient"))
		{
			DeskService service=new DeskService() ;
			
			int ssnid = Integer.parseInt(request.getParameter("ssnid"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String date = request.getParameter("dateofadmission");
			String bedtype = request.getParameter("bedtype");
			String address = request.getParameter("address");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			
			//Date date=null;
			//date = (Date) DateUtil.convertStringToDate(dateOfAdmission);
			
			
			Patient patient = new Patient( ssnid, name, age, date, address, bedtype, city,state);
			
			boolean success = false;
			try {
				success = service.addPatient(patient);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
			
			if(success) {
				
				request.setAttribute("message","Patient registration is successful.");
				request.getRequestDispatcher("success.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("errmessage","Sorry. Some error occured. Please Try Again.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				return;
			}
		}
		 
	}

}
