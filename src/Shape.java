public abstract class Shape implements IShape {
  protected IShape.Color color;
  protected double x1;
  protected double y1;
  protected static int ID;

  public Shape(Color color, double x1, double y1) {
    System.out.println(ID);
    ID++;
    this.x1 = x1;
    this.y1 = y1;
    this.color = color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return this.color;
  }

  public void move(double moveX, double moveY) {
    this.x1 += moveX;
    this.y1 += moveY;
  }

  protected static double arithmeticDistance(double x1, double y1, double x2, double y2) {
    double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    return distance;
  }
}