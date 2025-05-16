package java_collection_code;

import java.util.Arrays;
import java.util.stream.Collectors;

public class str_ques {
    public static void main(String[] args) {

       String str = "Java is a programming language";

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

    }
}
