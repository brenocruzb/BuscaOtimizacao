package Climbing;

import Util.Function;
import Util.Soluction;

public class HillClimbing extends Function{
	
	private Soluction soluction;
	private int numAvaliation;
	private double[] o;
	
	public HillClimbing(int numAvaliation, int tWeakSize, double min, double max, double[] o){
		this.soluction = new Soluction(tWeakSize, min, max);
		this.numAvaliation = numAvaliation;
		this.o = o;
	}
	
	public Soluction execute(){
		quality(this.soluction, this.o);
		for(int i = 0; i < this.numAvaliation; i++){
			Soluction newSoluction = Soluction.tWeak(this.soluction);
			
			if(quality(newSoluction, this.o) < this.soluction.getResult()){
				this.soluction.setSoluction(newSoluction.getSolution()); 
				this.soluction.setResult(newSoluction.getResult());
				this.soluction.setLastPosition(i);
			}
		}
		
		return this.soluction;
	}
	
	private double quality(Soluction soluction, double[] o){
		return this.f221(soluction, o);
	}
	
}

