package servletprograms;
import java.io.*;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import DaoPrograms.SaveHistoryDao;
import beansprograms.*;

@SuppressWarnings("serial")
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String hisDetailsJson= readHistoryDetailsFromRequest(req);

	String expression = parseExpressionFromJson(hisDetailsJson);
	
	String result = parseResultFromJson(hisDetailsJson);

	HttpSession hs = req.getSession();
	CalcUserBean cub= (CalcUserBean) hs.getAttribute("cubean");
	String uname = cub.getuName();
	
	int k= new SaveHistoryDao().saveHistoryToDatabase(expression,result,uname);
	
	if(k>0) {
		res.setContentType("application/json");
		res.getWriter().println("{\"status\":\"success\"}");
	}
	}
	
	private String readHistoryDetailsFromRequest(HttpServletRequest req) throws IOException{
		try(BufferedReader reader= new BufferedReader(new InputStreamReader(req.getInputStream()))) {
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		}
	}
	private String parseExpressionFromJson (String hisDetailsJson) {
		
		return hisDetailsJson.split("\"expression\":")[1].split(",")[0].replace("\"", "").trim();
	}
	
	private String parseResultFromJson(String hisDetailsJson) {
		
		return hisDetailsJson.split("\"result\":")[1].replace("\"", "").trim();
	}
}
