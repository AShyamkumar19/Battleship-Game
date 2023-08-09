package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipUnitsTest {
  ShipUnits s;

  @BeforeEach
  void setup() {
    s = new ShipUnits();
  }

  @Test
  void getShipUnits() {
    int units1 = s.getShipUnits(0, 0, 0, 0);
    assertEquals(0, units1);

    int units2 = s.getShipUnits(1, 2, 3, 4);
    int expectedUnits2 = ShipType.CARRIER.getLength() * 1
        + ShipType.BATTLESHIP.getLength() * 2
        + ShipType.DESTROYER.getLength() * 3
        + ShipType.SUBMARINE.getLength() * 4;
    assertEquals(expectedUnits2, units2);

    int units3 = s.getShipUnits(-1, -2, -3, -4);
    int expectedUnits3 = ShipType.CARRIER.getLength() * -1
        + ShipType.BATTLESHIP.getLength() * -2
        + ShipType.DESTROYER.getLength() * -3
        + ShipType.SUBMARINE.getLength() * -4;
    assertEquals(expectedUnits3, units3);
  }
}