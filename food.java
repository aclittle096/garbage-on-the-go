import java.util.Calendar;
import java.util.Scanner;

public class food {

  private String foodname;
  private int points;

  public food(String inFood, int inPoints) { // TODO Create two Calendar objects; one for best before date, another for expiration
    foodname = inFood;
    points = inPoints;
  }

  public String getName() {
    return foodname;
  }

  private void setName(String newName) {
    foodname = newName;
  }

  public int getPoints() {
    return points;
  }

  private void setPoints(int newPoints) {
    points = newPoints;
  }

}
