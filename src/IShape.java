public interface IShape {

  enum Color {
    BLUE,
    RED,
    YELLOW,
    GREEN
  }

  public void setColor(Color color);

  public Color getColor();

  public double getArea();

  public void move(double moveX, double moveY);

  public Shape copy();

  public double getCircumference();

  public boolean is_inside(double x, double y);
}
