package lab9.providers;

import lab9.History;

/**
 * There are various destinations for a History:
 *    a console printout of progress
 *    a visualization
 * 
 * @author roncytron
 *
 */
public interface ReceivesHistory {
	public void sendHistory(History history);
}
