<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beansprograms.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HistoryDetails-techcalc</title>
<link rel="icon" href="images/icon.png">
    <link rel="stylesheet" href="historyDetailsStyle.css">

</head>
<body>
<%
CalcUserBean cub =(CalcUserBean)session.getAttribute("cubean");
//ArrayList<CalcBean> al = new ArrayList<CalcBean>();
ArrayList<CalcBean> al =(ArrayList<CalcBean>)session.getAttribute("calcHisList");
%>
<header>
        <nav>
            <div class="logo">TechCalc.</div>
            <div class="user-login" > 
                <div class="side">Welcome <%=cub.getfName() %></div>
                <img src="images/pic.jpg" alt="User Icon" id="user-icon" onmouseover="openDropdown()" onmouseout="closeDropdown()">
                <div class="dropdown-content" id="dropdown-content">
                <a href="calculator.jsp"> Home </a>
                    <a href="profile"> profile </a>
                    <a href="#">setting </a>
                    <a href="logout" onclick="logout(this)">Logout</a>
                </div>
           </div>
        </nav>
    </header>
    <%if(al.size()==0) {%>
    
     <div id="popup" class="popup">
        <div class="popup-content">
            <span class="close" onclick="closePopup()">&times;</span>
            <p id="popupMessage"></p>
        </div>
    </div>
    
 <%}
    else {
    	%>
    	<h1>History Details</h1>
    	<table>
    	<tr>
    	<th class="tabhead">Expression</th>
        <th class="tabhead">Result</th>
        </tr>
    	<%
    	  Iterator <CalcBean> it = al.iterator();
    	while(it.hasNext()){
    		CalcBean cb =(CalcBean) it.next();%>
    		<tr>
    		<td><%=cb.getExpression() %></td>
    		<td><%=cb.getResult()%></td>
    		<td> 
    		<button class="btn" onclick="deleteRow(this)">delete</button>
    		<a href="delete?slno=<%= cb.getSlno() %>"  style="display:none;" id="anchor">delete</a> 
    		</td> <br>
    		</tr>
    	<% }// end of while %>
    	</table>
    	<div class="popup2" id="popup2"> Row Deleted !!!!</div>
    	 <div class="popup2" id="popup3">logout Successfully !!!!</div>
    	
    	<%}// end of else %>
     <script src="historyDetailsScript.js"></script>
    
</body>
</html>