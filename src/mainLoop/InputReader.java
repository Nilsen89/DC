package mainLoop;

import java.util.Date;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class InputReader {
	
	Timeline timeline;
	Duration time;
	long timeCalc;
	char direction;
	boolean jump = false;
	long max = 5;
	Date lastDate = new Date();
	Date currentDate;
	long idle;
	int moveDuration;
	int jumpDuration = 31;
	
	EventHandler<KeyEvent> input = new EventHandler<KeyEvent>() {	
		
	    @Override
		public void handle(KeyEvent ke) {

	    	calculateTime();
	    	
	    	// TESTING...
	    	System.out.println();
	    	System.out.println("direction: " + direction);
	    	System.out.println("idle: " + idle);
	    	System.out.println("timeCalc: "+timeCalc);
	    	System.out.println();
	    	// TESTING...
	    	
	    	//Duration
	    	moveDuration = 0;
	    	//Duration
	    	
	    	switch(ke.getCode()) {
	    		case A:
	    		case LEFT:
	    			directionCounter('l');
	    			break;
	    		case D:
	    		case RIGHT:
	    			directionCounter('r');
	    			break;
	    		case SPACE:
	    			jumpDuration = 0;
	    			break;
	    		default:
	    			timeCalc = 0;
	    			jumpDuration = 31;
	    			break;
	    	}
	    }
	};
	
	public InputReader() {}
	
	public void calculateTime() {
		currentDate = new Date(); 
		idle = lastDate.getTime() - currentDate.getTime();
		lastDate = currentDate;
	}
	
	public Duration getSpeed() {
		return time;
	}
	
	public void directionCounter(char direction) {
		if(this.direction != direction) {
			timeCalc = 1;
			if (this.direction == 'l') {
				this.direction = 'r';
			} else {			
				this.direction = 'l';
			}
		} else {
			if(inputChecker()) {
				if(timeCalc != max) {
					timeCalc++;
				}
			} else {
				timeCalc = 1;
			}
		}
	}
	
	public EventHandler<KeyEvent> getInputKey() {
		return input;
	}
	
	public boolean inputChecker() {
		return timeCalc <= max && idle > -400;
	}
	
	public long getTimeCalc() {
		return timeCalc;
	}
	
	public char getDirection() {
		return direction;
	}
	
	public boolean getDuration() {
		moveDuration++;
		return moveDuration < 21;
	}
	
	public boolean getJump() {
		jumpDuration++;
		return jumpDuration < 31;
	}
	
}