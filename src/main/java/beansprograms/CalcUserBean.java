package beansprograms;
import java.io.*;
@SuppressWarnings("serial")
public class CalcUserBean implements Serializable{
	public CalcUserBean() {}
	
	private String uName,fName,lName,eId,pWord;

	
	//getter & setter

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	
	
	

}
