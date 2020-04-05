package com.apn.servlets;

import java.io.IOException;

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param 0 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Fetching parameters from the HttpServletRequest object */
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address1") +", "+ request.getParameter("address2");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String accountNo=request.getParameter("accountNo");
		float balance=Float.parseFloat(request.getParameter("balance"));
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		
		AdminDAO adminDAO = new AdminDAO();
		UserService userService = new UserService();
		try 
		{
			HttpSession session = request.getSession();
			/* This searches the user based on user id */
			if(adminDAO.searchUserByUserId(userId)==null)
			{
				System.out.println("after search by userid");
				/*Creates the user object if the user id and password matches */
				if(password.equals(cpassword))
				{
					System.out.println("after password validation");
					UserBO user = new UserBO(firstName, lastName,  gender, address,  mobile,  email,
							 accountNo, userId, password,balance,"active");
					UserBO userBO = userService.createAccount(user);
					System.out.println("before userBo not null");
					if(userBO!=null)	
					{
						System.out.println("after userBo is not null");
						session.setAttribute("user", userBO);
			
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/RegisterSuccessPage.jsp");
						System.out.println("before dispatcher include");
						requestDispatcher.forward(request, response);
						System.out.println("after dispatcher include");
						
					}
					else
					{
						/*This error is generated if the entered credentials are invalid */
						
						request.setAttribute("registrationError", "Email and mobile already registered");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/RegisterPage.jsp");
						requestDispatcher.forward(request, response);
					}
			   }
				else
				{
					/*This error is generated if the entered credentials are invalid */

					request.setAttribute("passwordMismatchError", "password mismatch");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/RegisterPage.jsp");
					requestDispatcher.forward(request, response);
					
				}	
			}
			else
			{
				/*This error is generated if the entered credentials are invalid */
				
				request.setAttribute("userIdError", "User ID exists");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/RegisterPage.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
	catch (Exception e) 
		{
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
