public interface Operate
{
    double getResult(Double... numbers); //It only takes a method where you can modify in other classes(interface)
    // the 'Double...numbers' is a way to ask as a method an array of numbers (with the value type double)
}
