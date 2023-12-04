import java.util.Scanner;
import java.util.HashSet;
import java.io.*;

public class Sentiment {

  public static void start (Scanner scnr) throws IOException {

    System.out.println("\n");
    System.out.println("Sentiment Analysis.");

    //Declare variables

    FileInputStream posFS = null;
    FileInputStream negFS = null;
    FileInputStream inFS = null;
    Scanner scnrPos = null;
    Scanner scnrNeg = null;
    Scanner scnrIn = null;
    HashSet<String> posWords = new HashSet<String>();
    HashSet<String> negWords = new HashSet<String>();
    boolean done = false;
    String userFile;
    String userPref;
    String curWord;
    int posCount = 0;
    int negCount = 0;
    int total = 0;
    double posPct;
    double negPct;

    //Read file inputs

    posFS = new FileInputStream("pos.txt");
    scnrPos = new Scanner(posFS);

    while (scnrPos.hasNext()) {
      posWords.add(scnrPos.next());
    }
    System.out.println("" + posWords.size() + " positive words loaded.");
    scnrPos.close();
    posFS.close();

    negFS = new FileInputStream("neg.txt");
    scnrNeg = new Scanner(negFS);

    while (scnrNeg.hasNext()) {
      negWords.add(scnrNeg.next());
    }
    System.out.println("" + negWords.size() + " negative words loaded.");
    scnrNeg.close();
    negFS.close();

    //Down to business
    while (!done) {
      System.out.println("Enter the name of the text file to be analyzed (include the extension, please): ");
      userFile = scnr.next();
      inFS = new FileInputStream(userFile);
      scnrIn = new Scanner(inFS);
      while (scnrIn.hasNext()) {
        curWord = scnrIn.next();
        if (posWords.contains(curWord)) {
          ++posCount;
        }
        if (negWords.contains(curWord)) {
          ++negCount;
        }
        ++total;
      }
      inFS.close();
      scnrIn.close();
      System.out.println("\nSentiment analysis for " + userFile + ":");
      System.out.println("There were " + posCount + " total positive words, " + negCount + "  negative words, and " + total + " total words.");
      posPct = (((double) posCount) / total) * 100;
      negPct = (((double) negCount) / total) * 100;
      System.out.printf("\nThat's %.2f%% positive and %.2f%% negative.", posPct, negPct);
      System.out.print(" Overall the sentiment is ");
      if (posPct > (negPct + 5)) {
        System.out.print("positive.");
      } else if (negPct > (posPct + 5)) {
        System.out.print("negative.");
      } else {
        System.out.print("neutral.");
      }
      System.out.println("\nWould you like to analyze another file? y/n");
      userPref = scnr.next();
      while (!userPref.equals("y") && !userPref.equals("n")) {
        System.out.println("y or n, please.");
        userPref = scnr.next();
      }
      if (userPref.equals("n")) {
        System.out.println("\nGoodbye!");
        done = true;
      }
    }
  }
}
