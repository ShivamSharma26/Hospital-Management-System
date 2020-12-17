package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.service.CustomerService;
import com.util.DateUtil;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CustomerController() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String source=req.getParameter("source");
		
		if(source.equals("add")) {
			resp.sendRedirect("addCustomer.html");
		}
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerService service=new CustomerService();
		String source=req.getParameter("source");
		
		
		
		if(source.equals("addCustomer")) {
			
			Customer customer=new Customer();
			
			customer.setFirstName(req.getParameter("firstName"));
			customer.setLastName(req.getParameter("lastName"));
			customer.setDob(DateUtil.convertStringToDate(req.getParameter("dob"), "dd/MM/yyyy"));
			customer.setGender(req.getParameter("gender"));
			customer.setCity(req.getParameter("city"));
			customer.setCountry(req.getParameter("country"));
			customer.setEmail(req.getParameter("email"));
			customer.setAnnual_salary(Double.parseDouble(req.getParameter("salary")));
			
			System.out.println("Customer Details:\n"+customer );
			
			try			{
				boolean flag=service.addCustomer(customer);			
			}catch( ClassNotFoundException | SQLException e) {
			
		      e.printStackTrace();			
			
		}
		}
	}

}
