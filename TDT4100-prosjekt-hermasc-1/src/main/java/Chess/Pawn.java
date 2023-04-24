package Chess;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(String color, int positionX, int positionY, String name) {
        super(color, positionX, positionY, name);
        
    }

    


   

    @Override
    public void getAllPossibleMoves(){

        int x = getPositionX();
        int y = getPositionY();

        this.possibleMoves = new ArrayList<>();


        // Bestem retningen brikkene kan bevege seg basert på fargen
        int forward = getColor().equals("Black") ? 1 : -1;

        // Beregn ruten foran brikkene, og de to diagonale rutene for å ta en motstanderbrikke
        String squareInFront = "Square" + x + (y + forward);
        String leftCaptureSquare = "Square" + (x - 1) + (y + forward);
        String rightCaptureSquare = "Square" + (x + 1) + (y + forward);

        // Sjekk om ruten foran er et gyldig trekk
        if (getSquareByName(squareInFront) != null && !getSquareByName(squareInFront).Occupied()) {
            possibleMoves.add(squareInFront);
        }

        // Sjekk om den venstre diagonale ruten er et gyldig trekk for å ta en motstanderbrikke
        if (getSquareByName(leftCaptureSquare) != null && getSquareByName(leftCaptureSquare).Occupied() &&
                !getPieceByName(leftCaptureSquare).getColor().equals(getColor())) {
            possibleMoves.add(leftCaptureSquare);
        }

        // Sjekk om den høyre diagonale ruten er et gyldig trekk for å ta en motstanderbrikke
        if (getSquareByName(rightCaptureSquare) != null && getSquareByName(rightCaptureSquare).Occupied() &&
                !getPieceByName(rightCaptureSquare).getColor().equals(getColor())) {
            possibleMoves.add(rightCaptureSquare);
        }

        // Sjekk om bonden er på sin startposisjon og kan bevege seg to ruter fremover
        if ((getColor().equals("Black") && getPositionY() == 1) || (getColor().equals("White") && getPositionY() == 6)) {

            String twoSquaresInFront = "Square" + x + (y + 2 * forward);
            if (getSquareByName(squareInFront) != null && !getSquareByName(squareInFront).Occupied() &&
                    getSquareByName(twoSquaresInFront) != null && !getSquareByName(twoSquaresInFront).Occupied()) {
                possibleMoves.add(twoSquaresInFront);
            }
        }
    }

    @Override
    public String getName() {
        
        return this.name;
    }



    


}


