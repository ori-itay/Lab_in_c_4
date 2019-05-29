public class Parallelogram extends Shape {
  public double x2;
  public double y2;
  public double x3;
  public double y3;
  public double x4;
  public double y4;

  public Parallelogram(
      Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
    super(color, x1, y1);
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
    this.x4 = x1 + x3 - x2;
    this.y4 = y1 + y3 - y2;
    this.area = computeArea(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
    this.circumference = computeCircumference(this.x1, this.y1, this.x2, this.y2, this.x4, this.y4);
  }

  @Override
  public void move(double moveX, double moveY) {
    super.move(moveX, moveY); // TODO need to call Shape move.....
    this.x2 += moveX;
    this.x3 += moveX;
    this.x4 += moveX;
    this.y2 += moveY;
    this.y3 += moveY;
    this.y4 += moveY;
  }

  @Override
  public boolean is_inside(double x, double y) {
    Triangle T1 = new Triangle(this.color, this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
    Triangle T2 = new Triangle(this.color, this.x1, this.y1, this.x4, this.y4, this.x3, this.y3);
    return (T1.is_inside(x, y) || T2.is_inside(x, y));
  }

  @Override
  public Parallelogram copy() {
    return new Parallelogram(this.color, this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
  }

  static double computeArea(double x1, double y1, double x2, double y2, double x3, double y3) {
    double[][] matrix = new double[2][2];

    matrix[0][0] = x2 - x1;
    matrix[0][1] = y2 - y1;

    matrix[1][0] = x2 - x3;
    matrix[1][1] = y2 - y3;

    double area = Math.abs(computeDeterminant(matrix));
    return area;
  }

  private static double computeDeterminant(double[][] matrix) {
    return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
  }

  static double computeCircumference(
      double x1, double y1, double x2, double y2, double x4, double y4) {
    double aSideLength = arithmeticDistance(x1, y1, x2, y2);
    double bSideLength = arithmeticDistance(x1, y1, x4, y4);
    double circumference = 2 * aSideLength + 2 * bSideLength;
    return circumference;
  }
}
