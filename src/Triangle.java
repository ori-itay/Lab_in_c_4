public class Triangle extends Shape {
  private double x2;
  private double y2;
  private double x3;
  private double y3;

  public Triangle(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
    super(color, x1, y1);
    this.x2 = x2;
    this.x3 = x3;
    this.y2 = y2;
    this.y3 = y3;
  }

  @Override
  public void move(double moveX, double moveY) {
    super.move(moveX, moveY);
    this.x2 += moveX;
    this.x3 += moveX;
    this.y2 += moveY;
    this.y3 += moveY;
  }

  @Override
  public boolean is_inside(double x, double y) {
    double area = this.getArea();

    double partialArea1 = Parallelogram.computeArea(x, y, x2, y2, x3, y3) / 2;

    double partialArea2 = Parallelogram.computeArea(x1, y1, x, y, x3, y3) / 2;

    double partialArea3 = Parallelogram.computeArea(x1, y1, x2, y2, x, y) / 2;

    return (area == partialArea1 + partialArea2 + partialArea3);
  }

  @Override
  public Triangle copy() {
    return new Triangle(this.color, this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
  }

  @Override
  public double getArea() {
    return Parallelogram.computeArea(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3) / 2;
  }

  @Override
  public double getCircumference() {
    double aSideLength = arithmeticDistance(this.x1, this.y1, this.x2, this.y2);
    double bSideLength = arithmeticDistance(this.x1, this.y1, this.x3, this.y3);
    double cSideLength = arithmeticDistance(this.x2, this.y2, this.x3, this.y3);
    double circumference = aSideLength + bSideLength + cSideLength;
    return circumference;
  }

}
