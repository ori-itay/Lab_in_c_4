
public class Parallelogram extends Shape {
	public double x2;
	public double y2;
	public double x3;
	public double y3;
	private double x4;
	private double y4;
	
	public Parallelogram(Color color, double x1, double y1, double x2, double y2, double x3, double y3) {
		super(color, x1 ,y1);
		this.x3 = x3;
		this.y3 = y3;
		//this.x4 = ; klal makbilit
		//this.y4 = ;
		
	}
	
	public Parallelogram(double x2, double y2) {
		super(color, x1 ,y1);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public void move(double moveX, double moveY) {
		super.move(moveX, moveY); // TODO need to call Shape move..... 
		this.x2 += moveX;
		this.x3 += moveX;
		this.y2 += moveY;
		this.y3 += moveY;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getCircumference() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean is_inside(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
