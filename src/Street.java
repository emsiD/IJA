/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;

/**
 * The Class Street.
 * @brief Class representing street, contains start and end of street.
 */
public class Street {
	
	/** The id. */
	private String ID;
	
	/** The start. */
	private Coordinate start;
	
	/** The end. */
	private Coordinate end;
	
	/** The Stop list. */
	//private Coordinate brPoint;
	private List<Stop> StopList;
	
	/** The line. */
	private Line line;

	/**
	 * Instantiates a new street.
	 * @brief Creates street between two coordinates
	 * @param string name of street
	 * @param create begining coordinate
	 * @param create2 ending coordinate
	 */
	public Street(String string, Coordinate create, Coordinate create2) {
		this.ID = string;
		this.start = create;
		this.end = create2;
		this.StopList = new ArrayList<Stop>();
	}
	
	/**
	 * @brief Sets the line.
	 * @param representingLine the new line
	 */
	public void setLine(Line representingLine) {
		this.line = representingLine;
	}
	
	/**
	 * Gets the line of street
	 * @brief Returns the line representing the street.
	 * @return the line
	 */
	public Line getLine() {
		return this.line;
	}
	
	/**
	 * Gets the id of street
	 * @brief Returns the id of street.
	 * @return the id
	 */
	public String getId() {
		return this.ID;
	}

	/**
	 * Gets the coordinates of street
	 * @brief Returns list of coordinates of street.
	 * @return the coordinates
	 */
	public List<Coordinate> getCoordinates() {
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		coordinates.add(0, start);
		coordinates.add(2, end);
		return coordinates;
	}

	/**
	 * Gets the stops of street
	 * @brief Returns list of stops on the street.
	 * @return the stops
	 */
	public List<Stop> getStops() {
		return StopList;
	}

	
	/**
	 * @brief Adds the stop to street.
	 * @param stop the stop
	 * @return true, if successful
	 */
	public boolean addStop(Stop stop) {
		try {
			this.StopList.add(stop);
			return true;
		}
		catch (Exception e) {
			System.out.println("Error while trying to add stop to street.");
			return false;
		}
	}

	/**
	 * @brief Returns beginning coordinate of street.
	 * @return the beginning coordinate of street
	 */
	public Coordinate begin() {
		return this.start;
	}

	/**
	 * @brief Returns ending coordinate of street.
	 * @return the end coordinate of street
	 */
	public Coordinate end() {
		return this.end;
	}
	
	/**
	 * @brief Checks if one street follows another.
	 * @param s2 street to be checked
	 * @return true if one street follows another
	 */
	public Boolean follows(Street s2) {
		return this.begin().equals(s2.begin()) || this.begin().equals(s2.end()) || this.end().equals(s2.begin()) || this.end().equals(s2.end());
	}
	
}
