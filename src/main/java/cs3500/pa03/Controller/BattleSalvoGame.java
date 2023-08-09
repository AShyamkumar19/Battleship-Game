package cs3500.pa03.Controller;

import cs3500.pa03.Model.AiPlayer;
import cs3500.pa03.Model.GameBoard;
import cs3500.pa03.Model.HumanPlayer;
import cs3500.pa03.Model.Ship;
import cs3500.pa03.Model.ShipType;
import cs3500.pa03.Model.TrackerBoard;
import cs3500.pa03.Player;
import cs3500.pa03.View.PrintBoard;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates the starting board
 */
public class BattleSalvoGame {
  BoardSetup bs;

  /**
   * Gets all the specs for board
   *
   * @param height - height of board
   * @param width - width of board
   * @param carrier - number of carrier ships
   * @param battleship - number of battleship ships
   * @param destroyer - number of destroyer ships
   * @param submarine - number of submarine ships
   * @param totalShipUnits - total number of ship units
   */

  public void startGame(int height, int width, int carrier, int battleship, int destroyer,
                        int submarine, int totalShipUnits, BoardSetup bs) {
    this.bs = bs;
    Player p1 = new HumanPlayer(this);
    Player p2 = new AiPlayer(this);
    final PrintBoard pb = new PrintBoard();
    final StartGame sg = new StartGame();
    final TrackerBoard tb = new TrackerBoard();

    Map<ShipType, Integer> specifications = new HashMap<>();
    specifications.put(ShipType.SUBMARINE, submarine);
    specifications.put(ShipType.DESTROYER, destroyer);
    specifications.put(ShipType.BATTLESHIP, battleship);
    specifications.put(ShipType.CARRIER, carrier);

    List<Ship> playerShips = p1.setup(height, width, specifications);
    List<Ship> aiShips = p2.setup(height, width, specifications);

    GameBoard humanBoard = new GameBoard(height, width);
    for (Ship ship : playerShips) {
      humanBoard.placeShip(ship.getShipType());
    }

    GameBoard aiBoard = new GameBoard(height, width);
    for (Ship ship : aiShips) {
      aiBoard.placeShip(ship.getShipType());
    }

    char[][] trackerBoard = tb.trackerBoard(height, width);

    // pb.printBoard(aiBoard, "Opponent's Board Data"); // uncomment to see opponent's board
    pb.printAiBoard(trackerBoard, "Opponent's Board");
    pb.printBoard(humanBoard, "Your Board");
    sg.runGame(humanBoard, aiBoard, trackerBoard, totalShipUnits, this);

  }

  public BoardSetup getBoardSetup() {
    return this.bs;
  }
}
