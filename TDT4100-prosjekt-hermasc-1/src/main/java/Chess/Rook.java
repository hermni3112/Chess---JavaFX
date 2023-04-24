package Chess;

import java.util.ArrayList;

public class Rook extends Piece {

    

    public Rook(String color, int positionX, int positionY, String name) {
        super(color, positionX, positionY, name);
    }

    @Override
    public void getAllPossibleMoves(){

        int x = this.getPositionX();
        int y = this.getPositionY();

        this.possibleMoves = new ArrayList<>();
        ArrayList<String> up = new ArrayList<>();
        ArrayList<String> down = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> left = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {

            right.add("Square" + (x+i) + y);
            up.add("Square" + x + (y-i));
            left.add("Square" + (x-i) + y);
            down.add("Square" + x + (y+i)); 
        }

        for(String move : up){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
                if (getSquareByName(move).Occupied()) break;
            }
        }
        for(String move : down){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
                if (getSquareByName(move).Occupied()) break;
            }
        }
        for(String move : left){

            if (getSquareByName(move) != null){

                possibleMoves.add(move);
                if (getSquareByName(move).Occupied()) break;
            }
        }
        for(String move : right){

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
