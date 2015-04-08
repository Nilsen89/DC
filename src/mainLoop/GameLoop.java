package mainLoop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameLoop extends Application {
	
	GameScene gameScene = new GameScene();
	//ClockTimer ct = new ClockTimer(); // Image path IOExeption ERROR...
	
	private Stage primalStage;
	private Timeline timeline;
	
	private final Duration oneFrameAmt = Duration.millis(1000/60);
	private final String TITLE = "Devil's Clockwork";
	
	@SuppressWarnings("unchecked")
	private final KeyFrame loopKey = new KeyFrame(oneFrameAmt, 
			new EventHandler() {
		
				@Override
				public void handle(Event arg0) {
					render();
					ticker();
				}
			});
	
	public void initFrame() {
		
		primalStage.setTitle(TITLE);	
		primalStage.setScene(gameScene.getScene());
		primalStage.show();
	}
	
	private void render() {
		gameScene.reader();
	}
	
	private void ticker() {
		
	}

	public void initTimeline() {
		timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.getKeyFrames().add(loopKey);
		timeline.play();
	}
	
	@Override
	public void start(Stage primalStage) throws Exception {
		this.primalStage = primalStage;
		initFrame();
		initTimeline();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}