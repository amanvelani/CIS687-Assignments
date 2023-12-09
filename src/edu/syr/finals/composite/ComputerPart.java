package edu.syr.finals.composite;

import java.util.ArrayList;
import java.util.List;

public class ComputerPart {

}

interface Component{
    void showPrice();
}


class Leaf implements Component{
    private int price;
    private String name;

    public Leaf setPrice(int price) {
        this.price = price;
        return this;
    }
    public Leaf setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public void showPrice() {
        System.out.println("Leaf Name"+ ":" + name + " : " + price);
    }
}

class Composite implements Component{
    private String name;
    public Composite(String name){
        this.name = name;
    }
    List<Component> components = new ArrayList<>();
    public void addComponent(Component c){
        components.add(c);
    }
    public void removeComponent(Component c){
        components.remove(c);
    }
    @Override
    public void showPrice() {
        System.out.println("Component Name" + " : " + name);
        for(Component c : components){
            c.showPrice();
        }
    }
}
