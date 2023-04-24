package Chess;

import java.util.ArrayList;

public class King extends Piece {
    
    



    public King(String color, int positionX, int positionY, String name) {
        super(color, positionX, positionY, name);
    }

    @Override
    public void getAllPossibleMoves(){

        int x = this.getPositionX();
        int y = this.getPositionY();

        this.possibleMoves = new ArrayList<>();
        
        possibleMoves.add("Square" + (x+1) + y);
        possibleMoves.add("Square" + (x-1) + y);
        possibleMoves.add("Square" + (x) + (y+1));
        possibleMoves.add("Square" + (x) + (y-1));
        possibleMoves.add("Square" + (x+1) + (y+1));
        possibleMoves.add("Square" + (x+1) + (y-1));
        possibleMoves.add("Square" + (x-1) + (y+1));
        possibleMoves.add("Square" + (x-1) + (y-1));

    } 

    public String getName(){
        
        return this.name;
        
    }
}
