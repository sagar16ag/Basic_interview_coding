package funtionals_interface;


public class multiple_static_default {
    public static void main(String[] args) {

        MyFunctionalInterface obj = name ->
                System.out.println("Hello " + name);

        obj.sayHello("Sagar");  // abstract method
        obj.greet();            // default method
        obj.sayGoodbye();       // default method

        MyFunctionalInterface.staticMethod1(); // static method
        MyFunctionalInterface.staticMethod2(); // static method
    }
}