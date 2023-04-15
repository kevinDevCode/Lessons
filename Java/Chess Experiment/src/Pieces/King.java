package Pieces;

import GUI.ChessBoardGUI;

import java.util.IllegalFormatCodePointException;

public class King extends PieceMovement
{
    int [][] drawPath;
    boolean isWhite;

    public King(int xStart, int yStart)
    {
        super(xStart, yStart);
        isWhite = ChessBoardGUI.selectedPiece.iswhite;
    }

    @Override
    public int[][] PathFinding()
    {
        int contIndex = 0;
        drawPath = new int[2][contsizeKnight()];
        if ((xStart + 1) < 8) //MOVIMIENTO A DERECHA
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, yStart * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, yStart * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 1;
                    drawPath[1][contIndex] = yStart;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 1;
                drawPath[1][contIndex] = yStart;
                contIndex += 1;
            }
        }
        if ((xStart - 1) >= 0) //MOVIMIENTO A IZQUIERDA
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, yStart * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, yStart * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 1;
                    drawPath[1][contIndex] = yStart;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 1;
                drawPath[1][contIndex] = yStart;
                contIndex += 1;
            }
        }
        if ((yStart + 1) < 8) //MOVIMIENTO HACIA ABAJO
        {
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart;
                    drawPath[1][contIndex] = yStart + 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart;
                drawPath[1][contIndex] = yStart + 1;
                contIndex += 1;
            }
        }
        if ((yStart - 1) >= 0) //MOVIMIENTO HACIA ARRIBA
        {
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64 ).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart;
                    drawPath[1][contIndex] = yStart - 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart;
                drawPath[1][contIndex] = yStart - 1;
                contIndex += 1;
            }
        }
        if ((xStart + 1) < 8 && (yStart + 1) < 8) //MOVIMIENTO DERECHA-ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 1;
                    drawPath[1][contIndex] = yStart + 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 1;
                drawPath[1][contIndex] = yStart + 1;
                contIndex += 1;
            }
        }
        if ((xStart + 1) < 8 && (yStart - 1) >= 0) //MOVIMIENTO DERECHA-ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart + 1;
                    drawPath[1][contIndex] = yStart - 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart + 1;
                drawPath[1][contIndex] = yStart - 1;
                contIndex += 1;
            }
        }
        if ((xStart - 1) >= 0 && (yStart + 1) < 8) //MOVIMIENTO IZQUIERDA - ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 1;
                    drawPath[1][contIndex] = yStart + 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 1;
                drawPath[1][contIndex] = yStart + 1;
                contIndex += 1;
            }
        }
        if ((xStart - 1) >= 0 && (yStart - 1) >= 0) //MOVIMIENTO IZQUIERDA - ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    drawPath[0][contIndex] = xStart - 1;
                    drawPath[1][contIndex] = yStart - 1;
                    contIndex += 1;
                }
            }
            else
            {
                drawPath[0][contIndex] = xStart - 1;
                drawPath[1][contIndex] = yStart - 1;
                contIndex += 1;
            }
        }

        return drawPath;
    }

    public int contsizeKnight()
    {
        int conIndexSizeArray2D = 0;
        if ((xStart + 1) < 8) //MOVIMIENTO A DERECHA
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, yStart * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, yStart * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart - 1) >= 0) //MOVIMIENTO A IZQUIERDA
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, yStart * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, yStart * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((yStart + 1) < 8) //MOVIMIENTO HACIA ABAJO
        {
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece(xStart * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((yStart - 1) >= 0) //MOVIMIENTO HACIA ARRIBA
        {
            if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece(xStart * 64, (yStart - 1) * 64 ).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart + 1) < 8 && (yStart + 1) < 8) //MOVIMIENTO DERECHA-ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart + 1) < 8 && (yStart - 1) >= 0) //MOVIMIENTO DERECHA-ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart + 1) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart - 1) >= 0 && (yStart + 1) < 8) //MOVIMIENTO IZQUIERDA - ABAJO
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart + 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        if ((xStart - 1) >= 0 && (yStart - 1) >= 0) //MOVIMIENTO IZQUIERDA - ARRIBA
        {
            if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64) != null)
            {
                if (ChessBoardGUI.getPiece((xStart - 1) * 64, (yStart - 1) * 64).iswhite != isWhite)
                {
                    conIndexSizeArray2D += 1;
                }
            }
            else
            {
                conIndexSizeArray2D += 1;
            }
        }
        //System.out.println("ConIndexSizeArray2D: " + conIndexSizeArray2D);
        return conIndexSizeArray2D;
    }
}
