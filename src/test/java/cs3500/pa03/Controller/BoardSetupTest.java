package cs3500.pa03.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardSetupTest {
  BoardSetup bs;
  StringBuilder sb;

  /**
   * Set up the BoardSetup object.
   */
  @BeforeEach
  public void setup() {
    sb = new StringBuilder();
    StringReader sr = new StringReader("8\n8\n1\n1\n1\n1\n");
    bs = new BoardSetup(sr, sb);
  }

  /**
   * Test the setupBoard method.
   */
  @Test
  void testSetupBoard() {
    bs.setupBoard();
    assertEquals("", sb.toString());
  }

    /**
     * Test the getHeight method.
     */
    @Test
    void testGetters() {
      bs.setupBoard();
      bs.getHeight();
      bs.getWidth();
      bs.getCarrier();
      bs.getBattleship();
      bs.getDestroyer();
      bs.getSubmarine();
      bs.getTotalShips();
      assertEquals(8, bs.getHeight());
      assertEquals(8, bs.getWidth());
      assertEquals(1, bs.getCarrier());
      assertEquals(1, bs.getBattleship());
      assertEquals(1, bs.getDestroyer());
      assertEquals(1, bs.getSubmarine());
      assertEquals(4, bs.getTotalShips());
    }
}