package Chess;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board {

    public GridPane board;
    private ArrayList<Square> squares;


    public Board(GridPane board){

        this.board = board;
        board.setPrefSize(750, 750);
        this.squares = new ArrayList<>();
        makeBoard();
        addPieces();
        
    }

    
    //metode for å lage brettet
    public void makeBoard(){

        int n = 1;

        //bruker to for-løkker for å opprette et 8x8 grid
        for (int i = 0; i < 8; i++) {

            int unicodeStart = 104;

            for (int j = 0; j < 8; j++) {

                //opretter en ny Square (med border) for hver ny rute på brettet. Legger deretter til Square
                Square square = new Square(j,i);
                square.setPrefHeight(100);
                square.setPrefWidth(100);
                square.setCoordinates((char)unicodeStart, i);
                unicodeStart --;
                square.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                // square.setCharacters(j, i);
                

                //legger til farge på annenhver rute
                if (n % 2 == 0){
                    square.setBackground(new Background(new BackgroundFill(Color.SIENNA, null, null)));
                }
                else if(n % 2 != 0){
                    square.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, null, null)));
                }
                n++;

                board.add(square, j, i);
                squares.add(square);
            }
            n++;
        }
    }



    public void addPiece(Square square, Piece piece){
        square.getChildren().add(piece);
        square.isOccupied();
    }



    //legger til brikker
    public void addPieces(){

        
        for (Square square : squares){


            //setter hvite brikker
            if (square.getY() == 6){
                Pawn piece = new Pawn("White", square.getX(), square.getY(), "Pawn");
                piece.setImage(new Image("pieces/whitePawn.png"));
                addPiece(square, piece);
                
            }

            if (square.getY() == 7){

                if (square.getX() == 0 || square.getX() == 7){
                    Rook piece = new Rook("White", square.getX(),square.getY(), "Rook");
                    piece.setImage(new Image("pieces/whiteRook.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 2 || square.getX() == 5){
                    Bishop piece = new Bishop("White", square.getX(),square.getY(), "Bishop");
                    piece.setImage(new Image("pieces/whiteBishop.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 1 || square.getX() == 6){
                    Knight piece = new Knight("White", square.getX(),square.getY(), "Knight");
                    piece.setImage(new Image("pieces/whiteKnight.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 3) {
                    Queen piece = new Queen("White", square.getX(),square.getY(), "Queen");
                    piece.setImage(new Image("pieces/whiteQueen.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 4) {
                    King piece = new King("White", square.getX(),square.getY(), "King");
                    piece.setImage(new Image("pieces/whiteKing.png"));
                    addPiece(square, piece);
                }
            }





            //setter svarte brikker
            if (square.getY() == 1){
                Pawn piece = new Pawn("Black",square.getX(),square.getY(), "Pawn");
                piece.setImage(new Image("pieces/blackPawn.png"));
                addPiece(square, piece);
            }

            if (square.getY() == 0){

                if (square.getX() == 0 || square.getX() == 7){
                    Rook piece = new Rook("Black",square.getX(),square.getY(), "Rook");
                    piece.setImage(new Image("pieces/blackRook.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 2 || square.getX() == 5){
                    Bishop piece = new Bishop("Black",square.getX(),square.getY(), "Bishop");
                    piece.setImage(new Image("pieces/blackBishop.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 1 || square.getX() == 6){
                    Knight piece = new Knight("Black",square.getX(),square.getY(), "Knight");
                    piece.setImage(new Image("pieces/blackKnight.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 3) {
                    Queen piece = new Queen("Black",square.getX(),square.getY(), "Queen");
                    piece.setImage(new Image("pieces/blackQueen.png"));
                    addPiece(square, piece);
                }
                if (square.getX() == 4) {
                    King piece = new King("Black",square.getX(),square.getY(), "King");
                    piece.setImage(new Image("pieces/blackKing.png"));
                    addPiece(square, piece);
                }
            }            
        }
    }  



    public ArrayList<Square> getSquares(){
        return this.squares;
    }

}
    
