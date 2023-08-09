package cs3500.pa03.Model;

/**
 * Represents the coordinates of a cell.
 */
public class Coord {
  private int x;
  private int y;

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getRow() {
    return x;
  }

  public int getCol() {
    return y;
  }
}
