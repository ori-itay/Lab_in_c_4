
public class Circle extends Ellipse {
	
	public Circle(Color color,  double x1, double y1, double radius) {
		super(color, x1, y1, x1, y1, 2*radius);
		this.circumference = 2 * Math.PI * radius; //overriding the previous computed ellipse Circumference -- OK?
	}
	
	@Override
	public Circle copy() {
		return new Circle(this.color, this.x1, this.y1, this.D);
	} 
}
