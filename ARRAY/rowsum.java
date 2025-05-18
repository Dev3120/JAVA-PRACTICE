import java.util.Scanner;
public class rowsum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the rows: ");
        int r=sc.nextInt();

        System.out.println("Enter the column: ");
        int c=sc.nextInt();

        int[][]arr= new int[r][c];
        int n=3;
        boolean ismagic=true;

        System.out.println("Enter the elements: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println("\nRow Sums");
        for(int i=0;i<r;i++){
            int rowsum=0;
            for(int j=0;j<c;j++){
                rowsum += arr[i][j];
            }
            System.out.println("Sum of rows"+(i+1)+":"+rowsum);
        }
        

        System.out.println("\nColumn Sums:");
        for (int j = 0; j < c; j++) {
            int colSum = 0;
            for (int i = 0; i < r; i++) {
                colSum += arr[i][j];
            }
            System.out.println("Sum of column " + (j + 1) + ": " + colSum);
        }
        sc.close();
    }

}
