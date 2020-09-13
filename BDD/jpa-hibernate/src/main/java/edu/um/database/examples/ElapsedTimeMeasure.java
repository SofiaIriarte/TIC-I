package edu.um.database.examples;

public class ElapsedTimeMeasure {
	private long startTime;
	private long endTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void end() {
		endTime = System.currentTimeMillis();
	}
	
	public String result() {
		if (endTime == 0) {
			end();
		}
		return "Elapsed time: " + (endTime - startTime) + " ms.";
	}
	
}
