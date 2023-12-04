import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Suitor {

  public static void start(Scanner scnr) {

    int i;
    int count;
    LinkedList<SuitorNode> suitors = new LinkedList<SuitorNode>();
    ListIterator<SuitorNode> itr; 
    SuitorNode curSuitor;

    System.out.println("\n");
    System.out.println("Select the suitor.");

    System.out.println("\nSelect the number of suitors:");
    int numSuitors = scnr.nextInt();


    for (i = 1; i <= numSuitors; ++i) {
      System.out.println("Enter the name of suitor #" + i + " ");
      suitors.add(new SuitorNode(scnr.next()));
    }
    itr = suitors.listIterator();

    count = 1;
    curSuitor = itr.next();
    System.out.println();

    while (suitors.size() > 1) {
      if (count == 3) {
        itr.remove();
        System.out.println("Suitor #" + curSuitor.pos + ", " + curSuitor.name + ", eliminated.");
        count = 0;
      }
      if (!itr.hasNext()) {
        itr = suitors.listIterator();
      }
      ++count;
      curSuitor = itr.next();
    }
    System.out.println();
    System.out.println("The correct suitor was suitor #" + curSuitor.pos + ", " + curSuitor.name + ".");


  }
}
