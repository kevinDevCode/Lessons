import java.util.ArrayList;

public class Calculadora
{
    public static void main(String[] args)
    {
        try
        {
            ShuntingYard calc = new ShuntingYard("(3+4)*2-4");
            ArrayList<String> prefija = calc.getPrefija();
            for (String string : prefija)
            {
                System.out.print(string + " ");
            }
            RPN rpn = new RPN(prefija);
            System.out.println("\n Resultado: " + rpn.rpn());
        }catch (ParentesisAperturaException | ParentesisCierreExcepcion e)
        {
            e.printStackTrace();
        } catch (ElementoFaltante e)
        {
            e.printStackTrace();
        }


    }
}
