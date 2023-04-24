package Chess;

import java.util.ArrayList;


import javafx.scene.image.ImageView;


public class Piece extends ImageView implements PieceInterface{    
    
    private int positionX;
    private int positionY;
    private String color;
    protected ArrayList<String> possibleMoves;
    protected String name;
   
    

    public Piece(String color, int positionX, int positionY, String name){
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        
    }

    


    public int getPositionX() {
        return positionX;
    }


    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }


    public int getPositionY() {
        return positionY;
    }


    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    public String getColor() {
        return this.color;
    }

    


    public Square getSquareByName(String name){
        for(Square square : Game.b.getSquares()){
            if(square.getName().equals(name)){
                return square;
            }
        }

        return null;
    }

    public Piece getPieceByName(String name){
        for(Square square : Game.b.getSquares()){
            if(square.getChildren().size() == 0) continue;

            if(square.getName().equals(name))
                return (Piece) square.getChildren().get(0);

            }
        return null;
    }

    public String getName(){
        return name;
    }

    public void getAllPossibleMoves() {}


    @Override
    public boolean checkedOpponent() {

        getAllPossibleMoves();

        for (String move : possibleMoves){

            if (getPieceByName(move) != null){

                if (getPieceByName(move).getName() != "King") continue;

                if (getPieceByName(move).getName() == "King") return true;
            
            }
        }
       
        return false;

    }
}