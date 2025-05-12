package java_collection_code;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class List_ques {

    public static void main(String[] args) {

        //program to Check the number of even or odd in a single list using stream

        List<Integer> lt1 = List.of(2,1,7,18, 21, 34, 94, 53, 12, 45, 67, 89, 90);
        lt1.stream().forEach(i->{
            if(i%2==0)
                System.out.println("even no: " + i);
            else
                System.out.println("odd no: " + i);
        });

        System.out.println("////////////////////////////////////////////////////////");

        List<Integer> lt2 = List.of(2,1,7,18,21,34,94,53,12,45,67,89,90,90,34,45,67,89,89,67,45,3,2,1);
        List<Integer> lt3 = lt2.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Distinct and sorted list in ascending order: " + lt3);
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println("////////////////////////////////////////////////////////");
        List<Integer> lt4 = lt2.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Distinct and sorted list in Descending order: " + lt4);

    }
}
