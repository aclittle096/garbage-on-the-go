import java.util.Calendar;

public class food {

  String foodname;

  public food(String foodname) { // TODO Create two Calendar objects; one for best before date, another for expiration
    this.foodname = foodname;
  }

  public static String getName() {
    return foodname;
  }
  
  public static void setName(String newname) {
    foodname = newname;
  }

}
