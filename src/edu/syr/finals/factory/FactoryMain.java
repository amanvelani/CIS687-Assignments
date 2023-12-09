package edu.syr.finals.factory;

import edu.syr.finals.factory.phone.OS;
import edu.syr.finals.factory.phone.OSFactory;
// Factory Method Pattern - Creational Pattern
// Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
// The Factory Method Pattern is also known as Virtual Constructor.
// Advantages of Factory Design Pattern
// Factory Method Pattern allows the sub-classes to choose the type of objects to create.
// It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.
public class FactoryMain {
    public static void main(String[] args){
        OSFactory osf = new OSFactory();
        OS obj = osf.getInstance("close");
        obj.specs();
    }
}
