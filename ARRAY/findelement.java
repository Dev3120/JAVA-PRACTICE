public class findelement {
    public static void main(String[] args) {
        int[][] arr ={
            {2,9,41,100},
            {3,10,42,101},
            {5,15,45,200}

        };
        int row=0;
        int col=3;
        int target=15;

        while(row<4&&col>=0){
            if(arr[row][col]==target){
                System.out.println("Target found");
            }
            else if(target>arr[row][col]){
                row++;
            }
            else{
                col--;
            }
        }


       
    }
    
}
