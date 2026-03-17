package funtionals_interface;


@FunctionalInterface
interface MyFunctionalInterface {

    // 1️⃣ Only ONE abstract method (mandatory)
    void sayHello(String name);



    // 2️⃣ Multiple default methods allowed
    default void greet() {
        System.out.println("Welcome!");
    }

    default void sayGoodbye() {
        System.out.println("Goodbye!");
    }



    // 3️⃣ Multiple static methods allowed
    static void staticMethod1() {
        System.out.println("Static Method 1");
    }

    static void staticMethod2() {
        System.out.println("Static Method 2");
    }
}
