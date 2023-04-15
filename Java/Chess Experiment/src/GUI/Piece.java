package GUI;

import Pieces.*;

import java.util.LinkedList;

public  class Piece {
    public int xp, yp;
    public boolean iswhite;
    LinkedList<Piece> ps;
    public String name;
    public int x, y;
    //Bishop Class
    Bishop bishop;
    public LinkedList<Bishop> bish;
    //Pawn Class
    Pawn pawn;
    //ROOK class
    Rook rook;
    //QUEEN
    Queen queen;
    //KNIGHT
    Knight knight;
    //KING
    King king;
    public Piece(int x, int y, boolean iswhite, LinkedList<Piece> ps, String n) {
        this.xp = x;
        this.yp = y;
        this.iswhite = iswhite;
        this.ps = ps;
        this.name = n;
        bish = new LinkedList<>();
        this.x = xp * 64;
        this.y = yp * 64;
        ps.add(this);
    }

    public void move(int xp, int yp)
    {

        if (ChessBoardGUI.indexIsPiece == 0) //Rook
        {
            RookMovement(xp,yp);
        }
        else if (ChessBoardGUI.indexIsPiece == 1) //Knight
        {
            KnightMovement(xp,yp);
        }
        else if (ChessBoardGUI.indexIsPiece == 2) //Bishop
        {
            BishopMovement(xp,yp);

        }
        else if (ChessBoardGUI.indexIsPiece == 3) //Queen
        {
            QueenMovement(xp,yp);
        }
        else if (ChessBoardGUI.indexIsPiece == 4) //King
        {
            KingMovement(xp, yp);
        }
        else if (ChessBoardGUI.indexIsPiece == 5) //Pawn
        {
            PawnMovement(xp,yp);
        }
    }

    //Codigo usado para hacer el movimiento mas complejo
        /*if (ChessBoardGUI.getPiece(xp*64,yp*64) != null)
        {
            if (ChessBoardGUI.getPiece(xp*64,yp*64).iswhite != iswhite)
            {
                ChessBoardGUI.getPiece(xp*64,yp*64).kill();
            }
            else
            {
                x = this.xp * 64;
                y = this.yp * 64;
                return;
            }

        }
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;


    }*/
    public void kill() {
        ps.remove(this);
    }

