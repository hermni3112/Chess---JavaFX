package Chess;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileWriter {

    public static PrintWriter outFile;
    private Square square;
    
    


    public FileWriter(){

        
        try
        {
            outFile = new PrintWriter("GamesFile.txt");
            outFile.println("Game: ");
            outFile.flush();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'GamesFile.txt' could not be opened for writing.");
            System.exit(1);
        }
        
    }

    

    public void addMove(){
        
        outFile.println(Game.currentPlayer + " " + Game.currentPiece.getName() + " to " + this.square.getCoordinates());
        outFile.flush();
        System.out.println("move added to file");
        
        
        
    }

    public void takePiece(Piece currentPiece, Piece killedPiece, Square square, String currentPlayer){
        outFile.println(currentPlayer + " " + currentPiece.getName() + " takes " + killedPiece.getName() + " at " + square.getCoordinates());
        outFile.flush();
    }

    public void endGame(){
        outFile.close();
    }

    
    public void setSquare(Square square) {
        this.square = square;
    }

    public String getFileContent(){

        try {
            Scanner scanner = new Scanner(new FileReader("GamesFile.txt"));
            String line = scanner.nextLine();
            return line;
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return "fail";

    }
}


    

