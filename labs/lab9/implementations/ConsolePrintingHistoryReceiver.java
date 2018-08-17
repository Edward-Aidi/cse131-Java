package lab9.implementations;

import lab9.Guess;
import lab9.History;
import lab9.providers.ReceivesHistory;

/**
 * Prints out the changed history (last element) on the console
 * 
 * @author roncytron
 *
 */
public class ConsolePrintingHistoryReceiver implements ReceivesHistory {
	
	private History history;
	private final String msg;
	
	public ConsolePrintingHistoryReceiver() {
		this("Conosle message");
	}
	public ConsolePrintingHistoryReceiver(String msg) {
		this.history = null;
		this.msg     = msg;
	}

	@Override
	public void sendHistory(History history) {
		this.history = history;
	}
	
	public void output(Guess code) {
		message("Code " + code + " guess " + history.getHistoryAt(history.size()-1));
	}

	public void output(Guess code, int numMatch, int sameColor) {
		message("Code " + code + " guess " + history.getHistoryAt(history.size()-1) + " match " + numMatch + " same color " + sameColor);	
	}

	public void message(String s) {
		System.out.println(msg + ": " + s);
	}

}
