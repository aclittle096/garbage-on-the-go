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
import javafx.scene.paint.*;

/**   A class designed to minimize resource usage.
*     @author Alexander Little, Logan DiAdams */
public class garbage extends Application {
  Button button;
  Button button2;
  Button button3;

  Stage window;
  Scene scene, scene1;

  //--------------------------------------------------------------------
  public static void main(String[] args) {
    launch(args);
  } // main(String[])
  //--------------------------------------------------------------------

  public void start(Stage stage) throws Exception {
    Group root = new Group();

    stage.setTitle("Garbage on the Gooooo");

    button = new Button();
    button2 = new Button();
    button3 = new Button();

    button.setText("Garbage");
    button2.setText("Recyclable");
    button3.setText("Compost");

    button.setOnAction(this::handle);
    button2.setOnAction(this::handle);
    button3.setOnAction(this::handle);

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    layout.getChildren().add(button2);
    layout.getChildren().add(button3);
    scene = new Scene(layout, 600, 300, Color.GOLDENROD);
    stage.setScene(scene);

    window = stage;
    Label label1 = new Label("Welcome to the first scene");

    Button MyPoints = new Button("See my points");
    MyPoints.setOnAction(e -> window.setScene(scene1));

    //Layout 1
    VBox layout1 = new VBox(20);
    layout.getChildren().addAll(label1, MyPoints);
    scene = new Scene(layout1, 200, 200);

    //MyPoints
    Button home = new Button("Back to home");
    home.setOnAction(e -> window.setScene(scene));

    //Layout2
    StackPane layout2 = new StackPane();
    layout2.getChildren().add(home);
    scene1 = new Scene(layout2, 600, 300);

    window.setScene(scene);

    stage.show();

  } // start(Stage)

  public void handle(ActionEvent event) {
    if (event.getSource() == button) {
      int points = 5;
      System.out.println(points); // something like that

    } else if (event.getSource() == button2) {
      int points = 3;
    }

    else if (event.getSource() == button3) {
      int points = 4;
    }

  }
  //--------------------------------------------------------------------
  //--------------------------------------------------------------------
} // class garbage
