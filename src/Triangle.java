
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
		this.area = computeArea(x1, y1 ,x2 ,y2 ,x3 ,y3);
		this.circumference = computeCircumference(x1, y1 ,x2 ,y2 ,x3 ,y3);
	}
	
	@Override
	public void move(double moveX, double moveY) { // code reuse with the one in parallelogram
		super.move(moveX, moveY); 
		this.x2 += moveX;
		this.x3 += moveX;
		this.y2 += moveY;
		this.y3 += moveY;
	}

	@Override
	public boolean is_inside(double x, double y) {
		// TODO Auto-generated method stub
		   /* Calculate area of triangle ABC */
	    double A = this.getArea(); 
	   
	   /* Calculate area of triangle PBC */  
	    double A1 = computeArea(x, y ,x2 ,y2 ,x3 ,y3);
	   
	   /* Calculate area of triangle PAC */  
	    double A2 = computeArea(x1, y1 ,x ,y ,x3 ,y3);
	   
	   /* Calculate area of triangle PAB */   
	    double A3 = computeArea(x1, y1 ,x2 ,y2 ,x ,y);
	     
	   /* Check if sum of A1, A2 and A3 is same as A */
	    return (A == A1 + A2 + A3); 
	}

	@Override
	public Triangle copy() {
		return new Triangle(this.color, this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
	}
	
	private static double computeArea(double x1, double y1,double x2, double y2, double x3, double y3) {	
		return Parallelogram.computeArea(x1, y1, x2, y2, x3, y3) / 2;
	}
	
	private static double computeCircumference(double x1, double y1, double x2, double y2, double x3, double y3) {
		double aSideLength = arithmeticDistance(x1, y1, x2, y2);
		double bSideLength = arithmeticDistance(x1, y1, x3, y3);
		double cSideLength = arithmeticDistance(x2, y2, x3, y3);
		double circumference = aSideLength + bSideLength + cSideLength;
		return circumference;	
	}
}
