package application;
import javafx.scene.image.ImageView;


public class Starter extends Tile {
	ImageView starterTile;
	public Starter(int id, String property)  {
		super(id, property);
	}
	public boolean isStatic()  {
		return true;
	}
	public ImageView assignImage()  {
		if (getHorizontal())  {
			starterTile = new ImageView("starter_h.png".trim());
		}
		else if (getVertical())  {
			starterTile = new ImageView("starter_v.png".trim());
		}
		else  {
			// GET HERE AN EXCEPTION
		}
		return starterTile;
	}
}
