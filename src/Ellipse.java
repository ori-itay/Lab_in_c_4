
public class Ellipse extends Shape {
	private double x2; // change in all files public to private?
	private double y2;
	private double D;
	
	
	
	public Ellipse(Color color, double x1, double y1, double x2, double y2, double D) {
		//super();
		this.x2 = x2;
		this.y2 = y2;
		this.D	= D;
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

}
