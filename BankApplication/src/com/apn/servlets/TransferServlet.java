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
 * Servlet implementation class TransferServlet
 */
@WebServlet({ "/TransferServlet", "/Transfer" })
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
		String targetAccountNo = request.getParameter("targetAccountNo");
		float amount = Float.parseFloat(request.getParameter("amount"));
		UserService userService = new UserService();
		HttpSession session = request.getSession(true);
		System.out.println("after session creation");
		UserBO user = (UserBO)session.getAttribute("user");
		System.out.println("after session attribute get"+user);
		AdminDAO adminDAO = new AdminDAO();
		try 
		{
			/* This validates the user credentials  */
			if(user.getAccountNo().equals(accountNo) && !user.getAccountNo().equals(targetAccountNo))
			{	System.out.println("after account number validation");
				if(amount>0)
				{System.out.println("after amount >0");
					UserBO target = adminDAO.searchUserByAccountNo(targetAccountNo);
					if(target != null)
						{System.out.println("after the target identified");
							if(target.getStatus().equals("active"))
							{
								System.out.println("after the target is active");
							if(userService.transfer(user, target, amount))
							{
								session.setAttribute("target", target);
								session.setAttribute("amount", amount);
								session.setAttribute("balance", (Float)userService.checkBalance(accountNo));
								RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/TransferSuccessPage.jsp");
								requestDispatcher.include(request, response);
							}
							else
							{
								/*This error is generated if the entered credentials are invalid */
								request.setAttribute("withdrawError", "Insufficient funds");
								RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/TransferPage.jsp");
								requestDispatcher.forward(request, response);
							}
						}
						else
						{
							/*This error is generated if the entered credentials are invalid */
							request.setAttribute("accountNoError", "Please check the target account number");
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/TransferPage.jsp");
							requestDispatcher.forward(request, response);
						}
						
					}
					else
					{
						/*This error is generated if the entered credentials are invalid */
						request.setAttribute("accountNoError", "Target account number does not exist");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/TransferPage.jsp");
						requestDispatcher.forward(request, response);
					}
				}
				else
				{
					/*This error is generated if the entered credentials are invalid */
					request.setAttribute("accountNoError", "Please check the account number");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/TransferPage.jsp");
					requestDispatcher.forward(request, response);
				}
					
			}
			else
			{
				request.setAttribute("amountError", "Amount cannot be negative");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/DepositPage.jsp");
				requestDispatcher.forward(request, response);
			}
				}
				
				
			catch (SQLException e) {
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
