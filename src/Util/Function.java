package Util;

public abstract class Function {
	
	/**2.1.1 - F1: Shifted Sphere Function **/
	public double f211(Soluction soluction, double[] o){
		double result = 0;
		
		for(int i = 0; i < soluction.getSolution().length; i++){
			double z = soluction.getSolution()[i] - o[i];
			result += Math.pow(z, 2);
		}
		
		soluction.setResult(result);
		
		return result;
	}
	
	/**2.1.2 - F2: Schwefel’s Problem 2.21 **/
	public double f212(Soluction soluction, double[] o){
		double result = 0;
		
		for(int i = 0; i < soluction.getSolution().length; i++){
			double z = soluction.getSolution()[i] - o[i];
			if(Math.abs(z) > result)
				result = Math.abs(z);
		}
		
		soluction.setResult(result);
		
		return result;
	}
	
	
	/**2.2.1 - F3: Shifted Rosenbrock’s Function **/
	public double f221(Soluction soluction, double[] o){
		double result = 0;
		
		for(int i = 0; i < soluction.getSolution().length - 1; i++){
			double z1 = Math.pow(soluction.getSolution()[i] - o[i] + 1, 2);
			double z2 = soluction.getSolution()[i+1] - o[i+1] + 1;						
			
			double pt1 = Math.pow(z1 - z2, 2);
			double pt2 = Math.pow(z1 - 1, 2);
			
			result += 100 * pt1 + pt2;
		}
		
		soluction.setResult(result);
		
		return result;
	}
	
	/**2.2.2. F4: Shifted Rastrigin’s Function**/
	public double f222(Soluction soluction, double[] o){
		double result = 0;
		
		for(int i = 0; i < soluction.getSolution().length; i++){
			double z1 = Math.pow(soluction.getSolution()[i] - o[i], 2);
			
			result += z1 - 10 * Math.cos(2 * Math.PI * soluction.getSolution()[i]) + 10;
		}
		
		soluction.setResult(result);
		
		return result;
	}

}
