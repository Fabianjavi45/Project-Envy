package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.util.ArrayList;

import Game.Entities.BaseEntity;
import Game.Entities.EntityManager;
import Game.Entities.Dynamics.BaseNPCEntity;
import Game.Entities.Dynamics.NPC;
import Game.Entities.Dynamics.Player;
import Game.World.Walls;

public class TownArea extends BaseArea {

	Rectangle exit;
	Rectangle playerRect;
	public static boolean isInTown = false;

	private int imageWidth = 3200, imageHeight = 3200;
	public final static int playerXSpawn = -900, playerYSpawn =-2500;

	private Rectangle background = new Rectangle(3000, 3000);

	public static ArrayList<InWorldWalls> townWalls;

	public TownArea(Handler handler, EntityManager entityManager) {
		super(handler, entityManager);
		name="Town";
		handler.setXInWorldDisplacement(playerXSpawn);
		handler.setYInWorldDisplacement(playerYSpawn);

		playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

		
		this.entityManager = entityManager;
		this.entityManager.AddEntity(handler.newNPC(Images.PEnemyIdle,handler,1425,1600,"InWorldState","Prof. Rocket","Town","NPCone"));

		townWalls = new ArrayList<>();
		AddWalls();

	}

	public void tick() {
		super.tick();
		


		for (Walls w : townWalls) {
			w.tick();
		}
		if(!GameSetUp.LOADING) {
			entityManager.tick();
		}

	}

	@Override
	public void render(Graphics g) {
		super.render(g);


		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.black);
		g2.fill(background);

		g.drawImage(Images.ScaledTown, handler.getXInWorldDisplacement(), handler.getYInWorldDisplacement(), null);

	
		if (GameSetUp.DEBUGMODE) {
			for (Walls w : townWalls) {

				if (w.getType().equals("Wall"))
					g2.setColor(Color.black);
				else
					g2.setColor(Color.PINK);

				w.render(g2);
			}
		}


		entityManager.render(g);

	}

	private void AddWalls() {
	
		//Top Left trees
		townWalls.add(new InWorldWalls(handler,0,0 ,610,610, "Wall"));				//
		//Trees Left of North Exit
		townWalls.add(new InWorldWalls(handler,605,0 ,650,310, "Wall"));
		//Top of Town Exit
		townWalls.add(new InWorldWalls(handler,1250,0 ,650,60, "North Exit")); 	
		//Trees Right of North Exit
		townWalls.add(new InWorldWalls(handler,1900,0 ,640,310, "Wall"));
		//Top Right Trees
		townWalls.add(new InWorldWalls(handler,2540,0 ,460,480, "Wall"));
		//Top Right Red House
		townWalls.add(new InWorldWalls(handler,2050,480 ,640,380, "Wall"));
		townWalls.add(new InWorldWalls(handler,2070,860 ,610,260, "Wall"));
		//Top Right Trees Boundaries
		townWalls.add(new InWorldWalls(handler,2690,580 ,220,40, "Wall"));
		//Trees on Top of East Exit
		townWalls.add(new InWorldWalls(handler,2860,590 ,340,680, "Wall"));
		//The Legend of Zelda Sign
		townWalls.add(new InWorldWalls(handler,1740,1360,150,230, "Wall"));
		//Top Left Blue-ish House
		townWalls.add(new InWorldWalls(handler,620,630 ,640,370, "Wall"));
		townWalls.add(new InWorldWalls(handler,640,1000 ,620,270, "Wall"));
		//Trees on Top of West Exit
		townWalls.add(new InWorldWalls(handler,0,590 ,300,1000, "Wall"));
		//Trees Below of West Exit
		townWalls.add(new InWorldWalls(handler,0,1860 ,290,660, "Wall"));
		//Bottom Left Trees
		townWalls.add(new InWorldWalls(handler,0,2500 ,630,700, "Wall"));
		//Trees left of South Exit
		townWalls.add(new InWorldWalls(handler,720,3140 ,470,60, "Wall"));
		//Bottom of Town
		townWalls.add(new InWorldWalls(handler,1190,3130,810,70, "South Exit"));  
		//Trees Right of South Exit
		townWalls.add(new InWorldWalls(handler,2000,3140,150,60, "Wall"));
		townWalls.add(new InWorldWalls(handler,2150,3170,170,30, "Wall"));
		townWalls.add(new InWorldWalls(handler,2320,3140,150,60, "Wall"));
		//Bottom Right Trees
		townWalls.add(new InWorldWalls(handler,2560,2820,640,380, "Wall"));
		townWalls.add(new InWorldWalls(handler,2470,3160,130,40, "Wall"));
		//Bottom Right Orange House
		townWalls.add(new InWorldWalls(handler,2250,2440,620,270, "Wall"));
		townWalls.add(new InWorldWalls(handler,2230,2070,640,370, "Wall"));
		//Trees Below of East Exit
		townWalls.add(new InWorldWalls(handler,2880,1860,320,1050, "Wall"));
		//Right of Town Exit
		townWalls.add(new InWorldWalls(handler,3060,1240,140,660, "East Exit"));
		//Left of Town
		townWalls.add(new InWorldWalls(handler,0,1560,90,360, "West Exit"));
		//Armor Store
		townWalls.add(new InWorldWalls(handler,790,2150,640,540, "Wall"));
		townWalls.add(new InWorldWalls(handler,950,2070,320,80, "Wall"));
		//Bottom Left Trees
		townWalls.add(new InWorldWalls(handler,540,3150,200,50, "Wall"));
		//Flower Pots
		townWalls.add(new InWorldWalls(handler,1430,1430,150,160, "Wall")); 
		townWalls.add(new InWorldWalls(handler,1590,1590,150,160, "Wall"));	
		//NPC Wall
		townWalls.add(new InWorldWalls(handler,1445, 1590, 70, 160, "Wall"));
		
	}
	
	

	@Override
	public ArrayList<InWorldWalls> getWalls() {
		return townWalls;
	}
}




