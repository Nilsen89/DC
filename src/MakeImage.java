

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MakeImage {

	ImageView imageView;
	
	public  MakeImage (String path){
		File file = new File(path);
		try{
			FileInputStream fis = new FileInputStream(file);
			Image image = new Image(fis);
			imageView = new ImageView(image);
			fis.close();
	
		}catch (IOException e) {                   //gj�r dette p� tidligere �vinger
			System.out.println(e);
		}
	}
	public ImageView getImage(){
		return imageView;
	}
}
