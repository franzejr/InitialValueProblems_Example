package main;

import methods.PredictorCorrector;
import methods.RungeKutta;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double discretValue = 0.00001;
		
//		RungeKutta rk = new RungeKutta();
		//EDOSolver rk2 = new RungeKutta();
		
		//Euler ss = new Euler();
		//ss.modified(discreteValue);
		//EDOSolver euler = new Euler();
		//euler.forward(edo, 0.01);
		//euler.backward(edo, 0.01);
		//euler.modified(edo, 0.01);
//		double result[] = rk.solve(0.01);
		
		
//		/*Testing Predictor-Corrector */
		PredictorCorrector predictorCorrector = new PredictorCorrector();
		double result[] = predictorCorrector.execute(discretValue, 1000000);
		
//		for (double r : result) {
//			System.out.println(r +"\n");
//		}
		
//		MainFrame m = new MainFrame();
//		m.setVisible(true);

	}

}
