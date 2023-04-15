package Pieces;

import GUI.ChessBoardGUI;

public class Queen extends PieceMovement
{

    public Queen(int xStart, int yStart)
    {
        super(xStart, yStart);
    }

    @Override
    public int[][] PathFinding() {
        boolean isPieceInFront01 = true;
        boolean isPieceInFront02 = true;
        boolean isPieceInFront03 = true;
        boolean isPieceInFront04 = true;
        int[][] sizeOfDrawRookMovement = new int[8][8];
        int[][] arrayWithoutLimitsDrawRookMovement = new int[8][8];
        int contSizeColumn2DArrayWithLimits = 0;
        int contSizeColumn2DArraywithoutLimits = 0;
        //-ROOK METHOD-

        //-----------------------------------VERTICAL-ABAJO ----------------------------------------------------
        for (int i = xStart, j = yStart; j < 8; j++) //VERTICAL-ABAJO WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront01) {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && j != yStart) {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront01 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (yPositionLimits != -1) {
                        for (int x = xStart, y = yStart; y < yPositionLimits; y++) {
                            if (y != yStart) {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                                //System.out.println("QUEEN(Vertical-Abajo With limits,isPieceInFront01)-- valor X: " + x + " y: " + y);
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront01 == true) {
            for (int i = xStart, j = yStart; j < 8; j++) //VERTICAL-ABAJO WITHOUT LIMITS
            {
                if (j != yStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                    //System.out.println("QUEEN(Vertical-Abajo Without limits)-- valor X: " + i + " y: " + j);
                }
            }
        }

        //-------------------------------------VERTICAL - ARRIBA---------------------------------------------------
        for (int i = xStart, j = yStart; j >= 0; j--) {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront02 == true) {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && j != yStart) {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront02 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (yPositionLimits != -1) {
                        for (int x = xStart, y = yStart; y > yPositionLimits; y--) {
                            if (y != yStart) {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront02 == true) {
            for (int i = xStart, j = yStart; j >= 0; j--) {
                if (j != yStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                }
            }
        }
        //-------------------------------------HORIZONTAL - DERECHA-----------------------------------------------
        for (int i = xStart, j = yStart; i < 8; i++) {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront03 == true) {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && i != xStart) {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront03 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (xPositionLimits != -1) {
                        for (int x = xStart, y = yStart; x < xPositionLimits; x++) {
                            if (x != xStart) {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;

                            }
                        }
                    }
                }
            }
        }

        if (isPieceInFront03 == true) {
            for (int i = xStart, j = yStart; i < 8; i++) {
                if (i != xStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                }

            }
        }
        //-------------------------------------HORIZONTAL-IZQUIERDA----------------------------------------------
        for (int i = xStart, j = yStart; i >= 0; i--) {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (isPieceInFront04 == true) {
                if (ChessBoardGUI.getPiece(i * 64, j * 64) != null && i != xStart) {
                    xPositionLimits = i;
                    yPositionLimits = j;
                    isPieceInFront04 = false;
                    sizeOfDrawRookMovement[i][j] = 1;
                    contSizeColumn2DArrayWithLimits += 1;
                    if (xPositionLimits != -1) {
                        for (int x = xStart, y = yStart; x > xPositionLimits; x--) {
                            if (x != xStart) {
                                sizeOfDrawRookMovement[x][y] = 1;
                                contSizeColumn2DArrayWithLimits += 1;
                                //System.out.println("QUEEN(Vertical-Abajo With limits,isPieceInFront04)-- valor X: " + x + " y: " + y);
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront04 == true) {
            for (int i = xStart, j = yStart; i >= 0; i--) {
                if (i != xStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[i][j] = 1;
                    //System.out.println("QUEEN(Vertical-Abajo Without limits,isPieceInFront04)-- valor X: " + i + " y: " + j);
                }
            }
        }
        //-------------------------------------------------------------------------------------------------------
        //-BISHOP METHOD-
        isPieceInFront01 = true;
        isPieceInFront02 = true;
        isPieceInFront03 = true;
        isPieceInFront04 = true;

        //-----------------------------DERECHA - ARRIBA--------------------------------------------------------
        for (int x = xStart, y = yStart; (x < 8 && y >= 0); x++, y--) //DERECHA-ARRIBA WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (ChessBoardGUI.getPiece(x * 64, y * 64) != null && x != xStart && y != yStart) {
                if (isPieceInFront01 == true) {
                    xPositionLimits = x;
                    yPositionLimits = y;
                    contSizeColumn2DArrayWithLimits += 1;
                    sizeOfDrawRookMovement[x][y] = 1;
                    isPieceInFront01 = false;
                    if (xPositionLimits != -1 && yPositionLimits != -1) {
                        for (int i = xStart, j = yStart; (i < xPositionLimits && j > yPositionLimits); i++, j--) {
                            if (i != xStart && j != yStart) {
                                contSizeColumn2DArrayWithLimits += 1;
                                sizeOfDrawRookMovement[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront01) {
            for (int x = xStart, y = yStart; (x < 8 && y >= 0); x++, y--) //DERECHA-ARRIBA WITHOUT LIMITS
            {
                if (ChessBoardGUI.getPiece(x * 64, y * 64) == null && x != xStart && y != yStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[x][y] = 1;
                }
            }
        }
        //-----------------------------------------------DERECHA-ABAJO------------------------------------------
        for (int x = xStart, y = yStart; (x < 8 && y < 8); x++, y++) //DERECHA-ABAJO WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (ChessBoardGUI.getPiece(x * 64, y * 64) != null && x != xStart && y != yStart) {
                if (isPieceInFront02) {
                    xPositionLimits = x;
                    yPositionLimits = y;
                    contSizeColumn2DArrayWithLimits += 1;
                    sizeOfDrawRookMovement[x][y] = 1;
                    isPieceInFront02 = false;
                    if (xPositionLimits != -1 && yPositionLimits != -1) {
                        for (int i = xStart, j = yStart; (i < xPositionLimits && j < yPositionLimits); i++, j++) {
                            if (i != xStart && j != yStart) {
                                contSizeColumn2DArrayWithLimits += 1;
                                sizeOfDrawRookMovement[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront02 == true) {
            for (int x = xStart, y = yStart; (x < 8 && y < 8); x++, y++)  //DERECHA-ABAJO WITHOUT LIMITS
            {
                if (ChessBoardGUI.getPiece(x * 64, y * 64) == null && x != xStart && y != yStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[x][y] = 1;
                }
            }
        }

        //---------------------------------------IZQUIERDA-ARRIBA(CONTADOR)--------------------------------------
        for (int x = xStart, y = yStart; (x >= 0 && y >= 0); x--, y--) //IZQUIERDA-ARRIBA WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (ChessBoardGUI.getPiece(x * 64, y * 64) != null && x != xStart && y != yStart) {
                if (isPieceInFront03) {
                    xPositionLimits = x;
                    yPositionLimits = y;
                    contSizeColumn2DArrayWithLimits += 1;
                    sizeOfDrawRookMovement[x][y] = 1;
                    isPieceInFront03 = false;
                    if (xPositionLimits != -1 && yPositionLimits != -1) {
                        for (int i = xStart, j = yStart; (i > xPositionLimits && j > yPositionLimits); i--, j--) {
                            if (i != xStart && j != yStart) {
                                contSizeColumn2DArrayWithLimits += 1;
                                sizeOfDrawRookMovement[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront03) {
            for (int x = xStart, y = yStart; (x >= 0 && y >= 0); x--, y--) //IZQUIERDA-ARRIBA WITHOUT LIMITS
            {
                if (ChessBoardGUI.getPiece(x * 64, y * 64) == null && x != xStart && y != yStart) {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[x][y] = 1;
                }
            }
        }
        //------------------------------------------IZQUIERDA-ABAJO-----------------------------------------------
        for (int x = xStart, y = yStart; (x >= 0 && y < 8); x--, y++) //IZQUIERDA-ABAJO WITH LIMITS
        {
            int xPositionLimits = -1;
            int yPositionLimits = -1;
            if (ChessBoardGUI.getPiece(x * 64, y * 64) != null && x != xStart && y != yStart) {
                if (isPieceInFront04) {
                    xPositionLimits = x;
                    yPositionLimits = y;
                    contSizeColumn2DArrayWithLimits += 1;
                    sizeOfDrawRookMovement[x][y] = 1;
                    isPieceInFront04 = false;
                    if (xPositionLimits != -1 && yPositionLimits != -1) {
                        for (int i = xStart, j = yStart; (i > xPositionLimits && j < yPositionLimits); i--, j++) {
                            if (i != xStart && j != yStart) {
                                contSizeColumn2DArrayWithLimits += 1;
                                sizeOfDrawRookMovement[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        if (isPieceInFront04)
        {
            for (int x = xStart,  y = yStart;(x >= 0 && y < 8); x--, y++) //IZQUIERDA-ABAJO WITHOUT LIMITS
            {
                if (ChessBoardGUI.getPiece(x * 64, y * 64) == null && x != xStart && y != yStart)
                {
                    contSizeColumn2DArraywithoutLimits += 1;
                    arrayWithoutLimitsDrawRookMovement[x][y] = 1;
                }
            }
        }
        //--------------------------------------------------------------------------------------------------------
        int [][] drawPath = new int[2][contSizeColumn2DArrayWithLimits + contSizeColumn2DArraywithoutLimits];
        contSizeColumn2DArrayWithLimits = 0;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (sizeOfDrawRookMovement[i][j] == 1)
                {
                    drawPath[0][contSizeColumn2DArrayWithLimits] = i;
                    drawPath[1][contSizeColumn2DArrayWithLimits] = j;
                    contSizeColumn2DArrayWithLimits += 1;
                    //System.out.println("Queen(01)-- X: " + i + " Y: " + j);
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
                    contSizeColumn2DArraywithoutLimits += 1;
                    //System.out.println("Queen(02)-- X: " + i + " Y: " + j);
                }
            }
        }
        return drawPath;
    }
}
