package Chess;

import java.util.ArrayList;

public class Knight extends Piece {

    

    


    public Knight(String color, int positionX, int positionY, String name) {
        super(color, positionX, positionY, name);
    }



    @Override
    public void getAllPossibleMoves(){

        int x = this.getPositionX();
        int y = this.getPositionY();


        ArrayList<String> moves = new ArrayList<>();
        this.possibleMoves = new ArrayList<>();


        moves.add("Square" + (x+2) + (y+1));
        moves.add("Square" + (x+2) + (y-1));
        moves.add("Square" + (x+1) + (y+2));
        moves.add("Square" + (x-1) + (y+2));
        moves.add("Square" + (x-2) + (y+1));
        moves.add("Square" + (x-2) + (y-1));
        moves.add("Square" + (x+1) + (y-2));
        moves.add("Square" + (x-1) + (y-2));



        for (String move : moves){

            //eks på feilhåndtering
            if (getSquareByName(move) != null){


                if(getSquareByName(move).Occupied() && getPieceByName(move).getColor().equals(Game.currentPlayer)) continue;

                possibleMoves.add(move);
            }
        }
    }



    @Override
    public String getName() {
        return this.name;
    }
}
