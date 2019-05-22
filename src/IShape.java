
public interface IShape {
	
	enum Color {
		BLUE, RED, YELLOW, GREEN 
	}
	
	public void color(Color color);
	public float get_area();
	public void delete();
	public void move(float change_x, float change_y);
	public void copy();
	public void circumference();
	public void is_inside();
	
	

}
