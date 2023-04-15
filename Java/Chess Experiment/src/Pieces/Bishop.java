package Pieces;

import GUI.ChessBoardGUI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bishop extends PieceMovement
{
    int [][] findingPath;
    public int contdrawBlueBishop;
    public int xbishopMovementWithLimits;
    public int ybishopMovementWithLimits;
    LinkedList<Bishop> bish;
    public int cont = 0;
    public Bishop(int xStart, int yStart, LinkedList<Bishop> bish)
    {
        super(xStart, yStart);
        xbishopMovementWithLimits = 0;
        ybishopMovementWithLimits = 0;
        findingPath = new int[8][8];
        this.bish = bish;
        bish.add(this);
    }
    @Override
    public int [][] PathFinding()
    {
        int contPlaceBishop = 0;
        int xContsizeFor = xbishopMovementWithLimits;
        int yContSizeFor = ybishopMovementWithLimits;
        for (int i = 0, j = 0; i<8 && j < 8; i++,j++)
        {
            findingPath[i][j] = 0;

        }
        for (int i = xStart,  j = yStart;(i < 8 && j >= 0); i++, j--) //DERECHA-ARRIBA
        {
            findingPath[i][j] = 1;
        }
        for (int i = xStart,  j = yStart;(i >= 0 && j < 8); i--, j++) //IZQUIERDA-ABAJO
        {
            findingPath[i][j] = 1;

        }
        for (int i = xStart,  j = yStart ;(i >= 0  && j >= 0); i--, j--) //IZQUIERDA-ARRIBA
        {
            findingPath[i][j] = 1;

        }
        for (int i = xStart,  j = yStart;(i < 8 && j < 8); i++, j++) //DERECHA-ABAJO
        {
            findingPath[i][j] = 1;

        }
        //----------------------------------------------------------------------------
        findingPath[xStart][yStart] = 2;
        //----------------------------------------------------------------------------
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {

                if (findingPath[i][j] == 1)
                {
                    contPlaceBishop += 1;
                }

            }
        }
        cont = contPlaceBishop;  //Se coloco la constante porque la longitud del array era menos de la que se pintaba en color azul y daba error
        contdrawBlueBishop  = 0;
        int [][] drawPath = new int[2][cont];
        int contUntilPiece = 0;
        for (int i = 0; i < cont ; i++)
        {
            drawPath[0][i] = 0;
            drawPath[1][i] = 0;
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (findingPath[i][j] == 1)
                {
                    drawPath[0][contdrawBlueBishop] = i;
                    drawPath[1][contdrawBlueBishop] = j;
                    //System.out.println("drawPath X: " + drawPath[0][contdrawBlueBishop] + "drawPath Y: " + drawPath[1][contdrawBlueBishop]);
                    contdrawBlueBishop += 1;


                }


            }
        }

        /*for (int i = 0; i < cont; i++)
        {
            System.out.println("DrawPath X: " + drawPath[0][i] + " DrawPath Y: " + drawPath[1][i]);
        }
        */


        return drawPath;

    }



}
