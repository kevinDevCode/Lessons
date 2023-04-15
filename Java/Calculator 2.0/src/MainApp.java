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
        int contValue = 0;
        int contArray = 0;

        String numbersArr[] = inputExp.replace("(","*").replace(")","").split("[-+*/]");
        String operArr[] = inputExp.replace("(","*").replace(")","").split("[0-9]+");
        String everyLetter[] = inputExp.split("[0-9]+");
        Integer depositValue[] = new Integer[everyLetter.length];
        for(int i = 0; i < everyLetter.length;i++)
        {
            System.out.println(everyLetter[i]);

            if (everyLetter[i].contains("("))
            {
                depositValue[contArray] = contValue;
                String calcParenthesis[] = inputExp.split("[(,)]");
                parenthesisList = new LinkedList<String>(Arrays.asList(calcParenthesis));
                System.out.println(depositValue[i]);
                contArray += 1;
            }
            contValue += 1;
        }

        numbers = new LinkedList<String>(Arrays.asList(numbersArr));
        operation = new LinkedList<String>(Arrays.asList(operArr));

        System.out.println("numbersArr: " + numbers);
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


        System.out.println(res);
    }
}
