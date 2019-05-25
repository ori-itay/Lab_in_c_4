
public interface IShape {
	
	enum Color {
		BLUE, RED, YELLOW, GREEN 
	}
	
	public void setColor(Color color);
	public double getArea();
	//public double setArea(); put in Shape 
	//public void delete();
	public void move(double moveX, double moveY);
	//public void copy();
	public void getCircumference();
	//public void getSircumference();
	public void is_inside();
	
	

}
