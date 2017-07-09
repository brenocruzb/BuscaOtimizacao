package Util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Soluction extends Tweak{
	private double[] soluction;
	public static double min, max;
	
	private int lastPosition;
	
	private int changedPosition;
	private double changedValue;
	
	private double result;
	
	public Soluction(int size, double min, double max){
		this.soluction = new double[size];
		Soluction.min = min;
		Soluction.max = max;
		
		for(int i = 0; i < size; i++){
			double value = ThreadLocalRandom.current().nextDouble(min, max + 1);
//			double value = (Math.random() * max) + min;
			this.soluction[i] = value;
		}
	}
	
	public Soluction clone(){						
		Soluction clone = new Soluction(this.soluction.length, Soluction.min, Soluction.max);
		clone.setSoluction(this.soluction);
		clone.setLastPosition(this.lastPosition);
		clone.setResult(this.result);
		clone.setChangedPosition(this.changedPosition);
		clone.setChangedValue(this.changedValue);
		
		return clone;
	}
	
	public double[] getSolution(){
		return this.soluction;
	}
	
	public void setSoluction(double[] soluction){
		this.soluction = Arrays.copyOf(soluction, soluction.length);
	}
	
	public void setResult(double result){
		this.result = result;
	}
	
	public double getResult(){
		return this.result;
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public int getChangedPosition() {
		return changedPosition;
	}

	public void setChangedPosition(int changedPosition) {
		this.changedPosition = changedPosition;
	}

	public double getChangedValue() {
		return changedValue;
	}

	public void setChangedValue(double changedValue) {
		this.changedValue = changedValue;
	}
	
	public static void main(String[] args) {
		int tWeakSize = 50;
		int min = -100;
		int max = 100;
		
		Soluction s1 = new Soluction(tWeakSize, min, max);
		s1.setLastPosition(1);
		s1.setResult(2);
		s1.setChangedPosition(3);
		s1.setChangedValue(4);		
		System.out.println(Arrays.toString(s1.getSolution()));
		System.out.println(s1.getLastPosition());
		System.out.println(s1.getResult());
		System.out.println(s1.getChangedPosition());
		System.out.println(s1.getChangedValue());
		System.out.println("");
		
		Soluction s2 = s1.clone();
		s2.setResult(-100);
		System.out.println(Arrays.toString(s2.getSolution()));
		System.out.println(s2.getLastPosition());
		System.out.println(s2.getResult());
		System.out.println(s2.getChangedPosition());
		System.out.println(s2.getChangedValue());
		System.out.println("");
		
		s1 = new Soluction(tWeakSize, min, max);
		s1.setLastPosition(10);
		s1.setResult(20);
		s1.setChangedPosition(30);
		s1.setChangedValue(40);
		
		
		System.out.println(Arrays.toString(s1.getSolution()));
		System.out.println(s1.getLastPosition());
		System.out.println(s1.getResult());
		System.out.println(s1.getChangedPosition());
		System.out.println(s1.getChangedValue());
		System.out.println("");
		System.out.println(Arrays.toString(s2.getSolution()));
		System.out.println(s2.getLastPosition());
		System.out.println(s2.getResult());
		System.out.println(s2.getChangedPosition());
		System.out.println(s2.getChangedValue());
		System.out.println("");
	}
	
}
