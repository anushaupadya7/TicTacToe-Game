package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
	

public class Main extends Application
{
    Label message=new Label("X's Turn");
    boolean oTurn=false;
    boolean xTurn=true;
    char xOro[][]=new char[3][3];
 
    Button b00=new Button("");
    Button b01=new Button("");
    Button b02=new Button("");
    Button b10=new Button("");
    Button b11=new Button("");
    Button b12=new Button("");
    Button b20=new Button("");
    Button b21=new Button("");
    Button b22=new Button("");
 
    @Override
    public void start(Stage primaryStage)
    {
        System.out.println("////////////////////  "+(int)xOro[0][0]);
        GridPane xyPane=new GridPane();
        HBox textPane=new HBox();
        BorderPane pane=new BorderPane();
        Button refresh=new Button("Reset");
 
        b00.setMinSize(125,120);
        b01.setMinSize(125,120);
        b02.setMinSize(125,120);
        b10.setMinSize(125,120);
        b11.setMinSize(125,120);
        b12.setMinSize(125,120);
        b20.setMinSize(125,120);
        b21.setMinSize(125,120);
        b22.setMinSize(125,120);
 
        textPane.getChildren().add(message);
        textPane.getChildren().add(refresh);
        textPane.setSpacing(20);
        textPane.setAlignment(Pos.CENTER);
        message.setFont(Font.font(message.getFont().getFamily(), FontWeight.BOLD, FontPosture.REGULAR,20));
 
        xyPane.add(b00, 0,0);
        xyPane.add(b01, 1,0);
        xyPane.add(b02, 2,0);
        xyPane.add(b10, 0,1);
        xyPane.add(b11, 1,1);
        xyPane.add(b12, 2,1);
        xyPane.add(b20, 0,2);
        xyPane.add(b21, 1,2);
        xyPane.add(b22, 2,2);
        xyPane.setVgap(5);
        xyPane.setHgap(5);
 
        pane.setCenter(xyPane);
        pane.setTop(textPane);
        pane.setPadding(new Insets(5,5,5,5));
 
        Scene scene=new Scene(pane, 395,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe FX");
        primaryStage.show();
 
        //reset game
        refresh.setOnAction(event -> {
            b00.setText("");
            b01.setText("");
            b02.setText("");
            b10.setText("");
            b11.setText("");
            b12.setText("");
            b20.setText("");
            b21.setText("");
            b22.setText("");
 
            oTurn=false;
            xTurn=true;
 
            for(int r=0; r<3;r++)
            {
                for(int c=0; c<3; c++)
                {
                    xOro[r][c]='\0';
                }
            }
            b00.setDisable(false);
            b01.setDisable(false);
            b02.setDisable(false);
            b10.setDisable(false);
            b11.setDisable(false);
            b12.setDisable(false);
            b20.setDisable(false);
            b21.setDisable(false);
            b22.setDisable(false);
 
            message.setFont(Font.font(message.getFont().getFamily(), FontWeight.BOLD, FontPosture.REGULAR,20));
            message.setText("X's Turn");
        });
 
        //do all the things
        b00.setOnAction(event -> {
            if(xTurn)
                b00.setText("X");
            else
                b00.setText("O");
            SetXO(0,0);
            b00.setStyle("-fx-font-size:59");
            b00.setDisable(true);
        });
        b01.setOnAction(event -> {
            if(xTurn)
                b01.setText("X");
            else
                b01.setText("O");
            SetXO(0,1);
            b01.setStyle("-fx-font-size:59");
            b01.setDisable(true);
        });
        b02.setOnAction(event -> {
        if(xTurn)
            b02.setText("X");
        else
            b02.setText("O");
        SetXO(0,2);
            b02.setStyle("-fx-font-size:59");
        b02.setDisable(true);
        });
        b10.setOnAction(event -> {
            if(xTurn)
                b10.setText("X");
            else
                b10.setText("O");
            SetXO(1,0);
            b10.setStyle("-fx-font-size:59");
            b10.setDisable(true);
        });
        b11.setOnAction(event -> {
            if(xTurn)
                b11.setText("X");
            else
                b11.setText("O");
            SetXO(1,1);
            b11.setStyle("-fx-font-size:59");
            b11.setDisable(true);
        });
        b12.setOnAction(event -> {
            if(xTurn)
                b12.setText("X");
            else
                b12.setText("O");
            SetXO(1,2);
            b12.setStyle("-fx-font-size:59");
            b12.setDisable(true);
        });
        b20.setOnAction(event -> {
            if(xTurn)
                b20.setText("X");
            else
                b20.setText("O");
            SetXO(2,0);
            b20.setStyle("-fx-font-size:59");
            b20.setDisable(true);
        });
        b21.setOnAction(event -> {
            if(xTurn)
                b21.setText("X");
            else
                b21.setText("O");
            SetXO(2,1);
            b21.setStyle("-fx-font-size:59");
            b21.setDisable(true);
        });
        b22.setOnAction(event -> {
            if(xTurn)
                b22.setText("X");
            else
                b22.setText("O");
            SetXO(2,2);
            b22.setStyle("-fx-font-size:59");
            b22.setDisable(true);
        });
    }
 
    public void SetXO(int r,int c)
    {
        if(xTurn)
        {
            xOro[r][c]='X';
 
            message.setText("O's Turn");
 
            oTurn = true;
            xTurn = false;
        }
        else if (oTurn)
        {
            xOro[r][c]='O';
 
            message.setText("X's Turn");
 
            oTurn = false;
            xTurn = true;
        }
        //ASCII
        //O*3 in the pattern
        if((int) xOro[0][0] + (int) xOro[0][1] + (int) xOro[0][2]==237 ||
                (int) xOro[1][0] + (int) xOro[1][1] + (int) xOro[1][2]==237||
                (int) xOro[2][0] + (int) xOro[2][1] + (int) xOro[2][2]==237||
                (int) xOro[0][0] + (int) xOro[1][1] + (int) xOro[2][2]==237||
                (int) xOro[2][0] + (int) xOro[1][1] + (int) xOro[0][2]==237||
                (int) xOro[0][0] + (int) xOro[1][0] + (int) xOro[2][0]==237||
                (int) xOro[0][1] + (int) xOro[1][1] + (int) xOro[2][1]==237||
                (int) xOro[0][2] + (int) xOro[1][2] + (int) xOro[2][2]==237)
        {
            message.setText("Player O Wins");
            b00.setDisable(true);
            b01.setDisable(true);
            b02.setDisable(true);
            b10.setDisable(true);
            b11.setDisable(true);
            b12.setDisable(true);
            b20.setDisable(true);
            b21.setDisable(true);
            b22.setDisable(true);
        }
 
        //X*3 in the patterns
        else if((int) xOro[0][0] + (int) xOro[0][1] + (int) xOro[0][2]==264 ||
                (int) xOro[1][0] + (int) xOro[1][1] + (int) xOro[1][2]==264||
                (int) xOro[2][0] + (int) xOro[2][1] + (int) xOro[2][2]==264||
                (int) xOro[0][0] + (int) xOro[1][1] + (int) xOro[2][2]==264||
                (int) xOro[2][0] + (int) xOro[1][1] + (int) xOro[0][2]==264||
                (int) xOro[0][0] + (int) xOro[1][0] + (int) xOro[2][0]==264||
                (int) xOro[0][1] + (int) xOro[1][1] + (int) xOro[2][1]==264||
                (int) xOro[0][2] + (int) xOro[1][2] + (int) xOro[2][2]==264)
        {
            message.setText("Player X Wins");
            b00.setDisable(true);
            b01.setDisable(true);
            b02.setDisable(true);
            b10.setDisable(true);
            b11.setDisable(true);
            b12.setDisable(true);
            b20.setDisable(true);
            b21.setDisable(true);
            b22.setDisable(true);
        }
        //Draw
        else if((int) xOro[0][0]!=0 && (int) xOro[0][1] !=0 && (int) xOro[0][2]!=0 &&
                (int) xOro[1][0]!=0 && (int) xOro[1][1]!=0 && (int) xOro[1][2]!=0 &&
                (int) xOro[2][0]!=0 && (int) xOro[2][1]!=0 && (int) xOro[2][2]!=0)
        {
            message.setText("You meaningless strategy has resulted in a Draw");
            message.setFont(Font.font(message.getFont().getFamily(), FontWeight.BOLD, FontPosture.REGULAR,10));
 
        }
    }
 
    public static void main(String[] args)
    {
        launch(args);
    }
}
 
