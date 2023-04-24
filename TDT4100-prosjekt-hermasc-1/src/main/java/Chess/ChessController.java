package Chess;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;


public class ChessController {

    
    @FXML
    private GridPane board;

 
    public void initialize(){

        Game game = new Game(board);
    }
}
