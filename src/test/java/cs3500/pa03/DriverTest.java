package cs3500.pa03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class DriverTest {
  Driver driver;
  @Test
  public void testMain () {
    String userInput = "6 6 1 1 1 1 2 4 3 3 2 1\n";
    InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    //driver.main(new String[0]);
    System.setIn(System.in);
    System.setOut(System.out);

  }
}