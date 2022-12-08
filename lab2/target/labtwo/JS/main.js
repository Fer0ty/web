let XInput = document.getElementById('XInput');
let YInput = document.getElementById('YInput');
let RInput = document.getElementById('RInput');
XInput.oninput = xValidateForm;
YInput.oninput = yValidateForm;
RInput.oninput = rValidateForm;

let textInput = validateForm();

function validateForm(){
    let btn = document.getElementById('submitBtn');
    if(xValidateForm() && yValidateForm() && rValidateForm()){
        btn.removeAttribute('disabled');
    } else {
        btn.setAttribute('disabled', 'true');
    }
}

function xValidateForm() {
    let XInput = document.getElementById('XInput'),
        inputVal = XInput.value;
    inputVal = inputVal.replace(',', '.');
    if (inputVal.match(/^-?\d(\.\d{1,8})?$/g) && -5 <= inputVal && inputVal <= 3) {
        XInput.classList.remove("wrong")
        XInput.classList.add("correct")
        return true;
    } else {
        XInput.classList.remove("correct")
        XInput.classList.add("wrong")
        return false;
    }
}
function yValidateForm() {
    let YInput = document.getElementById('YInput'),
        inputVal = YInput.value;
    inputVal = inputVal.replace(',', '.');
    if (inputVal.match(/^-?\d(\.\d{1,8})?$/g) && -3 <= inputVal && inputVal <= 3) {
        YInput.classList.remove("wrong")
        YInput.classList.add("correct")
        return true;
    } else {
        YInput.classList.remove("correct")
        YInput.classList.add("wrong")
        return false;
    }
}
function rValidateForm() {
    let RInput = document.getElementById('RInput'),
        inputVal = RInput.value;
    inputVal = inputVal.replace(',', '.');
    if (inputVal.match(/^-?\d(\.\d{1,8})?$/g) && 2 <= inputVal && inputVal <= 5) {
        RInput.classList.remove("wrong")
        RInput.classList.add("correct")
        return true;
    } else {
        RInput.classList.remove("correct")
        RInput.classList.add("wrong")
        return false;
    }
}