package de.mame.mathegenerator.logics.numberPools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class RandomNumberPool
    implements NumberPool {

    Random _theRand = new Random();
    ArrayList<Integer> _randomNumberPool = new ArrayList<Integer>();
    int _startNumber;
    int _endNumber;

    public int getStartNumber() {
        return _startNumber;
    }

    public void setStartNumber(int startNumber) {
        this._startNumber = startNumber;
    }

    public int getEndNumber() {
        return _endNumber;
    }

    public void setEndNumber(int endNumber) {
        this._endNumber = endNumber;
    }

    @Override
    public void initPool(int startNumber, int endNumber) {
        this._startNumber = startNumber;
        this._endNumber = endNumber;
        this.initRandomNumberPool();
    }

    @Override
    public Integer getNumberFromPool() {
        return this.getRandomNumberFromPool();
    }




    /* The random number pool is a list of numbers from start to end.
     * */
    private void initRandomNumberPool(){
        this._randomNumberPool = new ArrayList<Integer>();
        for(Integer i = this._startNumber; i<this._endNumber; i++){
            this._randomNumberPool.add(i);}
    }


    private Integer getRandomNumberFromPool(){
        if(this._randomNumberPool == null)throw new IllegalArgumentException("RandomNumberPool is null !");
        /* ReInit if already empty */
        if(this._randomNumberPool.isEmpty()){
            this.initRandomNumberPool();
        }
        /* Return a random number from the List. This number can be returned
         * next time only after all other numbers were taken from the list. */
        int numberIdx = _theRand.nextInt(this._randomNumberPool.size());
        Integer returnNumber = this._randomNumberPool.get(numberIdx);
        System.out.println("Index " + numberIdx + " zahl " + returnNumber);
        this._randomNumberPool.remove(numberIdx);
        return returnNumber;
    }
}
