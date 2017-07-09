package Tabu;

import java.util.ArrayList;

import Util.Function;
import Util.Soluction;
import Util.Tuple;

public class Tabu extends Function{
	
	private Soluction soluction;
	private int numAvaliation;
	private int listTabuSize;
	private int neighbors;
	
	private Soluction best;
	private ArrayList<Tuple<Integer , Double>> listTabu;
	
	private double[] o;
	
	public Tabu(int listTabuSize, int numAvaliation, int neighbors, int tWeakSize, double min, double max, double[] o){
		this.soluction = new Soluction(tWeakSize, min, max);
		this.numAvaliation = numAvaliation;
		this.listTabuSize = listTabuSize;
		this.neighbors = neighbors;
		
		this.best = this.soluction.clone();
		listTabu = new ArrayList<>();		
		listTabu.add(new Tuple<>(0, 0.0));
		
		this.o = o;
	}
	
	public Soluction execute(){
		quality(this.soluction, this.o);
		for(int i = 0; i < this.numAvaliation; i++){
			if(listTabu.size() > this.listTabuSize){
				listTabu.remove(0);
			}
			Soluction newSoluction = Soluction.tWeak2(this.soluction);
			quality(newSoluction, this.o);
			Tuple<Integer, Double> tupleR = new Tuple<>(newSoluction.getChangedPosition(), newSoluction.getChangedValue());
			
			for(int j = 0; j < this.neighbors; j++){
				Soluction neighSoluction = Soluction.tWeak2(this.soluction);
				
				Tuple<Integer, Double> tupleW = new Tuple<>(neighSoluction.getChangedPosition(), neighSoluction.getChangedValue());
				
				if(!this.listTabu.contains(tupleW) && (quality(neighSoluction, this.o) < newSoluction.getResult() || this.listTabu.contains(tupleR))){
					newSoluction = neighSoluction.clone();
					tupleR = new Tuple<>(newSoluction.getChangedPosition(), newSoluction.getChangedValue());
				}
			}
			
			if(!this.listTabu.contains(tupleR)){
				this.soluction = newSoluction.clone();
				this.soluction.setLastPosition(i);
				
				this.listTabu.add(tupleR);
			}
			
			if(this.soluction.getResult() < quality(this.best, this.o)){
				this.best = this.soluction.clone();
			}
			
		}
		
		return this.best;
	}
	
	private double quality(Soluction soluction, double[] o){
		return this.f221(soluction, o);
	}

}
