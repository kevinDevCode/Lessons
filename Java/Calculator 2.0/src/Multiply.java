public class Multiply implements Operate
{
    public double getResult(Double...numbers)
    {
        Double mult = numbers[0];
        for (int i = 1; i < numbers.length; i++)
        {
            mult *= numbers[i];
        }
        return mult;
    }

}

