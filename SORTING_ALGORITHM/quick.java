package SORTING_ALGORITHM;

public class quick {
    public static void main(String args[]) {
        int arr[] = {4, 5, 2, 1, 9, 8, 7, 3};
        int n = arr.length;
        
        // Call QuickSort
        QS(arr, 0, n - 1);

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // QuickSort logic
    static void QS(int arr[], int s, int e) {
        if (s < e) {
            int pi = partition(arr, s, e);
            QS(arr, s, pi - 1);
            QS(arr, pi + 1, e);
        }
    }

    // Partition logic
    static int partition(int arr[], int s, int e) {
        int pivot = arr[e]; // Pivot is the last element
        int i = s - 1;

        // Loop through the array segment
        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot element to the correct position
        swap(arr, i + 1, e);
        return i + 1;
    }

    // Swap logic
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
