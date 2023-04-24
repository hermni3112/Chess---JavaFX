package Chess;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Game {
    
    public static Board b;
    public static Piece currentPiece;
    public static String currentPlayer;
    private boolean game;
    private boolean checked;
    private FileWriter writer;


    public Game(GridPane board){

        b = new Board(board);
        currentPlayer = "White";
        currentPiece = null;
        addActionHandler(b.board);
        this.game = true;
        this.checked = false;
        this.writer = new FileWriter();
        
    }

    

    public void addActionHandler(GridPane board){


        board.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent target){

                

                EventTarget clickedOn = target.getTarget();

                
                //trykket på en rute
                if (clickedOn.toString() == "Square"){

                    Square square = (Square) clickedOn;
                    
                    

                    if (square.Occupied()){
                        Piece newPiece = (Piece) square.getChildren().get(0);
                        
                        if (currentPiece == null){
                            currentPiece = newPiece;
                            
                            if (!currentPiece.getColor().equals(currentPlayer)){
                                currentPiece = null;
                                return;
                            }
                            selectPiece(game, square);
                        }

                        else {
                            if (currentPiece.getColor().equals(newPiece.getColor())){
                                deselectPiece(false, square);
                                currentPiece = newPiece;
                                selectPiece(game, square);
                            }

                            else {
                                killPiece(square);
                                
                            }
                        }
                    }
                    else {
                        
                        dropPiece(square);
                        
                    }
                }



                //trykket på en brikke
                else {

                    Piece newPiece = (Piece) clickedOn;
                    Square square = (Square) newPiece.getParent();
                    
                    
                    if (currentPiece == null){
                        currentPiece = newPiece;
                        
                        
                        if (!currentPiece.getColor().equals(currentPlayer)){
                            currentPiece = null;
                            return;
                        }

                        selectPiece(game, square);
                    }

                    else {
                        if (currentPiece.getColor().equals(newPiece.getColor())){
                            deselectPiece(false, square);
                            currentPiece = newPiece;
                            selectPiece(game, square);
                        }

                        else {
                            killPiece(square);
                            
                        }
                    }
                }
                
            }
            
        });
        
        
    }
    

    public void selectPiece(boolean game, Square square){

        //Sjekker om spillet er slutt
        if(!game){
            currentPiece = null;
            return;
        }

        //legger til skygge når man trykker på en brikke
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setColor(javafx.scene.paint.Color.BLACK);

        
        currentPiece.setEffect(dropShadow);

        Insets pos = new Insets(0, 7, 10, 0);
        square.movePosOfPieceOnSquare(currentPiece, pos);


        currentPiece.getAllPossibleMoves();
        System.out.println(currentPiece.possibleMoves);
        
    }

    

    public void deselectPiece(boolean changePlayer, Square square){
        //sjekker om spillet er satt i sjakk
        if (currentPiece.checkedOpponent()){
            checked = true;
            System.out.println("checked: " + checked );
        }

        Insets pos = new Insets(0, 0, 0, 0);
        square.movePosOfPieceOnSquare(currentPiece, pos);

        currentPiece.setEffect(null);
        currentPiece = null;
        if (changePlayer){
            currentPlayer = currentPlayer.equals("White") ? "Black" : "White";
        }
        GamesFileReader.addMoveToScore();

    }


    public void dropPiece(Square square){

        if(!currentPiece.possibleMoves.contains(square.getName())) return;

       
        Square initSquare = (Square) currentPiece.getParent();
        initSquare.isNotOccupied();
        square.getChildren().add(currentPiece);
        initSquare.getChildren().removeAll();
        square.isOccupied();
        currentPiece.setPositionX(square.getX());
        currentPiece.setPositionY(square.getY());
        
        writer.setSquare(square);
        writer.addMove();
        
        
        
        deselectPiece(true, square);
    }

    public void killPiece(Square square){

        
        Piece killedPiece = (Piece) square.getChildren().get(0);
        Square initSquare = (Square) currentPiece.getParent();
        
        if (!currentPiece.possibleMoves.contains(square.getName())) return;



        if (killedPiece.getName() == "King"){
            this.game = false;
        }

        writer.takePiece(currentPiece, killedPiece, square, currentPlayer);

        square.getChildren().remove(0);
        square.getChildren().addAll(currentPiece);
        square.isOccupied();
        initSquare.getChildren().removeAll();
        initSquare.isNotOccupied();
        currentPiece.setPositionX(square.getX()); 
        currentPiece.setPositionY(square.getY());
        deselectPiece(true, square);
        // GamesFileReader.addMoveToScore();
    }



    public String getCurrentPlayer() {
        return currentPlayer;
    }
     
    public Piece getCurrentPiece(){
        return currentPiece;
    }
}