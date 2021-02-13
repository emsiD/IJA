/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;


/**
 * The Class Coordinate.
 * @brief Represents x and y coordinates of some entity on map.
 */
public class Coordinate {
	
	/** The x coordinate. */
	private double x;
	
	/** The y cooordinate. */
	private double y;
	
	/**
	 * @brief Instantiates a new coordinate.
	 * @param d the d
	 * @param e the e
	 */
	Coordinate(double d, double e) {
		this.x = d;
		this.y = e;
	}
	

	/**
	 * Creates the coordinate.
	 * @param i point of coordinate
	 * @param j second point of coordinate
	 * @return the coordinate
	 */
	public static Coordinate create(double i, double j) {
		if (i < 0 || j < 0) return null;
		else {
			Coordinate coord = new Coordinate(i, j);
			return coord;		
		}
	}

	/**
	 * @brief Returns the x coordinate.
	 * @return the x
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * @brief Returns the y coordinate.
	 * @return the y
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * @brief Method "equals" override.
	 * @param obj object
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
	    }
		if (obj == null) {
            return false;
        }
		boolean result = false;
		if (obj.getClass() == this.getClass()) {
			Coordinate coords = (Coordinate) obj;
			if (coords.getX() == this.x && coords.getY() == this.y) {
				result = true;
			}
		}
        return result;
	}

	/**
	 * Hash code.
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * @brief Calculates the difference between two x coordinates.
	 * @param c coordiante to be checked
	 * @return distance between two points
	 */
	public double diffX(Coordinate c) {
		return this.x - c.x;
	}
	
	/**
	 * @brief Calculates the difference between two y coordinates.
	 * @param c coordiante to be checked
	 * @return distance between two points
	 */
	public double diffY(Coordinate c) {
		return this.y - c.y;
	}
	
}
