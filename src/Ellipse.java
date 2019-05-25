import java.lang.Math;

public class Ellipse extends Shape {
	private double x2; // change in all files public to private?
	private double y2;
	private double D;
	
	
	
	public Ellipse(Color color, double x1, double y1, double x2, double y2, double D) {
		//super();
		this.color 	= color;
		this.x1 	= x1;
		this.x2 	= x2;
		this.y1 	= y1;
		this.y2 	= y2;
		this.D		= D;
	}
	
	public Ellipse(){
		//super();
	}
	
	@Override
	public void move(double moveX, double moveY) {
		super.move(moveX, moveY);
		this.x2 += moveX;
		this.y2 += moveY;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getCircumference() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_inside(double x, double y) { // TODO verify this
		double distanceFromFirstFocal  = arithmeticDistance(x1, y1, x, y);
		double distanceFromSecondFocal = arithmeticDistance(x2, y2, x, y);
		if (distanceFromFirstFocal + distanceFromSecondFocal <= D) {
			return true;
		}
		else {
			return false;
		}
	}

	private double arithmeticDistance(double x1, double y1, double x2, double y2) {
		double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		return distance;
		
	}

}
