package mainLoop;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class InputReader {
	
	private boolean left, right, up, down, space;
	
	EventHandler<KeyEvent> output = new EventHandler<KeyEvent>() {	
		
	    @Override
		public void handle(KeyEvent ke) {
	    	switch(ke.getCode()) {
	    		case A:
	    		case LEFT:
	    			left = false;
	    			break;
	    		case D:
	    		case RIGHT:
	    			right = false;
	    			break;
	    		case SPACE:
	    			space = false;
	    			break;
	    		default:
	    			break;
	    	}
	    }
	   };
	
	EventHandler<KeyEvent> input = new EventHandler<KeyEvent>() {	
	
		@Override
		public void handle(KeyEvent ke) {
		   	switch(ke.getCode()) {
		   		case A:
		   		case LEFT:
		   			left = true;
		   			break;
		   		case D:
		   		case RIGHT:
		   			right = true;
		   			break;
		   		case SPACE:
		   			space = true;
		   			break;
		   		default:
		   			break;
		   	}
		}
	};
	
	public InputReader() {}
	
	public EventHandler<KeyEvent> getInputKey() {
		return input;
	}
	
	public EventHandler<KeyEvent> getOutputKey() {
		return output;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isSpace() {
		return space;
	}

	
	
}