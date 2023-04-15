package Pieces;

import java.util.ArrayList;

public abstract class PieceMovement
{
    int xStart,yStart;
    public PieceMovement(int xStart,int yStart)
    {
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public abstract int [][] PathFinding();
}
