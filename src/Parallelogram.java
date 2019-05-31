public class Parallelogram extends Shape {
  protected double x2;
  protected double y2;
  protected double x3;
  protected double y3;
  protected double x4;
  protected double y4;

  public Parallelogram(
      Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
    super(color, x1, y1);
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
    this.x4 = x1 + x3 - x2;
    this.y4 = y1 + y3 - y2;
  }

  @Override
  public void move(double moveX, double moveY) {
    super.move(moveX, moveY); 
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

  @Override
  public double getArea() { 
	return computeArea(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
  }
  
  protected static double computeArea(double x1, double y1, double x2, double y2, double x3, double y3) {
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

  @Override
  public double getCircumference() {
    double aSideLength = arithmeticDistance(this.x1, this.y1, this.x2, this.y2);
    double bSideLength = arithmeticDistance(this.x1, this.y1, this.x4, this.y4);
    double circumference = 2 * aSideLength + 2 * bSideLength;
    return circumference;
  }
}
