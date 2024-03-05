package servletprograms;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DaoPrograms.ViewAllHistoryDao;
import beansprograms.CalcBean;
import beansprograms.CalcUserBean;

import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewHistory")
public class ViewAllHistoryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			HttpSession hs = req.getSession(false);
			if(hs==null) {
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else {
				CalcUserBean cul = (CalcUserBean) hs.getAttribute("cubean");
				String uname = cul.getuName();
				ArrayList<CalcBean> al = new ViewAllHistoryDao().retrive(uname);
				hs.setAttribute("calcHisList", al);
				req.getRequestDispatcher("ViewAllHistory.jsp").forward(req, res);
			}
}
}
