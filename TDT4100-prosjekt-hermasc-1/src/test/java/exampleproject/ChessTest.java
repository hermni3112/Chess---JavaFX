package exampleproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import Chess.Board;
import Chess.FileWriter;
import Chess.King;
import Chess.Piece;
import Chess.Square;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class ChessTest {

    @FXML
    private GridPane pane;

    @Test
    public void testPiece(){
        Piece p = new Piece("White", 0, 0, "TestPawn");
        assertEquals("TestPawn", p.getName());
        assertEquals("White", p.getColor());
    }

    @Test
    public void testSquare(){
        Square square = new Square(3, 4);
        assertEquals(3, square.getX());
        assertEquals(4, square.getY());
    }


    
    @Test
    public void testFileWirter(){

        FileWriter fw = new FileWriter();
        assertEquals("Game: ", fw.getFileContent());
    }


    @Test
    public void testSquareOccupied(){

        Square square = new Square(0, 0);
        assertFalse(square.Occupied());
    }

    @Test
    public void testKing(){
        King k = new King("black", 5, 9, "king");
        assertEquals("black", k.getColor());
        assertEquals(5 , k.getPositionX());
        assertEquals(9, k.getPositionY());
        assertEquals("king", k.getName());
    }


    @Test
    public void testBoardCreation() {
        
        Board b = new Board(pane);
        assertNotNull(b);
    }


    
    
}
