package Chess;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class ChessApp extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {


        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("ChessBoard.fxml"));
        Parent root1 = loader1.load();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("scoreboard.fxml"));
        Parent root2 = loader2.load();


        SplitPane pane = new SplitPane();
        pane.getItems().addAll(root1, root2);
        Scene scene = new Scene(pane, 1120, 750);

        primaryStage.setScene(scene);
        primaryStage.show();


        // Legge til siste trekk hvis spiller lukker vindu før spillet er over
        primaryStage.setOnCloseRequest(event -> {
            FileWriter.outFile.close();
        });


    }

    public static void main(String[] args) {
        launch( args);
    }
}