package cs3500.pa03.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the game board.
 */
public class GameBoard {
  private final int height;
  private final int width;
  private final char[][] board;
  private int sunkShips;
  Random rand = new Random();

  /**
   * @param height the height of the board
   * @param width the width of the board
   */
  public GameBoard(int height, int width) {
    this.height = height;
    this.width = width;
    this.board = new char[height][width];
    createBoard();
  }

  /**
   * Creates the blank board.
   */
  public void createBoard() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.board[i][j] = '0';
      }
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public char getBoard(int row, int col) {
    return board[row][col];
  }

  public void setBoard(int x, int y, char h) {
    this.board[x][y] = h;
  }

  public void sinkShip() {
    sunkShips++;
  }

  public int getShipsSunk() {
    return sunkShips;
  }

  /**
   * @param ship the ship to be placed
   * @return the coordinates of the ship
   */
  public List<Coord> placeShip(ShipType ship) {
    int length = ship.getLength();
    boolean vertical = rand.nextBoolean();
    char symbol = ship.getSymbol();
    int row = 0;
    int col = 0;
    boolean validPosition = false;
    ArrayList<Coord> points = new ArrayList<>();

    while (!validPosition) {
      if (vertical) {
        row = rand.nextInt(height - length + 1);
        col = rand.nextInt(width);
        points.add(new Coord(row, col));
      } else {
        row = rand.nextInt(height);
        col = rand.nextInt(width - length + 1);
        points.add(new Coord(row, col));
      }
      validPosition = openSpot(ship, row, col, vertical);
    }
    if (vertical) {
      for (int i = 0; i < length; i++) {
        board[row + i][col] = symbol;
      }
    } else {
      for (int i = 0; i < length; i++) {
        board[row][col + i] = symbol;
      }
    }
    return points;
  }

  /**
   * @param ship - the ship to be placed
   * @param row - the row or x coordinate
   * @param col - the column or y coordinate
   * @param vertical - whether the ship is vertical or horizontal
   * @return boolean
   */
  public boolean openSpot(ShipType ship, int row, int col, boolean vertical) {
    int length = ship.getLength();

    if (vertical) {
      for (int i = 0; i < length; i++) {
        if ((board[row + i][col] != '0')
            || (row >= height && col >= width && row < 0 && col < 0)) {
          return false;
        }
      }
    } else {
      for (int i = 0; i < length; i++) {
        if ((board[row][col + i] != '0')
            || (row >= height && col >= width && row < 0 && col < 0)) {
          return false;
        }
      }
    }
    return true;
  }
}
