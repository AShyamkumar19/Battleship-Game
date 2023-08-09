package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class GameResultTest {
  GameResult g;

  /**
   * Set up the GameResult object.
   */
  @BeforeEach
  public void setup() {
    g = GameResult.WIN;
  }

  void testEnumValues() {
    assertEquals(3, GameResult.values().length);
    assertEquals(GameResult.WIN, GameResult.valueOf("WIN"));
    assertEquals(GameResult.LOSE, GameResult.valueOf("LOSE"));
    assertEquals(GameResult.TIE, GameResult.valueOf("TIE"));
  }

}