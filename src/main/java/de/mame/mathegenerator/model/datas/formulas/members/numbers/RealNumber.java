package de.mame.mathegenerator.model.datas.formulas.members.numbers;

public class RealNumber implements Number{

    Double _doubleValue;
    boolean _isInteger=false;


    public RealNumber(Double value) {
        this._doubleValue = value;
    }
    public RealNumber(Integer value) {
        this._doubleValue = value.doubleValue();
        this._isInteger = true;
    }


    @Override
    public Double GetValue() {
        return this._doubleValue;
    }
    @Override
    public void SetValue(Double value) {
        this._doubleValue = value;
    }

    @Override
    public String GetCharacter() {
        if(this._isInteger){
            return String.valueOf(this._doubleValue.intValue());
        }else{
            return String.valueOf(this._doubleValue);
        }

    }
}
