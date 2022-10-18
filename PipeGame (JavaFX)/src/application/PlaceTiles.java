//package application;
//
//import java.io.FileNotFoundException;
//import javafx.scene.layout.GridPane;
//
//public class PlaceTiles {
//	GridPane root = new GridPane();
//	InputProcessing inputProcessing = new InputProcessing();
//	public PlaceTiles() throws FileNotFoundException  {
//		for (int i = 0, j = 0; i < inputProcessing.getTiles().size() && j < 4; j++)  {
//			for (int k = 0; k < 4; k++)  {
//				root.add(inputProcessing.getTiles().get(i).assignImage(), k, j);
//				i++;
//			}
//		}
//	}
//}
