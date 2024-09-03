// quicksort divides and conquers like mergesort, it picks a pivot point that partitions the array, then sorts the subarrays
import java.util.Random; 

public class QuickSort{
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++){
            nums[i] = rand.nextInt(1000);
        }

        System.out.println("Before:");
        printArray(nums);

        quicksort(nums);

        System.out.println("\nAfter:");
        printArray(nums);
    }
    // overload quicksort method, having same name but passing different parameters
    private static void quicksort(int[] array){
        quicksort(array, 0, array.length-1);
    }

    // using a left and right pointer (at 0 and largest index value), excluding the initial pivot point
    private static int partition(int[] array, int lowI, int highI, int pivot){
        int left_pointer = lowI;
        int right_pointer = highI; 

        while(left_pointer < right_pointer){
            // left pointer moves right in array until it stops at a value > pivot
            while(array[left_pointer]<= pivot && left_pointer < right_pointer){
                left_pointer++;
            }
            // right pointer moves left in array until it stops at a value < pivot
            while(array[right_pointer] >= pivot && left_pointer < right_pointer){
                right_pointer--;
            }
            // when the pointers overlap swap that value with the pivot value, then the process repeats 
            swap(array, left_pointer, right_pointer);
        }
        swap(array, left_pointer, highI); // we use highI since we're swapping the pointers' value with the pivot
        return left_pointer;
    }
    public static void quicksort(int[] array, int lowI, int highI){
        if(lowI>=highI){
            return;
        }
        int pivotIndex = new Random().nextInt(highI - lowI) + lowI; // gives you random pivot index between the low and high index
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highI); // swapping random pivot to begain the partition process

        int left_pointer = partition(array, lowI, highI, pivot);

        // left subarray 
        quicksort(array, lowI, left_pointer-1); // since the pointers became the new pivot point, left pointer - 1 gives the highest index in the subarray 
        // right subarray
        quicksort(array, left_pointer + 1, highI); // right side of the pivot's small index is + 1 of pivot point and highI is the max Index value of the total array
        // ex: array[1, 2, 5, |7|, 9, 10], 7 is the pivot point, two subarrays, left and right side of pivot.
    }
    private static void swap(int[] array, int index1, int index2){ // using temp values to swap any two values
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static void printArray(int[] nums){ // printing the array
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+ " ");
        }
    }
}