package cs3500.pa03.Model;

import cs3500.pa03.Controller.BattleSalvoGame;
import cs3500.pa03.Player;
import cs3500.pa03.View.BoardSetupView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents the AI player.
 */
public class AiPlayer implements Player {
  BattleSalvoGame bsg;

  @Override
  public String name() {
    return "AI Player";
  }

  public AiPlayer(BattleSalvoGame bsg) {
    this.bsg = bsg;
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
    return ts.aiTakeShots(bsg.getBoardSetup());
  }

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return opponentShotsOnBoard;
  }

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    BoardSetupView bsv = new BoardSetupView();
    for (Coord c : shotsThatHitOpponentShips) {
      int x = c.getRow();
      int y = c.getCol();
      bsv.printAiShots(x, y);
    }

  }

  @Override
  public void endGame(GameResult result, String reason) {
    return;
  }
}
