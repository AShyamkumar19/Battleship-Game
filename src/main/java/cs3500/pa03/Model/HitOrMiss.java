package cs3500.pa03.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents whether a hit or miss occurred.
 */
public class HitOrMiss {

  /**
   * @param points the points to be checked
   * @param board the board to be checked
   * @param trackerBoard the tracker board to be checked
   * @return the list of successful hits
   */
  public List<Coord> humanHit(List<Coord> points, GameBoard board, char[][] trackerBoard) {
    ArrayList<Coord> humanSuccessfulHits = new ArrayList<>();
    for (Coord c : points) {
      int x = c.getRow();
      int y = c.getCol();
      if (board.getBoard(x, y) != '0') {
        board.setBoard(x, y, 'H');
        trackerBoard[x][y] = 'H';
        humanSuccessfulHits.add(c);
        board.sinkShip();
      } else {
        board.setBoard(x, y, 'M');
        trackerBoard[x][y] = 'M';
      }
    }
    return humanSuccessfulHits;
  }

  /**
   * @param points the points to be checked
   * @param board the board to be checked
   * @return the list of successful hits
   */
  public List<Coord> aiHit(List<Coord> points, GameBoard board) {
    ArrayList<Coord> aiSuccessfulHits = new ArrayList<>();
    for (Coord c : points) {
      int x = c.getRow();
      int y = c.getCol();
      if (board.getBoard(x, y) != '0') {
        board.setBoard(x, y, 'H');
        aiSuccessfulHits.add(c);
        board.sinkShip();
      } else {
        board.setBoard(x, y, 'M');
      }
    }
    return aiSuccessfulHits;
  }
}
