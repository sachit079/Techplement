package servletprograms;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import DaoPrograms.*;
@WebServlet("/delete")
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs =req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "session expired...<br>");
			req.getRequestDispatcher("message.jsp").forward(req, res);
		}
		else {
		   int slno = Integer.parseInt(req.getParameter("slno"));
		   int k = new DeleteHistoryDao().delete(slno);
		   if(k>0) {
			   req.getRequestDispatcher("delete.jsp").forward(req, res);
		   }
		}
	}
	
}
