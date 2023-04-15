package Pieces;

import GUI.ChessBoardGUI;

public class Pawn extends PieceMovement
{
    int [][] drawPath;
    public Pawn(int xStart, int yStart)
    {
        super(xStart, yStart);
    }

    @Override
    public int[][] PathFinding()
    {
        int size;
        if (contsizePawn() > 0)
        {
            size = contsizePawn();
        }
        else
        {
            size = 1;
        }
        drawPath = new int[2][size];

        if (ChessBoardGUI.selectedPiece.iswhite) //If the pawn is white, it substracts one
        {
            int cont = 0;

            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64) != null)
            {
                drawPath[0][cont] = xStart - 1;
                drawPath[1][cont] = yStart - 1;
                cont += 1;
            }
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64) != null)
            {
                drawPath[0][cont] = xStart + 1;
                drawPath[1][cont] = yStart - 1;
                cont += 1;
            }
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64) == null)
            {
                drawPath[0][cont] = xStart;
                drawPath[1][cont] = yStart - 1;
                cont += 1;
            }
            if (contsizePawn() <= 0)
            {
                drawPath[0][cont] = xStart;
                drawPath[1][cont] = yStart;
            }
        }
        else //If the pawn is black, it adds one
        {
            int cont = 0;
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64) != null)
            {
                drawPath[0][cont] = xStart - 1;
                drawPath[1][cont] = yStart + 1;
                cont += 1;
            }
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64) != null)
            {
                drawPath[0][cont] = xStart + 1;
                drawPath[1][cont] = yStart + 1;
                cont += 1;
            }
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64) == null)
            {
                drawPath[0][cont] = xStart;
                drawPath[1][cont] = yStart + 1;
                cont += 1;
            }
            if (contsizePawn() <= 0)
            {
                drawPath[0][cont] = xStart;
                drawPath[1][cont] = yStart;
            }


        }
        return drawPath;
    }

    public int contsizePawn()
    {
        int contsize = 0;

        if (ChessBoardGUI.selectedPiece.iswhite)
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64) != null)
            {
                contsize +=1;
                //System.out.println("(01) X: " + (xStart-1) + " Y: " + (yStart - 1));
            }
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64) != null)
            {
                //System.out.println("(02) X: " + (xStart+1) + " Y: " + (yStart - 1));
                contsize += 1;
            }
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64) == null)
            {
                //System.out.println("(03) X: " + xStart + " Y: " + (yStart - 1));
                contsize += 1;
            }
        }
        else
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64) != null)
            {
                contsize +=1;
                //System.out.println("(04) X: " + (xStart-1) + " Y: " + (yStart + 1));
            }
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64) != null)
            {
                //System.out.println("(05) X: " + (xStart + 1) + " Y: " + (yStart + 1));
                contsize += 1;
            }
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64) == null)
            {
                //System.out.println("(06) X: " + xStart + " Y: " + (yStart + 1));
                contsize += 1;
            }
        }


        return contsize;
    }
}


