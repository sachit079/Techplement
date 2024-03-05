function openDropdown() {
    var dropdownContent = document.getElementById("dropdown-content");
    dropdownContent.style.display = 'block';
}

function closeDropdown() {
    dropdownTimeout = setTimeout(function() {
        var dropdownContent = document.getElementById("dropdown-content");
        dropdownContent.style.display = 'none';
    }, 6000); // Adjust the delay as needed
}

//popups function

document.addEventListener("DOMContentLoaded", function() {
    // Simulate a successful registration and display the popup automatically
    setTimeout(() => {
        var popupMessage = document.getElementById("popupMessage");
        popupMessage.innerHTML = "no product found";
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

// delete popups

  function deleteRow(button) {
	     triggerAnchor();
            // Assuming the row to be deleted is the parent of the button
           var row = button.parentNode.parentNode;
            row.parentNode.removeChild(row);
            
            // Show the popup
            document.getElementById("popup2").style.display = "block";

            // Hide the popup after 2 seconds (2000 milliseconds)
            setTimeout(function() {
                document.getElementById("popup2").style.display = "none";
            }, 2000);
            
        }
        
        //Anchor tag
         function triggerAnchor() {
            // Get the anchor tag by its ID
            var anchorTag = document.getElementById("anchor");

            // Trigger the click event of the anchor tag
            anchorTag.click();
        }
        
        // popup for logout
        
        function logout(button) {

            // Show the popup
            document.getElementById("popup3").style.display = "block";

            // Hide the popup after 2 seconds (2000 milliseconds)
            setTimeout(function() {
                document.getElementById("popup3").style.display = "none";
            }, 3000);
        }