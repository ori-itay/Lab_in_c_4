import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class ToyCAD {
	
	public static void main(String[] args) {
		ArrayList<IShape> shapes = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		HashMap<String, ?> parsedCommand = new HashMap<>();
		while (true) {
			String line = scanner.nextLine();
			parse_line(line, parsedCommand);
			boolean exit = executeCommand(parsedCommand, shapes);
			if (exit) {break; }
			parsedCommand.clear();
			
		}
		scanner.close();
	}
	
	private static boolean executeCommand(HashMap<String,?> parsedCommand, ArrayList<IShape> shapes ) {
		switch ((String)parsedCommand.get("command")) {
			case "Exit":
				return true;
			case "new":
				
				return false;
			case "move":
				int ID = (int)parsedCommand.get("ID");
				shapes.get(ID).move(parsedCommand); // now in whatever shape it is, use what needed (for example if the shape if circle, in the implementation of move in circle it will use only x1 x2 and radius..(so need to change 'move' declaration)
				return false;
			default:
				return false;
		}


	}
	
	private static void parse_line(String line, HashMap<String,?> parsed_command) {
		
	}
	
	

}
