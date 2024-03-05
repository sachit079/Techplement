package servletprograms;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.http.*;

import beansprograms.CalcUserBean;
import DaoPrograms.RegisterDao;
@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		CalcUserBean cub = new CalcUserBean();
		cub.setuName(req.getParameter("uname"));
		cub.setfName(req.getParameter("fname"));
		cub.setlName(req.getParameter("lname"));
		cub.seteId(req.getParameter("email"));
		cub.setpWord(req.getParameter("pword"));
		int k=new RegisterDao().register(cub);
     if(k>0) {
			 req.getRequestDispatcher("register.jsp").forward(req, res);
	}
     else {
    	 req.getRequestDispatcher("registererror.jsp").forward(req, res);
     }
}
}
