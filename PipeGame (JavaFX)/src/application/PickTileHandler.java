//package application;
//
//import java.io.FileNotFoundException;
//
//import javafx.event.EventHandler;
//import javafx.scene.input.MouseEvent;
//
//public class PickTileHandler implements EventHandler<MouseEvent>  {
//	PlaceTiles placeTile = new PlaceTiles();
//	int count = 0;
//	Tile firstTile;
//	Tile secondTile;
//	public PickTileHandler() throws FileNotFoundException  {
//	}
//	public void handle(MouseEvent e)  {
//		System.out.println("I SEE YOU");
//		double screenx = e.getSceneX();
//		double screeny = e.getSceneY();
//		
//		int firstTileIndex = 0;
//		int secondTileIndex = 0;
//		count++;
//		outerLoop:
//		for (int i = 0, j = 100; i < placeTile.inputProcessing.getTiles().size() && j <= 400; j += 100)  {
//			for (int k = 100; k <= 400; k += 100)  {
//				if (screenx <= k && screeny <= j)  {
//					if (count % 2 == 1)  {
//						firstTile = placeTile.inputProcessing.getTiles().get(i);
//						firstTileIndex = i;
//						break outerLoop;
//					}
//					else  {
//						secondTile = placeTile.inputProcessing.getTiles().get(i);
//						secondTileIndex = i;
//						placeTile.inputProcessing.getTiles().set(firstTileIndex, secondTile);
//						placeTile.inputProcessing.getTiles().set(secondTileIndex, firstTile);
//						break outerLoop;
//					}
//				}
//				else  {
//					i++;
//				}
//			}
//		}
//	}
//}