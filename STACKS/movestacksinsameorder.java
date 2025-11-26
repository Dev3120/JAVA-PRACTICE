import java.util.Stack;
import java.util.Scanner;
public class movestacksinsameorder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        // int n;
        // System.out.println("Enter number of the elements ");
        // n=sc.nextInt();
        // for(int i=1;i<=n;i++){
        //     int x=sc.nextInt();
        //     st.push(x);
        // }
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);

        Stack<Integer> rt=new Stack<>();
        while(st.size()>0){
            rt.push(st.pop());

        }
        System.out.println(rt);


    }
    
}
