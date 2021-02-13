/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * The class vehicle.
 * @brief Class representing vehicle.
 */
public class Vehicle implements Draw,tUpdate{
	
	/** Coordinate representing current position. */
	private Coordinate position;
	
	/** The id. */
	private int ID;
	
	/** The speed. */
	private double speed = 0;
	
	/** The gui. */
	private List<Shape> gui;
	
	/** The distance. */
	private double distance = 0;
	
	/** The path. */
	private Path path;
	
	/** The l4. */
	private int L4=0;
	
	/** The l1. */
	private int L1=0;
	
	/** The l2. */
	private int L2=0;
	
	/** The l3. */
	private int L3=0;
	
	
	/**
	 * Instantiates a new vehicle.
	 * @param ID the id
	 * @param position position of vehicle
	 * @param speed speed of vehicle
	 * @param path path of vehicle
	 */
	public Vehicle(int ID,Coordinate position,double speed,Path path) {
		this.ID = ID;
		this.position = position;
		this.speed = speed;
		this.path = path;
		
		gui = new ArrayList<>();
		gui.add(new Circle(position.getX(),position.getY(),8,Color.rgb(38,209,215)));
	}
	
	/**
	 * Move objects in GUI
	 * @param coordinate to move objects to
	 */
	private void moveGUI(Coordinate coordinate) {
		for(Shape shape : gui) {
			shape.setTranslateX(coordinate.getX()-position.getX()+shape.getTranslateX());
			shape.setTranslateY(coordinate.getY()-position.getY()+shape.getTranslateY());
		}
	}
	
	/**
	 * Gets the gui.
	 * @brief Returns the gui.
	 * @return the gui
	 */
	@Override
	public List<Shape> getGUI() {
		return gui;
	}
	
	/**
	 * Update position of vehicles on map
	 * @brief Updates position of vehicles.
	 * @param time current time
	 * @return true, if successful
	 */
	@Override 
	public boolean update(LocalTime time) {
		boolean stopped = true;
		
		///LINKA1/// 965
		if((this.ID == 1)) {
			if(((time.isAfter(LocalTime.parse( "08:02:34" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:02:47" ).plus(974*L1,ChronoUnit.SECONDS))))) || 
			   ((time.isAfter(LocalTime.parse( "08:05:14" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:05:27" ).plus(974*L1,ChronoUnit.SECONDS))))) ||
			   ((time.isAfter(LocalTime.parse( "08:05:59" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:06:12" ).plus(974*L1,ChronoUnit.SECONDS))))) ||
			   ((time.isAfter(LocalTime.parse( "08:10:04" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:10:17" ).plus(974*L1,ChronoUnit.SECONDS))))) ||
			   ((time.isAfter(LocalTime.parse( "08:12:24" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:12:47" ).plus(974*L1,ChronoUnit.SECONDS))))) ||
			   ((time.isAfter(LocalTime.parse( "08:15:28" ).plus(974*L1,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:15:41" ).plus(974*L1,ChronoUnit.SECONDS)))))) {
				return false;
			}
			else stopped = false;
		}
		
		/// LINKA 2 /// 7,23 = 442
		else if((this.ID == 2)) {	
			if (((time.isAfter(LocalTime.parse( "08:00:42" ).plus(442*L2,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:00:55" ).plus(442*L2,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:01:22" ).plus(442*L2,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:01:35" ).plus(442*L2,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:03:22" ).plus(442*L2,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:03:35" ).plus(442*L2,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:05:36" ).plus(442*L2,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:05:49" ).plus(442*L2,ChronoUnit.SECONDS))))) ||	
			    ((time.isAfter(LocalTime.parse( "08:06:20" ).plus(442*L2,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:06:33" ).plus(442*L2,ChronoUnit.SECONDS)))))) {
				return false;
			}
			else stopped = false;
		}
		//7.23
		
		///LINKA3///
		else if((this.ID == 3)) {
			if (((time.isAfter(LocalTime.parse( "08:00:59" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:01:12" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:02:29" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:02:42" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:04:08" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:04:21" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:06:24" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:06:37" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:07:53" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:08:06" ).plus(814*L3,ChronoUnit.SECONDS))))) ||	
			    ((time.isAfter(LocalTime.parse( "08:09:55" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:10:06" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:11:26" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:11:39" ).plus(814*L3,ChronoUnit.SECONDS))))) ||
			    ((time.isAfter(LocalTime.parse( "08:12:34" ).plus(814*L3,ChronoUnit.SECONDS))) && ((time.isBefore(LocalTime.parse( "08:12:47" ).plus(814*L3,ChronoUnit.SECONDS)))))) {
				return false;
			}
			else stopped = false;
		}
		

		///LINKA4///
		else if((this.ID == 4)) {
			if (((time.isAfter(LocalTime.parse( "08:00:29" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:00:42" ).plus(548*L4,ChronoUnit.SECONDS))))) ||
				((time.isAfter(LocalTime.parse( "08:02:27" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:02:40" ).plus(548*L4,ChronoUnit.SECONDS))))) ||
				((time.isAfter(LocalTime.parse( "08:04:05" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:04:18" ).plus(548*L4,ChronoUnit.SECONDS))))) ||	
				((time.isAfter(LocalTime.parse( "08:06:10" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:06:23" ).plus(548*L4,ChronoUnit.SECONDS))))) ||	
				((time.isAfter(LocalTime.parse( "08:06:45" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:06:58" ).plus(548*L4,ChronoUnit.SECONDS))))) ||	
				((time.isAfter(LocalTime.parse( "08:07:34" ).plus(548*L4,ChronoUnit.SECONDS)))  && ((time.isBefore(LocalTime.parse( "08:07:47" ).plus(548*L4,ChronoUnit.SECONDS)))))) {
				return false;
			}
			else stopped = false;
		}
		
		if (stopped == false) {
			distance = distance + speed;
			if(distance > path.getPathSize()) {
				if (this.ID == 1) L1++;
				else if (this.ID == 2) L2++;
				else if (this.ID == 3) L3++;
				else if (this.ID == 4) L4++;
				distance = 0;
				return false;
			}
			Coordinate coords = path.getCoordinateDist(distance);
			moveGUI(coords);
			position = coords;
			return true;
		}
		return true;
	}
}
