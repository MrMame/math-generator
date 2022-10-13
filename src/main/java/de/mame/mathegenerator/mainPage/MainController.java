package de.mame.mathegenerator.mainPage;

import de.mame.mathegenerator.model.datas.MainFormData;
import de.mame.mathegenerator.model.mathGenerators.AdditionMathGenerator;
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

        AdditionMathGenerator theGenerator = new AdditionMathGenerator();
        theGenerator.setNumberRangeStart(0);
        theGenerator.setNumberRangeEnd(100);
        theGenerator.setNumberOfExercises(theFormData.getNumberOfExercises());

        model.addAttribute("theFormulas", theGenerator.createExercises());
        model.addAttribute("theGenerator",theGenerator);

        return "result-page";
    }


}
