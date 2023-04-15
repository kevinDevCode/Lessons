import java.util.Scanner;
public class ReadInput
{
    public static String read()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Expression, ex: 4*3/2");
        String inputLine = scanner.nextLine(); //it is used to print or take the value is in the second line
        scanner.close();
        return inputLine;
    }


}
