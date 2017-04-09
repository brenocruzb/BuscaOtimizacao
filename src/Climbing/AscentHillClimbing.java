package Climbing;

import Util.Function;
import Util.Soluction;

public class AscentHillClimbing extends Function{
	
	private Soluction soluction;
	private int numAvaliation;
	private int neighbors;
	
	public AscentHillClimbing(int numAvaliation, int neighbors, int size, double min, double max){
		this.soluction = new Soluction(size, min, max);
		this.numAvaliation = numAvaliation;
		this.neighbors = neighbors;
	}
	
	public Soluction execute(){
		quality(this.soluction);
		for(int i = 0; i < this.numAvaliation; i++){
			Soluction newSoluction = Soluction.tWeak2(this.soluction);
			quality(newSoluction);
			
			for(int j = 0; j < this.neighbors; j++){
				Soluction neighSoluction = Soluction.tWeak2(this.soluction);
				if(quality(neighSoluction) < newSoluction.getResult()){
					newSoluction.setSoluction(neighSoluction.getSolution());
					newSoluction.setResult(neighSoluction.getResult());
				}
			}
			
			if(quality(newSoluction) < this.soluction.getResult()){
				this.soluction.setSoluction(newSoluction.getSolution()); 
				this.soluction.setResult(newSoluction.getResult());
				this.soluction.setLastPosition(i);
			}
		}
		
		return this.soluction;
	}
	
	private double quality(Soluction soluction){
		return this.f211(soluction);
	}
	

}
