/* author: Matej Dubec
 * author: Timotej Kovacik
 */
package application;

import java.time.LocalTime;

/**
 * The Interface tUpdate.
 */
public interface tUpdate {
	
	/**
	 * Updates current time
	 * @param time current time
	 * @return true, if successful
	 */
	boolean update(LocalTime time);
}
