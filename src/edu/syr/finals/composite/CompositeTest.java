package edu.syr.finals.composite;
// Composite pattern - Structural pattern
// A composite object is a tree structure of object and has a List of its child objects.
// A composite can also have a composite object as its child.
// If you perform some operation on the lead node, it needs to be performed on the composite object as well.
/*
          Computer * Here C is a composite object
       /        \
    Cabinet   Peri [Composite Object]
    / \         /   \
HD    CPU    Mouse  Keyboard [Leaf Object]
*/
public class CompositeTest {
    public static void main(String[] args){
        Leaf l1 = new Leaf();
        l1.setPrice(4000).setName("Hard Disk");
        Component hd = l1;
        Leaf l2 = new Leaf();
        l2.setPrice(8000).setName("CPU");
        Component cpu = l2;
        Leaf l3 = new Leaf();
        l3.setPrice(300).setName("Mouse");
        Component mouse = l3;
        Leaf l4 = new Leaf();
        l4.setPrice(700).setName("Keyboard");
        Component keyboard = l4;

        Composite ph = new Composite("Peripheral");
        ph.addComponent(mouse);
        ph.addComponent(keyboard);
        Composite cabinet = new Composite("Cabinet");
        cabinet.addComponent(hd);
        cabinet.addComponent(cpu);

        Composite computer = new Composite("Computer");
        computer.addComponent(ph);
        computer.addComponent(cabinet);

        computer.showPrice();
    }
}
