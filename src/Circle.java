public class Circle extends Ellipse {

  public Circle(Color color, double centerX, double centerY, double radius) {
    super(color, centerX, centerY, centerX, centerY, 2 * radius);
  }

  @Override
  public Circle copy() {
    return new Circle(this.color, this.x1, this.y1, this.D);
  }
  
  @Override
  public double getCircumference() {
    return Math.PI * this.D;
  }
}