package PSO;

import java.util.ArrayList;

import Util.Soluction;

public class Pso{
	
	private int numAvaliation, tWeakSize, popSize;	
	private double min, max; 
	private double[] o;		
	
	public Pso(int popsize, int numAvaliation, int tWeakSize, double min, double max, double[]o){
		this.numAvaliation = numAvaliation;
		this.tWeakSize = tWeakSize;
		this.min = min;
		this.max = max;
		
		this.popSize = popsize;
		
		this.o = o;
	}
	
	public Soluction execute(){
		ArrayList<Particle> pop = new ArrayList<>();
		
		for(int i = 0; i < this.popSize; i++){
			pop.add(new Particle(this.tWeakSize, this.min, this.max, this.o));
		}		
		
		for (int i = 0; i < this.numAvaliation; i++){					
			for(Particle p : pop){				
				p.updatePosition();				
				p.updateLeaders();
			}
		}
			
		return Particle.gBest;
	}
	
	

}
