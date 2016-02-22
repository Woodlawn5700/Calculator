package ru.Pasha;

/**
 * Created by pavelpetrov on 21.02.16.
 */
public class Dividing extends Operatino {
    public Dividing (double a, double b){
        super(a, b);
    }
    @Override
    public double run(){
        return a/b;
    }
}
