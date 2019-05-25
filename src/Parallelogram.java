
public class Parallelogram extends Shape {
	public double x2;
	public double y2;
	public double x3;
	public double y3;
	
	public Parallelogram(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		
	}
	
	@Override
	public void move(double moveX, double moveY) {
		super.move(moveX, moveY); // TODO need to call Shape move..... 
		this.x2 += moveX;
		this.x3 += moveX;
		this.y2 += moveY;
		this.y3 += moveY;
	}

}
