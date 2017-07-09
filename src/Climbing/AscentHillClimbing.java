package Climbing;

import Util.Function;
import Util.Soluction;

public class AscentHillClimbing extends Function{
	
	private Soluction soluction;
	private int numAvaliation;
	private int neighbors;
	private double[] o;
	
	public AscentHillClimbing(int numAvaliation, int neighbors, int size, double min, double max, double[] o){
		this.soluction = new Soluction(size, min, max);
		this.numAvaliation = numAvaliation;
		this.neighbors = neighbors;
		this.o = o;
	}
	
	public Soluction execute(){
		quality(this.soluction, this.o);
		for(int i = 0; i < this.numAvaliation; i++){
			Soluction newSoluction = Soluction.tWeak2(this.soluction);
			quality(newSoluction, this.o);
			
			for(int j = 0; j < this.neighbors; j++){
				Soluction neighSoluction = Soluction.tWeak2(this.soluction);
				if(quality(neighSoluction, this.o) < newSoluction.getResult()){
					newSoluction.setSoluction(neighSoluction.getSolution());
					newSoluction.setResult(neighSoluction.getResult());
				}
			}
			
			if(quality(newSoluction, this.o) < this.soluction.getResult()){
				this.soluction.setSoluction(newSoluction.getSolution()); 
				this.soluction.setResult(newSoluction.getResult());
				this.soluction.setLastPosition(i);
			}
		}
		
		return this.soluction;
	}
	
	private double quality(Soluction soluction, double[] o){
		return this.f211(soluction, o);
	}
	

}
