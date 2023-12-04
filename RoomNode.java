import java.util.*;

public class RoomNode{
  private static char roomChar = 'A';
  public char name;
  protected HashMap<Character, RoomNode> adjRooms;
  public boolean wins;

  public RoomNode () {
    name = roomChar;
    adjRooms = new HashMap<Character, RoomNode>();
    wins = false;
    ++roomChar;
  }

  public RoomNode get (char target) {
    return adjRooms.get(target);
  }

  public void addRoom (Character roomDir, RoomNode newRoom) {
    if (roomDir == 'n' || roomDir == 'e' || roomDir == 'w' || roomDir == 's') {
      adjRooms.put(roomDir, newRoom);
    
    if (roomDir == 'n'){
      newRoom.adjRooms.put('s', this);
    } else if (roomDir == 'e') {
      newRoom.adjRooms.put('w', this);
    } else if (roomDir == 'w') {
      newRoom.adjRooms.put('e', this);
    } else if (roomDir == 's') {
      newRoom.adjRooms.put('n', this);
    }
    }
  }

  public static String toString (Character x) {
    switch (x) {
      case 'n':
        return "north";
      case 'e':
        return "east";
      case 'w':
        return "west";
      case 's':
        return "south";
      default:
        return null;
    }
  }

  public void print () {
    Set<Character> dirs = adjRooms.keySet();
    Iterator<Character> itr = dirs.iterator();

    System.out.print("\nYou are in room " + name + " of the house. You can go ");

    System.out.print(RoomNode.toString(itr.next()));

    if (dirs.size() == 2) {
      System.out.print(" or " + RoomNode.toString(itr.next()));
    } else if (dirs.size() > 2) {
      System.out.print(", " + RoomNode.toString(itr.next()) + ", ");
    } 
    if (dirs.size() == 3) {
      System.out.print("or " + RoomNode.toString(itr.next()));
    } else if (dirs.size() == 4) {
      System.out.print("" + RoomNode.toString(itr.next()) + ", or " + RoomNode.toString(itr.next()));
    }
    System.out.print(".\n");
  }

}
