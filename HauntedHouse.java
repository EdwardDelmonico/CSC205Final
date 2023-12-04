import java.util.Scanner;

public class HauntedHouse {

  public static RoomNode curRoom;

  public static boolean go (char dir, RoomNode presentRoom){
    RoomNode target = presentRoom.get(dir);
    if (target == null) {
      System.out.println("You can't go that way.");
    } else {
      curRoom = target;
      if (!curRoom.wins){
        curRoom.print();
      }
    }
    return curRoom.wins;
  }

  public static void start (Scanner scnr) {

    char choice;

    System.out.println("\n");
    System.out.println("Escape the Haunted House.");
    System.out.println("Input n for north, e for east, w for west, or s for south. X to quit.");

    RoomNode a = new RoomNode();
    RoomNode b = new RoomNode();
    RoomNode c = new RoomNode();
    RoomNode d = new RoomNode();
    RoomNode e = new RoomNode();
    RoomNode f = new RoomNode();
    RoomNode g = new RoomNode();
    RoomNode h = new RoomNode();
    RoomNode i = new RoomNode();
    RoomNode j = new RoomNode();
    RoomNode k = new RoomNode();
    RoomNode l = new RoomNode();
    l.wins = true;

    a.addRoom('s', e);
    a.addRoom('e', b);
    e.addRoom('s', i);
    i.addRoom('e', j);
    b.addRoom('e', c);
    c.addRoom('e', d);
    d.addRoom('s', h);
    b.addRoom('s', f);
    f.addRoom('e', g);
    g.addRoom('s', k);
    k.addRoom('e', l);

    curRoom = a;
    a.print();

    choice = scnr.next().toLowerCase().charAt(0);

    while (choice != 'x' && !curRoom.wins){
      if (go(choice, curRoom)) {
        System.out.println("You've escaped. For now.");
      } else {
      choice = scnr.next().toLowerCase().charAt(0);
      }
    }
  }
}
