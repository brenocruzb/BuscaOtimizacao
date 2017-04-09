package Util;

import java.util.Arrays;

public abstract class Tweak {
	
	/**Altera para um valor aleatorio em uma posicao aleatoria **/
	public static Soluction tWeak(Soluction soluction){
		
		int randomPosition = (int) (Math.random() * soluction.getSolution().length);
		double randomValue = (Math.random() * Soluction.max) + Soluction.min;
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length); 
		
		copySolution[randomPosition] = randomValue;
		
		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);
		
		return soluction2;
	}
		
	/**Incrementa ou decrementa em 0.2 o valor de uma posição aleatória da solução**/
	public static Soluction tWeak2(Soluction soluction){
		
		double val = 0.2 * (Math.random() > 0.5 ? 1 : -1);
		
		int randomPosition = (int) (Math.random() * soluction.getSolution().length);		
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length); 
		
		if(copySolution[randomPosition] + val <= Soluction.max && copySolution[randomPosition] + val >= Soluction.min)
			copySolution[randomPosition] += val;
		
		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);
		
		return soluction2;
	}
	
	/**Incrementa ou decrementa em 0.2 o valor de todas as posições da solução**/
	public static Soluction tWeak3(Soluction soluction){
		
		double val = 0.2 * (Math.random() > 0.5 ? 1 : -1);
		double[] copySolution = Arrays.copyOf(soluction.getSolution(), soluction.getSolution().length); 
		
		for(int i = 0; i < copySolution.length; i++)
			if(copySolution[i] + val <= Soluction.max && copySolution[i] + val >= Soluction.min)
				copySolution[i] += val;
		
		Soluction soluction2 = new Soluction(soluction.getSolution().length, Soluction.min, Soluction.max);
		soluction2.setSoluction(copySolution);
		
		return soluction2;
	}

}
