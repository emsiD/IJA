/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class StreetMap.
 * @brief Class representing map of streets.
 */
public class StreetMap {
	
	/** The street map. */
	private Map<String, Street> streets;
	
	/**
	 * Instantiates a new street map.
	 */
	public StreetMap () {
		this.streets = new HashMap<String, Street>();
	}

	/**
	 * @brief Adds the street to streetmap
	 * @param s street to be added
	 */
	public void addStreet (Street s) {
		this.streets.put(s.getId(), s);
	}

	/**
	 * Gets the street.
	 * @brief Returns street with certain id.
	 * @param id id of street
	 * @return the street
	 */
	public Street getStreet (String id) {
		Street street = streets.get(id);
		return street;
	}
	
	/**
	 * Return list of street
	 * @brief returns list of streets.
	 * @return list of streets
	 */
	public List<Street> getStreets() {
		List<Street> list = new ArrayList<Street>(this.streets.values());
		return list;
	}

}
