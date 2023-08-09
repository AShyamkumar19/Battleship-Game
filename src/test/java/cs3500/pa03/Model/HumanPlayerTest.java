package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cs3500.pa03.Controller.BattleSalvoGame;
import cs3500.pa03.View.BoardSetupView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanPlayerTest {
  BattleSalvoGame game;
  BoardSetupView view;
  HumanPlayer humanPlayer;

  @BeforeEach
  void setUp() {
    game = mock(BattleSalvoGame.class);
    view = mock(BoardSetupView.class);
    humanPlayer = new HumanPlayer(game);
  }

  @Test
  void testSetup() {
    int height = 10;
    int width = 10;
    List<Coord> coords = new ArrayList<>();
    coords.add(new Coord(0, 0));
    coords.add(new Coord(1, 1));
    coords.add(new Coord(2, 2));
    Map<ShipType, Integer> specifications = new HashMap<>();
    specifications.put(ShipType.CARRIER, 1);
    specifications.put(ShipType.BATTLESHIP, 2);

    GameBoard gameBoard = mock(GameBoard.class);
    when(gameBoard.placeShip(ShipType.CARRIER)).thenReturn(coords);

    List<Ship> expectedShips = new ArrayList<>();
    expectedShips.add(new Ship(ShipType.CARRIER, coords));
    expectedShips.add(new Ship(ShipType.BATTLESHIP, coords));
    expectedShips.add(new Ship(ShipType.BATTLESHIP, coords));

    List<Ship> actualShips = humanPlayer.setup(height, width, specifications);


    assertEquals(expectedShips.size(), actualShips.size());
    assertFalse(actualShips.containsAll(expectedShips));
  }

  @Test
  void testTakeShots() {
    List<Coord> opponentShots = new ArrayList<>();
    opponentShots.add(new Coord(0, 0));
    opponentShots.add(new Coord(1, 1));

    doNothing().when(view).printAiShots(0, 0);
    doNothing().when(view).printAiShots(1, 1);

    List<Coord> expectedShots = new ArrayList<>();
    expectedShots.add(new Coord(0, 0));
    expectedShots.add(new Coord(1, 1));

  }

  @Test
  void testReportDamage() {
    List<Coord> opponentShots = new ArrayList<>();
    opponentShots.add(new Coord(0, 0));
    opponentShots.add(new Coord(1, 1));

    doNothing().when(view).printAiShots(0, 0);
    doNothing().when(view).printAiShots(1, 1);

    List<Coord> actualShots = humanPlayer.reportDamage(opponentShots);

    assertEquals(opponentShots.size(), actualShots.size());
    assertTrue(actualShots.containsAll(opponentShots));
  }

  @Test
  void testSuccessfulHits() {
    List<Coord> successfulHits = new ArrayList<>();
    successfulHits.add(new Coord(0, 0));
    successfulHits.add(new Coord(1, 1));

    doNothing().when(view).printHumanShots(0, 0);
    doNothing().when(view).printHumanShots(1, 1);

    humanPlayer.successfulHits(successfulHits);
  }

  @Test
  void testEndGame() {
    humanPlayer.endGame(GameResult.WIN, "Congratulations!");

  }
}