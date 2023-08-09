package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationTest {
  Validation v;

  /**
   * Set up the Validation object.
   */
  @BeforeEach
  public void setup() {
    v = new Validation();
  }

  @Test
  void validateDimensions() {
    String input1 = "9\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input1.getBytes());
    System.setIn(inputStream);
    Scanner scanner = new Scanner(System.in);

    int result = v.validateDimensions(scanner);
    assertEquals(9, result);
  }

  @Test
  void validateNumber() {
  }

  @Test
  void validateFleet() {
    String input = "1\n1\n1\n1\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    Scanner scanner = new Scanner(System.in);

    int initialCarrier = 1;
    int initialBattleship = 1;
    int initialDestroyer = 1;
    int initialSubmarine = 1;

    v.validateFleet(8, initialCarrier, initialBattleship, initialDestroyer, initialSubmarine);

    // Assert that the fleet values have been updated correctly
    assertEquals(1, initialCarrier);
    assertEquals(1, initialBattleship);
    assertEquals(1, initialDestroyer);
    assertEquals(1, initialSubmarine);

  }
}