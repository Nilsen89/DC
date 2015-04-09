package mainLoop;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class GameScene {
	
	InputReader inputReader = new InputReader();
	Velocity velocity = new Velocity(inputReader);
	
	Pane paneContainer = new Pane();
	Scene scene = new Scene(paneContainer);
	
	
	
	//TESTING...
	Rectangle player;
	Rectangle ground;
	//TESTING...
	
	public GameScene() {
		scene.setOnKeyPressed(inputReader.getInputKey());
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
		
		
		//TESTING...
		if(inputReader.getDuration()) {
			player.setTranslateX(player.getTranslateX()+velocity.getSpeed());
		} if(inputReader.getJump()) {
			player.setTranslateY(player.getTranslateY()-2);
		} 
		if(!player.getBoundsInParent().intersects(ground.getBoundsInParent())) {			
			player.setTranslateY(player.getTranslateY()+1);
		}
		
		//TESTING...
	
	}
}
