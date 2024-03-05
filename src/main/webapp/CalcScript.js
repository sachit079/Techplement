
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
        //history display in web browser
        addToHistory(currentExpression + ' = ' + result);

        // send history details to servlet
        sendHistoryToServer(currentExpression,result);

        currentExpression = '';
    } catch (error) {
        display.value = 'Error';
        currentExpression = '';
    }
}

function addToHistory(expression) {
    const listItem = document.createElement('li');
    listItem.textContent = expression;
    historyList.appendChild(listItem);
}

function toggleHistory() {
    if (historySection.style.display === 'none') {
        historySection.style.display = 'block';
    } else {
        historySection.style.display = 'none';
    }
}

function deleteOneDigit(){
              let temp = display.value.toString();
       display.value = temp.slice(0, currentExpression.length - 1);
       currentExpression=display.value;
}
// dropdown 

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
function sendHistoryToServer(expression,result) {

    fetch('HistoryServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ expression: expression, result: result }),
    })
    .then(response => response.json())
    .then(data => console.log('History sent to server: ',data))
    .catch(error=> console.error('Error sending history to server: ',error));
}


