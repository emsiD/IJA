/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;
/**
 * The Class Stop.
 * @brief Class representing bus stop.
 */
public class Stop {
	
	/** The id. */
	private String ID;
	
	/** The location. */
	private Coordinate location;
	
	/** The street. */
	private Street street;

	/**
	 * Equals.
	 * @brief Override of "equals" method.
	 * @param obj the object
	 * @return true, if equal
	 */
	@Override
	public boolean equals (Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		int result = 0;
		if (obj.getClass() == street.getClass()) {
			Street street2 = (Street) obj;
			result = this.ID.compareTo(street2.getId());
		}
		return (result == 0);
	}

	/**
	 * @brief Instantiates a new stop.
	 * @param string the string
	 * @param c1 the coordinate
	 */
	public Stop(String string, Coordinate c1) {
		this.ID = string;
		this.location = c1;
	}

	/**
	 * @brief Assigns a name to stop.
	 * @param string the string
	 */
	public Stop(String string) {
		this.ID = string;
	}

	/**
	 * @brief Returns stop ID.
	 * @return the id
	 */
	public String getId() {
		return this.ID;
	}

	/**
	 * Gets the coordinate.
	 * @brief Returns the coordinate.
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return this.location;
	}

	/**
	 * Sets the street.
	 * @brief Sets the street on which the stop is placed.
	 * @param s the new street
	 */
	public void setStreet(Street s) {
		this.street = s;
	}

	/**
	 * Gets the street.
	 * @brief Returns street.
	 * @return the street
	 */
	public Street getStreet() {
		return this.street;
	}

	/**
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("stop(%s)", this.ID);
	}
	
}
