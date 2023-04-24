package Chess;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javafx.scene.control.TextArea;


public class GamesFileReader {

    public static Scanner scanner;
    public static TextArea textArea;


    public GamesFileReader(TextArea ta){

        textArea = ta;

        try {
            scanner = new Scanner(new FileReader("GamesFile.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }



    public static void addMoveToScore(){

        if(scanner.hasNextLine()){
            String line = scanner.nextLine();
            textArea.appendText(line + "\n") ;
        }
    }

    

    
}