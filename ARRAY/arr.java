import java.util.Scanner;
public class arr{
    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        int a[];
        int n;
        n=sc.nextInt();
        a=new int[n];
        
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            a[i]=x;
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(a[i]);
        // }
        int max=a[0];
        for(int i=0;i<n;i++){
            if(a[i]>max){
                max=a[i];
            }
            
            
        }
        System.out.println(max);
    }    
}
