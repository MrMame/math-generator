package de.mame.mathegenerator.model.datas.formulas;

import de.mame.mathegenerator.model.datas.formulas.members.FormulaMember;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Formula {
    String _value;
    ArrayList<FormulaMember> _formulaMembers = new ArrayList<>();

    public void AddFormulaMember(FormulaMember theFormulaMember){
        this._formulaMembers.add(theFormulaMember);
    }
    public List<FormulaMember> GetFormulaMembers(){
        return Collections.unmodifiableList(this._formulaMembers);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for(FormulaMember theMember: this._formulaMembers){
            returnString.append(theMember.GetCharacter());
        }

        return returnString.toString();
    }
}
