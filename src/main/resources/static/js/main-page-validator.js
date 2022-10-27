'use strict'


/* EXPORTS ----------------------------------------------------- */

export function validateForm(){


    // Remove all floating point numbers
    removeFloatingPointFromValue('#numberOfExercises');
    removeFloatingPointFromValue('#exercisesNumberRangeStart');
    removeFloatingPointFromValue('#exercisesNumberRangeEnd');


    // check validities
    const isExNumInvalid = getExerciseNumberInvalid();
    const isCalRngStartInvalid = getCalulcationRangeStartInvalid();
    const isCalRngEndInvalid = getCalulcationRangeEndInvalid();
    const isNoOperatorSelected = getNoOperatorSelected();
    const isSubmitDisabled = (isExNumInvalid || isCalRngStartInvalid || isCalRngEndInvalid || isNoOperatorSelected);

    // Show invalid messages
    (isExNumInvalid)? showExerciseNumberInvalidBox() : hideExerciseNumberInvalidBox();
    (isCalRngStartInvalid)? showCalulcationRangeStartValidationError(): hideCalulcationRangeStartValidationError();
    (isCalRngEndInvalid)? showCalulcationRangeEndValidationError(): hideCalulcationRangeEndValidationError();
    (isNoOperatorSelected)? showOperatorsValidationError(): hideOperatorValidationError();

    // Enable/Disable submit button
    (isSubmitDisabled)? DisableSubmitButton(): EnableSubmitButton();
}



/* PRIVATES ----------------------------------------------------- */

function removeFloatingPointFromValue(sel){
    let el = document.querySelector(sel);
    let values =  el.value.split(".");
    el.value = values[0];
}

function showExerciseNumberInvalidBox(){
     showElement('ValidationErrorAnzahlInput');
}

function hideExerciseNumberInvalidBox(){
     hideElement('ValidationErrorAnzahlInput');
}

function showCalulcationRangeStartValidationError(){
    showElement('ValErrExNumRngStrtInp');
}
function hideCalulcationRangeStartValidationError(){
    hideElement('ValErrExNumRngStrtInp');
}

function showCalulcationRangeEndValidationError(){
    showElement('ValErrExNumRngEndInp');
}
function hideCalulcationRangeEndValidationError(){
    hideElement('ValErrExNumRngEndInp');
}

function showOperatorsValidationError(){
    showElement('ValidationErrorOperators');
}
function hideOperatorValidationError(){
    hideElement('ValidationErrorOperators');
}

function getExerciseNumberInvalid(){
    let exNumInput = document.querySelector('#numberOfExercises');
    return !exNumInput.validity.valid;
}
function getCalulcationRangeStartInvalid(){
     let rangeStartInput = document.querySelector('#exercisesNumberRangeStart');
    return !rangeStartInput.validity.valid;
}
function getCalulcationRangeEndInvalid(){
     let rangeStartInput = document.querySelector('#exercisesNumberRangeEnd');
    return !rangeStartInput.validity.valid;
}
function getNoOperatorSelected(){
    var checkBoxes = document.querySelectorAll('input[type=checkbox]');
    var uncheckedBoxes = [].filter.call( checkBoxes, function( el ) {
        if(el.checked==false){return el;}
    });
    return (checkBoxes.length === uncheckedBoxes.length);
}

function DisableSubmitButton(){
    const submitButton = document.querySelector('button[id=submitButton]');
    submitButton.disabled = true;
}
function EnableSubmitButton(){
    const submitButton = document.querySelector('button[id=submitButton]');
    submitButton.disabled = false;
}

function hideElement(elementId){
    const element = document.querySelector('#' + elementId);
    element.classList.add("hidden");
}
function showElement(elementId){
    const element = document.querySelector('#' + elementId);
    element.classList.remove("hidden");
}

