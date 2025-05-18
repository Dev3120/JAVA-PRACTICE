import java.util.Scanner;

public class rowwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt();

        // Initialize the 2D array
        int[][] arr = new int[r][c];

        // Populate the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Display the array row-wise
        System.out.println("Array elements (row-wise):");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
