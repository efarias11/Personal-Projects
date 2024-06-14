import java.util.Random;
public class MergeSortMain { // int sorting
    public static void main(String[] args){
        Random rand = new Random();
        int[] array = new int[100];

        for(int i = 0; i<array.length; i++){
            int rng = rand.nextInt(100);
            array[i] = rng;
            System.out.print(array[i]+", ");
        }
    }
}

