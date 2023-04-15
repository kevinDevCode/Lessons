public class AbstractionDemo
{
    public static void main(String[] args)
    {
        //We create an object with the child class of the abstract class, this is the only way we can create
        //an object with the child class, only referencing to the abstract class
        GraphicObject circle = new Circle();
        circle.draw();
        circle.resize();

        GraphicObject rectangle = new Rectangle();
        rectangle.draw();
        rectangle.resize();

    }
}
