/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class PathMap.
 * @brief Represents map of paths.
 */
public class PathMap {
	
	/** The paths. */
	private Map<String, Path> paths;
	
	/**
	 * @brief Instantiates a new path map.
	 */
	public PathMap() {
		this.paths = new HashMap<String, Path>();
	}
	
	/**
	 * @brief Adds the path.
	 * @param path the path to be added to map
	 * @param name the name of path
	 */
	public void addPath(Path path, String name) {
		this.paths.put(name, path);
	}
	
	/**
	 * Gets the path name.
	 * @brief Returns the name of the path, based on the index passed.
	 * @param index the index
	 * @return the path name
	 */
	public String getPathName(int index) {
		int i = 0;
		String name = "";
		for (String key: this.paths.keySet()) {
			if (i == index) {
				name = key;
				break;
			}
			else i++;
		}
		return name;
	}
	
	/**
	 * Gets the path.
	 * @brief Returns the path of passed name.
	 * @param name the name
	 * @return the path
	 */
	public Path getPath(String name) {
		return this.paths.get(name);
	}
}
