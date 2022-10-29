'use strict'
import {validateForm} from "./main-page-validator.js";


function addEventHandlers(){
    var theForm = document.querySelector('form');
    theForm.addEventListener('change',validateForm);
}




/* MAIN ###################################################################### */
    addEventHandlers();
    validateForm();
