package PSO;

import Util.Function;
import Util.Soluction;

public class Particle extends Function{
	
	private Soluction soluction;
	private double[] velocity;
	
	private double[] o;
	
	private static final double C1 = 1.494, C2 = 1.494;
	private static final double V_MAX = 4.0, V_MIN = -4.0;
	
	private Soluction pBest;
	
	public static Soluction gBest;
	
	public Particle(int size, double min, double max, double[] o){
		this.soluction = new Soluction(size, min, max);
		this.pBest = this.soluction.clone();
		
		if(Particle.gBest == null){
			gBest = new Soluction(size, min, max);
			gBest.setResult(1000000000000000.0);
		}
		
		this.velocity = new double[size];
		this.o = o;
		
		for(int i = 0; i < velocity.length; i++) velocity[i] = 0.0;
		
		this.accessFitness(this.soluction, this.o);
		
		if(this.soluction.getResult() < Particle.gBest.getResult())
			Particle.gBest = this.soluction.clone();				
		
	}
		
	public void updatePosition() {
		this.updateVelocity();
		
		for(int i = 0; i < this.soluction.getSolution().length - 1; i++){
			this.soluction.getSolution()[i + 1] = this.soluction.getSolution()[i] + this.velocity[i + 1];									
		}	
		
		this.accessFitness(this.soluction, this.o);
	}
	
	private void updateVelocity(){
				
		double phi1 = Math.random();
		double phi2 = Math.random();
		
		for (int i = 0; i < this.velocity.length-1; i++) {	
			
			double newVelocity = velocity[i] + C1 * phi1 * (    this.pBest.getSolution()[i] - this.soluction.getSolution()[i]) + 
											   C2 * phi2 * (Particle.gBest.getSolution()[i] - this.soluction.getSolution()[i]);
			
//			if(newVelocity > V_MAX)
//				velocity[i + 1] = V_MAX;
//			else if(newVelocity < V_MIN)
//				velocity[i + 1] = V_MIN;
//			else
				velocity[i + 1] = newVelocity;						
		}
	}


	public void updateLeaders() {
		if(this.soluction.getResult() < this.pBest.getResult())
			this.pBest = this.soluction.clone();

		if(this.soluction.getResult() < Particle.gBest.getResult())
			Particle.gBest = this.soluction.clone();		
	}
		
	public Soluction getSoluction(){
		return this.soluction;
	}
	
	public Soluction getPBest(){
		return this.pBest;
	}

	
	private double accessFitness(Soluction pi, double[] o) {
		//Setar na solução passada por parâmetro em getResult o valor do fitness 
		return this.f221(pi, o);
	}

}
