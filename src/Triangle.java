
public class Triangle extends Shape {
	public double x2;
	public double y2;
	public double x3;
	public double y3;
	
	public Triangle(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		super();
		System.out.println("aa");
	}
	
	@Override
	public void move(double moveX, double moveY) { // code reuse with the one in parallelogram
		super.move(moveX, moveY); 
		this.x2 += moveX;
		this.x3 += moveX;
		this.y2 += moveY;
		this.y3 += moveY;
	}

}
