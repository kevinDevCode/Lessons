public class Add implements Operate
{
    @Override
    public double getResult(Double...numbers)
    {
        Double sum = 0.0;
        for (Double num : numbers)
        {
            sum += num;
        }
        return sum;
    }
}
