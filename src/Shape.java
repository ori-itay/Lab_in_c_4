public abstract class Shape implements IShape {
	public IShape.Color color;
	public double area; // private?
	public double circumference;
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
	
	public double getArea() {
		return this.area;
	}
	
	public double getCircumference() {
		return this.circumference;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void move(double moveX, double moveY) {
		this.x1 += moveX;
		this.y1 += moveY;
	}
	
	static double arithmeticDistance(double x1, double y1, double x2, double y2) { // TODO need to return two decimal points -- WHY??
		double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		return distance;
	}
	
	static double shortest_distance(double x1, double y1, double lineSlope, double lineParam_a) { 
		if(lineSlope == 0) {
			return Math.abs(y1 - lineParam_a);
		}
		return Math.abs((-lineSlope * x1 + y1 - lineParam_a) /  lineSlope); 
	}
		
}
