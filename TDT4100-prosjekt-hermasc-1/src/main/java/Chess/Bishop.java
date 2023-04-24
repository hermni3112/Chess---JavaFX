package Chess;

import java.util.ArrayList;

public class Bishop extends Piece {
    
    



    public Bishop(String color, int positionX, int positionY, String name) {
        super(color, positionX, positionY, name);
    }



    @Override
    public void getAllPossibleMoves(){

        int x = this.getPositionX();
        int y = this.getPositionY();
        
        ArrayList<String> movesUpRight = new ArrayList<>();
        ArrayList<String> movesUpLeft = new ArrayList<>();
        ArrayList<String> movesDownRight = new ArrayList<>();
        ArrayList<String> movesDownLeft = new ArrayList<>();

        this.possibleMoves = new ArrayList<>();

        ArrayList<String> allMoves = new ArrayList<>();






        
        for (int i = 1; i < 8; i++) {
            
            movesUpRight.add("Square" + (x+i) + (y-i));
            allMoves.add("Square" + (x+i) + (y-i));

            movesUpLeft.add("Square" + (x-i) + (y-i));
            allMoves.add("Square" + (x-i) + (y-i));

            movesDownRight.add("Square" + (x+i) + (y+i));
            allMoves.add("Square" + (x+i) + (y+i)); 
 
            movesDownLeft.add("Square" + (x-i) + (y+i));
            allMoves.add("Square" + (x-i) + (y+i));       
       

        }

        for (String move : movesUpRight){
            

            
            if (getSquareByName(move) != null){

                possibleMoves.add(move);
                
                if(getSquareByName(move).Occupied()) break;
            }
        }

        for (String move : movesUpLeft){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
    
                if (getSquareByName(move).Occupied()) break;
            }
        }

        for (String move : movesDownRight){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
    
                if (getSquareByName(move).Occupied()) break;
            }
        }

        for (String move : movesDownLeft){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
    
                if (getSquareByName(move).Occupied()) break;
            }
        }
    }



    @Override
    public String getName() {
       
        return this.name;
    }       
}
