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
 * Servlet implementation class CheckBalanceServlet
 */
@WebServlet({ "/CheckBalanceServlet", "/CheckBalance" })
public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
    	System.out.println("in checkbalance servlet");
		String accountNo = request.getParameter("accountNo");
		UserBO user = (UserBO)session.getAttribute("user");
		/* This checks if account number belongs to the user  */
		System.out.println("db acno is :"+user.getAccountNo());
		if(user.getAccountNo().equals(accountNo))
		{
			/* Creating user service object */
			UserService userService = new UserService();
			
			try 
			{
				/* This fetches the user balance */
				Float balance=userService.checkBalance(accountNo);
				session.setAttribute("balance", balance);
				/* The balance is redirected to the CheckBalanceSuccessPage */
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/CheckBalanceSuccessPage.jsp");
				requestDispatcher.forward(request, response);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				response.sendRedirect("views/ErrorPage.jsp");
				
			}
			
			
		}
		else
		{
			/* This error is generated if account number does not belong to the user */
		request.setAttribute("accountNoError", "Please check your account number");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/CheckBalancePage.jsp");
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
