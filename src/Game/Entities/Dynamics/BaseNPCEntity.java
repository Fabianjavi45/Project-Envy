package Game.Entities.Dynamics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Game.GameStates.InWorldState;
import Game.World.InWorldAreas.InWorldWalls;
import Game.World.Walls;
import Main.GameSetUp;
import Main.Handler;

public class BaseNPCEntity extends BaseDynamicEntity {
	
	double chaseSpeed = 1;
	boolean canMove = true;
	public String foundState;
	public String name="NPC";
	public String Area;//None for MapState
    public String type;//class it is ex: "EnemyOne"
    
    

	public BaseNPCEntity(Handler handler, int xPosition, int yPosition, String state,String name,String area, BufferedImage[] animFrames) {
		super(handler, xPosition, yPosition,animFrames);
		this.foundState = state;
		Area=area;
		this.name = name;
		nextArea = new Rectangle();
	}

	@Override
	public void tick() {
			super.tick();
			if(handler.getArea().equals(this.Area)) {
				PlayerDetectorRect();
	        }
	}

   

    private void PlayerDetectorRect() {
	
    	if(foundState.equals("InWorldState")){
    			nextArea = new Rectangle((int) getXOffset() + handler.getXInWorldDisplacement(),
    				(int) getYOffset() + handler.getYInWorldDisplacement() - 10,
    				getCollision().width, getCollision().height + 65);
		}
	}


	@Override
	public void render(Graphics g) {
		
		if (GameSetUp.DEBUGMODE) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(nextArea);
		}

	}
	}


   





