package SORTING_ALGORITHM;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {9, 12, 13, 6, 5};
        int n = arr.length;

        // Insertion sort logic
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i - 1;

            // Corrected condition to j >= 0
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }

        // Printing the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
