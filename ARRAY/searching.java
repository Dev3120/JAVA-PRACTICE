public class searching {
    public static int linearSearch(int[]arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;

            }
            
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] array = {4, 3, 1, 9, 8, 7};
        int target = 9;

        int index = linearSearch(array, target);
        
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }    
}
