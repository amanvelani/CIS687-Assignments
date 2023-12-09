package edu.syr.finals.builder;
// Builder pattern - Creational Design Pattern
// Builder pattern is used when we have a lot of parameters to pass to the constructor
// Builder pattern is used to build immutable objects
// Builder pattern is used to build objects which are complex in nature
public class Shop {
   public static void main(String[] args){
       // Problem is that we have to pass all the parameters to the constructor and have to pass the parameters in the same order
       Phone p = new Phone("Android", "Snapdragon", 4000, 4);
       System.out.println(p);
       // There are some cases when the consumer is not concerned about all the parameters
       // In such cases we can use the builder pattern
       PhoneBuilder pb = new PhoneBuilder();
       pb.setOs("iOS").setProcessor("Arm");
       Phone p1 = pb.getPhone();
       System.out.println(p1);
   }
}

class PhoneBuilder{
    private String os;
    private String processor;
    private int battery;
    private int ram;

    public PhoneBuilder setOs(String os){
        this.os = os;
        return this;
    }
    public PhoneBuilder setProcessor(String processor){
        this.processor = processor;
        return this;
    }
    public PhoneBuilder setBattery(int battery){
        this.battery = battery;
        return this;
    }
    public PhoneBuilder setRam(int ram){
        this.ram = ram;
        return this;
    }
    public Phone getPhone(){
        return new Phone(os, processor, battery, ram);
    }
}

class Phone{
    private String os;
    private String processor;
    private int battery;
    private int ram;

    public Phone(String os, String processor, int battery, int ram) {
        this.os = os;
        this.processor = processor;
        this.battery = battery;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" + "os=" + os + ", processor=" + processor + ", battery=" + battery + ", ram=" + ram + '}';
    }
}
