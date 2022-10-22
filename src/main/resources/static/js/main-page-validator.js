function showTestMessage(){
    window.alert("Test Message click!");

}


function validateFormState(){

    /* Following will be validated:
        - "Anzahl" Field ha a valid number
        - "Von" field has a valid number
        - "Bis" field has a valid number
        - "Aufgabenart" needs to be checked one checkbox at least
        */

    // Get if "Anzahl" is valid

    // Get if "Von" is valid

    // Get if "Bis" is valid

    // Get empty checkboxe
    var checkBoxes = document.querySelectorAll('input[type=checkbox]'); 
    var uncheckedBoxes = [].filter.call( checkBoxes, function( el ) {
    return !el.checked
    });


    // Check if all constraints are fullfilled
    const submitButton = document.querySelector('button[type=submit]');
    submitButton.disabled = false;
    if (checkBoxes.length == uncheckedBoxes.length) {
        submitButton.disabled = true;
    }
    

}
