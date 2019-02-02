import java.util.*;
import java.io.*;

public class dailytips {

  public static void main(String[] args) {
    Random rand = new Random();
    int randomIndex = rand.nextInt(11);
    ArrayList<String> theTips = new ArrayList<>();

    try {
      File file = new File("tips.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));

      String line = "";
      line = reader.readLine();
      while (line != null) {
        theTips.add(line);
        line = reader.readLine();
      }
    } catch (IOException e) {
        System.out.println("It appears the file necessary for the daily tips is missing and cannot be found.");
    }

    System.out.println(theTips.get(randomIndex));
  }

}
