import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuntingYard
{
    private String operacion;
    private ArrayList<String> prefija;
    private ArrayList<String> tokens;

    public ShuntingYard(String operacion) throws ParentesisAperturaException, ParentesisCierreExcepcion {
        this.operacion = operacion;
        prefija = new ArrayList<>();
        tokens = new ArrayList<>();
        this.tokenizar();
        this.shuntingYard();
    }

    private void tokenizar()
    {
        String patron = "(?<token>[\\(]|[0-9]+|[-+\\*/%^]|[\\)])";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(this.operacion);

        String token;

        while (matcher.find())
        {
            token = matcher.group();
            tokens.add(token);
        }

    }

    public void shuntingYard() throws ParentesisCierreExcepcion, ParentesisAperturaException
    {
        String token;
        int contParentesis = 0;
        Stack<String> pila = new Stack();
        for (int i = 0; i < tokens.size(); i++) {
            token = tokens.get(i);
            if(token.matches("[0-9]+"))
            {
                prefija.add(token);
            } else if (token.equals("("))
            {
                pila.push(token);
                contParentesis += 1;
            } else if (token.matches("[-+\\*/%^]"))
            {
                if (!pila.empty())
                {
                    if (compararPresedencias(token, pila.peek()))
                    {
                        prefija.add(pila.pop());
                        pila.push(token);
                    }
                    else
                    {
                        pila.push(token);
                    }
                }else
                {
                    pila.push(token);
                }
            } else if (token.equals(")"))
            {
                contParentesis -= 1;
                if(!pila.empty())
                {
                    while (true)
                    {
                        if (!pila.empty())
                        {
                            if (!pila.peek().equals("("))
                            {
                                prefija.add(pila.pop());
                            }
                            else
                            {
                                pila.pop();
                                break;
                            }
                        }else
                        {
                            break;
                        }
                    }
                }else
                {
                    throw new ParentesisCierreExcepcion("Parentesis de cierre sobrante");
                }
            }
            if (contParentesis < 0)
            {
                throw new ParentesisCierreExcepcion("Parentesis de cierre sobrante");
            }
        }
        while (!pila.empty())
        {
            if (!pila.peek().equals("("))
            {
                prefija.add(pila.pop());
            }
            else
            {
                throw new ParentesisAperturaException("Parentesis de apertura sobrante");
            }
        }
    }

    private boolean compararPresedencias(String opExp, String opTopPila )
    {
        return darPresedenciaOperacion(opExp) < darPresedenciaPila(opTopPila);
    }

    private int darPresedenciaOperacion(String op)
    {
        switch (op)
        {
            case "^":
                return 4;
            case "*": case "/": case "%":
                return 2;
            case "+": case "-":
                return 1;
            default: return 0;
        }
    }

    private int darPresedenciaPila(String op)
    {
        switch (op)
        {
            case "^":
                return 3;
            case "*": case "/": case "%":
                return 2;
            case "+": case "-":
                return 1;
            default: return 0;
        }
    }

    public ArrayList<String> getPrefija() {
        return prefija;
    }
}
