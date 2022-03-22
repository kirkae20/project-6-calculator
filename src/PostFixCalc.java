import java.util.Scanner;

public class PostFixCalc {

    public static Integer EvaluatePostFix(String exp) {
        Stack<String> postfixStack = new Stack<>();
        for(int i = 0; i < exp.length(); i++) {
            char check = exp.charAt(i);
            if(Character.isDigit(check)) {
                postfixStack.push(String.valueOf(check));
            }
            else if ((check == '+') || (check == '-') || (check == '*') || (check == '/')) {
                String item1 = postfixStack.pop();
                String item2 = postfixStack.pop();
                if (check == '+'){
                    int sum = Integer.parseInt(item1) + Integer.parseInt(item2);
                    postfixStack.push(String.valueOf(sum));
                }
                else if (check == '-'){
                    int difference = Integer.parseInt(item2) - Integer.parseInt(item1);
                    postfixStack.push(String.valueOf(difference));
                }
                else if (check == '*'){
                    int product = Integer.parseInt(item1) * Integer.parseInt(item2);
                    postfixStack.push(String.valueOf(product));
                }
                else if (check == '/'){
                    int quotient = Integer.parseInt(item2) / Integer.parseInt(item1);
                    postfixStack.push(String.valueOf(quotient));
                }
            }
        }
        return Integer.parseInt(postfixStack.pop());
    }

    // A utility function to return the precedence of a given operator
    static int precedence(Character ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

        }
        return -1;
    }
    public static String InfixToPostfix(String exp) {
        String postfixExp = "";
        Stack<Character> infixStack = new Stack<>();
        for(int i = 0; i < exp.length(); i++) { // while there is input to read in exp
            char check = exp.charAt(i);
            if (check >= '0' && check <= '9') {
                postfixExp += check;
            } else if (check == '(') {
                infixStack.push(check);
            } else if (check == ')') {
                while (!infixStack.isEmpty() && infixStack.peek() != '(') {
                    postfixExp += infixStack.pop();
                }
                if (!infixStack.isEmpty()) {
                    infixStack.pop();
                }
            } else if ((check == '+') || (check == '-') || (check == '*') || (check == '/')) {
                if(infixStack.isEmpty()){
                    infixStack.push(check);
                }
                else if (!infixStack.isEmpty() && (precedence(infixStack.peek()) < precedence(check))){
                    infixStack.push(check);
                }
                else {
                    if (!infixStack.isEmpty() && precedence(infixStack.peek()) >= precedence(check)) {
                        while (infixStack.peek() != '(') {
                            postfixExp += infixStack.pop();
                        }
                        infixStack.push(check);
                    }// keep popping operators until... then push the original operator on the stack
                }         // a. the original operator is lower in precedence than the operator at the top of the stack
            }             // b. the left parenthesis is reached
        }                 // c. the stack is empty
        while(!infixStack.isEmpty()){
            postfixExp += infixStack.pop();
        }
        return postfixExp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Infix Expression: ");
        String InFixExpression = input.nextLine();

        String PostFixExpression = InfixToPostfix((InFixExpression));
        System.out.println(PostFixExpression);

        Integer result = EvaluatePostFix(PostFixExpression);
        System.out.println(result);

    }
}
