import java.util.Arrays;

import Climbing.AscentHillClimbing;
import Climbing.HillClimbing;
import Gentic.Genetic;
import PSO.Particle;
import PSO.Pso;
import Tabu.Tabu;
import Util.Soluction;

public class Main {

	public static void main(String[] args) {
		int neighbors = 650;
		int numAvaliation = 50000 / neighbors;
		int tWeakSize = 50;
		double min = -100;
		double max = 100;
		int listTabuSize = 200;
//		
//		//Deslocamento
		double[] o = new double[tWeakSize];
		
		for(int i = 0; i < 20; i++){
//			System.out.println("i = " + (i+1));
//			======================Metaheurísticas======================
//			
//			HillClimbing meta = new HillClimbing(numAvaliation, tWeakSize, min, max, o);
//			AscentHillClimbing meta = new AscentHillClimbing(numAvaliation, neighbors, tWeakSize, min, max, o);
//			Tabu meta = new Tabu(listTabuSize, numAvaliation, neighbors, tWeakSize, min, max, o);
//			Genetic meta = new Genetic(neighbors, numAvaliation, tWeakSize, min, max, o);
			Pso meta = new Pso(neighbors, numAvaliation, tWeakSize, min, max, o);
//			
//			===========================================================
			
			Soluction result = meta.execute();
			
			System.out.println(result.getResult());
			Particle.gBest = null;
//			System.out.println(result.getLastPosition());
		}
		
		

	}

}
