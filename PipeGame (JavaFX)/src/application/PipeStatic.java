package application;
import javafx.scene.image.ImageView;

public class PipeStatic extends Tile {
	ImageView pipeStaticTile;
	public PipeStatic(int id, String property)  {
		super(id, property);
	}
	public boolean isStatic()  {
		return true;
	}
	public ImageView assignImage()  {
		if (getHorizontal())  {
			pipeStaticTile = new ImageView("pipestatic_h.png".trim());
		}
		else if (getVertical())  {
			pipeStaticTile = new ImageView("pipestatic_v.png".trim());
		}
		else if (getCurved00())  {
			pipeStaticTile = new ImageView("pipestatic_00.png".trim());
		}
		else if (getCurved01())  {
			pipeStaticTile = new ImageView("pipestatic_01.png".trim());
		}
		else if (getCurved10())  {
			pipeStaticTile = new ImageView("pipestatic_10.png".trim());
		}
		else if (getCurved11())  {
			pipeStaticTile = new ImageView("pipestatic_11.png".trim());
		}
		else  {
			// GET HERE AN EXCEPTION
		}
		return pipeStaticTile;
	}
}
