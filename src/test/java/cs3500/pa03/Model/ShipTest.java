package cs3500.pa03.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
  Ship s;
  Ship s2;
  Ship s3;
  Ship s4;

  @BeforeEach
  public void setup() {
    List<Coord> points = Arrays.asList(
        new Coord(0, 1),
        new Coord(0, 2),
        new Coord(0, 3));
    s = new Ship(ShipType.CARRIER, points);
    s2 = new Ship(ShipType.BATTLESHIP, points);
    s3 = new Ship(ShipType.DESTROYER, points);
    s4 = new Ship(ShipType.SUBMARINE, points);
  }

  @Test
  void getShipType() {
    assertEquals(ShipType.CARRIER, s.getShipType());
    assertEquals(ShipType.BATTLESHIP, s2.getShipType());
    assertEquals(ShipType.DESTROYER, s3.getShipType());
    assertEquals(ShipType.SUBMARINE, s4.getShipType());
  }

  @Test
  void getPoints() {
    List<Coord> points2 = Arrays.asList(
        new Coord(0, 1),
        new Coord(0, 2),
        new Coord(0, 3));
    Ship ship = new Ship(ShipType.DESTROYER, points2);
    assertEquals(points2, ship.getPoints());
  }

  @Test
  void testShipTypeLength() {
    assertEquals(6, ShipType.CARRIER.getLength());
    assertEquals(5, ShipType.BATTLESHIP.getLength());
    assertEquals(3, ShipType.SUBMARINE.getLength());
    assertEquals(4, ShipType.DESTROYER.getLength());
  }

  @Test
  void testShipTypeSymbol() {
    assertEquals('C', ShipType.CARRIER.getSymbol());
    assertEquals('B', ShipType.BATTLESHIP.getSymbol());
    assertEquals('S', ShipType.SUBMARINE.getSymbol());
    assertEquals('D', ShipType.DESTROYER.getSymbol());
  }
}