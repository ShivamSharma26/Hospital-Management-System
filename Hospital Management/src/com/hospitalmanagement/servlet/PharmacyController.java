package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.beans.Patient;
import com.hospitalmanagement.service.DeskService;
import com.hospitalmanagement.service.PharmacyService;



/**
 * Servlet implementation class PharmacyController
 */
@WebServlet("/PharmacyController")
public class PharmacyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacyController() {
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
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action.equals("searchPatient")){
			String patient_id =request.getParameter("patient_id");
			System.out.println(patient_id);
			session.setAttribute("patient_id", patient_id);
			
			PharmacyService service=new PharmacyService() ;
			//Patient p=new Patient();
			try {
				Patient p=service.searchPatient(patient_id);
				System.out.println("Controller"+p.getDate());	
				request.setAttribute("Patient Details", p);
				request.setAttribute("PatientId", patient_id);
				request.getRequestDispatcher("issueMedicine.jsp").forward(request, response);
			 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					 
		}
		/*if(action.equals("checkAvailability")) {
			double flag=0.0;
			String medicine_name =request.getParameter("med_name");
			String quantity =request.getParameter("quantity");
			System.out.println("medicine "+medicine_name);
			PharmacyService service=new PharmacyService() ;
			try {
				int quantity1=Integer.parseInt(quantity);
				System.out.println("quantity is:"+quantity1);
				flag=service.addMedicine(medicine_name,quantity1);
				System.out.println(flag);
				if(flag>=0.0) {
					request.setAttribute("name",medicine_name) ;
					request.setAttribute("quantity",quantity) ;
					request.setAttribute("rate",flag) ;
										request.setAttribute("rate",flag);
					request.getRequestDispatcher("addMedicine.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
		
	}

}
