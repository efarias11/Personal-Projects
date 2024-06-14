public class MergeSort { // sorts by dividing and conquering, by dividing the array in halves until it can't, then compare sorting and merging in the end
    public void merge(int[] array, int left, int middle, int right){
        // to find the length of the subarrays
        // left is the first index, middle is the index at the center, and right is the last index
        int n1 = middle - left + 1; // 
        int n2 = right - middle;

        // the temp subarrys
        int[] l = new int[n1];
        int[] r = new int[n2];

        // copying the main array's data to the subarrays
        for(int i = 0; i<n1; i++){
            l[i] = array[left+i];
        }
        for(int j = 0; j<n2; j++){
            r[j] = array[middle+1+j];
        }
        // to start each array at index 0
        int i = 0, j = 0, k = left; // can initialize mulitple variables on one line 
        while(i<n1 && j<n2){
            if(l[i]<=r[j]){
                array[k] = l[i];
                i++;
            }else{
                array[k] = r[j];
                j++;
            }
            k++;
        }
    }
}
