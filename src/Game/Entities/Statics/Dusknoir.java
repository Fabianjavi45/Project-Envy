package Game.Entities.Statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Handler;
import Resources.Images;

public class Dusknoir extends BaseStaticEntity {

	Rectangle collision;
	public static Rectangle Questdetect;

	int width, height;

	public Dusknoir(Handler handler, int xPosition, int yPosition) {
		super(handler, xPosition, yPosition);
		width = 100;
		height = 100;

		this.setXOffset(xPosition);
		this.setYOffset(yPosition);
		collision = new Rectangle();
	}


	@Override
	public void render(Graphics g) {
		g.drawImage(Images.Dusk, (int)(handler.getXDisplacement() + xPosition),(int)( handler.getYDisplacement() + yPosition), width, height, null);
		collision = new Rectangle((int)(handler.getXDisplacement() + xPosition), (int)(handler.getYDisplacement() + yPosition ), width+5, height+35);
		Questdetect= new Rectangle((int)(handler.getXDisplacement() + xPosition), (int)(handler.getYDisplacement() + yPosition), width+5, height+35);
		//g.drawRect((int)(handler.getXDisplacement() + xPosition), (int)(handler.getYDisplacement() + yPosition), width+5, height+35);
	}


	@Override
	public Rectangle getCollision() {
		return collision;
	}



	@Override
	public double getXOffset() {
		return xPosition;
	}




}
