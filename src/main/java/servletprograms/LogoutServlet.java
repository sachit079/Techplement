package servletprograms;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws
	ServletException,IOException{
	HttpSession hs = req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg", "session expired");
	}
	else {
		hs.invalidate();
		req.setAttribute("msg", "logout Successfully");
	}
	req.getRequestDispatcher("Logout.jsp").forward(req, res);
	}
}
