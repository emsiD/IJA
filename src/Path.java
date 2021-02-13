/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Path.
 * @brief Represents travel path on map for each vehicle.
 */
public class Path {
	
	/** List of paths. */
	private List<Coordinate> path;
	
	/** Schedule of bus rides. */
	private double timetable;
	
	/** The street list. */
	private List<Street> streetList;
	
	/**
	 * Instantiates a new path.
	 * @param path list of coordinates
	 * @param YAMLtimetable timetable from YAML file (schedule of bus rides)
	 */
	public Path(List<Coordinate> path, double YAMLtimetable) {
		this.path = path;
		this.timetable = YAMLtimetable;
		this.streetList = new ArrayList<Street>();
	}
	
	/**
	 * @brief Adds the street to street list.
	 * @param street street to be added
	 */
	public void addStreet(Street street) {
		this.streetList.add(street);
	}
	
	/**
	 * @brief Returns the street list.
	 * @return the street list
	 */
	public List<Street> getStrList() {
		return this.streetList;
	}
	
	/**
	 * @brief Returns the schedule of bus rides.
	 * @return the timetable
	 */
	double getTimetable() {
		return this.timetable;
	}
	
	/**
	 * @brief Returns the distance between point a and point b.
	 * @param a point a
	 * @param b point b
	 * @return the distance
	 */
	private double getDist(Coordinate a, Coordinate b) {
		return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+ Math.pow(a.getY() + b.getY(),2));
	}
	
	/**
	 * @brief Returns the coordinate of passed distance.
	 * @param distance the distance
	 * @return the coordinate dist
	 */
	public Coordinate getCoordinateDist(double distance) {
		double len = 0;
		double currLen = 0;
		Coordinate a = null;
		Coordinate b = null;
		
		for(int i =0; i<path.size()-1;i++) {
			a = path.get(i);
			b = path.get(i+1);
			currLen = getDist(a,b);
			if (len+getDist(a,b) >= distance) break;
			len+=currLen;
		}
		
		if(a == null || b == null) return null;
		double drive = (distance-len)/currLen;
		return new Coordinate(a.getX() + (b.getX()-a.getX())*drive, a.getY() + (b.getY()-a.getY())*drive);
	}
	
	/**
	 * @brief Returns the size of path.
	 * @return the path size
	 */
	public double getPathSize() {
		double size = 0;
		for(int i =0; i<path.size()-1;i++) {
			size += getDist(path.get(i),path.get(i+1));
		}
		return size;
	}
	
	/**
	 * @brief Returns the size of path list.
	 * @return size of path list
	 */
	public int size() {
		int size =0;
		for(int i =0; i<path.size()-1;i++) {
			size += 1;
		}
		return size;
	}
	
	/**
	 * @brief Returns the coordinate on certain index from path.
	 * @param index the index
	 * @return the path coordinate
	 */
	public Coordinate getPathCoor(int index) {
		return this.path.get(index);
	}
	
}
