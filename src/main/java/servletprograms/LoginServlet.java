package servletprograms;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import beansprograms.*;
import DaoPrograms.LoginDao;
@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String uN=req.getParameter("uname");
		String pW=req.getParameter("pword");
		
		CalcUserBean cub= new LoginDao().login(uN,pW);
		
		if(cub==null) {
			   req.setAttribute("msg", "Username & Password is incorrect....<br>");
			   req.getRequestDispatcher("loginerror.jsp").forward(req, res);
		   }
		   else {
			   HttpSession hs=req.getSession();
			   hs.setAttribute("cubean", cub);
			   req.getRequestDispatcher("calculator.jsp").forward(req, res);
		   }
	}

}
