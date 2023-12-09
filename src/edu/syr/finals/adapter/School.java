package edu.syr.finals.adapter;
// Adapter pattern - Structural Design Pattern
// Adapter pattern works as a bridge between two incompatible interfaces.
// This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
// This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.
// A real life example could be a case of card reader which acts as an adapter between memory card and a laptop.
public class School {
    public static void main(String[] args){
        Pen p = new PenAdapter();
        Assignment a = new Assignment();
        a.setPen(p);
        a.writeAssignment("This is an assignment");
    }
}

