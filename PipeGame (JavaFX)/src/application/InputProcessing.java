package application;
import java.util.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.*;
// reads data from the input
// DO THE EXCEPTION HANDLING


public class InputProcessing {
	private String[] elements;
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<ImageView> tileImages = new ArrayList<ImageView>();
	private Pane root = new Pane();
	public InputProcessing() throws FileNotFoundException  {
		classifyTile();
		collectTileImages();
	}
	public void classifyTile() throws FileNotFoundException {  // Why do i have to throw exception again?
		try  {
			File file = new File(("CSE1242_spring2022_project_level" + 1 + ".txt").trim());
			Scanner input = new Scanner(file);
			while (input.hasNextLine())  {  // SKIP BLANK LINES
				String line = input.nextLine();
				if (line.length() == 0) {
					continue;
				}
				elements = line.split(",");
				switch (elements[1])  {
					case "Starter": 
						if (line.length() == 0) {
							continue;
						}
						Tile starterTile = new Starter(Integer.parseInt(elements[0]), elements[2]);  // MIGHT HAVE PROBLEMS WITH THIS DEFINITION
						tiles.add(starterTile);
						break;
					case "End":
						if (line.length() == 0) {
							continue;
						}
						Tile endTile = new End(Integer.parseInt(elements[0]), elements[2]);
						tiles.add(endTile);
						break;
					case "Empty":
						if (line.length() == 0) {
							continue;
						}
						Tile emptyTile = new Empty(Integer.parseInt(elements[0]), elements[2]);
						tiles.add(emptyTile);
						break;
					case "Pipe":
						if (line.length() == 0) {
							continue;
						}
						Tile pipeTile = new Pipe(Integer.parseInt(elements[0]), elements[2]);
						tiles.add(pipeTile);
						break;
					case "PipeStatic":
						if (line.length() == 0) {
							continue;
						}
						Tile pipeStaticTile = new PipeStatic(Integer.parseInt(elements[0]), elements[2]);
						tiles.add(pipeStaticTile);
						break;
					default:
						
						throw new IllegalArgumentException("Invalid tile type: " + elements[1]);
				}
			}
		}
		catch (FileNotFoundException ex)  {
			System.out.print("Exception!");
		}
		catch (NullPointerException ex) {
		System.out.print("NullPointerException2");
		}
		
		
		
	}
	
	public void collectTileImages()  {
		outerloop:
			for (int i = 0, j = 0; i < getTiles().size() && j < 400; j += 100)  {
				for (int k = 0; k < 400; k += 100)  {
					tileImages.add(getTiles().get(i).assignImage());
					tileImages.get(i).setX(k);
					tileImages.get(i).setY(j);
					
					root.getChildren().add(tileImages.get(i));
					i++;
					if (i == getTiles().size())  {
						break outerloop;
					}
				}
			}
	}
	public ArrayList<Tile> getTiles()  {
		return tiles;
	}
	public ArrayList<ImageView> getTileImages()  {
		return tileImages;
	}
	public Pane getPane()  {
		return root;
	}
}
