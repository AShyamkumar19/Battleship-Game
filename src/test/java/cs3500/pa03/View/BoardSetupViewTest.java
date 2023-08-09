package cs3500.pa03.View;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardSetupViewTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private BoardSetupView view;

  @BeforeEach
  void setUp() {
    view = new BoardSetupView();
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testPrintWelcomeMessage() {
    view.printWelcomeMessage();
    //assertEquals("Hello! Welcome to the OOD BattleSalvo Game! \n", outContent.toString());
  }

  @Test
  void testPrintDimensionsMessage() {
    view.printDimensionsMessage();
    //assertEquals("Please enter a valid height and width below: \n", outContent.toString());
  }

  @Test
  void testPrintLine() {
    view.printLine();
//    assertEquals("------------------------------------------------------\n", outContent.toString());
  }

  @Test
  void testPrintInvalidDimensions() {
    view.printInvalidDimensions();
    String expectedOutput = "Uh Oh! You've entered invalid dimensions. "
        + "Please remember that the height and width\n"
        + "of the game must be in the range (6, 15), inclusive. Try again! \n";
    //assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testPrintFleetMessage() {
    int maxShips = 5;
    view.printFleetMessage(maxShips);
    String expectedOutput = "Please enter your fleet in the order "
        + "[Carrier, Battleship, Destroyer, Submarine].\n"
        + "Remember, your fleet may not exceed size " + maxShips + ".\n";
//    assertEquals("Please enter your fleet in the order "
//        + "[Carrier, Battleship, Destroyer, Submarine].\n" +
//        "Remember, your fleet may not exceed size 5.\n", outContent.toString());
  }

  @Test
  void testPrintInvalidFleetMessage() {
    int maxShips = 5;
    view.printInvalidFleetMessage(maxShips);
    String expectedOutput = "Uh Oh! You've entered invalid fleet sizes.\n"
        + "Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n"
        + "Remember, your fleet may not exceed size " + maxShips + ".\n";
   // assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testPrintTakeShots() {
    int maxShots = 3;
    view.printTakeShots(maxShots);
    String expectedOutput = "Please enter + " + maxShots + " Shots (Ex: x y): \n";
    //assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testPrintInvalidShots() {
    int maxShots = 3;
    view.printInvalidShots(maxShots);
    String expectedOutput = "Uh Oh! You've entered invalid shots.\n"
        + "Please enter + " + maxShots + " Shots: \n";
    //assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testPrintAiShots() {
    int x = 2;
    int y = 3;
    view.printAiShots(x, y);
    String expectedOutput = "AI got hit at point: (" + x + ", " + y + ")\n";
    //assertEquals(expectedOutput, outContent.toString());
  }
  @Test
  void testPrintHumanShots() {
    int x = 2;
    int y = 3;
    view.printHumanShots(x, y);
    String expectedOutput = "You got hit at point: (" + x + ", " + y + ")\n";
    //assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  void testPrintUserWinner() {
    view.printUserWinner();
    //assertEquals("Congratulations! You won!\n", outContent.toString());
  }

  @Test
  void testPrintLoser() {
    view.printLoser();
    //assertEquals("Sorry! You lost!\n", outContent.toString());
  }

  @Test
  void testPrintTie() {
    view.printTie();
    //assertEquals("It's a tie!\n", outContent.toString());
  }



}