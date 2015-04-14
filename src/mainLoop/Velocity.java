package mainLoop;

import java.util.Date;

public class Velocity {
	
	private InputReader inputReader;
	private int moveSpeed = 0;
	private int jumpSpeed = 0;
	
	Date lastDate = new Date();
	Date newDate;
	long doubleJumpIdle;
	boolean jump;
	
	public Velocity(InputReader inputReader) {
		this.inputReader = inputReader;
	}
	
	public void calcuateTime() {
		newDate = new Date();
		doubleJumpIdle = lastDate.getTime() - newDate.getTime();
		lastDate = newDate;
	}
	
	public void calculate() {
		if(inputReader.isLeft()) {
			if(moveSpeed > -5) {
				moveSpeed--;
			}
		} else if(inputReader.isRight()) {
			if(moveSpeed < 5) {
				moveSpeed++;
			}
		} else {
			if(moveSpeed == 0) {}
			else if(moveSpeed < 0) {
				moveSpeed++;
			} else if(moveSpeed > 0){
				moveSpeed--;
			}
		} if(inputReader.isSpace()) {
			calcuateTime();
			if(doubleJumpIdle <  200) {	
				jump = true;
				if(jumpSpeed < 10) {
					jumpSpeed++;
				}
			} else {
				jumpSpeed = 0;
				jump = false;
			}
		} else {
			if (jumpSpeed > 0 && jumpSpeed != 0) {
			jumpSpeed--;
			}
		}
	}
	
	public int getSpeed() {
		return moveSpeed;
	}
	
	public int getJump() {
		return jumpSpeed;
	}
}