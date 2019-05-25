
public abstract class Shape implements IShape {
	public Color color;
	//public double area; // private?
	public double x1;
	public double y1;
	public static int ID;
	
	public Shape() {
		System.out.println(ID);
		ID++;
		
	}
	
	public Shape(Color color, double x1, double y1) {
		this();
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
	}
	

	
/*	public double getArea() {
		return this.area;
	} */
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void move(double moveX, double moveY) {
		this.x1 += moveX;
		this.y1 += moveY;
	}
}
