import java.util.ArrayList;
import java.util.Stack;

public class RPN
{
    private ArrayList<String> prefija;
    private Stack<String> pila;

    public RPN(ArrayList<String> prefija)
    {
        this.prefija = prefija;
        pila = new Stack();
    }
    public double rpn() throws ElementoFaltante {
        String eleDer, eleIzq;
        for(String token : prefija)
        {
            if(esOperador(token))
            {
                eleDer = pila.pop();
                if (pila.isEmpty())
                {
                    throw new ElementoFaltante("Error, elemento faltante");
                }
                eleIzq = pila.pop();
                double resultado = operar(eleIzq,token,eleDer);
                pila.push("" + resultado);
            }
            else
            {
                pila.push(token);
            }

        }
        return Double.parseDouble(pila.pop());

    }



    private boolean esOperador(String token)
    {
        if (token.matches("[-+\\*/%^]"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private double operar(String eleIzq, String operador, String eleDer)
    {
        double a = Double.parseDouble(eleIzq);
        double b = Double.parseDouble(eleDer);
        switch (operador)
        {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            case "%":
                return a%b;
            case "^":
                Math.pow(a,b);
            default: return -1;
        }
    }
}
