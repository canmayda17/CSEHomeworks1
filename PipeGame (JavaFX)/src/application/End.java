package application;
import javafx.scene.image.ImageView;

public class End extends Tile {
	ImageView endTile;
	public End(int id, String property)  {
		super(id, property);
	}
	public boolean isStatic()  {
		return true;
	}
	public ImageView assignImage()  {
		if (getHorizontal())  {
			endTile = new ImageView("end_h.png".trim());
		}
		else if (getVertical())  {
			endTile = new ImageView("end_v.png".trim());
		}
		else  {
			// GET HERE AN EXCEPTION
		}
		return endTile;
	}
}
