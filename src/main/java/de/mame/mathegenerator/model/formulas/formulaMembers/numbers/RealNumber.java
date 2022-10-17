package de.mame.mathegenerator.model.formulas.formulaMembers.numbers;

public class RealNumber implements Number {


    private static final String FORMAT_STRING = "%3s";  // Decimal numbers will be 3 characters
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
            return String.format(FORMAT_STRING, String.valueOf(this._doubleValue.intValue()));
        }else{
            return String.format(FORMAT_STRING, String.valueOf(this._doubleValue));
        }

    }
}
