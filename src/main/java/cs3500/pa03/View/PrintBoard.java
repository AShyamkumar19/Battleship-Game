package cs3500.pa03.View;

import cs3500.pa03.Model.GameBoard;

/**
 * Prints the board.
 */
public class PrintBoard {

  /**
   * @param board the GameBoard to be printed
   * @param player the title to be printed
   */
  public static void printBoard(GameBoard board, String player) {
    int height = board.getHeight();
    int width = board.getWidth();

    System.out.println(player);
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        System.out.print(board.getBoard(row, col) + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * @param board the char Board to be printed
   * @param player the title to be printed
   */
  public static void printAiBoard(char[][] board, String player) {
    int height = board.length;
    int width = board[0].length;

    System.out.println(player);
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}
