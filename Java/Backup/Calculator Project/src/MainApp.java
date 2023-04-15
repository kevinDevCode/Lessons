import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainApp {
    public static void main(String[] args) {
        final String inputExp = ReadInput.read();

        Queue<String> operation;
        Queue<String> numbers;
        Queue<String>  parenthesisList;

        String numbersArr[] = inputExp.split("[-+*/]");
        String operArr[] = inputExp.split("[0-9]+");
        String calcParenthesis[] = inputExp.split("()");

        numbers = new LinkedList<String>(Arrays.asList(numbersArr));
        operation = new LinkedList<String>(Arrays.asList(operArr));
        parenthesisList = new LinkedList<String>(Arrays.asList(calcParenthesis));

        Double res = Double.parseDouble(numbers.poll());
        while (!numbers.isEmpty()) {
            String opr = operation.poll();
            Operate operate;
            switch (opr) {
                case "+":
                    operate = new Add();
                    break;
                case "-":
                    operate = new Subtract();
                    break;
                case "*":
                    operate = new Multiply();
                    break;
                case "/":
                    operate = new Divide();
                    break;
                default:
                    continue;
            }
            Double num = Double.parseDouble(numbers.poll());
            res = operate.getResult(res, num);
        }
        System.out.println(parenthesisList);
        System.out.println(res);
    }
}
