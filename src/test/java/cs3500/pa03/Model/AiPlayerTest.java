package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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

class AiPlayerTest {
  BattleSalvoGame bsg;
  AiPlayer aiPlayer;

  @BeforeEach
  void setUp() {
    bsg = mock(BattleSalvoGame.class);
    aiPlayer = new AiPlayer(bsg);
  }

  @Test
  void testName() {
    assertEquals("AI Player", aiPlayer.name());
  }

  @Test
  void testSetup() {
    int height = 10;
    int width = 10;
    Map<ShipType, Integer> specifications = new HashMap<>();
    specifications.put(ShipType.CARRIER, 1);
    specifications.put(ShipType.BATTLESHIP, 2);
    specifications.put(ShipType.SUBMARINE, 3);

    aiPlayer.setup(height, width, specifications);

  }

  @Test
  void testTakeShots() {
    TakeShot ts = mock(TakeShot.class);
    when(ts.aiTakeShots(any())).thenReturn(new ArrayList<>());
  }

  @Test
  void testReportDamage() {
    List<Coord> opponentShots = new ArrayList<>();
    opponentShots.add(new Coord(2, 3));
    opponentShots.add(new Coord(4, 5));

    List<Coord> reportedDamage = aiPlayer.reportDamage(opponentShots);
    assertEquals(opponentShots, reportedDamage);
  }

  @Test
  void testSuccessfulHits() {
    BoardSetupView bsv = mock(BoardSetupView.class);
    List<Coord> shotsThatHit = new ArrayList<>();
    shotsThatHit.add(new Coord(2, 3));
    shotsThatHit.add(new Coord(4, 5));

    aiPlayer.successfulHits(shotsThatHit);
  }

  @Test
  void testEndGame() {
    GameResult result = GameResult.WIN;
    String reason = "All opponent's ships sunk";

    aiPlayer.endGame(result, reason);
  }

}