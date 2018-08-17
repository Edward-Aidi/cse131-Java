package biofindframe;

import java.io.File;

import org.biojava3.core.sequence.DNASequence;

import biojava.SequenceLoader;
import cse131.ArgsProcessor;

public class FindTheFrame {
	
	//
	// Do not change any code from here....
	//

	public static void main(String[] args) {
		File file = ArgsProcessor.chooseFile("genomes");
		System.out.println("For " + file + ", best reading frame is " + runsolution(file));
	}
	
	public static int runsolution(File file) {
		//
		// Load the sequence into a DNASequence object
		//
		SequenceLoader sequenceLoader = new SequenceLoader();
		DNASequence dnaSequence = sequenceLoader.loadDNASequence(file);
		
		//
		// Convert the sequence to a string and then a char array
		//
		String dnaAsString = dnaSequence.getSequenceAsString().toUpperCase();
		char[] dnaAsCharArray = dnaAsString.toCharArray();
		
		//
		// Call your solution to compute the result
		//
		int frame = bestReadingFrame(dnaAsCharArray);
		
		return frame;
	}
	
	//
	// ... to here, so we can unit test your solution
	//
	
	/**
	 * 
	 * @param dna an array of char.  Each element is a nucleotide:  one of A, T, C, or G.
	 * @return the index at which the best reading frame occurs.  This would be 0, 1, or 2.
	 */
	public static int bestReadingFrame(char[] dna) {
		

		// Below, define each of the three Stop Codons as a separate array of char,
		//     named ochre, amber, and opal
		//     See http://en.wikipedia.org/wiki/Genetic_code#Start.2Fstop_codons

		// From Wiki, "UAG is amber, UGA is opal (sometimes also called umber), and UAA is ochre" 
		
		char[] ochre = new char[] {'U', 'A', 'A'};
		char[] amber = new char[] {'U', 'A', 'G'};
		char[] opal = new char[] {'U', 'G', 'A'};
		
		// Below, define the Start Codon (Methionine) as an array of char
		//Start Codon
		char[] methionine = new char[] {'A', 'U', 'G'};
		
		int count1 = 0;
		int ans = -1;  // returned if no appropriate sequences was found
		for(int i = 0; i < dna.length; i++) {
			if(dna[i] == methionine[0] && dna[i+1] == methionine[1] && dna[i+2] == methionine[2]) {
				count1 = count1 + 1;
				i = i + 3;
				boolean test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
						(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				while(!test && i < dna.length){
					count1 = count1 + 1;
					i = i + 3;
					test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
							(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				}
			}
		}
		
		int count2 = 0;
		for(int i = 1; i < dna.length; i++) {
			if(dna[i] == methionine[0] && dna[i+1] == methionine[1] && dna[i+2] == methionine[2]) {
				count2 = count2 + 1;
				i = i + 3;
				boolean test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
						(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				while(!test && i < dna.length){
					count2 = count2 + 1;
					i = i + 3;
					test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
							(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				}
			}
		}
		
		int count3 = 0;
		for(int i = 2; i < dna.length; i++) {
			if(dna[i] == methionine[0] && dna[i+1] == methionine[1] && dna[i+2] == methionine[2]) {
				count3 = count3 + 1;
				i = i + 3;
				boolean test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
						(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				while(!test && i < dna.length){
					count3 = count3 + 1;
					i = i + 3;
					test = (dna[i] == 'U' && dna[i+1] == 'A' && (dna[i+2] == 'A') || dna[i+2] == 'G' ) ||
							(dna[i] == 'U' && dna[i+1] == 'G' && dna[i+2] == 'A');
				}
			}
		}
		//
		// Follow the instructions in the extension write up
		//
		int max = 0;
		if(count1 < count2) {
			max = count2;
		}
		else {
			max = count1;
		}
		if(max < count3) {
			max = count3;
		}
		if(max == count1) {
			ans = 0;
		}
		if(max == count2) {
			ans = 1;
		}
		if(max == count3) {
			ans = 2;
		}
		
		return ans;
	}
}
