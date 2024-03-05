<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beansprograms.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calculator-TechCalc</title>
    <link rel="stylesheet" href="calcstyle.css">
       <link rel="icon" href="images/icon.png">
    


</head>

<body>
<%
CalcUserBean cub = (CalcUserBean)session.getAttribute("cubean");

%>
<header>
        <nav>
            <div class="logo">TechCalc.</div>
            <div class="user-login" > 
                <div class="side">Welcome <%=cub.getfName() %></div>
                <img src="images/pic.jpg" alt="User Icon" id="user-icon" onmouseover="openDropdown()" onmouseout="closeDropdown()">
                <div class="dropdown-content" id="dropdown-content">
                    <a href="profile"> profile </a>
                    <a href="#">setting </a>
                    <a href="viewHistory"> history details </a>
                    <a href="logout">Logout</a>
                </div>
        
            </div>
        </nav>
    </header>

    <div class="container">
        <input type="text" name="dis" placeholder="0" id="display"><br>
        <button onclick="appendToDisplay('7')">7</button>
        <button onclick="appendToDisplay('8')">8</button>
        <button onclick="appendToDisplay('9')">9</button>
        <button onclick="deleteOneDigit()">DEL</button>
        <button onclick="clearDisplay()">C</button><br>
        <button onclick="appendToDisplay('4')">4</button>
        <button onclick="appendToDisplay('5')">5</button>
        <button onclick="appendToDisplay('6')">6</button>
        <button onclick="appendToDisplay('*')">*</button>
        <button onclick="appendToDisplay('/')">/</button><br>
        <button onclick="appendToDisplay('1')">1</button>
        <button onclick="appendToDisplay('2')">2</button>
        <button onclick="appendToDisplay('3')">3</button>
        <button onclick="appendToDisplay('-')">-</button><br>
        <button id="historyToggle" onclick="toggleHistory()">&#x1F552;</button>
        <button onclick="appendToDisplay('0')">0</button>
        <button onclick="appendToDisplay('.')">.</button>
        <button onclick="appendToDisplay('+')">+</button>
        <button id="equal" onclick="calculateResult()">=</button><br><br>
       <div id="history">
            
            <ul id="historyList"><h2>History</h2></ul>
        </div>
    </div>

    <script src="CalcScript.js"></script>



</body>
</html>