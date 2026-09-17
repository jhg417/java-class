import java.util.Arrays;

public class Ch05_1_5_ReferenceCheck {
    public static void main(String[] args){
     int[] original = {10,20};

     int[] alias = original;

     alias[0] = 30;

     int[] sameValues = {30,20};
        System.out.println("original[0]: " + original[0]);
        System.out.println("같은 객체: " + (original == sameValues));
        System.out.println("항목이 같음: " + Arrays.equals(original, sameValues));

        String[] names = new String[4];
        names[0] = "김서윤";
        names[2] = "박민준";

        for (int i = 0; i<names.length; i++){
            if(names[i] != null) {
                System.out.println(names[i]);
            }
        }
    }
}
