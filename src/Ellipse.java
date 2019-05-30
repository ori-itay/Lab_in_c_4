
public class Ellipse extends Shape {
  private double x2;
  private double y2;
  public double D;
  public double a;
  public double b;

  public Ellipse(Color color, double focusX1, double focusY1, double focusX2, double focusY2, double D) {
    super(color, focusX1, focusX2);
    this.x2 = focusX2;
    this.y2 = focusY2;
    this.D = D;
    this.a = D / 2;
    double focusDist = arithmeticDistance(this.x1, this.y1, this.x2, this.y2);
    double c = focusDist / 2;
    this.b = Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2));
    this.area = Math.PI * this.a * this.b;
    this.circumference = computeCircumference(this.a, this.b);
  }

  @Override
  public void move(double moveX, double moveY) {
    super.move(moveX, moveY);
    this.x2 += moveX;
    this.y2 += moveY;
  }

  @Override
  public boolean is_inside(double x, double y) { // TODO verify the math
    double distanceFromFirstFocal = arithmeticDistance(x1, y1, x, y);
    double distanceFromSecondFocal = arithmeticDistance(x2, y2, x, y);
    if (distanceFromFirstFocal + distanceFromSecondFocal <= D) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Ellipse copy() {
    return new Ellipse(this.color, this.x1, this.y1, this.x2, this.y2, this.D);
  }

  private static double computeCircumference(double a, double b) {
    final int N = 1000;
    double sum = 0;

    for (int n = 1; n < N; n++) {
      double A = doublefactorial(2 * n - 1) / (Math.pow(2, n) * factorial(n));
      double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
      double B = Math.pow(h, n) / Math.pow(2 * n - 1, 2);
      sum += Math.pow(A, 2) * B;
    }
    double circumference = Math.PI * (a + b) * (sum + 1);
    return circumference;
  }

  private static int doublefactorial(int n) {
    if (n == 0 || n == 1) return 1;

    return n * doublefactorial(n - 2);
  }

  private static int factorial(int n) {
    return doublefactorial(n) * doublefactorial(n - 1);
  }
}
