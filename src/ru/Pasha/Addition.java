package ru.Pasha;

/**
 * Created by pavelpetrov on 21.02.16.
 */
public class Addition extends Operatino {
    public Addition (double a, double b){
         super(a, b);
    }
    @Override
    public double run(){
        return a+b;
    }
}
