package application;
	 
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Path;


public class Main extends Application {
	PickTileHandler pickTileHandler = new PickTileHandler();
	InputProcessing inputProcessing = new InputProcessing();
	Path path = new Path();
	public Main() throws FileNotFoundException  {
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			// BINDING
			Scene scene = new Scene(inputProcessing.getPane(),600,600);
			scene.addEventFilter(MouseEvent.MOUSE_CLICKED, pickTileHandler);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Pipes!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public class PickTileHandler implements EventHandler<MouseEvent>  {
		int count = 0;
		double sceneX;
		double sceneY;
		double firstTileX;
		double secondTileX;
		double firstTileY;
		double secondTileY;
		int firstTileIndex;
		int secondTileIndex;
		Tile firstTile;
		Tile secondTile;
		ImageView firstTileImageView;
		ImageView secondTileImageView;
		

		public void handle(MouseEvent e)  {
			System.out.println("I SEE YOU");
			count++;
			sceneX = e.getSceneX();
			sceneY = e.getSceneY();
			outerloop:
			for (int i = 0, j = 100; i < inputProcessing.getTileImages().size() && j <= 400; j += 100)  {
				for (int k = 100; k <= 400; k += 100)  {
					if (sceneX <= k && sceneY <= j)  {
						if (count % 2 == 1)  {
							firstTileX = k - 100;
							firstTileY = j - 100;
							firstTileImageView = inputProcessing.getTileImages().get(i);
							firstTile = inputProcessing.getTiles().get(i);
							firstTileIndex = i;
							break outerloop;
						}
						else  {
							secondTileX = k - 100;
							secondTileY = j - 100;
							secondTileImageView = inputProcessing.getTileImages().get(i);
							secondTile = inputProcessing.getTiles().get(i);
							secondTileIndex = i;
							
							Tile tile = (Tile)(firstTile.clone());
							inputProcessing.getTiles().set(firstTileIndex, secondTile);
							inputProcessing.getTiles().set(secondTileIndex, tile);
							
							inputProcessing.getTileImages().set(firstTileIndex, inputProcessing.getTiles().get(firstTileIndex).getImageView());
							inputProcessing.getTileImages().set(secondTileIndex, inputProcessing.getTiles().get(secondTileIndex).getImageView());
							
							inputProcessing.getTileImages().get(firstTileIndex).setX(firstTileX);
							inputProcessing.getTileImages().get(firstTileIndex).setY(firstTileY);
							inputProcessing.getTileImages().get(secondTileIndex).setX(secondTileX);
							inputProcessing.getTileImages().get(secondTileIndex).setY(secondTileY);
							break outerloop;
						}
					}
					else  {
						i++;
						if (i == inputProcessing.getTileImages().size())  {
							break outerloop;
						}
					}
				}
			}
		}
	}
}
