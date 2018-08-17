package lab9;

/**
 * Parameters of our game
 * @author roncytron
 *
 */
public class GameProperties {
	
	private final int numColors, numHoles, maxNumGuesses;
	private final String name;
	
	/**
	 * Construct a standard (according to Wikipedia) game
	 *   6 colors
	 *   4 holes per row
	 *  12 allowed attempts to guess the solution
	 */
	public GameProperties() {
		this("Default game", 6,4,12);
	}
	
	public GameProperties(String name) {
		this(name, 6, 4, 12);
	}
	
	/**
	 * @param name a String for printing out the name of this particular game
	 * @param numColors the number of possible peg colors
	 * @param numHoles the number of holes per row in the game
	 * @param maxNumGuesses the number of guesses allowed in this game
	 */
	public GameProperties(String name, int numColors, int numHoles, int maxNumGuesses) {
		this.name           = name;
		this.numColors      = numColors;
		this.numHoles       = numHoles;
		this.maxNumGuesses  = maxNumGuesses;
	}

	public int getNumColors() {
		return numColors;
	}

	public int getNumHoles() {
		return numHoles;
	}

	public int getMaxNumGuesses() {
		return maxNumGuesses;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GameProperties [numColors=" + numColors + ", numHoles=" + numHoles + ", maxNumGuesses=" + maxNumGuesses
				+ "]";
	}


}
