package mainLoop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameLoop extends Application {
	
	private Stage primalStage;
	private Scene scene;
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
		Pane paneContainer = new Pane();
		
		scene = new Scene(paneContainer);	
		
		primalStage.setScene(scene);
		primalStage.show();
	}
	
	private void render() {
		
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