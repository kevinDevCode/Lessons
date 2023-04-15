public class Divide implements Operate
{
    public double getResult(Double...numbers)
    {
        Double result = numbers[0];
        for (int i = 1; i< numbers.length;i++)
        {
            result /= numbers[i];
        }
        return result;
    }
}
