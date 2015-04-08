package mainLoop;

import javafx.util.Duration;

public class Velocity {
	
	Duration movementDuration;
	InputReader inputReader;
	long speed;
	
	public Velocity(InputReader inputReader) {
		this.inputReader = inputReader;
	}
	
	public void calculate() {
		speed = inputReader.getTimeCalc()*1; // temp-mod
		if(inputReader.getDirection() == 'l') {			
			speed *= -1;
		}
		movementDuration = Duration.millis(inputReader.getTimeCalc()*250); // temp-mod
	}
	
	public long getSpeed() {
		return speed;
	}
	
	public Duration getMovementDuration() {
		return movementDuration;
	}
	
}