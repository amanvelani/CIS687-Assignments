package edu.syr.finals.adapter;

public class Assignment {
    private Pen p;
    public void setPen(Pen p){
        this.p = p;
    }
    public Pen getPen(){
        return p;
    }
    public void writeAssignment(String str){
        p.write(str);
    }
}
