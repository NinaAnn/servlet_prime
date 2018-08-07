package test.servlet;

import java.math.BigInteger;

public class Prime {
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger TWO = new BigInteger("2");
	private static final int certainty = 100;
	private static char[] digitString = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static BigInteger calPrime(BigInteger start) {
		if(isEven(start)) {
			start = start.add(ONE);
		}
		else {
			start = start.add(TWO);
		}
		if(start.isProbablePrime(certainty)) {
			return (start);
		}
		else {
			return (calPrime(start));
		}
	}
	private static boolean isEven(BigInteger Number) {
		return (Number.mod(TWO).equals(ZERO));
	}
	
	private static char genRandom(boolean isHead) {
		int index = 0;
		if(isHead) {
			index = 1 + (int)Math.floor(Math.random() * 9);
		}
		else {
			index = (int)Math.floor(Math.random() * 10);
		}
		return digitString[index];
	}
	
	public static BigInteger randomDigits(int primeDigits) {
		char[] s = new char[primeDigits];
		int i;
		for(i=0; i<primeDigits; i++) {
			if(i == 0) {
				s[0] = genRandom(true);
			}
			else {
				s[i] = genRandom(false);
			}
		}
		String start = new String(s);
		return (new BigInteger(start));
	}
}
