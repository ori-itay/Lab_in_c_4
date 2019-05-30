public class Circle extends Ellipse {

  public Circle(Color color, double centerX, double centerY, double radius) {
    super(color, centerX, centerY, centerX, centerY, 2 * radius);
    this.circumference =
        2 * Math.PI * radius; // overriding the previous computed ellipse Circumference -- OK?
  }

  @Override
  public Circle copy() {
    return new Circle(this.color, this.x1, this.y1, this.D);
  }
}
