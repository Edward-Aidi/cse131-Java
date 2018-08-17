package roundtables;

import java.math.BigInteger;

public class MaxInteger {

	public static void main(String[] args) {
		int biggie = Integer.MAX_VALUE;
		System.out.println(biggie+1);
		BigInteger bi = BigInteger.valueOf(biggie);
		System.out.println("Big int " + bi);
		BigInteger bi2 = bi.add(BigInteger.ONE);
		System.out.println("bigger int " + bi2);
		System.out.println("really big " + bi2.multiply(bi2));
		for (int i=0; i < 10; ++i) {
			bi2 = bi2.multiply(bi2);
		}
		System.out.println("bigggg " + bi2);

	}

}
