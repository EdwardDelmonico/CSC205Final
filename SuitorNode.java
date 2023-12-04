public class SuitorNode {
  private static int num = 1;
  public int pos;
  public String name;

  public SuitorNode (String name) {
    this.name = name;
    this.pos = num;
    ++num;
  }
}
