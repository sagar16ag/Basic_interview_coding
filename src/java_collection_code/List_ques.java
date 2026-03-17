package java_collection_code;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class List_ques {

    public static void main(String[] args) {

        //program to Check the number of even or odd in a single list using stream

        List<Integer> lt6 = List.of(2,1,7,18, 21, 34, 94, 53, 12, 45, 67, 89, 90);
        lt6.stream().forEach(i->{
            if(i%2==0)
                System.out.println("even no: " + i);
            else
                System.out.println("odd no: " + i);
        });

        System.out.println("////////////////////////////////////////////////////////");

        List<Integer> lt8 = List.of(2,1,7,18,21,34,94,53,12,45,67,89,90,90,34,45,67,89,89,67,45,3,2,1);
        List<Integer> lt9 = lt8.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Distinct and sorted list in ascending order: " + lt9);
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");
        List<Integer> lt4 = lt8.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Distinct and sorted list in Descending order: " + lt4);


        List<Integer> lt2 = List.of(2,1,7,18,21,34,94,53,12,45,67,89,90,90,34,45,67,89,89,67,45,3,2,1);

        List<Integer> lt3 = lt2.stream()
                .filter(e->e>20 && e<40)
                .collect(Collectors.toList());

        System.out.println("Distinct and sorted list in ascending order: " + lt3);


        List<Integer> lt5 = lt2.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(lt5);

        Optional<Integer> op = lt2.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        //.get();

        System.out.println("2nd highest: " + op);



        double avg = lt2.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println("average " +  avg);



        List<Integer> top5 = lt2.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .toList();

        System.out.println("top 5 " +  top5);


        Map<Integer, Long> mp = lt2.stream()
                .collect(Collectors.groupingBy(e->e,Collectors.counting()));

        mp.forEach((k,v) -> System.out.println(k + " : " + v));
        System.out.println("///////////////////");

        lt2.stream()
                .collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()>1)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));


        List<Integer> lt7 = lt2.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(lt7);


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
