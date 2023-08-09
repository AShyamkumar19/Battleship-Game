package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cs3500.pa03.Controller.BoardSetup;
import cs3500.pa03.View.BoardSetupView;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TakeShotTest {
  TakeShot ts;
  BoardSetupView bsv;

  /**
   * Sets up the test object
   */
  @BeforeEach
  void setUp() {
    ts = new TakeShot();
    bsv = mock(BoardSetupView.class);
    ts.bsv = bsv;
  }

  @Test
  void testTakeShots() {
    BoardSetup boardSetup = mock(BoardSetup.class);
    when(boardSetup.getTotalShips()).thenReturn(4);
    when(boardSetup.getHeight()).thenReturn(10);
    when(boardSetup.getWidth()).thenReturn(10);

    String input = "0 0\n5 5\n1 1\n";
    List<Coord> expectedShots = new ArrayList<>();
    expectedShots.add(new Coord(0, 0));
    expectedShots.add(new Coord(5, 5));
    expectedShots.add(new Coord(7, 8));

    List<Coord> actualShots = ts.takeShotsFromString(boardSetup, input);

    assertEquals(expectedShots.size(), actualShots.size());
    assertFalse(actualShots.containsAll(expectedShots));
  }

  @Test
  void testAiTakeShots() {
    BoardSetup boardSetup = mock(BoardSetup.class);
    when(boardSetup.getTotalShips()).thenReturn(5);
    when(boardSetup.getHeight()).thenReturn(10);
    when(boardSetup.getWidth()).thenReturn(10);

    List<Coord> shots = ts.aiTakeShots(boardSetup);

    assertEquals(5, shots.size());

    for (Coord shot : shots) {
      assertTrue(shot.getRow() >= 0 && shot.getRow() < 10);
      assertTrue(shot.getCol() >= 0 && shot.getCol() < 10);
    }
  }


}