    public void BishopMovement(int xp, int yp)
    {
        bishop = new Bishop(xp, yp, bish);
        if (bishop.PathFinding() != null)
        {
            for (int i = 0; i < ChessBoardGUI.drawSizeLimitsPiece[0].length; i++) {
                if (ChessBoardGUI.drawSizeLimitsPiece != null)
                {
                    if (ChessBoardGUI.drawSizeLimitsPiece[0][i] == xp && ChessBoardGUI.drawSizeLimitsPiece[1][i] == yp) {

                        if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null) {
                            if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite)
                            {
                                ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                            } else
                            {
                                x = this.xp * 64;
                                y = this.yp * 64;
                                return;

                            }
                        }
                        System.out.println("");
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        System.out.println("X: " + x / 64 + " Y: " + y / 64);
                        return;
                    }

                }

            }


        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;
    }

    public void RookMovement(int xp, int yp)
    {
        rook = new Rook(xp,yp);
        if (rook.PathFinding() != null)
        {
            for (int i = 0; i < ChessBoardGUI.arrayLocalPositionRook[0].length; i++)
            {
                if (ChessBoardGUI.arrayLocalPositionRook != null)
                {
                    if (ChessBoardGUI.arrayLocalPositionRook[0][i] == xp && ChessBoardGUI.arrayLocalPositionRook[1][i] == yp)
                    {
                        if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null)
                        {
                            if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite)
                            {
                                ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                            }
                            else
                            {
                                x = this.xp * 64;
                                y = this.yp * 64;
                                return;
                            }
                        }
                        System.out.println("");
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        System.out.println("X: " + x / 64 + " Y: " + y / 64);
                        return;
                    }
                }
            }
        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;
    }
    public void PawnMovement(int xp, int yp)
    {
        pawn = new Pawn(xp,yp);
        if (pawn.PathFinding() != null )
        {
            if (ChessBoardGUI.arrayLocalPositionPawn != null)
            {
                for (int i = 0; i < ChessBoardGUI.arrayLocalPositionPawn[0].length; i++)
                {
                    if (ChessBoardGUI.arrayLocalPositionPawn[0][i] == xp && ChessBoardGUI.arrayLocalPositionPawn[1][i] == yp)
                    {
                        if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null) {
                            if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite) {
                                ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                            } else {
                                x = this.xp * 64;
                                y = this.yp * 64;
                                return;

                            }
                        }

                        //System.out.println("poderoso condicional");
                        System.out.println("");
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        System.out.println("X: " + x / 64 + " Y: " + y / 64);
                        return;
                    }
                }
            }


        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;

    }

    public void QueenMovement(int xp, int yp)
    {
        queen = new Queen(xp, yp);
        if (queen.PathFinding() != null)
        {
            for (int i = 0; i < ChessBoardGUI.arrayLocalPositionQueen[0].length; i++)
            {
                if (ChessBoardGUI.arrayLocalPositionQueen != null)
                {
                 if (ChessBoardGUI.arrayLocalPositionQueen[0][i] == xp && ChessBoardGUI.arrayLocalPositionQueen[1][i] == yp)
                 {
                     if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null)
                     {
                         if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite)
                         {
                             ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                         }
                         else
                         {
                             x = this.xp * 64;
                             y = this.yp * 64;
                             return;
                         }
                     }
                     System.out.println("");
                     this.xp = xp;
                     this.yp = yp;
                     x = xp * 64;
                     y = yp * 64;
                     return;
                 }

                }
            }
        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;
    }
    public void KnightMovement(int xp, int yp)
    {
        knight = new Knight(xp,yp);
        if (ChessBoardGUI.arrayLocalPositionKnight != null)
        {
            System.out.println("pasa");
            for (int i = 0; i < ChessBoardGUI.arrayLocalPositionKnight[0].length; i++)
            {
                if (ChessBoardGUI.arrayLocalPositionKnight != null)
                {
                    if (ChessBoardGUI.arrayLocalPositionKnight[0][i] == xp && ChessBoardGUI.arrayLocalPositionKnight[1][i] == yp)
                    {
                        if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null)
                        {
                            if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite)
                            {
                                ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                            }
                            else
                            {
                                x = this.xp * 64;
                                y = this.yp * 64;
                                return;
                            }
                        }
                        System.out.println("");
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        return;
                    }
                }
            }
        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;
    }
    public void KingMovement(int xp, int yp)
    {
        king = new King(xp, yp);
        if (ChessBoardGUI.arrayLocalPositionKing != null)
        {
            for (int i = 0; i < ChessBoardGUI.arrayLocalPositionKing[0].length; i++)
            {
                if (ChessBoardGUI.arrayLocalPositionKing != null)
                {
                    if (ChessBoardGUI.arrayLocalPositionKing[0][i] == xp && ChessBoardGUI.arrayLocalPositionKing[1][i] == yp)
                    {
                        if (ChessBoardGUI.getPiece(xp * 64, yp * 64) != null)
                        {
                            if (ChessBoardGUI.getPiece(xp * 64, yp * 64).iswhite != iswhite)
                            {
                                ChessBoardGUI.getPiece(xp * 64, yp * 64).kill();
                            }
                            else
                            {
                                x = this.xp * 64;
                                y = this.yp * 64;
                                return;
                            }
                        }
                        System.out.println("");
                        this.xp = xp;
                        this.yp = yp;
                        x = xp * 64;
                        y = yp * 64;
                        return;
                    }
                }
            }
        }
        x = this.xp * 64;
        y = this.yp * 64;
        return;
    }
}
