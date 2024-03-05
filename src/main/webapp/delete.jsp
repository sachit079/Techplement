<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.popup2 {
            display: none;
            position: fixed;
            top: 11%;
            right: 2%;
            background-color: #f2f2f2;
            color: black;
            padding: 15px;
            border-radius: 5px;
            z-index: 1;
  }
</style>
</head>
<body>
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
            popupMessage.innerHTML = "Successfully deleted!!!";
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
<jsp:forward page="ViewAllHistory.jsp"></jsp:forward>
</body>
</html>