<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> login page</title>
</head>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f2f2f2; /* Background color behind the transparent popup */
}

.popup {
    display: none;
    position: fixed;
    top: 10px;
    right: 10px;
background : transparent;
    border: 1px solid #ddd;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    z-index: 9999; /* Set a high z-index to make sure it's on top */
}
.popup-content {
    text-align: center;
}

.close {
    position: absolute;
    top: 3px;
    right: 5px;
    cursor: pointer;
}
#popupMessage{
 color:red;
}
</style>
<body>
<%
String msg = (String)request.getAttribute("msg");
%>

<div id="popup" class="popup">
        <div class="popup-content">
            <span class="close" onclick="closePopup()">&times;</span>
            <p id="popupMessage"></p>
        </div>
    </div>

<script>
document.addEventListener("DOMContentLoaded", function() {
    // Simulate a successful registration and display the popup automatically
    setTimeout(() => {
        var popupMessage = document.getElementById("popupMessage");
        popupMessage.innerHTML = "Username & Password incorrect !";
        showPopup();
    }, 1000); // Simulating a delay for demonstration purposes
});

function showPopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "block";
}

function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}
</script>
<%@include file="login.html" %>
</body>
</html>