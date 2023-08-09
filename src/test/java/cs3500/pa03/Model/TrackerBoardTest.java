package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackerBoardTest {
  TrackerBoard tb;

  /**
   * Set up the TrackerBoard object.
   */
  @BeforeEach
  public void setup() {
    tb = new TrackerBoard();
  }

  @Test
  void trackerBoard() {
    TrackerBoard trackerBoard = new TrackerBoard();
    int height = 5;
    int width = 7;
    char[][] board = trackerBoard.trackerBoard(height, width);

    assertEquals(height, board.length);
    assertEquals(width, board[0].length);

    char expectedSymbol = '0';
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        assertEquals(expectedSymbol, board[i][j]);
      }
    }
  }
}