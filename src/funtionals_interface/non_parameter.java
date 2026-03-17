package funtionals_interface;


@FunctionalInterface
interface MyInterface {
    void sayHello();   // no parameter
}

public class non_parameter {
    public static void main(String[] args) {
        MyInterface obj = () -> System.out.println("Hello Sagar");
        obj.sayHello();
    }
}
