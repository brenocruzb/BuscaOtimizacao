package Gentic;

import java.util.ArrayList;

import Util.Function;
import Util.Soluction;

public class Genetic extends Function{
	
	private int numAvaliation, tWeakSize, popSize;	
	private double min, max; 
	private double[] o;

	public Genetic(int popsize, int numAvaliation, int tWeakSize, double min, double max, double[]o){
		this.numAvaliation = numAvaliation;
		this.tWeakSize = tWeakSize;
		this.min = min;
		this.max = max;
		
		this.popSize = popsize;
		
		this.o = o;
	}
	
	public Soluction execute(){									
		ArrayList<Soluction> p = new ArrayList<>();
		
		for(int i = 0; i < this.popSize; i++){
			p.add(new Soluction(this.tWeakSize, this.min, this.max));
		}
		
		Soluction best = null;
		
		for(int i = 0; i < this.numAvaliation; i++){
			//Parte 1
			for(Soluction pi : p){
				accessFitness(pi, this.o);
				
				if(best == null || pi.getResult() < best.getResult()){
					best = pi.clone();
				}
			}
			
			ArrayList<Soluction> q = new ArrayList<>();
			//Parte 2
			for(int j = 0; j < this.popSize / 2; j++){							
				
				Soluction pa = selectWithReplacement(p);
				Soluction pb = selectWithReplacement(p);
				
				Soluction[] c = crossover(pa.clone(), pb.clone());
				Soluction ca = c[0];
				Soluction cb = c[1];
				
				q.add(mutate(ca));
				q.add(mutate(cb));
			}
			
			p.clear();
			p.addAll(q);
		}
		
		return best;
	}

	private Soluction mutate(Soluction cb) {
		// Método de multação. Retorna a própria solução cb multacionada
		// Bit-Flip Mutation
		
		return Soluction.tWeak3(cb);
		
//		byte[] cbByte = Util.toByteArray(cb.getSolution());
//		
//		double p = 1 / cbByte.length;
//		
//		for(int i = 0; i < cbByte.length; i++){
//			if(p >= Math.random()){
//				cbByte[i] = (byte) ~cbByte[i];
//			}
//		}
//		
//		double[] cbDouble = Util.toDoubleArray(cbByte);
//		cb.setSoluction(cbDouble);
//		
//		return cb;
	}

	private Soluction[] crossover(Soluction clone, Soluction clone2) {
		// Cruzamento entre pais - retorna duas novas solução decorrente do cruzamento
		// Uniform crossover
		
		for(int i = 0; i < clone.getSolution().length; i++){
			boolean change = Math.random() > 0.5;
			
			if(change){
				double aux = clone.getSolution()[i];
				clone.getSolution()[i] = clone2.getSolution()[i];
				clone2.getSolution()[i] = aux;
			}
		}
		
		Soluction[] result = new Soluction[2];
		result[0] = clone;
		result[1] = clone2;
		
		return result;
	}

	private Soluction selectWithReplacement(ArrayList<Soluction> p) {
		// Método de seleção dos pais - retorna uma solução da lista decorrente do método de seleção
		
		//Seleção por torneio.
		
		int randomPosition1 = (int) (Math.random() * p.size());
		int randomPosition2 = (int) (Math.random() * p.size());
		
		while(randomPosition1 == randomPosition2){
			randomPosition2 = (int) (Math.random() * p.size());
		}
		
		Soluction p1 = p.get(randomPosition1);
		Soluction p2 = p.get(randomPosition2);
		
		if(p1.getResult() < p2.getResult())
			return p1;
		
		return p2;
		
//		===========================
//		Roleta
		
		
//		double total = 0;
//		for(Soluction pi : p){
//			total += pi.getResult();
//		}
//		
//		
//		double current = 0;
//		double randomValue = (Math.random() * (total + 1));
//		
//		for(int i = 0; i < p.size(); i++){
//			current += p.get(i).getResult();
//			if(current >= randomValue){
//				return p.get(i);
//			}
//		}
//		
//		
//		return null;
	}

	private double accessFitness(Soluction pi, double[] o) {
		//Setar na solução passada por parâmetro em getResult o valor do fitness 
		return this.f221(pi, o);
	}
}
