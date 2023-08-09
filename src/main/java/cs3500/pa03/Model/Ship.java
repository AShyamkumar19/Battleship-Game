package cs3500.pa03.Model;

import java.util.List;

/**
 * Represents a ship.
 */
public class Ship {
  private ShipType type;
  private List<Coord> points;

  public Ship(ShipType type, List<Coord> points) {
    this.type = type;
    this.points = points;
  }

  public ShipType getShipType() {
    return type;
  }

  public List<Coord> getPoints() {
    return points;
  }

}
