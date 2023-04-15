package GUI;

import Pieces.*;
import StructureChessBoard.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;
import javax.imageio.ImageIO;

public class ChessBoardGUI
{
    //UI
    public static LinkedList<Piece> ps = new LinkedList<>(); //This list of the class Piece is used for all the inputs we need to draw the pieces
    public static Piece selectedPiece = null;
    public static Piece selected = null;
    public static int posX,posY;
    public static int indexIsPiece;
    //Class Bishop
    static Bishop bishop;
    public static Bishop bishop2;
    static Type typeOfPiece = Type.bishop;
    public static LinkedList<Bishop> bish = new LinkedList<>();
    static int [][] drawSizeLimitsPiece;
    //Class Pawn
    public static Pawn pawn;
    public static int [][] arrayLocalPositionPawn;
    //Class Knight
    public static Knight knight;

    public static int [][] arrayLocalPosition;
    static boolean isPresstoColor = false;

    //Class ROOK
    public static Rook rook;
    public static int [][] arrayLocalPositionRook;

    //Class Queen
    public static Queen queen;
    public static int [][] arrayLocalPositionQueen;

    //Class Knight
    public static int [][] arrayLocalPositionKnight;

    //Class King
    public static King king;
    public static int [][] arrayLocalPositionKing;

    public static void main(String[] args) throws IOException
    {

        //Add in an array of Images all the images of the pieces
        BufferedImage all = ImageIO.read(new File("D:\\Programming\\Java\\Chess Experiment\\chess.png"));
        Image image[] = new Image[12];
        int ind = 0;


        for (int y = 0; y < 400; y+=200) //This two for we need it to know where we want to cut the pieces in all the image
        {
            for (int x = 0; x< 1200; x += 200)
            {
                //We add in the images´ array the pieces with the function getSubimage
                image[ind] = all.getSubimage(x,y,200,200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        JFrame frame = new JFrame();
        frame.setBounds(10,10,512,512); //We design all the screen in squares with this function, 10x10, width and height of all the screen
        frame.setUndecorated(true);
        JPanel pn = new JPanel() //Colored all the screen as a chessboard with this function
        {
            boolean isWhite = true;
            int contTimes = 0;
            @Override
            public void paint(Graphics g)
            {
                for (int y = 0; y < 8; y++)
                {
                    for (int x = 0; x < 8; x++)
                    {
                        if (isWhite)
                        {
                            g.setColor(Color.white.brighter());
                        }
                        else
                        {
                            g.setColor(Color.gray.darker());

                        }
                        g.fillRect(x * 64,y * 64, 64,64);
                        isWhite =! isWhite;

                        if (isPresstoColor) //This conditional paint in blue in the sqares which the Bishop can be placed
                        {

                            g.setColor(Color.CYAN);

                            if (indexIsPiece == 0) //ROOK
                            {
                                for (int i = 0; i < arrayLocalPositionRook[0].length; i++)
                                {
                                    g.fillRect(arrayLocalPositionRook[0][i] * 64, arrayLocalPositionRook[1][i] * 64, 64, 64);
                                }
                            }
                            else if (indexIsPiece == 1) //KNIGHT
                            {
                                for (int i = 0; i < arrayLocalPositionKnight[0].length; i++)
                                {
                                    g.fillRect(arrayLocalPositionKnight[0][i] * 64, arrayLocalPositionKnight[1][i] * 64, 64, 64);
                                }
                            }
                            else if (indexIsPiece == 2) //BISHOP
                            {
                                for (int i = 0; i < drawSizeLimitsPiece[0].length  ; i++)
                                {
                                    //System.out.println("In I: " + i + " Draw Value in X: " + drawSizeLimitsPiece[0][i] + " Y: " + drawSizeLimitsPiece[1][i]);
                                    g.fillRect(drawSizeLimitsPiece[0][i] * 64,drawSizeLimitsPiece[1][i] * 64,64,64);
                                }
                            }
                            else if (indexIsPiece == 3) //QUEEN
                            {
                                for (int i = 0; i < arrayLocalPositionQueen[0].length; i++)
                                {
                                    g.fillRect(arrayLocalPositionQueen[0][i] * 64, arrayLocalPositionQueen[1][i] * 64, 64,64);
                                }
                            }
                            else if (indexIsPiece == 4) //KING
                            {
                                for (int i = 0; i < arrayLocalPositionKing[0].length; i++)
                                {
                                    g.fillRect(arrayLocalPositionKing[0][i] * 64, arrayLocalPositionKing[1][i] * 64,64,64);
                                }
                            }
                            else if (indexIsPiece == 5) //PAWN
                            {
                                for (int i = 0; i < pawn.PathFinding()[0].length; i++)
                                {
                                    g.fillRect(pawn.PathFinding()[0][i] * 64,pawn.PathFinding()[1][i] * 64,64,64);
                                }

                            }
                        }

                    }
                    isWhite =! isWhite;
                }
                for(Piece p : ps ) //Add all the pieces in the chessboard
                {
                    int ind = 0;
                    if(p.name.equals("king"))
                    {
                        ind = 0;
                    }
                    if(p.name.equals("queen"))
                    {
                        ind = 1;
                    }
                    if(p.name.equals("bishop"))
                    {
                        ind = 2;
                    }
                    if(p.name.equals("knight"))
                    {
                        ind = 3;
                    }
                    if(p.name.equals("rook"))
                    {
                        ind = 4;
                    }
                    if(p.name.equals("pawn"))
                    {
                        ind = 5;
                    }
                    if (!p.iswhite)
                    {
                        ind +=6;
                    }
                    g.drawImage(image[ind],p.x ,p.y, this);
                }
            }
        };
        frame.add(pn);
        selectedPiece();
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (selectedPiece != null)
                {
                    selectedPiece.x = e.getX() - 32;
                    selectedPiece.y = e.getY() - 32;
                    frame.repaint();

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {

                //System.out.println((getPiece(e.getX(),e.getY()).iswhite?"white ": "black ") + getPiece(e.getX(), e.getY()).name);
                isPresstoColor =! isPresstoColor; //Boolean that shows when the color in the method paint is colored in blue
                selectedPiece = getPiece(e.getX(),e.getY());
                //Getting the position X and Y when the player pushed
                posX = e.getX()/64;
                posY = e.getY()/64;
                //Bishop Initialization
                bishop = new Bishop(posX,posY,bish);
                bishop2 = new Bishop(posX,posY,bish);
                int [][] bishopMovementWithLimits;
                int [][] bishopMovementWithLimits02;
                int contSizeColumnLimitsBishop = 0;
                int contSizeColumnWithoutLimitsBishop = 0;
                //Pawn Initialization
                pawn = new Pawn(posX,posY);
                //ROOK Initialization
                rook = new Rook(posX,posY);
                //QUEEN Inicialization
                queen = new Queen(posX,posY);
                //KNIGHT Inicialization
                knight = new Knight(posX,posY);
                //KING Inicialization
                king = new King(posX,posY);
                //This code express the color where the piece can be and the type of piece is pushed by player
                String namePiece = getPiece(e.getX(),e.getY()).name.toString();
                String namePieceType = typeOfPiece.toString();
                indexIsPiece = isPiece(namePiece); //It was used as an index to know which piece is being pushed
                //System.out.println("Nombre de la pieza: " + namePiece);
                //System.out.println("Nombre de la tipo Pieza: " + namePieceType.toLowerCase());

                if (indexIsPiece == 2) //BISHOP
                {
                    boolean contLimitsSize01 = true;
                    boolean contLimitsSize02 = true;
                    boolean contLimitsSize03 = true;
                    boolean contLimitsSize04 = true;

                    if (bishop.PathFinding() != null) //just to show all the places the Bishop can be placed
                    {
                        arrayLocalPosition = new int[2][bishop.PathFinding()[0].length];
                        for (int i = 0; i < bishop.PathFinding()[0].length ; i++ )
                        {
                            arrayLocalPosition[0][i] = bishop.PathFinding()[0][i];
                            arrayLocalPosition[1][i] = bishop.PathFinding()[1][i];
                        }
                        //--------------------------------------------------------------------------------
                        int [][] array2DWithLimitsPiece = new int[8][8];
                        int [][] array2DWithoutLimitsPiece =  new int[8][8];
                        for (int i = 0, j = 0;(i < 8 && j < 8); i++,j++)
                        {
                            array2DWithLimitsPiece[i][j] = 0;
                            array2DWithoutLimitsPiece[i][j] = 0;
                        }

                        //-------------------------DERECHA-ARRIBA(CONTADOR)--------------------------------------

                        for (int x = posX,  y = posY;(x < 8 && y >= 0); x ++, y --) //DERECHA-ARRIBA WITH LIMITS
                        {
                            int xPositionLimits = -1;
                            int yPositionLimits = -1;

                            if (getPiece(x * 64, y * 64) != null && x != posX && y != posY)
                            {
                                if (contLimitsSize01 == true) //Additional Code = && getPiece(x * 64, y * 64).iswhite
                                {
                                    contSizeColumnLimitsBishop += 1;
                                    xPositionLimits= x;
                                    yPositionLimits = y;
                                    array2DWithLimitsPiece[x][y] = 1;

                                    if (xPositionLimits != -1 && yPositionLimits != -1)
                                    {
                                        for (int i = posX, j = posY; (i < xPositionLimits && j > yPositionLimits); i++, j--)
                                        {
                                            if (i != posX && j != posY)
                                            {
                                                contSizeColumnLimitsBishop += 1;
                                                array2DWithLimitsPiece[i][j] = 1;
                                                //System.out.println("Valor WITH LIMITS X: " + i + " Y: " + j);
                                            }

                                        }
                                    }
                                    contLimitsSize01 = false;
                                }
                            }

                        }
                        if (contLimitsSize01 == true)
                        {
                            for (int x = posX,  y = posY;(x < 8 && y >= 0); x ++, y --) //DERECHA-ARRIBA WITHOUT LIMITS
                            {
                                if (getPiece(x * 64, y * 64) == null && x != posX && y != posY)
                                {
                                    array2DWithoutLimitsPiece[x][y] = 1;
                                    contSizeColumnWithoutLimitsBishop += 1;
                                    //System.out.println("Valor en WITHOUT LIMITS x: " + x + " Y: " + y);
                                }
                            }
                        }

                        //-----------------------------DERECHA-ABAJO(CONTADOR)--------------------------------------------------
                        for (int x = posX,  y = posY;(x < 8 && y < 8); x++, y++) //DERECHA-ABAJO WITH LIMITS
                        {
                            int xPositionLimits = -1;
                            int yPositionLimits = -1;

                            if (getPiece(x * 64, y * 64) != null && x != posX && y != posY)
                            {
                                if (contLimitsSize02)
                                {
                                    contSizeColumnLimitsBishop += 1;
                                    xPositionLimits= x;
                                    yPositionLimits = y;
                                    array2DWithLimitsPiece[x][y] = 1;

                                    if (xPositionLimits != -1 && yPositionLimits != -1)
                                    {
                                        for (int i = posX, j = posY; (i < xPositionLimits && j < yPositionLimits); i++, j++)
                                        {
                                            if (i != posX && j != posY)
                                            {
                                                contSizeColumnLimitsBishop += 1;
                                                array2DWithLimitsPiece[i][j] = 1;
                                                //System.out.println("Valor WITH LIMITS X: " + i + " Y: " + j);
                                            }

                                        }
                                    }
                                    contLimitsSize02 = false;
                                }
                            }

                        }

                        if (contLimitsSize02 == true)
                        {
                            for (int x = posX,  y = posY;(x < 8 && y < 8); x++, y++)  //DERECHA-ABAJO WITHOUT LIMITS
                            {
                                if (getPiece(x * 64, y * 64) == null && x != posX && y != posY)
                                {
                                    array2DWithoutLimitsPiece[x][y] = 1;
                                    contSizeColumnWithoutLimitsBishop += 1;
                                    //System.out.println("Valor en WITHOUT LIMITS x: " + x + " Y: " + y);
                                }
                            }
                        }
                        //----------------------------IZQUIERDA-ARRIBA(CONTADOR)----------------------------------------------
                        for (int x = posX,  y = posY ;(x >= 0  && y >= 0); x--, y--) //IZQUIERDA-ARRIBA WITH LIMITS
                        {
                            int xPositionLimits = -1;
                            int yPositionLimits = -1;

                            if (getPiece(x * 64, y * 64) != null && x != posX && y != posY)
                            {
                                if (contLimitsSize03)
                                {
                                    contSizeColumnLimitsBishop += 1;
                                    contLimitsSize03 = false;
                                    xPositionLimits= x;
                                    yPositionLimits = y;
                                    array2DWithLimitsPiece[x][y] = 1;

                                    if (xPositionLimits != -1 && yPositionLimits != -1)
                                    {
                                        for (int i = posX, j = posY; (i > xPositionLimits && j > yPositionLimits); i--, j--)
                                        {
                                            if (i != posX && j != posY)
                                            {
                                                contSizeColumnLimitsBishop += 1;
                                                array2DWithLimitsPiece[i][j] = 1;
                                                //System.out.println("Valor WITH LIMITS X: " + i + " Y: " + j);
                                            }

                                        }
                                    }

                                }
                            }
                        }

                        if (contLimitsSize03 == true)
                        {
                            for (int x = posX,  y = posY;(x >= 0 && y >= 0); x --, y --) //IZQUIERDA-ARRIBA WITHOUT LIMITS
                            {
                                if (getPiece(x * 64, y * 64) == null && x != posX && y != posY)
                                {
                                    array2DWithoutLimitsPiece[x][y] = 1;
                                    contSizeColumnWithoutLimitsBishop += 1;
                                    //System.out.println("Valor en WITHOUT LIMITS x: " + x + " Y: " + y);
                                }
                            }
                        }

                        //---------------------------------IZQUIERDA-ABAJO(CONTADOR)-------------------------------------------

                        for (int x = posX,  y = posY;(x >= 0 && y < 8); x--, y++) //IZQUIERDA-ABAJO WITH LIMITS
                        {
                            int xPositionLimits = -1;
                            int yPositionLimits = -1;
                            if (getPiece(x * 64, y * 64) != null && x != posX && y != posY)
                            {
                                if (contLimitsSize04)
                                {
                                    contSizeColumnLimitsBishop += 1;
                                    contLimitsSize04 = false;
                                    xPositionLimits= x;
                                    yPositionLimits = y;
                                    array2DWithLimitsPiece[x][y] = 1;

                                    if (xPositionLimits != -1 && yPositionLimits != -1)
                                    {
                                        for (int i = posX, j = posY; (i > xPositionLimits && j < yPositionLimits); i--, j++)
                                        {
                                            if (i != posX && j != posY)
                                            {
                                                contSizeColumnLimitsBishop += 1;
                                                array2DWithLimitsPiece[i][j] = 1;
                                                //System.out.println("Valor WITH LIMITS X: " + i + " Y: " + j);
                                            }
                                        }
                                    }

                                }
                            }

                        }
                        if (contLimitsSize04 == true)
                        {
                            for (int x = posX,  y = posY;(x >= 0 && y < 8); x--, y++) //IZQUIERDA-ABAJO WITHOUT LIMITS
                            {
                                if (getPiece(x * 64, y * 64) == null && x != posX && y != posY)
                                {
                                    array2DWithoutLimitsPiece[x][y] = 1;
                                    contSizeColumnWithoutLimitsBishop += 1;
                                }
                            }
                        }



                        //System.out.println("Size of  contSizeColumnLimitsBishop: " + contSizeColumnLimitsBishop);
                        //System.out.println("Size of contSizeColumnWithoutLimitsBishop:  " + contSizeColumnWithoutLimitsBishop);
                        //--------------------------------------------------------------------------------------
                        drawSizeLimitsPiece = new int[2][contSizeColumnLimitsBishop + contSizeColumnWithoutLimitsBishop];
                        contSizeColumnLimitsBishop = 0;
                        for (int i = 0; i < 8; i++)
                        {
                            for (int j = 0; j < 8; j++)
                            {
                                if (array2DWithLimitsPiece[i][j] == 1)
                                {
                                    drawSizeLimitsPiece[0][contSizeColumnLimitsBishop] = i;
                                    drawSizeLimitsPiece[1][contSizeColumnLimitsBishop] = j;
                                    //System.out.println("Valor en I: " + contSizeColumnLimitsBishop + " Existe en array2DWithLimitsPiece X: " + drawSizeLimitsPiece[0][contSizeColumnLimitsBishop] + " Y: " + drawSizeLimitsPiece[1][contSizeColumnLimitsBishop]);
                                    contSizeColumnLimitsBishop += 1;
                                }
                            }
                        }
                        contSizeColumnWithoutLimitsBishop = contSizeColumnLimitsBishop;

                        for (int i = 0; i < 8; i++)
                        {
                            for (int j = 0; j < 8; j++)
                            {
                                if (array2DWithoutLimitsPiece[i][j] == 1)
                                {
                                    drawSizeLimitsPiece[0][contSizeColumnWithoutLimitsBishop] = i;
                                    drawSizeLimitsPiece[1][contSizeColumnWithoutLimitsBishop] = j;
                                    //System.out.println("Existe en array2DWithoutLimitsPiece X: " + drawSizeLimitsPiece[0][contSizeColumnWithoutLimitsBishop] + " Y: " + drawSizeLimitsPiece[1][contSizeColumnWithoutLimitsBishop]);
                                    contSizeColumnWithoutLimitsBishop += 1;
                                }
                            }
                        }
                    }
                }

                if (indexIsPiece == 5) //Pawn
                {
                    if (pawn.PathFinding() != null)
                    {
                        arrayLocalPositionPawn = new int[2][pawn.PathFinding()[0].length];
                        for (int i = 0; i < pawn.PathFinding()[0].length; i++)
                        {
                            arrayLocalPositionPawn[0][i] = pawn.PathFinding()[0][i];
                            arrayLocalPositionPawn[1][i] = pawn.PathFinding()[1][i];
                            //System.out.println("Pawn: Eje X da valor de: " + pawn.PathFinding()[0][i] + " Eje Y da valor de: " + pawn.PathFinding()[1][i]);
                        }
                    }
                }
                if (indexIsPiece == 0) //ROOK
                {
                    arrayLocalPositionRook = new int[2][rook.PathFinding()[0].length];
                    for (int i = 0; i < arrayLocalPositionRook[0].length; i++)
                    {
                        arrayLocalPositionRook[0][i] = rook.PathFinding()[0][i];
                        arrayLocalPositionRook[1][i] = rook.PathFinding()[1][i];
                        //System.out.println("ROOK: Position X: " +  arrayLocalPositionRook[0][i] + " Y: " + arrayLocalPositionRook[1][i]);
                    }
                }
                if (indexIsPiece == 1) //Knight
                {
                    arrayLocalPositionKnight = new int[2][knight.PathFinding()[0].length];
                    for (int i = 0; i < knight.PathFinding()[0].length; i++)
                    {
                        arrayLocalPositionKnight[0][i] = knight.PathFinding()[0][i];
                        arrayLocalPositionKnight[1][i] = knight.PathFinding()[1][i];
                        System.out.println("KNIGHT-- X: " + arrayLocalPositionKnight[0][i] + " Y: " + arrayLocalPositionKnight[1][i]);
                    }
                }
                if (indexIsPiece == 3) //QUEEN
                {
                    arrayLocalPositionQueen = new int[2][queen.PathFinding()[0].length];
                    for (int i = 0; i < arrayLocalPositionQueen[0].length; i++)
                    {
                        arrayLocalPositionQueen[0][i] = queen.PathFinding()[0][i];
                        arrayLocalPositionQueen[1][i] = queen.PathFinding()[1][i];
                        //System.out.println("QUEEN: Position X: " + arrayLocalPositionQueen[0][i] + " Y: " + arrayLocalPositionQueen[1][i]);
                    }

                }
                if (indexIsPiece == 4) //KING
                {
                    arrayLocalPositionKing = new int[2][king.PathFinding()[0].length];
                    for (int i = 0; i < arrayLocalPositionKing[0].length; i++)
                    {
                        arrayLocalPositionKing[0][i] = king.PathFinding()[0][i];
                        arrayLocalPositionKing[1][i] = king.PathFinding()[1][i];
                        System.out.println("KING-- X: " + arrayLocalPositionKing[0][i] + " Y: " + arrayLocalPositionKing[1][i]);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                isPresstoColor =! isPresstoColor;
                selectedPiece.move(e.getX()/64,e.getY()/64);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    public static Piece getPiece(int x,int y)
    {
        int xp = x/64;
        int yp = y/64;
        for (Piece p : ps)
        {
            if (p.xp == xp && p.yp == yp)
            {
                return p;
            }
        }
        return null;
    }

    public static void selectedPiece()
    {
        //All the pieces of chess as pawn,king,etc were written here as objects of the class Piece
        Piece theRookBlack01 = new Piece(0,0,false,ps,"rook");
        Piece theKnightBlack01 = new Piece(1,0,false,ps,"knight");
        Piece thBishopBlack01 = new Piece(2,0,false,ps,"bishop");
        Piece theQueenBlack = new Piece(3,0,false,ps,"queen");
        Piece theKingBlack = new Piece(4,0,false,ps,"king");
        Piece theBishopBlack02 = new Piece(5,0,false,ps,"bishop");
        Piece theKnightBlack02 = new Piece(6,0,false,ps,"knight");
        Piece theRookBlack02 = new Piece(7,0,false,ps,"rook");
        Piece thePawnBlack01 = new Piece(0,1,false,ps,"pawn");
        Piece thePawnBlack02 = new Piece(1,1,false,ps,"pawn");
        Piece thePawnBlack03 = new Piece(2,1,false,ps,"pawn");
        Piece thePawnBlack04 = new Piece(3,1,false,ps,"pawn");
        Piece thePawnBlack05 = new Piece(4,1,false,ps,"pawn");
        Piece thePawnBlack06 = new Piece(5,1,false,ps,"pawn");
        Piece thePawnBlack07 = new Piece(6,1,false,ps,"pawn");
        Piece thePawnBlack08 = new Piece(7,1,false,ps,"pawn");

        Piece theRookWhite01 = new Piece(0,7,true,ps,"rook");
        Piece theknightWhite01 = new Piece(1,7,true,ps,"knight");
        Piece theBishopWhite01 = new Piece(2,7,true,ps,"bishop");
        Piece theQueenWhite = new Piece(3,7,true,ps,"queen");
        Piece theKingWhite = new Piece(4,4,true,ps,"king");
        Piece theBishopWhite02 = new Piece(5,7,true,ps,"bishop");
        Piece theknightWhite02 = new Piece(6,7,true,ps,"knight");
        Piece theRookWhite02 = new Piece(7,7,true,ps,"rook");
        Piece thePawnWhite01 = new Piece(0,6,true,ps,"pawn");
        Piece thePawnWhite02 = new Piece(1,6,true,ps,"pawn");
        Piece thePawnWhite03 = new Piece(2,6,true,ps,"pawn");
        Piece thePawnWhite04 = new Piece(3,6,true,ps,"pawn");
        Piece thePawnWhite05 = new Piece(4,6,true,ps,"pawn");
        Piece thePawnWhite06 = new Piece(5,6,true,ps,"pawn");
        Piece thePawnWhite07 = new Piece(6,6,true,ps,"pawn");
        Piece thePawnWhite08 = new Piece(7,6,true,ps,"pawn");

    }

    public static int isPiece(String namePiece)
    {
        int index = 0;
        Type typeOfPieceRook = Type.rook;
        Type typeOfPieceKnight = Type.knight;
        Type typeOfPieceBishop = Type.bishop;
        Type typeOfPieceQueen = Type.queen;
        Type typeOfPieceKing = Type.king;
        Type typeOfPiecePawn = Type.pawn;
        if (namePiece == typeOfPieceRook.toString())
        {
            index = 0;
        }
        else if (namePiece == typeOfPieceKnight.toString())
        {
            index = 1;
        }
        else if (namePiece == typeOfPieceBishop.toString())
        {
            index = 2;
        }
        else if(namePiece == typeOfPieceQueen.toString())
        {
            index = 3;
        }
        else if(namePiece == typeOfPieceKing.toString())
        {
            index = 4;
        }
        else if (namePiece == typeOfPiecePawn.toString())
        {
           index = 5;
        }

        return index;

    }

}
