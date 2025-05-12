package java_collection_code;

public class array {

    public static void main(String[] args) {

        //Shift all 0's to left

        Integer lt[] = {0,0,1,0,-3,12,0,4,5,0,6,0,7,8,-9,0,0,0,0,0,0,1,0,0,20,30,0,0,0,0,1};

        for(int i=0;i<lt.length-1;i++){
            if(lt[i] == 0 && lt[i+1] != 0){
                lt[i] = lt[i+1];
                lt[i+1] = 0;
                i = Math.max(-1, i - 2);
            }
        }
        for (int i =0; i<lt.length; i++){
            System.out.print(lt[i] + " ");
        }

    }
}
