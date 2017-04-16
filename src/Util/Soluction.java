package Util;

import java.util.Arrays;

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
			double value = (Math.random() * max) + min;
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
	
}
