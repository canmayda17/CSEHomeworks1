package application;
import javafx.scene.image.ImageView;

public class Pipe extends Tile {
	ImageView pipeTile;
	public Pipe(int id, String property)  {
		super(id, property);
	}
	public boolean isStatic()  {
		return false;
	}
	public ImageView assignImage()  {
		if (getHorizontal())  {
			pipeTile = new ImageView("pipe_h.png".trim());
		}
		else if (getVertical())  {
			pipeTile = new ImageView("pipe_v.png".trim());
		}
		else if (getCurved00())  {
			pipeTile = new ImageView("pipe_00.png".trim());
		}
		else if (getCurved01())  {
			pipeTile = new ImageView("pipe_01.png".trim());
		}
		else if (getCurved10())  {
			pipeTile = new ImageView("pipe_10.png".trim());
		}
		else if (getCurved11())  {
			pipeTile = new ImageView("pipe_11.png".trim());
		}
		else  {
			// GET HERE AN EXCEPTION
		}
		return pipeTile;
	}
}
