/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;
	
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.yaml.snakeyaml.Yaml;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The Class Main.
 * @brief Represents main, contains information loading from input file.
 */
public class Main extends Application {
	
	/**
	 * Coordinate getter.
	 * @brief Method for returning coordinates of certain part of street.
	 * @param strName street name
	 * @param part part of street
	 * @param map street map
	 * @return the coordinate
	 */
	public Coordinate coordGetter(String strName, String part, StreetMap map) {
		Coordinate toBeReturned;
		if (part.equals("end")) {
			toBeReturned = map.getStreet(strName).end();
		}
		else {
			toBeReturned = map.getStreet(strName).begin();
		}
		return toBeReturned;
	}
	
	/**
	 * Start.
	 * @brief Creation of needed structures, data loading from input files.
	 * @param primaryStage top level JavaFX container
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Sample.fxml")); // fxml file loading
			BorderPane root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			StreetMap streetMap = new StreetMap(); // instances of classes which are used for street and path saving.
			PathMap pathMap = new PathMap();
			int ID = 0;
        	Double c1;
        	Double c2;
			
			Yaml yaml = new Yaml(); // yaml file loading, divided into arrays for each yaml object that was loaded
		    try (InputStream in = Main.class.getResourceAsStream("/export.yml")) {
		    	LinkedHashMap<?, ?> obj = (LinkedHashMap<?, ?>) yaml.load(in);
		        ArrayList<?> streets = (ArrayList<?>) obj.get("streets");
		        ArrayList<?> stops = (ArrayList<?>) obj.get("stops");
		        ArrayList<?> paths = (ArrayList<?>) obj.get("paths");
		        List<Draw> elements = new ArrayList<>();
		          
		        Iterator<?> itr = streets.iterator(); // street loading from yaml
		        while (itr.hasNext()) {
		        	LinkedHashMap<?, ?> streetYAML = (LinkedHashMap<?, ?>) itr.next();
		        	c1 = Double.valueOf(((LinkedHashMap<?, ?>) streetYAML.get("from")).get("x").toString());
		        	c2 = Double.valueOf(((LinkedHashMap<?, ?>) streetYAML.get("from")).get("y").toString());
		        	Coordinate from = Coordinate.create(c1, c2);
		        	c1 = Double.valueOf(((LinkedHashMap<?, ?>) streetYAML.get("to")).get("x").toString());
		        	c2 = Double.valueOf(((LinkedHashMap<?, ?>) streetYAML.get("to")).get("y").toString());
		        	Coordinate to = Coordinate.create(c1, c2);
		        	Street street = new Street((String)(streetYAML.get("name").toString()), from, to);
		        	streetMap.addStreet(street);
		        }
		          
		        itr = stops.iterator();  // stop loading from yaml
		        while (itr.hasNext()) { 
		        	LinkedHashMap<?, ?> stopYAML = (LinkedHashMap<?, ?>) itr.next();
		        	c1 = Double.valueOf((((LinkedHashMap<?, ?>) stopYAML.get("coordinates")).get("x")).toString());
		        	c2 = Double.valueOf((((LinkedHashMap<?, ?>) stopYAML.get("coordinates")).get("y")).toString());
		        	Coordinate stopCoordinate = Coordinate.create(c1,c2);
		        	Stop stop = new Stop(stopYAML.get("id").toString(), stopCoordinate);
		        	stop.setStreet(streetMap.getStreet(stopYAML.get("street").toString()));
		        	stop.getStreet().addStop(stop);
		        }
		        
		        itr = paths.iterator(); // path loading from yaml
		        while (itr.hasNext()) {
		        	LinkedHashMap<?, ?> pathsYAML = (LinkedHashMap<?, ?>) itr.next();
		        	List<Coordinate> coordsOfPath = new ArrayList<Coordinate>();
		        	String pathName = pathsYAML.get("name").toString();
		        	
		        	String[] splitString = pathsYAML.get("from").toString().split("\\.");
		        	Coordinate start = coordGetter(splitString[0], splitString[1],streetMap);
		        	coordsOfPath.add(start);
		        	
		        	String[] throughStreets = pathsYAML.get("through").toString().split(" ");
		        	for (String throughStr:throughStreets) {
		        		splitString = throughStr.split("\\.");
		        		Coordinate coord = coordGetter(splitString[0], splitString[1],streetMap);
		        		coordsOfPath.add(coord);
		        	}
		        	
		        	splitString = pathsYAML.get("to").toString().split("\\.");
		        	Coordinate end = coordGetter(splitString[0], splitString[1],streetMap);
		        	coordsOfPath.add(end);
		        	
		        	double timetable = Double.valueOf(pathsYAML.get("timetable").toString());
		        	Path path = new Path(coordsOfPath, timetable);
		        	
		        	throughStreets = pathsYAML.get("streets").toString().split(" ");
		        	for (String pathStreet:throughStreets) {
		        		path.addStreet(streetMap.getStreet(pathStreet));
		        	}
		        	
		        	ID++;
		        	elements.add(new Vehicle(ID,new Coordinate(0,0),10,path));
		        	pathMap.addPath(path, pathName);
		        }
		        SampleController controller = loader.getController();
		        controller.setMaps(pathMap, streetMap);
		        controller.addLinesToList();
		        controller.setLines();
			    controller.setElements(elements);
				controller.TimerStart(1);
		    } catch (Exception e) {
		    	System.out.println("Error occured during yaml file reading.");
		    	e.printStackTrace();
		    }		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method.
	 * @brief launch of application.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
