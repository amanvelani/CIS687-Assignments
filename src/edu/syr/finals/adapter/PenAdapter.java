package edu.syr.finals.adapter;

public class PenAdapter implements Pen {
    RandomPen pp = new RandomPen();
    @Override
    public void write(String str){
        pp.mark(str);
    }
}
