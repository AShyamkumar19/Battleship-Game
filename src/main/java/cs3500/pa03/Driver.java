package cs3500.pa03;

import cs3500.pa03.Controller.BattleSalvoGame;
import cs3500.pa03.Controller.BoardSetup;
import cs3500.pa03.Model.ShipUnits;
import java.io.InputStreamReader;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    final ShipUnits su = new ShipUnits();
    BattleSalvoGame game = new BattleSalvoGame();
    BoardSetup bs = new BoardSetup(new InputStreamReader(System.in), System.out);

    bs.setupBoard();
    int height = bs.getHeight();
    int width = bs.getWidth();
    int carrier = bs.getCarrier();
    int battleship = bs.getBattleship();
    int destroyer = bs.getDestroyer();
    int submarine = bs.getSubmarine();
    int totalShipUnits = su.getShipUnits(carrier, battleship, destroyer, submarine);
    game.startGame(height, width, carrier, battleship, destroyer, submarine, totalShipUnits, bs);
  }
}