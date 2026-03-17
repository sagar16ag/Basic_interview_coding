package java_collection_code;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class palindrome_and_anagaram {
    public static void main(String[] args) {
        // string is palindrom or not
        String str = "madam";

        boolean isPalindrome = IntStream
                .range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));

        System.out.println(isPalindrome);


        System.out.println("////////////////////////////////////////////////////////");

        String s1 = "listten";
        String s2 = "silentt";

        boolean isAnagram = s1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(s2.chars().sorted().boxed().collect(Collectors.toList()));

//        boolean isAnagram =
//                Arrays.equals(
//                        s1.chars().sorted().toArray(),
//                        s2.chars().sorted().toArray()
//                );

        System.out.println(isAnagram);
    }
}