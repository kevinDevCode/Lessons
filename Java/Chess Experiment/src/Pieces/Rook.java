package Pieces;

import GUI.ChessBoardGUI;

import java.time.Year;

public class Rook extends PieceMovement
{
    int [][] sizeWihoutLimits;
    public Rook(int xStart, int yStart) {
        super(xStart, yStart);
    }
    @Override
    public int[][] PathFinding()
    {
        boolean isPieceInFront01 = true;
        boolean isPieceInFront02 = true;
        boolean isPieceInFront03 = true;
        boolean isPieceInFront04 = true;
        int [][] sizeOfDrawRookMovement = new int[8][8];
        int[][] arrayWithoutLimitsDrawRookMovement = new int[8][8];
        int contSizeColumn2DArrayWithLimits = 0;
        int contSizeColumn2DArraywithoutLimits = 0;

        //--------------------------VERTICAL-ABAJO----------------------------------------------------------------
        for (int i = xStart, j = yStart; j < 8; j++) //VERTICAL-ABAJO WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront01)
            {
                if (ChessBoardGUI.getPiece(i * 64,j * 64) != null && j != yStart)
                {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront01 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (yPositionLimits != -1)
                    {
                        for (int x = xStart, y = yStart; y < yPositionLimits; y++)
                        {
                            if (y != yStart)
                            {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                                //System.out.println("isPieceInFront01: Valor en Rook con LIMITES X: " + x + " Y: " + y);
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront01 == true)
        {
            for (int i = xStart, j = yStart; j < 8; j++) //VERTICAL-ABAJO WITHOUT LIMITS
            {
                if (j != yStart)
                {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                    //System.out.println("isPieceInFront01: Valor en Rook sin LIMITES X: " + i + " Y: " + j);
                }

            }
        }
        //-----------------------VERTICAL - ARRIBA -----------------------------------------------------------
        for (int i = xStart, j = yStart; j >= 0; j--)
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront02 == true)
            {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && j != yStart)
                {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront02 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (yPositionLimits != -1)
                    {
                        for (int x = xStart, y = yStart; y > yPositionLimits; y--)
                        {
                            if (y != yStart)
                            {

                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                            }
                        }
                    }
                }
            }
        }

        if (isPieceInFront02 == true)
        {
            for (int i = xStart, j = yStart; j >= 0; j--)
            {
                if (j != yStart)
                {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                    //System.out.println("isPieceInFront01: Valor en Rook sin LIMITES X: " + i + " Y: " + j);
                }
            }
        }

        //-----------------------HORIZONTAL - DERECHA---------------------------------------------------------
        for (int i = xStart, j = yStart; i < 8; i++)
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront03 == true)
            {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && i != xStart)
                {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront03 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (xPositionLimits != -1)
                    {

                        for (int x = xStart, y = yStart; x < xPositionLimits; x++)
                        {
                            if (x != xStart)
                            {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                                //System.out.println("isPieceInFront03: Valor en Rook con LIMITES X: " + x + " Y: " + y);
                            }

                        }
                    }
                }
            }
        }
        if (isPieceInFront03 == true)
        {
            for (int i = xStart, j = yStart; i < 8; i++)
            {
                if (i != xStart)
                {
                    //System.out.println("isPieceInFront03: Valor en Rook sin LIMITES X: " + i + " Y: " + j);
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;

                }

            }
        }
        //------------------------------------HORIZONTAL-IZQUIERDA--------------------------------------------------
        for (int i = xStart, j= yStart; i >= 0; i--)
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront04 == true)
            {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && i != xStart)
                {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront04 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (xPositionLimits != -1)
                    {
                        for (int x = xStart, y = yStart; x > xPositionLimits; x--)
                        {
                            if (x != xStart)
                            {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                                //System.out.println("isPieceInFront04: Valor en Rook con LIMITES X: " + x + " Y: " + y);
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront04 == true)
        {
            for (int i = xStart, j= yStart; i >= 0; i--)
            {
                if (i != xStart)
                {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                    //System.out.println("isPieceInFront04: Valor en Rook sin LIMITES X: " + i + " Y: " + j);
                }
            }
        }
        //------------------------------------------------------------------------------------------------------

        int [][] drawPath = new int[2][contSizeColumn2DArrayWithLimits + contSizeColumn2DArraywithoutLimits];
        //System.out.println("drawPath--- first: " + contSizeColumn2DArrayWithLimits + " second: " + contSizeColumn2DArraywithoutLimits);
        contSizeColumn2DArrayWithLimits = 0;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (sizeOfDrawRookMovement[i][j] == 1)
                {
                    drawPath[0][contSizeColumn2DArrayWithLimits] = i;
                    drawPath[1][contSizeColumn2DArrayWithLimits] = j;
                    //System.out.println("ROOK: " + contSizeColumn2DArrayWithLimits +  " Move in X: " + drawPath[0][contSizeColumn2DArrayWithLimits] + " Y: " + drawPath[1][contSizeColumn2DArrayWithLimits]);
                    contSizeColumn2DArrayWithLimits += 1;
                }
            }
        }
        contSizeColumn2DArraywithoutLimits = contSizeColumn2DArrayWithLimits;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (arrayWithoutLimitsDrawRookMovement[i][j] == 1)
                {
                    drawPath[0][contSizeColumn2DArraywithoutLimits] = i;
                    drawPath[1][contSizeColumn2DArraywithoutLimits] = j;
                    //System.out.println("2ROOK: " + contSizeColumn2DArraywithoutLimits +  " Move in X: " + drawPath[0][contSizeColumn2DArraywithoutLimits] + " Y: " + drawPath[1][contSizeColumn2DArraywithoutLimits]);
                    contSizeColumn2DArraywithoutLimits += 1;
                }
            }
        }
        for (int i = 0; i < drawPath[0].length; i++)
        {
            //System.out.println("ROOK-- X: " + drawPath[0][i] + " Y: " + drawPath[1][i]);
        }
        return drawPath;
    }
}
