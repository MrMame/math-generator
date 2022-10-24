'use strict'
import {validateForm} from "./main-page-validator.js";


function addEventHandlers(){
    /* Form Validating */
    var sections = document.querySelectorAll('input[type=number]');
    for(var i = 0;i < sections.length; i++){
        sections[i].addEventListener('change',validateForm);
    }

    /* Checkboxes */
    var sections = document.querySelectorAll('input[type=checkbox]');
        for(var i = 0;i < sections.length; i++){
            sections[i].addEventListener('change',validateForm);
        }

    /* Test Button */
    const submitButton = document.querySelector('button[id=validateButton]');
    submitButton.addEventListener('click',validateForm );

}




/* MAIN ###################################################################### */
    addEventHandlers();
    validateForm();
