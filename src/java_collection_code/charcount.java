package java_collection_code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class charcount {

    public static void main(String[] args) {

        //program to count the number of characters in each word

        List<String> list1 = Arrays.asList("Hello", "World", "Java", "Programming");
        Map<Object, Long> map1 = list1.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map1.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("Count of characters in each word:");
        System.out.println(map1);

        System.out.println("////////////////////////////////////////////////////////");

        //program to count the number of occurrences of each word in a list of strings

        List<String> list2 = Arrays.asList("Hello", "World", "Java", "Programming", "Java", "Programming");
        Map<Object, Long> map2 = list2.stream()
                .collect(Collectors.groupingBy(e->e,Collectors.counting()));
        map2.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("program to count the number of occurrences of each word in a list of strings:");
        System.out.println(map2);

        //program to count the number of occurrences of each character from a string

        System.out.println("////////////////////////////////////////////////////////");

        String str = "Sagar Agrawal, Senior Software Engineer";
        Map<Object, Long> map3 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e->e,Collectors.counting()));
        map3.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("program to count the number of occurrences of each word in a list of strings:");
        System.out.println(map3);

    }
}