import java.util.*;
import java.io.*;
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

  // Acquiring the stats of the user from tally.txt
  try {
    private File file = new File("tally.txt");
    private BufferedReader reader = new BufferedReader(new FileReader(file));
    points = Integer.parseInt(reader.readLine());
    garbageTally = Integer.parseInt(reader.readLine());
    recyclableTally = Integer.parseInt(reader.readLine());
    compostTally = Integer.parseInt(reader.readLine());
  }
  catch (IOException e) {
    System.out.println("It appears the file necessary for the daily tips is missing and cannot be found.");
  }
  //--------------------------------------------------------------------
  public static void main(String[] args) {
    launch(args);
  } // main(String[])
  //--------------------------------------------------------------------
  public void start(Stage stage) throws Exception {
    Group root = new Group();

    stage.setTitle("Garbage on the Gooooo");

    window = stage;
    Label label1 = new Label("Welcome to the first scene");

    Button MyPoints = new Button("See my points");
    MyPoints.setOnAction(e -> window.setScene(scene1));

    // Layout 1
    VBox layout1 = new VBox(20);
    layout1.getChildren().addAll(label1, MyPoints);
    scene = new Scene(layout1, 200, 200);

    // MyPoints
    Button home = new Button("Back to home");
    home.setOnAction(e -> window.setScene(scene));

    // Layout2
    StackPane layout2 = new StackPane();
    layout2.getChildren().add(home);
    scene1 = new Scene(layout2, 600, 300);

    window.setScene(scene);
    window.show();

    button = new Button();
    button2 = new Button();
    button3 = new Button();

    button.setText("Garbage");
    button2.setText("Recyclable");
    button3.setText("Compost");

    button.setOnAction(this::handle);
    button2.setOnAction(this::handle);
    button3.setOnAction(this::handle);

    button.setTranslateX(10);
    button.setTranslateY(-90);

    button2.setTranslateX(100);
    button2.setTranslateY(-90);

    button3.setTranslateX(190);
    button3.setTranslateY(-90);

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    layout.getChildren().add(button2);
    layout.getChildren().add(button3);
    scene = new Scene(layout, 600, 300, Color.GOLDENROD);
    stage.setScene(scene);

    // Alert for daily tips
    dailytipsbox.display("Daily tip of the day!", dailyTip());

    stage.show(); // let the fun begin

  } // start(Stage)

  public void handle(ActionEvent event) {
    if (event.getSource() == button) {
      int points = 5;
      System.out.println(points); // something like that

    } else if (event.getSource() == button2) {
      int points = 3;
      button2.setStyle("-fx-background-color: #ff0000;");
    }

    else if (event.getSource() == button3) {
      int points = 4;
    }

  }
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
    }
    catch (IOException e) {
      System.out.println("It appears the file necessary for the daily tips is missing and cannot be found.");
    }

    return theTips.get(randomIndex);
  } // dailyTip()
  //--------------------------------------------------------------------
  public void tally(String category) {
    File tallyFile = new File("tally.txt");
    FileOutputStream update = new FileOutputStream(tallyFile, false);

    if (category.equals("Garbage")) {
      points += 2;
      garbageTally += 1;

      update.write(points.getBytes());
      update.write(garbageTally.getBytes());
      update.write(recyclableTally.getBytes());
      update.write(compostTally.getBytes());
      update.close();
    } // if
    else if (category.equals("Recyclable")) {
      points += 5;
      recyclableTally += 1;

      update.write(points.getBytes());
      update.write(garbageTally.getBytes());
      update.write(recyclableTally.getBytes());
      update.write(compostTally.getBytes());
      update.close();
    } // else if
    else {
      points += 7;
      compostTally += 1;

      update.write(points.getBytes());
      update.write(garbageTally.getBytes());
      update.write(recyclableTally.getBytes());
      update.write(compostTally.getBytes());
      update.close();
    } // else
  } // tally(String)
} // class garbage
