package application;
import javafx.scene.image.ImageView;

public class Empty extends Tile {
	ImageView emptyTile;
	public Empty(int id, String property)  {
		super(id, property);
	}
	public boolean isStatic()  {
		return false;
	}
	public ImageView assignImage()  {
		if (getFree())  {
			emptyTile = new ImageView("empty_f.png".trim());
		}
		else if (getNone())  {
			emptyTile = new ImageView("empty_n.png".trim());
		}
		else  {
			// GET HERE AN EXCEPTION
		}
		return emptyTile;
	}
}
