package lab9;

import lab9.implementations.HonestFeedback;
import lab9.implementations.RandomGuessProvider;
import lab9.implementations.StaticGuessProvider;
import lab9.providers.ProvidesFeedback;
import lab9.providers.ProvidesGuess;
import lab9.providers.ReceivesHistory;

public class SmartGuesser implements ReceivesHistory, ProvidesGuess{

	final private GameProperties gp;
	final private ProvidesGuess randomGuesser;
	private History history;
	
	public SmartGuesser(GameProperties gp) {
		this.gp = gp;
		this.randomGuesser = new RandomGuessProvider(gp);
		this.history = null;
	}
	@Override
	public void sendHistory(History history) {
		// do something with history eventually
		System.out.println("history is updated.");
		this.history = history;
	}

	@Override
	public Guess getGuess() {
		//first guess can't base on history
		if(history == null) {
			int[] g = {1,1,2,2};
			Guess gg = new Guess(g);
			return gg;
		}
		else {
			// take the last guess
			Guess lastGuess = history.getHistoryAt(history.size()-1);
			int[] nextguess = new int[gp.getNumHoles()];
			// initially copy over my last guess
			HonestFeedback h = new HonestFeedback(lastGuess);
			ProvidesGuess codeMaker = new StaticGuessProvider(gp);
			Guess code = codeMaker.getGuess();
			// same position, i.e., match number
			int black = h.numSamePosition(code);
			// same color
			int white = h.numIntersection(code);
			
			// not sure how to calculate the score
			// thought it should have 5*5 scores available, there are 14 possible scores in the game is valid, for example. (3, 1) is impossible
			
//			(black, white)
//			(0,0)			
//			(0,1)	
//			(0,2)	
//			(0,3)	
//			(0,4)	
//			(1,0)	
//			(1,1)	
//			(1,2)	
//			(1,3)	
//			(2,0)	
//			(2,1)		
//			(2,2)		
//			(3,0)		
//			(4,0)		
//			
			
			
			// Better than random guesser
			if(white == 4) {
				for(int i = 0; i < gp.getNumHoles()-1; ++i) {
					
					nextguess[i] = lastGuess.getChoice(i+1);
				}
				nextguess[gp.getNumHoles()-1] = lastGuess.getChoice(0);
				return new Guess(nextguess);
			}
			if(white == 4) {
				int[] c = new int[]
				return new Guess(nextguess);
			}
			return new Guess(nextguess);
		}
	}
}
