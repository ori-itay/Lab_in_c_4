
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
	public void move(double moveX, double moveY) { // code reuse with the one in parallelogram
		super.move(moveX, moveY); 
		this.x2 += moveX;
		this.x3 += moveX;
		this.y2 += moveY;
		this.y3 += moveY;
	}

	@Override
	public double getArea() {
		//TODO either calculate sizes and then s= (a+b+c)/2, then sqrt(s*(s-a)(s-b)(s-c)). or calculate it with what he said, half a paralellogram
		return 0;
	}

	@Override
	public void getCircumference() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_inside(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
