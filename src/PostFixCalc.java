import java.util.Scanner;

public class PostFixCalc {

    public static Integer EvaluatePostFix(String exp) {
        // FINISH ME
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
        // FINISH ME
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
