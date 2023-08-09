package cs3500.pa03.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import cs3500.pa03.Model.Coord;
import cs3500.pa03.Model.GameBoard;
import cs3500.pa03.Model.ShipType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleSalvoGameTest {
  private BattleSalvoGame battleSalvoGame;
  private BoardSetup boardSetup;
  private GameBoard humanBoard;
  private GameBoard aiBoard;

  @BeforeEach
  void setUp() {
    boardSetup = mock(BoardSetup.class);
    battleSalvoGame = new BattleSalvoGame();
    battleSalvoGame.startGame(10, 10, 2, 2, 2, 2, 16, boardSetup);
    humanBoard = mock(GameBoard.class);
    aiBoard = mock(GameBoard.class);
  }

  //Uncomment the lines below to see it test the BattleSalvoGame and StartGame class
//  @Test
//  void testStartGame() {
//
//    Map<ShipType, Integer> specifications = new HashMap<>();
//    specifications.put(ShipType.SUBMARINE, 2);
//    specifications.put(ShipType.DESTROYER, 2);
//    specifications.put(ShipType.BATTLESHIP, 2);
//    specifications.put(ShipType.CARRIER, 2);
//
//    List<Coord> points = new ArrayList<>();
//    points.add(new Coord(0, 0));
//    points.add(new Coord(0, 1));
//    points.add(new Coord(0, 2));
//    points.add(new Coord(0, 3));
//
//
//    battleSalvoGame.startGame(10, 10, 2, 2, 2, 2, 16, boardSetup);
//    assertEquals(2, ShipType.SUBMARINE.getLength());
//    assertEquals(2, ShipType.DESTROYER.getLength());
//  }
}