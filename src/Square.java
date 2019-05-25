
public class Square extends Rectangle {
	public double length;
		
	public Square(Color color, double x1, double y1, double length) {
		super();
	}
	
	@Override
	public void move(double moveX, double moveY) { // no need to declare and just call super?
		super.move(moveX, moveY); // 
	}
}
