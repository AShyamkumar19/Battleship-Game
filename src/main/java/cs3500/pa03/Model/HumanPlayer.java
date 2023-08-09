package cs3500.pa03.Model;

import cs3500.pa03.Controller.BattleSalvoGame;
import cs3500.pa03.Player;
import cs3500.pa03.View.BoardSetupView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents the human player.
 */
public class HumanPlayer implements Player {
  BattleSalvoGame gm;

  @Override
  public String name() {
    return "User Player";
  }

  public HumanPlayer(BattleSalvoGame gm) {
    this.gm = gm;
  }

  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    ArrayList<Ship> ships = new ArrayList<>();
    GameBoard gm = new GameBoard(height, width);
    for (ShipType shipType : specifications.keySet()) {
      for (int i = 0; i < specifications.get(shipType); i++) {
        Ship ship = new Ship(shipType, gm.placeShip(shipType));
        ships.add(ship);

      }
    }
    return ships;
  }

  @Override
  public List<Coord> takeShots() {
    TakeShot ts = new TakeShot();
    return ts.takeShots(gm.getBoardSetup());
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    BoardSetupView bsv = new BoardSetupView();
    for (Coord c : opponentShotsOnBoard) {
      int x = c.getRow();
      int y = c.getCol();
      bsv.printAiShots(x, y);
    }
    return opponentShotsOnBoard;
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    BoardSetupView bsv = new BoardSetupView();
    for (Coord c : shotsThatHitOpponentShips) {
      int x = c.getRow();
      int y = c.getCol();
      bsv.printHumanShots(x, y);
    }
  }

  @Override
  public void endGame(GameResult result, String reason) {
    return;
  }
}
