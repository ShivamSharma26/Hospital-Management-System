package com.hospitalmanagement.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospitalmanagement.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String action=request.getParameter("action");
		
		if(action==null) {
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		
		if(action.equals("login")) {
			//retrieve the username and password from login page
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			LoginService service=new LoginService();
			String position="";
			
				try {
					position = service.validateLogin(username,password);
					System.out.println("Controller"+position);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			if(position=="DeskExecutive") {
				//new session must be created
				//HttpSession newSession=request.getSession(true);
				//newSession.setAttribute(username, username);
				request.getRequestDispatcher("home.jsp").forward(request, response);//redirected to home page
			}
			else if(position=="Pharmacy") {
				
				request.getRequestDispatcher("home1.jsp").forward(request, response);
			}
			else if(position=="Diagnotists") {
				
				request.getRequestDispatcher("home2.jsp").forward(request, response);
			}
			
		}
	}

}
