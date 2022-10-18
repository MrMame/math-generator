package de.mame.mathegenerator.controllers;

import de.mame.mathegenerator.logics.services.MathGeneratorsService;
import de.mame.mathegenerator.model.formDatas.MainPageFormData;
import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/")
public class MainPageController {

    private MathGeneratorsService _mathGeneratorsService;


    @Autowired
    public MainPageController(MathGeneratorsService mathGeneratorsService) {
        this._mathGeneratorsService = mathGeneratorsService;
    }

    @GetMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("theDate", new Date());
        model.addAttribute("theFormData", new MainPageFormData());
        return "main-page";
    }

    @PostMapping("/")
    public String showMainPage(@ModelAttribute MainPageFormData theFormData, Model model){
        model.addAttribute("theFormData",theFormData);
        System.out.println("Received number of exercises :" + theFormData.getNumberOfExercises());

        /* Formulas return list for the response*/
        ArrayList<Formula> formulas = new ArrayList<>();

        /* If Addition is checked, create Formulas to return list */
        if(theFormData.getWithOperationsAdd()){
            formulas.addAll(this._mathGeneratorsService.CreateAdditionFormulas(
                    theFormData.getExercisesNumberRangeStart(),
                    theFormData.getExercisesNumberRangeEnd(),
                    theFormData.getNumberOfExercises()));
        }

        /* If Subtraction is checked, create Formulas to return list */
        if(theFormData.getWithOperationsSub()){
            formulas.addAll(this._mathGeneratorsService.CreateSubtractionFormulas(
                    theFormData.getExercisesNumberRangeStart(),
                    theFormData.getExercisesNumberRangeEnd(),
                    theFormData.getNumberOfExercises()));
        }

        /* If Multiplication is checked, create Formulas to return list */
        if(theFormData.getWithOperationsMul()){
            formulas.addAll(this._mathGeneratorsService.CreateMultiplicationFormulas(
                    theFormData.getExercisesNumberRangeStart(),
                    theFormData.getExercisesNumberRangeEnd(),
                    theFormData.getNumberOfExercises()));
        }

        /* If division is checked, create Formulas to return list */
        if(theFormData.getWithOperationsDiv()){
            formulas.addAll(this._mathGeneratorsService.CreateDivisionFormulas(
                    theFormData.getExercisesNumberRangeStart(),
                    theFormData.getExercisesNumberRangeEnd(),
                    theFormData.getNumberOfExercises()));
        }

        /* Return the Formulas to the model*/
        model.addAttribute("theFormulas", formulas);

        /* Show results page */
        return "result-page";
    }


}
