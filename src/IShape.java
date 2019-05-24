
public interface IShape {
	
	enum Color {
		BLUE, RED, YELLOW, GREEN 
	}
	
	public void color(Color color);
	public double get_area();
	public void delete();
	public void move(double change_x, double change_y);
	public void copy();
	public void circumference();
	public void is_inside();
	
	

}
