package Chess;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;


public class ScoreController {

    @FXML
    private Pane pane;

    @FXML
    private TextArea scoreboardTextArea;




    public void initialize() {

        GamesFileReader gfr = new GamesFileReader(scoreboardTextArea);
        
    }


}
    