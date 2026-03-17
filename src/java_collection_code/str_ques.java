package java_collection_code;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class str_ques {
    public static void main(String[] args) {

       String str = "Java is a programming languagej";

       String result = str.replaceAll("[aeiouAEIOU]", "");
       System.out.println("String after removing vowels: " + result);

       String result1 = str.replaceAll("[^aeiouAEIOU]", "");
       System.out.println("String after removing Constants: " + result1);

       String result2 = Arrays.stream(str.split(" "))
               .map(word -> new StringBuilder(word).reverse().toString())
               .collect(Collectors.joining(" "));
         System.out.println("String after reversing each word: " + result2);  // o/p = avaJ si a gnimmargorp egaugnal


        String result3 = new StringBuilder(str).reverse().toString();
        System.out.println("String after reversing the whole line: " + result3);  // o/p = egaugnal gnimmargorp a si avaJ


        // Find duplicate characters using streams
        str.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        // Remove duplicate characters from string using streams
        String result4 =
                str.toLowerCase().chars()
                        .mapToObj(c -> (char) c)
                        .distinct()
                        .map(String::valueOf)
                        .collect(Collectors.joining());

        System.out.println(result4);



        // Find the second most duplicate character in a string using streams
        String str1 = "spppsstsaa";
        str1.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .ifPresent(e ->
                        System.out.println(e.getKey() + " : " + e.getValue())
                );
    }


}
