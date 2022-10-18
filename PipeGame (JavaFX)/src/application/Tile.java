package application;
import javafx.scene.image.ImageView;


public abstract class Tile implements Cloneable  {
	private int id;
	private String property;  // Irrelevant?
	private boolean horizontal;
	private boolean vertical;
	private boolean free;
	private boolean none;
	private boolean curved00;
	private boolean curved01;
	private boolean curved10;
	private boolean curved11;
	
	public Tile(int id, String property)  {
		this.id = id;
		this.property = property;
		assignProperty(property);
		
	}
	public void assignProperty(String property)  {
		switch (property)  {
			case "Horizontal":
				this.horizontal = true;
				break;
			case "Vertical":
				this.vertical = true;
				break;
			case "Free":
				this.free = true;
				break;
			case "none":
				this.none = true;
				break;
			case "00":
				this.curved00 = true;
				break;
			case "01":
				this.curved01 = true;
				break;
			case "10":
				this.curved10 = true;
				break;
			case "11":
				this.curved11 = true;
				break;
			default:
				// GET HERE AN EXCEPTION
		}
	}

	public int getId()  {
		return id;
	}
	public void setId(int id)  {
		this.id = id;
	}
	public boolean getHorizontal()  {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal)  {
		this.horizontal = horizontal;
	}
	public boolean getVertical()  {
		return vertical;
	}
	public void setVertical(boolean vertical)  {
		this.vertical = vertical;
	}
	public boolean getFree()  {
		return free;
	}
	public void setFree(boolean free)  {
		this.free = free;
	}
	public boolean getNone()  {
		return none;
	}
	public void setNone(boolean none)  {
		this.none = none;
	}
	public boolean getCurved00()  {
		return curved00;
	}
	public void setCurved00(boolean curved00)  {
		this.curved00 = curved00;
	}
	public boolean getCurved01()  {
		return curved01;
	}
	public void setCurved01(boolean curved01)  {
		this.curved01 = curved01;
	}
	public boolean getCurved10()  {
		return curved10;
	}
	public void setCurved10(boolean curved10)  {
		this.curved10 = curved10;
	}
	public boolean getCurved11()  {
		return curved11;
	}
	public void setCurved11(boolean curved11)  {
		this.curved11 = curved11;
	}
	public abstract boolean isStatic();
	
	public abstract ImageView assignImage();
	
	public Object clone()  {
		try  {
			Tile tile = (Tile)super.clone();
			return tile;
		}
		catch (CloneNotSupportedException ex)  {
			return null;  // REWRITE THE EXCEPTION
		}
	}
	public ImageView getImageView() {
		return assignImage();
	}
}
