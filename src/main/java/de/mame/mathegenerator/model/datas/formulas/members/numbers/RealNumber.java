package de.mame.mathegenerator.model.datas.formulas.members.numbers;

public class RealNumber implements Number{

    double _value;

    public RealNumber(double value) {
        this._value = value;
    }

    @Override
    public double GetValue() {
        return this._value;
    }
    @Override
    public void SetValue(double value) {
        this._value = value;
    }

    @Override
    public String GetCharacter() {
        return String.valueOf(this._value);
    }
}
