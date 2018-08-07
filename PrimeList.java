package test.servlet;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeList implements Runnable {
	public int numPrimes, numDigits;
	private ArrayList<BigInteger> primeFound;

	public PrimeList(int numPrimes, int numDigits){
		this.numDigits = numDigits;
		this.numPrimes = numPrimes;
		this.primeFound = new ArrayList<BigInteger>(numPrimes);
		Thread t = new Thread(this);
		t.start();
		
	}
	@Override
	public void run() {
		BigInteger start = Prime.randomDigits(numDigits);
		for(int i=0; i<numPrimes; i++) {
			start = Prime.calPrime(start);
			primeFound.add(start);
		}
	}
	
	public synchronized boolean isDone() {
		return (primeFound.size() == this.numPrimes);
	}
	
	public synchronized ArrayList<BigInteger> getPrimes(){
		if(this.isDone())
			return(primeFound);
		else {
			return((ArrayList<BigInteger>)primeFound.clone());
		}
	}
}
