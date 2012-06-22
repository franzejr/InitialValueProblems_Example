package main;

/*
 * Class that represents an EDO
 * 
 */
public class EDO {

	private double initialValue = 5.0;

	public double df(double t, double y) {

		return -20 * y + 7 * Math.exp(-0.5 * t);
	}

	public double getInitialValue() {
		return initialValue;
	}
	
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}
	
	

}
