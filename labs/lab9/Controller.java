package lab9;

import lab9.implementations.ConsolePrintingHistoryReceiver;
import lab9.implementations.HonestFeedback;
import lab9.providers.ProvidesFeedback;
import lab9.providers.ProvidesGuess;

public class Controller {
	
	private final GameProperties game;
	private final ProvidesGuess codeMaker, codeBreaker;
	private final History history;
	
	public Controller(GameProperties g, ProvidesGuess codeMaker, ProvidesGuess codeBreaker) {
		this.game        = g;
		this.codeMaker   = codeMaker;
		this.codeBreaker = codeBreaker;
		this.history     = new History(game);
	}
	
	public void run() {
		ConsolePrintingHistoryReceiver console = new ConsolePrintingHistoryReceiver(game.getName());
		console.message(" ");
		console.message("Game starts");
		history.addObserver(console);
		boolean won = false;
		boolean okMove = true;
		do {
			Guess code  = codeMaker.getGuess();
			Guess guess = codeBreaker.getGuess();
			
			ProvidesFeedback pf = new HonestFeedback(code);
			if (pf.isSolution(guess)) {
				console.message("Winner!");
				won = true;
			}
			okMove = history.registerGuess(guess);
			
//			console.output(code);
//			console.message(" number exactly right position " + pf.numSamePosition(guess));
//			console.message(" number of pegs in common color " + pf.numIntersection(guess));

//			above were in the video, but this will put the information out on one line:

			console.output(code, pf.numSamePosition(guess), pf.numIntersection(guess));
			if (!okMove)
				console.message("Bad move, you lose!");
		} while (okMove && !won);
		console.message("Game ends");
		console.message(" ");

	}
	
	public History getHistory() {
		return this.history;
	}
	
	public GameProperties getGameProperties() {
		return this.game;
	}

	public ProvidesGuess getCodeMaker() {
		return this.codeMaker;
	}
	
}