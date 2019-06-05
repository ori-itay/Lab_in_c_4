import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ToyCAD {
	
  private static final boolean EXIT = true;
  private static final boolean DONT_EXIT = false;
  

  public static void main(
      String[]
          args) {
    List<IShape> shapes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String line = scanner.nextLine();
      Map<String, Object> parsedCommand = parseLine(line);
      boolean exit = executeCommand(parsedCommand, shapes);
      if (exit) {
        break;
      }
    }
    scanner.close();
  }

  enum PrintTotalMethod {
    AREA,
    CIRCUMFERENCE
  }

  private static boolean executeCommand(Map<String, Object> parsedCommand, List<IShape> shapes) {
    switch ((String) parsedCommand.get("command")) {
      case "NEW":
        addNewInstanceToShapes(shapes, parsedCommand);
        return DONT_EXIT;
      case "DELETE":
        shapes.remove(parsedCommand.get("ID"));
        return DONT_EXIT;
      case "MOVE":
        shapes
            .get((int) parsedCommand.get("ID"))
            .move((double) parsedCommand.get("moveX"), (double) parsedCommand.get("moveY"));
        return DONT_EXIT;
      case "COPY":
        IShape copiedShape = shapes.get((int) parsedCommand.get("ID")).copy();
        copiedShape.move((double) parsedCommand.get("moveX"), (double) parsedCommand.get("moveY"));
        shapes.add(copiedShape);
        return DONT_EXIT;
      case "AREA":
        printTotalColored(shapes, (IShape.Color) parsedCommand.get("color"), PrintTotalMethod.AREA);
        return DONT_EXIT;
      case "COLOR":
        shapes
            .get((int) parsedCommand.get("ID"))
            .setColor((IShape.Color) parsedCommand.get("color"));
        return DONT_EXIT;
      case "CIRCUMFERENCE":
        printTotalColored(shapes, (IShape.Color) parsedCommand.get("color"), PrintTotalMethod.CIRCUMFERENCE);
        return DONT_EXIT;
      case "IS_INSIDE":
        if (shapes
            .get((int) parsedCommand.get("ID"))
            .is_inside((double) parsedCommand.get("x"), (double) parsedCommand.get("y"))) {
          System.out.println("1");
        } else {
          System.out.println("0");
        }
        return DONT_EXIT;
      case "EXIT":
        return EXIT;
      default:
    	return DONT_EXIT;
    }
  }

  private static void addNewInstanceToShapes(
      List<IShape> shapes,
      Map<String, Object> parsedCommand) {
	IShape shape = null;
    String className = (String) parsedCommand.get("className");
    double x1 = (double) parsedCommand.get("x1");
    double y1 = (double) parsedCommand.get("y1");
    IShape.Color color = (IShape.Color) parsedCommand.get("color");
    switch (className) {
      case "ELLIPSE":
        double D = (double) parsedCommand.get("D");
        shape =
            new Ellipse(
                color,
                x1,
                y1,
                (double) parsedCommand.get("x2"),
                (double) parsedCommand.get("y2"),
                D);
        break;
      case "CIRCLE":
        double radius = (double) parsedCommand.get("radius");
        shape = new Circle(color, x1, y1, radius);
        break;
      case "PARALLELOGRAM":
    	  shape =
            new Parallelogram(
                color,
                x1,
                y1,
                (double) parsedCommand.get("x2"),
                (double) parsedCommand.get("y2"),
                (double) parsedCommand.get("x3"),
                (double) parsedCommand.get("y3"));
        break;
      case "RECTANGLE":
    	  shape =
            new Rectangle(
                color, x1, y1, (double) parsedCommand.get("x2"), (double) parsedCommand.get("y2"));
        break;
      case "SQUARE":
        double length = (double) parsedCommand.get("length");
        shape = new Square(color, x1, y1, length);
        break;
      case "TRIANGLE":
    	  shape =
            new Triangle(
                color,
                x1,
                y1,
                (double) parsedCommand.get("x2"),
                (double) parsedCommand.get("y2"),
                (double) parsedCommand.get("x3"),
                (double) parsedCommand.get("y3"));
        break;
    }
    shapes.add(shape);
  }

  private static Map<String, Object> parseLine(String line) {
    Map<String, Object> parsedCommand = new HashMap<>();
    String singleSpaceUppercasedLine = line.replaceAll("\\s+", " ").toUpperCase();
    List<String> splittedLine = Arrays.asList(singleSpaceUppercasedLine.split(" "));
    if (splittedLine.get(0).equals("")) {
      splittedLine.remove(0);
    }
    parsedCommand.put("command", splittedLine.get(0));

    switch (splittedLine.get(0)) {
      case ("NEW"):
        parseNewCommand(splittedLine, parsedCommand);
        break;
      case ("DELETE"):
        parsedCommand.put("ID", Integer.valueOf(splittedLine.get(1)));
        break;
      case ("MOVE"): 
      case ("COPY"):
        parsedCommand.put("ID", Integer.valueOf(splittedLine.get(1)));
        parsedCommand.put("moveX", Double.valueOf(splittedLine.get(2)));
        parsedCommand.put("moveY", Double.valueOf(splittedLine.get(3)));
        break;
      case ("AREA"):
      case ("CIRCUMFERENCE"):
        parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(1)));
        break;
      case ("COLOR"):
        parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(1)));
        parsedCommand.put("ID", Integer.valueOf(splittedLine.get(2)));
        break;
      case ("IS_INSIDE"):
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

  private static void parseNewCommand(
      List<String> splittedLine, Map<String, Object> parsedCommand) {
    parsedCommand.put("className", splittedLine.get(1));
    parsedCommand.put("color", IShape.Color.valueOf(splittedLine.get(2)));
    parsedCommand.put("x1", Double.valueOf(splittedLine.get(3)));
    parsedCommand.put("y1", Double.valueOf(splittedLine.get(4)));

    if (splittedLine.get(1).equals("ELLIPSE")
        || splittedLine.get(1).equals("PARALLELOGRAM")
        || splittedLine.get(1).equals("RECTANGLE")
        || splittedLine.get(1).equals("TRIANGLE")) {
      parsedCommand.put("x2", Double.valueOf(splittedLine.get(5)));
      parsedCommand.put("y2", Double.valueOf(splittedLine.get(6)));
    }
    if (splittedLine.get(1).equals("PARALLELOGRAM") || splittedLine.get(1).equals("TRIANGLE")) {
      parsedCommand.put("x3", Double.valueOf(splittedLine.get(7)));
      parsedCommand.put("y3", Double.valueOf(splittedLine.get(8)));
    }

    if (splittedLine.get(1).equals("CIRCLE")) {
      parsedCommand.put("radius", Double.valueOf(splittedLine.get(5)));
    } else if (splittedLine.get(1).equals("ELLIPSE")) {
      parsedCommand.put("D", Double.valueOf(splittedLine.get(7)));
    } else if (splittedLine.get(1).equals("SQUARE")) {
      parsedCommand.put("length", Double.valueOf(splittedLine.get(5)));
    }
  }

  static void printTotalColored(List<IShape> shapes, IShape.Color color, PrintTotalMethod method) {
    DecimalFormat formatter = new DecimalFormat("#0.00");
    double totalColored = 0;

    for (IShape shape : shapes) {
      if (method == PrintTotalMethod.AREA && shape.getColor() == color) {
        totalColored += shape.getArea();
      } else if (method == PrintTotalMethod.CIRCUMFERENCE && shape.getColor() == color) {
        totalColored += shape.getCircumference();
      }
    }
    System.out.println(formatter.format(totalColored));
  }
}