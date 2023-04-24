package Chess;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Square extends StackPane {

    private String name;
    private int x;
    private int y;
    private boolean occupied = false;
    private String coordinates;


    public Square(int x, int y){
        this.x = x;
        this.y = y;
        this.name = "Square" + x + y;
    }
    

    public String getName() {
        return name;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    
    public boolean Occupied(){
        return this.occupied;
    }

    public void isOccupied(){
        this.occupied = true;
    }

    public void isNotOccupied(){
        this.occupied = false;
    }




    @Override
    public String toString() {
        
        return "Square";
    }



    public void movePosOfPieceOnSquare(Piece piece, Insets in){

        setMargin(piece, in);
    }



    public void setCoordinates(char c, int number){
        this.coordinates = Character.toString(c) + Integer.toString(number + 1);
    }


    public String getCoordinates(){
        return this.coordinates;
    }


    public void setCharacters(int x, int y){

        Text c;
        if (y == 7){
            if (x == 0){
                c = new Text("a");
            }
            else if (x == 1){
                c = new Text("b");
            }
            else if (x == 2){
                c = new Text("c");
            }
            else if (x == 3){
                c = new Text("d");
            }
            else if (x == 4){
                c = new Text("e");
            }
            else if (x == 5){
                c = new Text("f");
            }
            else if (x == 6){
                c = new Text("g");
            }
            else{
                c = new Text("h");
            }
            setAlignment(c, Pos.BOTTOM_LEFT);
            c.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            this.getChildren().add(c);
        }

        if (x == 7){
            if (y == 0){
                c = new Text("8");
            }
            else if (y == 1){
                c = new Text("7");
            }
            else if (y == 2){
                c = new Text("6");
            }
            else if (y == 3){
                c = new Text("5");
            }
            else if (y == 4){
                c = new Text("4");
            }
            else if (y == 5){
                c = new Text("3");
            }
            else if (y == 6){
                c = new Text("2");
            }
            else {
                c = new Text("1");

            }
            setAlignment(c, Pos.TOP_RIGHT);
            c.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            this.getChildren().add(c);
        }
        

        
    
    }
    
}
