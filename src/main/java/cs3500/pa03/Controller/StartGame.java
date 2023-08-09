package cs3500.pa03.Controller;

import static cs3500.pa03.View.PrintBoard.printAiBoard;
import static cs3500.pa03.View.PrintBoard.printBoard;
import cs3500.pa03.Model.AiPlayer;
import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.GameBoard;
import cs3500.pa03.Model.HitOrMiss;
import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.View.BoardSetupView;
import java.util.List;

/**
 * Represents the start of the game.
 */
public class StartGame {

  /**
   * @param humanBoard the human player's board
   * @param aiBoard the AI player's board
   * @param trackerBoard the tracker board
   * @param totalShipUnits the total number of ship units
   */
  public void runGame(GameBoard humanBoard, GameBoard aiBoard, char[][] trackerBoard,
                      int totalShipUnits, BattleSalvoGame bsg) {
    HumanPlayer humanPlayer = new HumanPlayer(bsg);
    AiPlayer aiPlayer = new AiPlayer(bsg);
    HitOrMiss hm = new HitOrMiss();
    BoardSetupView bsv = new BoardSetupView();
    boolean isGameOver = false;
    while (!isGameOver) {
      List<Coord> humanShots = humanPlayer.takeShots();
      List<Coord> aiShots = aiPlayer.takeShots();

      List<Coord> humanShotsOnBoard = humanPlayer.reportDamage(hm.aiHit(aiShots, humanBoard));
      List<Coord> aiShotsOnBoard = aiPlayer.reportDamage(hm.humanHit(humanShots, aiBoard,
          trackerBoard));

      humanPlayer.successfulHits(humanShotsOnBoard);
      aiPlayer.successfulHits(aiShotsOnBoard);

      printAiBoard(trackerBoard, "Opponent's Board");
      printBoard(humanBoard, "Your Board");

      if (humanBoard.getShipsSunk() == totalShipUnits) {
        bsv.printLoser();
        isGameOver = true;
        break;
      }
      if (aiBoard.getShipsSunk() == totalShipUnits) {
        bsv.printUserWinner();
        isGameOver = true;
        break;
      }
      if (humanBoard.getShipsSunk() == totalShipUnits && aiBoard.getShipsSunk() == totalShipUnits) {
        bsv.printTie();
        isGameOver = true;
        break;
      }

    }
  }
}
