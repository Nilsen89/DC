package mainLoop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ClockTimer {
	
	private int minutes = 59;
	private int seconds = 59;
	private String timerFormat = "%s:%s";
	private String timer = String.format(timerFormat, minutes, seconds);
	
	Timeline timeline;
	StackPane clockStack;
	MakeImage background;
	Text clockText;
	
	private final Duration oneSecond = Duration.millis(1000);
	
	@SuppressWarnings("unchecked")
	private final KeyFrame countdownKey = new KeyFrame(oneSecond, 
			new EventHandler() {
		
				@Override
				public void handle(Event arg0) {
					if(seconds != 0) {
						seconds--;
					} else {
						seconds = 59;
						if(minutes != 0) {
							minutes--;
						} else {
							seconds = 0;
							timeline.stop();
						}
					} if(seconds < 10 && minutes < 10) {
						timer = String.format("%s%s:%s%s","0", minutes,"0",seconds);
						clockText.setText(timer);
					} else if(minutes < 10) {
						timer = String.format("%s%s:%s","0", minutes,seconds);
						clockText.setText(timer);
					} else if(seconds < 10) {
						timer = String.format("%s:%s%s", minutes,"0",seconds);
						clockText.setText(timer);
					} else {
						timer = String.format(timerFormat, minutes, seconds);
						clockText.setText(timer);
					}
				}
			});
	
	public ClockTimer() {
		initTimeline();
		initText();
		makeImage();
		makeStack();
	}

	private void initText() {
		 clockText = new Text(timer);
		 clockText.setFont(Font.font("Verdana",30));
		 clockText.setFill(Color.WHITE);
	}

	public void makeImage() {
		background = new MakeImage("C:\\Users\\Christoffer\\DC\\resource\\clockBg.jpg");
		background.getImage().setScaleX(0.2);
		background.getImage().setScaleY(0.2);
	}
	
	public void makeStack() {
		clockStack = new StackPane();
		clockStack.getChildren().addAll(background.getImage(), clockText);
	}
	
	public void initTimeline() {
		timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.getKeyFrames().add(countdownKey);
		timeline.play();
	}
	
	public void stopTime() {
		timeline.pause();
	}
	
	public void startTime() {
		timeline.play();
	}
	
	public StackPane getStackPane() {
		return clockStack;
	}
}
