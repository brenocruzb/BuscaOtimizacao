import Climbing.AscentHillClimbing;
import Climbing.HillClimbing;
import Tabu.Tabu;
import Util.Soluction;

public class Main {

	public static void main(String[] args) {
		int neighbors = 1;
		int numAvaliation = 50000 / neighbors;
		int tWeakSize = 50;
		double min = -100;
		double max = 100;
		int listTabuSize = 200;
		
		for(int i = 0; i < 20; i++){
			
//			======================Metaheurísticas======================
//			
//			HillClimbing meta = new HillClimbing(numAvaliation, tWeakSize, min, max);
//			AscentHillClimbing meta = new AscentHillClimbing(numAvaliation, neighbors, tWeakSize, min, max);
			Tabu meta = new Tabu(listTabuSize, numAvaliation, neighbors, tWeakSize, min, max);
//			
//			===========================================================
			
			Soluction result = meta.execute();
			
			System.out.println(result.getResult());
//			System.out.println(result.getLastPosition());
		}

	}

}
