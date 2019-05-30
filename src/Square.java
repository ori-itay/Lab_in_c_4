public class Square extends Rectangle {
  public double length;

  public Square(Color color, double centerX, double centerY, double length) {
    super(color, centerX - length / 2, centerY - length / 2, centerX + length / 2, centerY + length / 2);
  }

  @Override
  public Square copy() {
    return new Square(this.color, this.x1, this.y1, this.length);
  }
}
