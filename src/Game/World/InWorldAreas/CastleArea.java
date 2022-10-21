package Game.World.InWorldAreas;

import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Game.Entities.BaseEntity;
import Game.Entities.EntityManager;
import Game.Entities.Dynamics.BaseNPCEntity;
import Game.Entities.Dynamics.NPC;
import Game.Entities.Dynamics.Player;
import Game.Entities.Dynamics.SBoss;

import Game.World.Walls;

public class CastleArea extends BaseArea {


	Rectangle playerRect;
	//BaseNPCEntity D1;
	//BaseNPCEntity D2;
	//InWorldWalls W1;
	//InWorldWalls W2;
	public static boolean isInCastle = false;

	public static boolean S1=false;
	public static boolean S2=false;
	public static boolean P1=false;
	public static boolean P2=false;

	private int imageWidth = 5790, imageHeight = 5600;
	public final static int playerXSpawn = -2067, playerYSpawn =-4954;

	private Rectangle background = new Rectangle(3000, 3000);

	public static ArrayList<InWorldWalls> castleWalls;

	public CastleArea(Handler handler, EntityManager entityManager) {
		super(handler, entityManager);
		name="Castle";
		handler.setXInWorldDisplacement(playerXSpawn);
		handler.setYInWorldDisplacement(playerYSpawn);

		playerRect = new Rectangle((int) handler.getWidth() / 2 - 5, (int) (handler.getHeight() / 2) + 300, 70, 70);

		this.entityManager = entityManager;
		this.entityManager.AddEntity(handler.newEnemy(Images.BEnemyIdle, handler, 2590,430,"InWorldState", "Castle Monster","Castle", "sBoss",100,100,40,50,8,12,20,10,20,10,1,5,"None","Fire",null,null));

		castleWalls = new ArrayList<>();
		//W1=new InWorldWalls(handler,2560,1970,520,400, "Wall");
		//W2= new InWorldWalls(handler,2560,1090,520,400, "Wall");
		//castleWalls.add(W1);
		//castleWalls.add(W2);
		AddWalls();

	}

	public void tick() {
		super.tick();

		for (Walls w : castleWalls) {
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

		g.drawImage(Images.ScaledCastle, handler.getXInWorldDisplacement(), handler.getYInWorldDisplacement(), null);


		g.drawRect(handler.getXInWorldDisplacement() + 680,handler.getYInWorldDisplacement() + 3590,260,400);
		g.drawRect(handler.getXInWorldDisplacement() + 4770,handler.getYInWorldDisplacement() + 3540,260,400);

		if (GameSetUp.DEBUGMODE) {
			for (Walls w : castleWalls) {

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

		//Image Boundary
		castleWalls.add(new InWorldWalls(handler,0,5560,2690,40, "Wall"));
		castleWalls.add(new InWorldWalls(handler,0,280,5790,70, "Wall"));
		castleWalls.add(new InWorldWalls(handler,2950,5560,2840,40, "Wall"));

		//Main Room
		castleWalls.add(new InWorldWalls(handler,2260,4840,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3220,4840,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3220,4040,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3220,3240,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,2260,3240,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,2260,4040,160,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1620,3160,160,170, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1620,3320,320,640, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3860,3320,160,450, "Wall"));

		//Down Left Room
		castleWalls.add(new InWorldWalls(handler,1460,2760,160,2800, "Wall"));
		castleWalls.add(new InWorldWalls(handler,500,2760,960,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,500,3200,640,280, "Wall"));
		castleWalls.add(new InWorldWalls(handler,730,3570,160,300, "Wall"));
		castleWalls.add(new InWorldWalls(handler,340,2760,160,1680, "Wall"));
		castleWalls.add(new InWorldWalls(handler,500,4160,640,280, "Wall"));
		castleWalls.add(new InWorldWalls(handler,170,1790,2410,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,90,2020,80,410, "Wall"));
		castleWalls.add(new InWorldWalls(handler,30,2400,60,3160, "Wall"));
		castleWalls.add(new InWorldWalls(handler,340,5120,800,280, "Wall"));

		//Down Right Room
		castleWalls.add(new InWorldWalls(handler,4020,2760,160,2800, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4180,2760,960,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5140,2760,160,1680, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4500,3200,640,280, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4820,3640,160,300, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4500,4160,640,280, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4500,5120,800,280, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3060,1790,2560,560, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5620,1940,80,490, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5700,2310,60,3250, "Wall"));

		//Top Left Room
		castleWalls.add(new InWorldWalls(handler,80,1710,90,160, "Wall"));
		castleWalls.add(new InWorldWalls(handler,30,310,60,1480, "Wall"));
		castleWalls.add(new InWorldWalls(handler,90,310,90,130, "Wall"));
		castleWalls.add(new InWorldWalls(handler,260,1140,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1020,1050,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,630,890,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,230,490,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,710,380,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1180,490,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1510,220,160,1250, "Wall"));
		castleWalls.add(new InWorldWalls(handler,1670,910,910,560, "Wall"));

		//Top Right Room
		castleWalls.add(new InWorldWalls(handler,5620,1710,120,120, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5620,300,90,130, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5700,300,50,1420, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5340,1290,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4780,970,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4300,1010,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5420,810,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,5060,410,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,4300,410,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3970,140,160,1330, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3060,910,910,560, "Wall"));

		//Boss Room
		castleWalls.add(new InWorldWalls(handler,2420,430,160,400, "Wall"));
		castleWalls.add(new InWorldWalls(handler,3060,430,160,400, "Wall"));

		//Exit of Castle in Main Room
		castleWalls.add(new InWorldWalls(handler,2690, 5560, 260, 40, "Castle Exit"));



	}
	/*
	public void CheckDoorUnlock(){
		if(S1 && S2) {
			this.entityManager.RemoveEntity(D1);
			//castleWalls.remove(W1);
			S1=false;
			S2=false;
		}

		if(P1 && P2) {
			this.entityManager.RemoveEntity(D2);
			//castleWalls.remove(W2);
			P1=false;
			P2=false;
		}
	}
	 */

	@Override
	public ArrayList<InWorldWalls> getWalls() {
		return castleWalls;
	}
}




