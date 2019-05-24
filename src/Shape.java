
public abstract class Shape implements IShape {
	public Color color;
	public double area;
	public double x1;
	public double y1;
	public static int ID;
	
	public Shape() {
		ID++;
		System.out.println(ID);
	}
	
//	public float get_area() {
	//	
	//}
	
	public void color(Color color) {
		this.color = color;
	}
}
