import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ToyCAD {
	
	public static void main(String[] args) { // DEBUGGING GOES LIKE THIS: checking new command with all shapes, move on to next command etc
		List<IShape> shapes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine().replaceAll("\\s+", " ");
			Map<String,Object> parsedCommand = parseLine(line);
			boolean exit = executeCommand(parsedCommand, shapes);
			if (exit) {break; }
		}
		scanner.close();
	}
	
	private static boolean executeCommand(Map<String,Object> parsedCommand, List<IShape> shapes ) {
		switch ((String)parsedCommand.get("command")) {
			
			case "new":
				addNewInstanceToShapes(shapes, parsedCommand); 
				return false;
			case "delete":
				shapes.remove(parsedCommand.get("ID"));
				return false;
			case "move":
				shapes.get((int) parsedCommand.get("ID")).move((double) parsedCommand.get("moveX"),(double) parsedCommand.get("moveY")); // now in whatever shape it is, use what's needed (for example if the shape if circle, in the implementation of move in circle it will use only x1 x2 and radius..(so need to change 'move' declaration)
				return false;
			case "copy": //specifically debug this
				
			case "is_inside":
				if (shapes.get((int) parsedCommand.get("ID")).is_inside((double) parsedCommand.get("x"), (double) parsedCommand.get("y"))) { System.out.println("1");}
				else {System.out.println("0");}
				return false;
			case "EXIT":
				return true;
			default:
				return false;
		}


	}
	


	private static void addNewInstanceToShapes(List<IShape> shapes, Map<String,Object> parsedCommand) { // TODO add area field...to consturtor or not..L54/55
		String className = (String) parsedCommand.get("className"); 
		double x1 = (double) parsedCommand.get("x1");
		double y1 = (double) parsedCommand.get("y1");
		IShape.Color color = (IShape.Color) parsedCommand.get("color");
		switch (className) { // change to if? and then no code replication.... with x2 x3 etc
			case "Ellipse":
				double D = (double) parsedCommand.get("D");
				IShape ellipse = new Ellipse(color, x1, y1, (double) parsedCommand.get("x2"), (double) parsedCommand.get("y2"), D);
				//ellipse.calculateArea();
				shapes.add(ellipse); // debug that its the incremented ID..
				break;
			case "Circle":
				double radius = (double) parsedCommand.get("radius");
				IShape circle = new Circle(color, x1, y1, radius);
				shapes.add(circle);
				break;
			case "Parallelogram":
				IShape parallelogram = new Parallelogram(color, x1, y1, (double) parsedCommand.get("x2"), (double) parsedCommand.get("y2"), (double) parsedCommand.get("x3"), (double) parsedCommand.get("y3"));
				shapes.add(parallelogram);
				break;
			case "Rectangle":
				IShape rectangle = new Rectangle(color, x1, y1, (double) parsedCommand.get("x2"), (double) parsedCommand.get("y2"));
				shapes.add(rectangle);
				break;
			case "Square":
				double length = (double) parsedCommand.get("length");
				IShape square = new Square(color, x1, y1, length) ;
				shapes.add(square);
				break;
			case "Triangle":
				IShape triangle = new Triangle(color, x1, y1, (double) parsedCommand.get("x2"), (double) parsedCommand.get("y2"), (double) parsedCommand.get("x3"), (double) parsedCommand.get("y3"));
				shapes.add(triangle);
				break;
			default:
				System.out.println("Invalid shape name!");
		}
		
	}

	private static Map<String, Object> parseLine(String line) {
		Map<String, Object> parsedCommand = new HashMap<>();
		List<String> splittedLine = Arrays.asList(line.split(" "));
		if (splittedLine.get(0).equals("")) { splittedLine.remove(0); }
		parsedCommand.put("command", splittedLine.get(0));
		
		switch (splittedLine.get(0)) {
			case ("new"):
				parseNewCommand(splittedLine, parsedCommand);
				break;
			case ("delete"):
				parsedCommand.put("ID",    Integer.valueOf(splittedLine.get(1)));
				break;
			case ("move"): // upper case or lower case?. case move and copy are the same, it will add the same arguments to the parsedCommand 
			case ("copy"):
				parsedCommand.put("ID",    Integer.valueOf(splittedLine.get(1)));
				parsedCommand.put("moveX", Double.valueOf(splittedLine.get(2)));
				parsedCommand.put("moveY", Double.valueOf(splittedLine.get(3)));
				break;
			case ("area"):
			case ("circumference"):
				parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(1)));
				break;
			case ("color"): // upper case or lower case?
				parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(1)));
				parsedCommand.put("ID", Integer.valueOf(splittedLine.get(2)));
				break;
			case ("is_inside"):
				parsedCommand.put("ID", Integer.valueOf(splittedLine.get(1)));
				parsedCommand.put("x", Double.valueOf(splittedLine.get(2)));
				parsedCommand.put("y", Double.valueOf(splittedLine.get(3)));
				break;
			case ("EXIT"):
				break;
			default:
				System.out.println("Command doesn't exist!");
		}
		
		return parsedCommand;
	}
	
	private static void parseNewCommand(List<String> splittedLine, Map<String,Object> parsedCommand){
		parsedCommand.put("className", splittedLine.get(1)); // shouldnt be when is_inside etc......
		parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(2)));
		parsedCommand.put("x1", Double.valueOf(splittedLine.get(3)));
		parsedCommand.put("y1", Double.valueOf(splittedLine.get(4)));
		
		if (splittedLine.get(1).equals("Ellipse") ||
				splittedLine.get(1).equals("Parallelogram") || 
				splittedLine.get(1).equals("Rectangle") || 
				splittedLine.get(1).equals("Triangle")) 
		{
			parsedCommand.put("x2", Double.valueOf(splittedLine.get(5)));
			parsedCommand.put("y2", Double.valueOf(splittedLine.get(6)));
		}
		if (splittedLine.get(1).equals("Paralellogram") || splittedLine.get(1).equals("Triangle")) {
			parsedCommand.put("x3", Double.valueOf(splittedLine.get(7)));
			parsedCommand.put("y3", Double.valueOf(splittedLine.get(8)));
		}
		
		if (splittedLine.get(1).equals("Circle")) {
			parsedCommand.put("radius", Double.valueOf(splittedLine.get(5)));
		}
		else if (splittedLine.get(1).equals("Ellipse")) {
			parsedCommand.put("D", Double.valueOf(splittedLine.get(7)));
		}
		else if (splittedLine.get(1).equals("Square")) {
			parsedCommand.put("length", Double.valueOf(splittedLine.get(5)));
		}
	}
	
	

}
