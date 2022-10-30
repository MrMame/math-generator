'use strict'


/* EXPORTS ----------------------------------------------------- */

export function validateForm(e){


    // Remove all floating point numbers
    removeFloatingPointFromValue('#numberOfExercises');
    removeFloatingPointFromValue('#exercisesNumberRangeStart');
    removeFloatingPointFromValue('#exercisesNumberRangeEnd');

    // check validities
    const isExNumInvalid = getExerciseNumberInvalid();
    const isCalRngStartInvalid = getCalulcationRangeStartInvalid();
    const isCalRngEndInvalid = getCalulcationRangeEndInvalid();
    const areRangeInputsValid = !(isCalRngStartInvalid || isCalRngEndInvalid)
    const isNoOperatorSelected = getNoOperatorSelected();
    const isSubmitDisabled = (isExNumInvalid || isCalRngStartInvalid || isCalRngEndInvalid || isNoOperatorSelected);

    // fix wrong caluclation range (min > max) if inputs are already in inputs valid number range
    if(areRangeInputsValid){
        fixCalculationRange(e);
    }

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

function fixCalculationRange(e){
    let rangeStartInput = document.querySelector('#exercisesNumberRangeStart');
    let rangeEndInput = document.querySelector('#exercisesNumberRangeEnd');

    /* Error1: End is smaller than start */
    let isEndLowerEqualStart = parseInt(rangeEndInput.value) <= parseInt(rangeStartInput.value);
    if(isEndLowerEqualStart){

        let eventTargetId = event.target.getAttribute("id");

        // If User is currently changing Endnumber, than we have to change the Start number for him.
        if( eventTargetId === 'exercisesNumberRangeEnd'){
            fixStartRange();
        }
        // If User is currently changing startnumber, than we have to change the endnumber for him.
        if(eventTargetId === 'exercisesNumberRangeStart'){
            fixEndRange();
        }
        // By default, we are changing the end number
        let isEventNotSendFromRangeInputs = !(eventTargetId === 'exercisesNumberRangeEnd' || eventTargetId === 'exercisesNumberRangeStart');
        if(isEventNotSendFromRangeInputs){
            fixEndRange();
        }

    }
}

function fixStartRange(){
    let rangeStartInput = document.querySelector('#exercisesNumberRangeStart');
    let rangeEndInput = document.querySelector('#exercisesNumberRangeEnd');

    let endRangeMinValue = parseInt(rangeEndInput.getAttribute("min"));
    let isEndRangeMinValue =(parseInt(rangeEndInput.value) === parseInt(endRangeMinValue));

    if(isEndRangeMinValue){
        rangeStartInput.value = endRangeMinValue
        rangeEndInput.value = endRangeMinValue + 1;
    }else{
        rangeStartInput.value = parseInt(rangeEndInput.value) - 1;
    }
}


function fixEndRange(){
    let rangeStartInput = document.querySelector('#exercisesNumberRangeStart');
    let rangeEndInput = document.querySelector('#exercisesNumberRangeEnd');

    let startRangeMaxValue = parseInt(rangeStartInput.getAttribute("max"));
    let isStartValAtMax = (parseInt(rangeStartInput.value) === parseInt(startRangeMaxValue));

    if(isStartValAtMax){
        rangeStartInput.value = startRangeMaxValue - 1;
        rangeEndInput.value = startRangeMaxValue;
    }else{
        rangeEndInput.value = parseInt(rangeStartInput.value) + 1;
    }
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

