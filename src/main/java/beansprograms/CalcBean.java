package beansprograms;
import java.io.*;
@SuppressWarnings("serial")
public class CalcBean implements Serializable{

	public CalcBean() {}
	
	private int slno;
	private String expression,result,uname;

	// getter & setter
	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
	
}
