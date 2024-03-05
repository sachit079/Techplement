
let currentExpression = '';
const display = document.getElementById('display');
const historyList = document.getElementById('historyList');
const historySection = document.getElementById('history');

function appendToDisplay(value) {
    currentExpression += value;
    display.value = currentExpression;
}

function clearDisplay() {
    currentExpression = '';
    display.value = '';
}

function calculateResult() {
    try {
        const result = eval(currentExpression);
        display.value = result;

        currentExpression = '';
    } catch (error) {
        display.value = 'Error';
        currentExpression = '';
    }
}



function deleteOneDigit(){
              let temp = display.value.toString();
       display.value = temp.slice(0, currentExpression.length - 1);
       currentExpression=display.value;
}

function showPopup() {
    makeBodyTransparent();
    var popup = document.getElementById("popup");
    var overlay = document.getElementById("overlay");

    popup.style.display = "block";
    overlay.style.display = "block";
}

function closePopup() {
    resetBody();
    var popup = document.getElementById("popup");
    var overlay = document.getElementById("overlay");

    popup.style.display = "none";
    overlay.style.display = "none";
}
function makeBodyTransparent() {
    document.body.classList.add("transparent-body");
}
function resetBody() {
    document.body.classList.remove("transparent-body");
}

function toggleDropdown() {
    var dropdownContent = document.getElementById("dropdown-content");
    var currentDisplay = window.getComputedStyle(dropdownContent).getPropertyValue('display');
    
    if (currentDisplay === 'none') {
        dropdownContent.style.display = 'block';
    } else {
        dropdownContent.style.display = 'none';
    }
}

function exitApplication() {
  window.close();
}

function openDropdown() {
    var dropdownContent = document.getElementById("dropdown-content");
    dropdownContent.style.display = 'block';
}

function closeDropdown() {
    dropdownTimeout = setTimeout(function() {
        var dropdownContent = document.getElementById("dropdown-content");
        dropdownContent.style.display = 'none';
    }, 2000); // Adjust the delay as needed
    
}
