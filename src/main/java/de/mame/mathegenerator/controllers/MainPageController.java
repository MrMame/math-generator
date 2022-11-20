package de.mame.mathegenerator.controllers;

import de.mame.mathegenerator.logics.services.FormulasGeneratorService;
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

    private FormulasGeneratorService _formulasGeneratorService;


    @Autowired
    public MainPageController(FormulasGeneratorService formulasGeneratorService) {
        this._formulasGeneratorService = formulasGeneratorService;
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
        if(theBindingResult.hasErrors()){return "main-page";}
        // OutComment : This line of code is unnecessary ? delete if possible
        //model.addAttribute("theFormData",theFormData);
        /*  Let the Service create some Formulas for the user.
            Put them into the model.
            In case of an Error, the returned formulas list is empty */
        ArrayList<Formula> formulas = createFormulasWithService(theFormData);
        model.addAttribute("theFormulas", formulas);
        /* In case of an error, we return to the main page */
        if(formulas.size() > 0){
            return "result-page";
        }else{
            return "main-page";
        }
    }


    /**
     *
     * @param theFormData Formulardata from HTTP Request, containing the definitions for generating the formulas
     * @return Generated formulas to show to the user
     */
    private ArrayList<Formula> createFormulasWithService(MainPageFormData theFormData) {
        ArrayList<Formula> formulas = new ArrayList<>();
        try {
            formulas = this._formulasGeneratorService.GenerateFormulas(theFormData.getExercisesNumberRangeStart(),
                    theFormData.getExercisesNumberRangeEnd(),
                    theFormData.getNumberOfExercises(),
                    theFormData.getWithOperationsAdd(),
                    theFormData.getWithOperationsSub(),
                    theFormData.getWithOperationsMul(),
                    theFormData.getWithOperationsDiv());
        }catch(Exception e){
            System.out.println("Error while creating formulas. "
                    + e.toString());
            formulas.clear();       // In case of an error, all formulas are invalid and will be deleted
        }
        return formulas;
    }


}
