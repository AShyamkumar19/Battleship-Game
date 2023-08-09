package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HitOrMissTest {
  HitOrMiss h;
  GameBoard board;
  char[][] trackerBoard;

  /**
   * Set up the HitOrMiss object.
   */
  @BeforeEach
  public void setup() {
    h = new HitOrMiss();
    board = new GameBoard(8, 8);
    trackerBoard = new char[8][8];
  }

  @Test
  void humanHit() {
    List<Coord> points = Arrays.asList(
        new Coord(1, 1),
        new Coord(1, 2),
        new Coord(1, 3));
    List<Coord> successfulHits = h.humanHit(points, board, trackerBoard);
    assertEquals('M', board.getBoard(1,1));
    assertEquals('M', board.getBoard(1,2));
    assertEquals('M', board.getBoard(1,3));
    assertEquals('M', trackerBoard[1][1]);
    assertEquals('M', trackerBoard[1][2]);
    assertEquals('M', trackerBoard[1][3]);

    assertEquals(0, successfulHits.size());
  }

  @Test
  void aiHit() {
    List<Coord> points = new ArrayList<>();
    points.add(new Coord(2, 2));
    points.add(new Coord(3, 3));

    List<Coord> successfulHits = h.aiHit(points, board);

    assertEquals('M', board.getBoard(2, 2));
    assertEquals('M', board.getBoard(3, 3));

    assertEquals(0, successfulHits.size());
  }
}