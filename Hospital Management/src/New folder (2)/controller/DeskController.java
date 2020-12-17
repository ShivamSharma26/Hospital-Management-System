package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Medicine;
import com.Bean.Patient;
import com.Bean.Test;
import com.service.DeskService;
import com.util.calculateDayAmount;


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
			DeskService service = new DeskService();
			
			int ssnid = Integer.parseInt(request.getParameter("ssnid"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String date = request.getParameter("dateofadmission");
			String bedtype = request.getParameter("bedtype");
			String address = request.getParameter("address");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			
			
			
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
		 //bill pagee
		 
			 if(action.equals("getBill")) {
				 
				 DeskService service = new DeskService();
				 
				 int id = Integer.parseInt(request.getParameter("patient_id"));
				 Patient patient = null;
				 try {
					 patient = service.getPatientDetails(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(patient!=null) {
				 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				 Date dod = new Date();
				 System.out.println(df.format(dod));
				 String dodis = df.format(dod);
				 
				 long days = calculateDayAmount.calculateDay(patient.getDate());
				 double bedbill = calculateDayAmount.calculateBedAmount(days, patient.getBedtype());
				 
				 
				 List<Medicine> med = new ArrayList<>();
				 try {
					med = service.getMedicines(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 double medbill=0;
				 for(Medicine m:med) {
					 medbill = medbill + m.getAmount();
				 }
				 
				 List<Test> test = new ArrayList<>();
				 try {
					test = service.getTest(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 double testbill=0;
				 for(Test t:test) {
					 testbill = testbill + t.getAmount();
				 }
				 
				 double totalbill = bedbill+medbill+testbill;
				 
				 request.setAttribute("PatientId", patient.getId());
				 request.setAttribute("patient", patient);
				 request.setAttribute("dod", dodis);
				 request.setAttribute("days",days );
				 request.setAttribute("bedbill",bedbill );
				 request.setAttribute("med", med);
				 request.setAttribute("medbill",medbill );
				 request.setAttribute("test", test);
				 request.setAttribute("testbill",testbill );
				 request.setAttribute("totalbill",totalbill );
				 request.getRequestDispatcher("billpage.jsp").forward(request, response);

			}
			else {
				request.setAttribute("errmessage", "No Patient with this ID found.");
				request.getRequestDispatcher("error.jsp").forward(request, response);

			}
			 }
		 
		if(action.equals("discharge")) {
			
			DeskService service = new DeskService();
			int id = Integer.parseInt(request.getParameter("patient_id"));
			
			boolean result = false;
			
			try {
				result = service.disPatient(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result) {
				request.setAttribute("msg", "Patient Discharged successfully.");
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errmessage", "Unable to discharge patient.");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}
	}

}
