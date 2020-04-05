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
 * Servlet implementation class DepositServlet
 */
@WebServlet({ "/DepositServlet", "/Deposit" })
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
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
		float amount = Float.parseFloat(request.getParameter("amount"));
		UserService userService = new UserService();
		HttpSession session = request.getSession(true);
		/*Fetches the user attribute from the session object */
		UserBO user = (UserBO)session.getAttribute("user");
		/*This checks if the user credentials belong to the user */
		if(user.getAccountNo().equals(accountNo) && user.getUserId().equals(userId) )
		{
			if(amount>0)
			{
				try {
					/* This deposits the amount after validating the user details */
					if(userService.deposit(amount, user))
					{
						session.setAttribute("user", user);
						session.setAttribute("amount", amount);
						session.setAttribute("balance", (Float)userService.checkBalance(accountNo));
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/DepositSuccessPage.jsp");
						requestDispatcher.include(request, response);
						
					}
					else
					{
						/*This error is generated if the entered credentials are invalid */
						
						request.setAttribute("accountNoError", "Deposit Unsuccessful");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/DepositPage.jsp");
						requestDispatcher.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					response.sendRedirect("views/ErrorPage.jsp");
				}
			}
			else
			{
				request.setAttribute("amountError", "Amount cannot be negative");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/DepositPage.jsp");
				requestDispatcher.forward(request, response);
			}
			}
			
		else
		{
			/*This error is generated if the entered credentials are invalid */
			
			request.setAttribute("accountNoError", "Please check your account number");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/DepositPage.jsp");
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
