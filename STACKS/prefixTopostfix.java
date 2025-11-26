import java.util.Stack;

public class prefixTopostfix {
    public static void main(String[] args) {
        String str = "-9/*+5346";  // Prefix expression
        Stack<String> val = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                val.push("" + ch);  // convert char to string
            } else {
                // pop 2 operands
                String v1 = val.pop();
                String v2 = val.pop();
                String combined = v1 + v2 + ch;  // postfix = operand1 operand2 operator
                val.push(combined);
            }
        }

        System.out.println("Postfix Expression: " + val.peek());
    }
}
