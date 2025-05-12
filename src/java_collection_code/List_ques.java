package java_collection_code;

import java.util.List;

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

    }
}
