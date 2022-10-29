package de.mame.mathegenerator.controllers;

import de.mame.mathegenerator.logics.services.MathGeneratorsService;
import de.mame.mathegenerator.model.formDatas.MainPageFormData;
import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String showMainPage(@Valid @ModelAttribute("theFormData") MainPageFormData theFormData,
                               BindingResult theBindingResult,Model model){
        /* Returns to Main Form if Inputvalidation has found some issues */
        if(theBindingResult.hasErrors()){
            return "main-page";
        }

        model.addAttribute("theFormData",theFormData);
        System.out.println("Received number of exercises :" + theFormData.getNumberOfExercises());

        /* Formulas return list for the response*/
        ArrayList<Formula> formulas = new ArrayList<>();

        formulas = this._mathGeneratorsService.CreateMixedFormulas(theFormData.getExercisesNumberRangeStart(),
                                                                    theFormData.getExercisesNumberRangeEnd(),
                                                                    theFormData.getNumberOfExercises(),
                                                                    theFormData.getWithOperationsAdd(),
                                                                    theFormData.getWithOperationsSub(),
                                                                    theFormData.getWithOperationsMul(),
                                                                    theFormData.getWithOperationsDiv());

        /* Return the Formulas to the model*/
        model.addAttribute("theFormulas", formulas);

        /* Show results page */
        return "result-page";
    }


}
