package mainLoop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class GameScene {
	
	private InputReader inputReader = new InputReader();
	private Velocity velocity = new Velocity(inputReader);
	
	private Pane paneContainer = new Pane();
	private Scene scene = new Scene(paneContainer);
	
	//TESTING...
	Rectangle player;
	Rectangle ground;
	//TESTING...
	
	public GameScene() {
		scene.setOnKeyPressed(inputReader.getInputKey());
		scene.setOnKeyReleased(inputReader.getOutputKey());
		paneContainer.setPrefSize(800, 600);
		
		//TESTING...
		
		player = new Rectangle(150,150);
		ground = new Rectangle(800,200);
		ground.setTranslateY(400);
		player.setTranslateY(250);
		player.setTranslateX(300);
		StackPane one = new StackPane();
		StackPane two = new StackPane();
		one.getChildren().add(player);
		two.getChildren().add(ground);
		paneContainer.getChildren().addAll(two,one);
		
		//TESTING...
	}
	
	public void setStackPane(StackPane stackPane) {
		paneContainer.getChildren().add(stackPane);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void reader() {
		velocity.calculate();
		
		player.setTranslateX(player.getTranslateX() + velocity.getSpeed());
		player.setTranslateY(player.getTranslateY() - velocity.getJump());	
	}
}
