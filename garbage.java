import java.util.*;
import javafx.application.*;
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
import java.awt.Rectangle;
import javafx.scene.text.*;
import javafx.scene.paint.*;

/**   A class designed to minimize resource usage.
*     @author Alexander Little, Logan DiAdams */
public class garbage extends Application {
  Button button;
  Button button2;
  Button button3;
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

    MyPoints.setText("See my points!");
    button.setText("Garbage");
    button2.setText("Recyclable");
    button3.setText("Compost");

    button.setOnAction(this::handle);
    button2.setOnAction(this::handle);
    button3.setOnAction(this::handle);
    MyPoints.setOnAction(this::handle);

    MyPoints.setTranslateX(20);
    MyPoints.setTranslateY(20);

    button.setTranslateX(10);
    button.setTranslateY(-90);

    button2.setTranslateX(100);
    button2.setTranslateY(-90);

    button3.setTranslateX(190);
    button3.setTranslateY(-90);

    layout.getChildren().add(button);
    layout.getChildren().add(button2);
    layout.getChildren().add(button3);
    layout.getChildren().add(MyPoints);
    layout.getChildren().add(text);
    //layout.getChildren().add(home);
    //layout.getChildren().add(MyPoints);

    //scene = new Scene(tabpane);

    scene = new Scene(layout, 600, 300, Color.GOLDENROD);
    stage.setScene(scene);

    stage.show();

  } // start(Stage)

  public void handle(ActionEvent event) {

    Stage stage = new Stage();

    if (event.getSource() == button) {
      int points = 5;
      button.setStyle("-fx-background-color: #ff0000;");

    }

    else if (event.getSource() == button2) {
      int points = 3;
      button2.setStyle("-fx-background-color: #ff0000;");
    }

    else if (event.getSource() == button3) {
      int points = 4;
      button3.setStyle("-fx-background-color: #ff0000;");
    }
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

      stage.show();
      //Label label1 = new Label("Welcome to the first scene");
      //VBox layout1 = new VBox(20);
      //layout1.getChildren().addAll(label1, MyPoints);
      //System.out.println("HELLO");
      //Scene scene = new Scene(layout1, 200, 200);
      //stage.setScene(scene);

      //scene.show();
    }

  }
  //--------------------------------------------------------------------

} // class garbage
