package Climbing;

import Util.Function;
import Util.Soluction;

public class HillClimbing extends Function{
	
	private Soluction soluction;
	private int numAvaliation;
	
	public HillClimbing(int numAvaliation, int size, double min, double max){
		this.soluction = new Soluction(size, min, max);
		this.numAvaliation = numAvaliation;
	}
	
	public Soluction execute(){
		quality(this.soluction);
		for(int i = 0; i < this.numAvaliation; i++){
			Soluction newSoluction = Soluction.tWeak2(this.soluction);
			
			if(quality(newSoluction) < this.soluction.getResult()){
				this.soluction.setSoluction(newSoluction.getSolution()); 
				this.soluction.setResult(newSoluction.getResult());
				this.soluction.setLastPosition(i);
			}
		}
		
		return this.soluction;
	}
	
	private double quality(Soluction soluction){
		return this.f222(soluction);
	}
	
}

