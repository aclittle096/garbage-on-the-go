import java.util.*;
import java.io.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.*;
import javafx.geometry.Pos;

import java.io.FileInputStream;
import java.awt.Rectangle;
import javafx.scene.text.*;
import javafx.scene.paint.*;

/**   An application designed to make the process of waste management fun and competitive.
*     @author Alexander Little, Logan DiAdams */
public class garbage extends Application {
  Button button;
  Button button2;
  Button button3;
  Button reset;
  Button MyPoints;
  //Button home;

  Stage window;
  Scene scene, scene1;
  StackPane layout;
  //--------------------------------------------------------------------
  public static void main(String[] args) {
    launch(args);
  } // main(String[])
  //--------------------------------------------------------------------
  public void start(Stage stage) throws Exception {
    Group root = new Group();

    stage.setTitle("Garbage on the Gooooo");

    Text text = new Text();
    text.setText("Choose a category: ");
    text.setTranslateX(-120);
    text.setTranslateY(-90);
    text.setFill(Color.WHITE); /////////////

    Image image = new Image("file:17996802-public-garbage-can.jpg ");
    ImageView mv = new ImageView(image);

    //-window = stage;
    //-Label label1 = new Label("Welcome to the first scene");


    //Button MyPoints = new Button("See my points");
    //MyPoints.setOnAction(e -> window.setScene(scene1));

    //-Layout 1
    //-VBox layout1 = new VBox(20);
    //-layout1.getChildren().addAll(label1, MyPoints);
    //-scene = new Scene(layout1, 200, 200);

    //MyPoints
    //-Button home = new Button("Back to home");
    //-home.setOnAction(e -> window.setScene(scene));
    layout = new StackPane();
    layout.getChildren().addAll(mv);
    //Layout2
    //StackPane layout2 = new StackPane();
    //layout2.getChildren().add(home);
    //layout.getChildren().add(home);
    //scene1 = new Scene(layout, 600, 300);
    //scene1 = new Scene(layout2, 600, 300);


    //window.setScene(scene);
    //window.show();

    MyPoints = new Button();
    button = new Button();
    button2 = new Button();
    button3 = new Button();
    reset = new Button();

    MyPoints.setText("See my points!");
    button.setText("Garbage");
    button2.setText("Recyclable");
    button3.setText("Compost");
    reset.setText("Reset Stats (can't be undone!)");

    button.setOnAction(this::handle);
    button2.setOnAction(this::handle);
    button3.setOnAction(this::handle);
    reset.setOnAction(this::handle);

    MyPoints.setOnAction(this::handle);

    MyPoints.setTranslateX(20);
    MyPoints.setTranslateY(20);

    button.setTranslateX(10);
    button.setTranslateY(-90);

    button2.setTranslateX(100);
    button2.setTranslateY(-90);

    button3.setTranslateX(190);
    button3.setTranslateY(-90);

    reset.setTranslateX(20);
    reset.setTranslateY(60);




    layout.getChildren().add(button);
    layout.getChildren().add(button2);
    layout.getChildren().add(button3);
    layout.getChildren().add(MyPoints);
    layout.getChildren().add(text);
    layout.getChildren().add(reset);
    //layout.getChildren().add(home);
    //layout.getChildren().add(MyPoints);

    //scene = new Scene(tabpane);

    scene = new Scene(layout, 600, 300, Color.GOLDENROD);
    stage.setScene(scene);

    stage.setResizable(false);

    // Alert for daily tips
    dailytipsbox.display("Daily tip of the day!", dailyTip());

    stage.show();

  } // start(Stage)
  //--------------------------------------------------------------------
  public void handle(ActionEvent event) {
    Stage stage = new Stage();

    if (event.getSource() == button) { //garbage
      int points = 5;
      button.setStyle("-fx-background-color: #ff0000;");

      Text t = new Text();
      t.setText("You clicked garbage!");
      t.setTranslateX(-120);
      t.setTranslateY(10);

      tally("Garbage");
    } // if

    else if (event.getSource() == button2) { //recyclable
      int points = 3;
      button2.setStyle("-fx-background-color: #ff0000;");

      tally("Recyclable");
    } // else if

    else if (event.getSource() == button3) { //compost
      int points = 4;
      button3.setStyle("-fx-background-color: #ff0000;");

      tally("Compost");
    } // else if
    /*
    if (event.getSource() == home) {
      home.setOnAction(e -> window.setScene(scene));
    }
    */

    else if (event.getSource() == MyPoints) {
      //MyPoints.setOnAction(e -> window.setScene(scene1));
      //newStage.setTitle("Garbage on the Gooooo");

      TabPane tabpane = new TabPane();
      Tab newTab = new Tab();
      newTab.setText("My points!");
      //newTab.setContent(new Rectangle(200, 200, Color.LIGHTSTEELBLUE));

      tabpane.getTabs().add(newTab);
      //Label label1 = new Label("Welcome to the first scene");
      StackPane layout1 = new StackPane();
      layout.getChildren().add(tabpane);
      newTab.setContent(layout1);
      //Scene scene2 = new Scene(tabpane);
      //scene = new Scene(tabpane, 200, 200);
      Scene scene2 = new Scene(layout1);

      //stage.setScene(scene2);
      stage.setScene(scene2);

      //stage.show();
      //Label label1 = new Label("Welcome to the first scene");
      //VBox layout1 = new VBox(20);
      //layout1.getChildren().addAll(label1, MyPoints);
      //System.out.println("HELLO");
      //Scene scene = new Scene(layout1, 200, 200);
      //stage.setScene(scene);

      //scene.show();

      //----------------------------------------
    /*  Stage popUp = new Stage();

      popUp.initModality(Modality.APPLICATION_MODAL);
      popUp.setTitle("My Points!");
      Label label1 = new Label("Scoreboard");
      Button home = new Button("Go back to home!");
      popUp.setOnAction(e -> popUp.close());
      VBox layout1 = new VBox(10);
      layout1.getChildren().addAll(label1, home);
      layout1.setAlignment(Pos.CENTER);
      Scene scene2 = new Scene(layout1, 300, 250);
      popUp.setScene(scene2);
      popUp.showAndWait();*/

    } // else if

    else if (event.getSource() == reset) {
      try {
        File tallyFile = new File("tally.txt");
        FileOutputStream update = new FileOutputStream(tallyFile, false);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(update));

        bw.write("0");
        bw.newLine();
        bw.write("0");
        bw.newLine();
        bw.write("0");
        bw.newLine();
        bw.write("0");
        bw.newLine();

        update.close();
        bw.close();
      } // try
      catch (IOException e) {
        System.out.println("You dun goofed bud");
        // e.printStackTrace();
      } // catch
    } // else if
  } // handle(ActionEvent)
  //--------------------------------------------------------------------
  public String dailyTip() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(11);
    ArrayList<String> theTips = new ArrayList<>();

    try {
      File file = new File("tips.txt"); // be sure this is included with application
      BufferedReader reader = new BufferedReader(new FileReader(file));

      String line = "";
      line = reader.readLine();
      while (line != null) {
        theTips.add(line);
        line = reader.readLine();
      }
      reader.close();
    }
    catch (IOException e) {
      System.out.println("It appears the file necessary for the daily tips is missing and cannot be found.");
    }

    return theTips.get(randomIndex);
  } // dailyTip()
  //--------------------------------------------------------------------
  public void tally(String category) {
    try {
      File file = new File("tally.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));

      String[] theDigits = new String[4];
      for (int i = 0; i < 4; i++) {
        theDigits[i] = reader.readLine();
      }
      int points = Integer.parseInt(theDigits[0]);
      int garbageTally = Integer.parseInt(theDigits[1]);
      int recyclableTally = Integer.parseInt(theDigits[2]);
      int compostTally = Integer.parseInt(theDigits[3]);

      FileOutputStream update = new FileOutputStream(file, false);
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(update));
      if (category.equals("Garbage")) {
        points += 2;
        garbageTally += 1;
        bw.write(points);
        bw.newLine();
        bw.write(garbageTally);
        bw.newLine();
        bw.write(recyclableTally);
        bw.newLine();
        bw.write(compostTally);
        bw.newLine();
      } // if
      else if (category.equals("Recyclable")) {
        points += 5;
        recyclableTally += 1;
        bw.write(points);
        bw.newLine();
        bw.write(garbageTally);
        bw.newLine();
        bw.write(recyclableTally);
        bw.newLine();
        bw.write(compostTally);
        bw.newLine();
      } // else if
      else {
        points += 7;
        compostTally += 1;
        bw.write(points);
        bw.newLine();
        bw.write(garbageTally);
        bw.newLine();
        bw.write(recyclableTally);
        bw.newLine();
        bw.write(compostTally);
        bw.newLine();
      } // else
      reader.close();
      bw.close();
      update.close();
    } // try
    catch (IOException e) {
        System.out.println("Wait... what happened to the files? Was it you, Logan?");
    } // catch
  } // tally(String)
} // class garbage
