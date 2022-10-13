package de.mame.mathegenerator.mainPage;

import de.mame.mathegenerator.model.datas.MainFormData;
import de.mame.mathegenerator.model.mathGenerators.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("theDate", new Date());
        model.addAttribute("theFormData", new MainFormData());
        return "main-page";
    }

    @PostMapping("/")
    public String showMainPage(@ModelAttribute MainFormData theFormData, Model model){
        model.addAttribute("theFormData",theFormData);
        System.out.println("Received number of exercises :" + theFormData.getNumberOfExercises());

        /* Add a generator for each checked type of math operations */
        GroupOfMathGenerators theMultiGenerator = new GroupOfMathGenerators();
        if(theFormData.getWithOperationsAdd()){theMultiGenerator.AddMathGenerator(new AdditionMathGenerator());}
        if(theFormData.getWithOperationsDiv()){theMultiGenerator.AddMathGenerator(new DivisionMathGenerator());}
        if(theFormData.getWithOperationsMul()){theMultiGenerator.AddMathGenerator(new MultiplicationMathGenerator());}
        if(theFormData.getWithOperationsSub()){theMultiGenerator.AddMathGenerator(new SubtractionMathGenerator());}

        theMultiGenerator.setNumberRangeStart(0);
        theMultiGenerator.setNumberRangeEnd(theFormData.getExercisesNumberRange());
        theMultiGenerator.setNumberOfExercises(theFormData.getNumberOfExercises());

        model.addAttribute("theFormulas", theMultiGenerator.createExercises());
        model.addAttribute("theGenerator",theMultiGenerator);

        return "result-page";
    }


}
