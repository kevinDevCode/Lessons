package Pieces;

import GUI.ChessBoardGUI;

import java.util.logging.XMLFormatter;

public class Knight extends PieceMovement
{
    int [][] drawPath;
    boolean isWhite;
    public Knight(int xStart, int yStart)
    {
        super(xStart, yStart);
        isWhite = ChessBoardGUI.selectedPiece.iswhite;
    }

    @Override
    public int[][] PathFinding()
    {
        drawPath = new int[2][contsizeKnight()];
        int contIndex = 0;
        if ( (xStart + 1) < 8 && (yStart + 2) < 8) //DERECHA-ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart + 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart + 2) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 1;
                    drawPath[1][contIndex] = yStart + 2;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 1;
                drawPath[1][contIndex] = yStart + 2;
                contIndex += 1;
            }

        }
        if ((xStart + 1) >= 0 && (yStart - 2) >= 0) //DERECHA-ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart - 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart - 2) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 1;
                    drawPath[1][contIndex] = yStart - 2;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 1;
                drawPath[1][contIndex] = yStart - 2;
                contIndex += 1;
            }

        }
        if ((xStart - 1) >= 0 && (yStart + 2) < 8) //IZQUIERDA-ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart + 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart + 2) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 1;
                    drawPath[1][contIndex] = yStart + 2;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 1;
                drawPath[1][contIndex] = yStart + 2;
                contIndex += 1;
            }

        }
        if ((xStart - 1) >= 0 && (yStart - 2) >= 0) //IZQUIERDA-ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart - 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart - 2) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 1;
                    drawPath[1][contIndex] = yStart - 2;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 1;
                drawPath[1][contIndex] = yStart - 2;
                contIndex += 1;
            }

        }
        if ((xStart + 2) < 8 && (yStart + 1) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart + 2) * 64,(yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 2) * 64,(yStart + 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 2;
                    drawPath[1][contIndex] = yStart + 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 2;
                drawPath[1][contIndex] = yStart + 1;
                contIndex += 1;
            }
        }
        if ((xStart + 2) < 8 && (yStart - 1) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 2;
                    drawPath[1][contIndex] = yStart - 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 2;
                drawPath[1][contIndex] = yStart - 1;
                contIndex += 1;
            }
        }
        if ((xStart - 2) >= 0 && (yStart + 1) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart + 1) * 64) != null)
            {
                System.out.println("X: " + (xStart - 2) + " Y: " + (yStart + 1));
                if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 2;
                    drawPath[1][contIndex] = yStart + 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 2;
                drawPath[1][contIndex] = yStart + 1;
                contIndex += 1;
            }
        }
        if ((xStart - 2) >= 0 && (yStart - 1) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 2) * 64,(yStart - 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 2;
                    drawPath[1][contIndex] = yStart - 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 2;
                drawPath[1][contIndex] = yStart - 1;
                contIndex += 1;
            }
        }
        System.out.println("Valor de contIndex: " + contIndex);
        return drawPath;
    }

    public int contsizeKnight()
    {
        int conIndexSizeArray2D = 0;

        if ( (xStart + 1) < 8 && (yStart + 2) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart + 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart + 2) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }

        }
        if ((xStart + 1) >= 0 && (yStart - 2) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart - 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64,(yStart - 2) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }

        }
        if ((xStart - 1) >= 0 && (yStart + 2) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart + 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart + 2) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }

        }
        if ((xStart - 1) >= 0 && (yStart - 2) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart - 2) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64,(yStart - 2) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }

        }
        if ((xStart + 2) < 8 && (yStart + 1) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart + 2) < 8 && (yStart - 1) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 2) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart - 2) >= 0 && (yStart + 1) < 8)
        {
            if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart - 2) >= 0 && (yStart - 1) >= 0)
        {
            if (ChessBoardGUI.getPiece((xStart - 2) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 2) * 64,(yStart - 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        System.out.println("Valor de conIndexSizeArray2D: " + conIndexSizeArray2D);
        return conIndexSizeArray2D;
    }

}
