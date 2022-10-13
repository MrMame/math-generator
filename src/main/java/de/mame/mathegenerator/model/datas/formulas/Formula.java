package de.mame.mathegenerator.model.datas.formulas;

import de.mame.mathegenerator.model.datas.formulas.members.FormulaMember;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Formula {
    String _value;
    ArrayList<FormulaMember> _formulaMembers = new ArrayList<FormulaMember>();

    public String get_value() {
        return _value;
    }
    public void set_value(String _value) {
        this._value = _value;
    }

    public Formula() {
    }
    public Formula(String value) {
        this._value = value;
    }

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
