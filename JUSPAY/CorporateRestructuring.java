package JUSPAY;

import java.util.*;

public class CorporateRestructuring {

    public static List<Integer> isCompliant(int N, int[][] arr) {
        // Create a list to store the order of non-compliant employees
        List<Integer> result = new ArrayList<>();
        
        // Create a list to check if an employee has been removed
        boolean[] removed = new boolean[N + 1];
        
        // Process all employees until no more non-compliant ones can be removed
        boolean anyRemoval = true;
        while (anyRemoval) {
            anyRemoval = false;
            for (int i = 1; i <= N; i++) {
                if (!removed[i] && arr[i - 1][1] == 1) { // non-compliant employee
                    boolean canRemove = true;
                    
                    // Check if this non-compliant employee has compliant subordinates
                    for (int j = 1; j <= N; j++) {
                        if (arr[j - 1][0] == i && arr[j - 1][1] == 0) {
                            canRemove = false;
                            break;
                        }
                    }
                    
                    if (canRemove) {
                        // Remove the non-compliant employee and add to the result list
                        removed[i] = true;
                        result.add(i);
                        anyRemoval = true;
                        break;
                    }
                }
            }
        }
        
        // If no employees were removed, return -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Example Input
        int N = 5;
        int[][] arr = {
            {1, 1},
            {-1, 0},
            {2, 1},
            {1, 1},
            {3, 0}
        };

        // Get the result (order of removal of non-compliant employees)
        List<Integer> removalOrder = isCompliant(N, arr);

        // Print the result
        for (int id : removalOrder) {
            System.out.print(id + " ");
        }
    }
}

