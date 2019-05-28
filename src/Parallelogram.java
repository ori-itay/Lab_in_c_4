
public class Parallelogram extends Shape {
	public double x2;
	public double y2;
	public double x3;
	public double y3;
	public double x4;
	public double y4;
	
	public Parallelogram(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(color, x1 ,y1);
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x1+x3-x2;
		this.y4 = y1+y3-y2;	
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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Parallelogram copy() {
		return new Parallelogram(this.color, this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
	}
	
	static double computeArea(double x1, double y1,double x2, double y2, double x3, double y3) {
		double height;
		double x2_x3_Dist = Math.abs(x2-x3);
		double y2_y3_Dist = Math.abs(y2-y3);
		if(x2_x3_Dist != 0) {
			double lineSlope = y2_y3_Dist/x2_x3_Dist;
			double lineParam_a = y2 - lineSlope*x2;
			height = shortest_distance(x1, y1, lineSlope, lineParam_a);
		}
		else {
			height = Math.abs(y1-y2);
		}
		double base = arithmeticDistance(x1, y1, x2, y2);		
		double area = base*height;
		return area;
	}
	
	static double computeCircumference(double x1, double y1, double x2, double y2, double x4, double y4) {
		double aSideLength = arithmeticDistance(x1, y1, x2, y2);
		double bSideLength = arithmeticDistance(x1, y1, x4, y4);
		double circumference = 2*aSideLength + 2*bSideLength;
		return circumference;
	}
}
