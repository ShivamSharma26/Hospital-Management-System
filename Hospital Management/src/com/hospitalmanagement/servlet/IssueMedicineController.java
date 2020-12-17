package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.beans.Medicine;
import com.hospitalmanagement.service.PharmacyService;

/**
 * Servlet implementation class IssueMedicineController
 */
@WebServlet("/IssueMedicineController")
public class IssueMedicineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueMedicineController() {
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
		HttpSession session=request.getSession(false);
		ArrayList<Medicine> list=new ArrayList<Medicine>();
		double amount=0.0;
		double flag=0.0;
		String name =request.getParameter("name");
		
		String medicine_name =request.getParameter("med_name");
		String quantity =(request.getParameter("quant"));
		System.out.println("medicine "+medicine_name+quantity);
		PharmacyService service=new PharmacyService() ;
		String id=(String) session.getAttribute("patient_id");
		System.out.println("patient_id" +id);
		int id1=Integer.parseInt(id);
		try {
			
			int quantity1=Integer.parseInt(quantity);
			System.out.println("quantity is:"+quantity1);
			flag=service.addMedicine(medicine_name,quantity1,id1);
			System.out.println(flag);
			if(flag>=0.0) {
				amount=flag*quantity1;
				//request.setAttribute("name",medicine_name) ;
				//request.setAttribute("quantity",quantity) ;
				//request.setAttribute("rate",flag) ;
				//request.setAttribute("success","Available") ;
				//request.setAttribute("rate",flag);
				for(int i = 0; i < 4; i++) {
					list.add(new Medicine(medicine_name,quantity1,flag,amount));
				}
				 int i=0;
				 while(i!=0)
			        { 
			            // the data received from arraylist is of Data type 
			            // which is custom (int, String, int, long) 
			            // based on class Data 
			  
			            Medicine m = list.get(i); 
			  
			            // data variable of type Data has four primitive datatypes 
			            // roll -int 
			            // name- String 
			            // marks- int 
			            // phone- long 
			            System.out.println(m.getMedicine_name()+" "+m.getQuantity()+" "
			                               +m.getRate()+" "+m.getAmount()); 
			            i--;
			        } 
				response.getOutputStream().print(flag);
				//request.getRequestDispatcher("addMedicine.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


