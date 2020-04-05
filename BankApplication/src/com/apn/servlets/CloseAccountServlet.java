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

import com.apn.services.UserService;

/**
 * Servlet implementation class CloseAccountServlet
 */
@WebServlet({ "/CloseAccountServlet", "/CloseAccount" })
public class CloseAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Fetching parameters from the HttpServletRequest object */
		String accountNo = request.getParameter("accountNo");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		/*Fetching user attribute from the session object*/
		UserBO user = (UserBO)session.getAttribute("user");
		UserService userService = new UserService();
		/*This checks if the entered credentials are valid and belongs to the user*/
		if(user.getAccountNo().equals(accountNo) && user.getUserId().equals(userId) && user.getPassowrd().equals(password))
		{
				try 
				{
					/*This closes the user account*/
					if(userService.closeAccount(user))
					{	
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/CloseAccountSuccessPage.jsp");
						requestDispatcher.forward(request, response);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					response.sendRedirect("views/ErrorPage.jsp");
				}
				
		}
		else
		{
			/*This error is generated if the entered credentials are invalid */
			request.setAttribute("invalidCredentialsError", "Invalid Credentials");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/CloseAccountPage.jsp");
			requestDispatcher.forward(request, response);
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
