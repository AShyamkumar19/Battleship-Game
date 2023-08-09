package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordTest {
  Coord c;

  /**
   * Set up the Coord object.
   */
  @BeforeEach
  public void setup() {
    c = new Coord(1, 1);
  }

  @Test
  void getRow() {
    c.getRow();
    assertEquals(1, c.getRow());
  }

  @Test
  void getCol() {
    c.getCol();
    assertEquals(1, c.getCol());
  }
}