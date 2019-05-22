
public abstract class Shape implements IShape {
	public Color color;
	public float area;
	public float x1;
	public float y1;
	public static long ID;
	
	public Shape() {
		ID++;
		System.out.println(ID);
	}
	
//	public float get_area() {
//		return this.area;
//	}
	
	public void color(Color color) {
		this.color = color;
	}
}
