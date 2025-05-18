import java.util.Scanner;

publicgit class calculator{
    static double calculate(double a,double b,char op){
        switch(op){
            case'+':return a+b;
            case'-':return a-b;
            case'*':return a*b;
            case'/':return (b!=0)?a/b:Double.NaN;
            default:System.out.println("Invakid operator");return Double.NaN;

        }
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter num1,operator,num2: ");
        double x=sc.nextDouble();
        char op=sc.next().charAt(0);
        double y=sc.nextDouble();

        double result = calculate(x, y, op);
        if (!Double.isNaN(result))
            System.out.println("Result: " + result);
        else
            System.out.println("Error in calculation.");

        sc.close();
    }
}
