import java.lang.Math;

public class Ellipse extends Shape {
	private double x2; 
	private double y2;
	public double D;
	
	
	public Ellipse(Color color, double x1, double y1, double x2, double y2, double D) {
		super(color, x1, y1);
		this.x2 	= x2;
		this.y2 	= y2;
		this.D		= D;
		this.area = computeArea(x1, y1, x2, y2, D);
		//this.circumference = computeCircumference();
	}
	
	@Override
	public void move(double moveX, double moveY) { // if circle is moved, x2 y2 is also moved etc..
		super.move(moveX, moveY);
		this.x2 += moveX;
		this.y2 += moveY;
	}

	@Override
	public boolean is_inside(double x, double y) { // TODO verify the math
		double distanceFromFirstFocal  = arithmeticDistance(x1, y1, x, y);
		double distanceFromSecondFocal = arithmeticDistance(x2, y2, x, y);
		if (distanceFromFirstFocal + distanceFromSecondFocal <= D) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Ellipse copy() {
		return new Ellipse(this.color, this.x1, this.y1, this.x2, this.y2, this.D);
	}
	
	private static double computeArea(double x1, double y1, double x2, double y2, double D) {
		double focus_dist = arithmeticDistance(x1, y1, x2, y2);
		double a = D/2;
		double c = focus_dist/2;
		double b = Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2));
		double area = Math.PI*a*b;
		return area;
	}
	
	private static double computeCircumference(double x1, double y1, double x2, double y2, double D) {
		//TODO implement
		double circumference = 0;
		return circumference;
	}
}
