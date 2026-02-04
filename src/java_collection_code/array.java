package java_collection_code;

public class array {

    public static void main(String[] args) {

        //Shift all 0's to Right side of array

        Integer lt[] = {0,0,1,0,-3,12,0,4,5,0,6,0,7,8,-9,0,0,0,0,0,0,1,0,0,20,30,0,0,0,0,1};

        int index = 0;
        for (int i = 0; i < lt.length; i++) {
            if (lt[i] != 0) {
                lt[index] = lt[i];
                index++;
            }
        }
        while (index < lt.length) {
            lt[index] = 0;
            index++;
        }
        for (int i =0; i<lt.length; i++){
            System.out.print(lt[i] + " ");
        }
        System.out.println();
        System.out.println("////////////////////////////////////////////////////////");
        //Shift all 0's to Left side of array

        int index1 = lt.length - 1;
        for(int i = lt.length - 1; i >= 0; i--){
            if(lt[i] != 0){
                lt[index1] = lt[i];
                index1--;
            }
        }
        while(index1 >= 0) {
            lt[index1] = 0;
            index1--;
        }
        for (int i =0; i<lt.length; i++){
            System.out.print(lt[i] + " ");
        }
    }
}
