package com.apn.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.apn.bo.UserBO;
import com.apn.dao.AdminDAO;
import com.apn.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Fetching parameters from the HttpServletRequest object */
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		AdminDAO adminDAO = new AdminDAO();
		
		
		try 
		{
			System.out.println("line1-beforesessioncreation");
			/*This counts the invalid attempts and deactivates the user account after 3 unsuccessful attempts */
			HttpSession session = request.getSession(true);
			UserBO user = adminDAO.searchUserByUserId(userId);
			System.out.println("line1-after search method");
			if(user!=null)
			{
				if(session.getAttribute("count")==null) 
					session.setAttribute("count",new Integer(0));
				System.out.println("after count");
				
				if(adminDAO.validateCredentials(userId, password))
				{
					System.out.println("validating the creditionals");
					
					session.setAttribute("user", user);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/ServicesPage.jsp");
					requestDispatcher.include(request, response);
				}
				else
				{
					System.out.println("if creditionals are invalid");
					request.setAttribute("credentialsError", "Invalid user credentials");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LoginPage.jsp");
					requestDispatcher.forward(request, response);
					Integer count=(Integer)session.getAttribute("count");
					count++;
					session.setAttribute("count",count);
					if(count<3)
					{	System.out.println("if wrong more than 3 times");
						/*This error is generated if the entered credentials are invalid */
						request.setAttribute("loginAttemptError", 3-count+" attempts left");
						RequestDispatcher requestDispatch = request.getRequestDispatcher("views/LoginPage.jsp");
						requestDispatch.forward(request, response);
					}
					else
					{
						System.out.println("account deactivation");
						/*This error is generated if the entered credentials are invalid */
						
						request.setAttribute("loginAttemptError", "Account deactivated. Contact branch");
						UserService userService=new UserService();
						userService.closeAccount(user);
						RequestDispatcher requestDispat = request.getRequestDispatcher("views/LoginPage.jsp");
						requestDispat.forward(request, response);
						session.invalidate();
					}
					
				}
			}
			else
				
			{
				System.out.println("if no values entered");
				request.setAttribute("No values Entered", "Please enter the values in the fields");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/LoginPage.jsp");
				requestDispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("views/ErrorPage.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
