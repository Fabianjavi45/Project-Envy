package Game.Entities.Dynamics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Game.GameStates.State;
import Main.Handler;
import Resources.Images;

public class NPC extends BaseNPCEntity {

	public static Rectangle npcOne;
	Rectangle Range;
	int width, height;
	public int currentWidth, currentHeight;
	public boolean Text=false;
	public boolean Text2=false;
	public boolean Qtext= false;
	public boolean QText2= false;


	public NPC(Handler handler, int xPosition, int yPosition, String state, String name, String area, BufferedImage[] animFrames) {
		super(handler, yPosition, yPosition,state,name,area,animFrames);
		width = 30;
		height = 30;
		speed = 1;
		type="NPCone";
		this.setXOffset(xPosition);
		this.setYOffset(yPosition);

		this.foundState = state;
		npcOne = new Rectangle();
	}

	@Override
	public void tick() {

		if(!Player.isinArea)super.tick();

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			Text=!Text;
			handler.getGame().getMusicHandler().playEffect("res/music/selectBeep.wav",1);
		}

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)){
			Qtext=true;
			handler.getGame().getMusicHandler().playEffect("res/music/SSAcquired.wav",1);
		}
		else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)) {
			Qtext=false;
			handler.getGame().getMusicHandler().playEffect("res/music/enterSelect.wav",1);
		}

	}

	@Override
	public void render(Graphics g) {
		super.render(g);

		Graphics2D g2 = (Graphics2D) g;


		if(handler.getArea().equals(this.Area)) {
			if (Player.checkInWorld) {
				npcOne = new Rectangle((int) (handler.getXInWorldDisplacement() + getXOffset()),
						(int) (handler.getYInWorldDisplacement() + getYOffset()), 90, 110);
				Range= new Rectangle((int) getXOffset() + handler.getXInWorldDisplacement(),
						(int) getYOffset() + handler.getYInWorldDisplacement() - 10,
						getCollision().width, getCollision().height + 70);
			}

			g2.setColor(Color.black);
			g.drawImage(Images.NPC_front[0],npcOne.x,npcOne.y,npcOne.width,npcOne.height,null);

			if (Range.intersects(handler.getEntityManager().getPlayer().getCollision())) {

				if(Player.ObjectiveComplete) {
					if(!Text) {
						g2.setColor(Color.WHITE);
						g2.fillRect(npcOne.x-20, npcOne.y -35,100, 20);
						g2.setColor(Color.BLACK);
						g2.drawRect(npcOne.x-20, npcOne.y -35, 100, 20);
						g2.drawString("Press 'E'",npcOne.x, npcOne.y - 20);
					}
					else {
						g2.setColor(Color.WHITE);
						g2.fillRect(npcOne.x-20, npcOne.y + 115, 400, 60);
						g2.setColor(Color.BLACK);
						g2.drawRect(npcOne.x-20, npcOne.y + 115, 400, 60);
						g2.drawString("You defeated the PRIMAL MINION!",npcOne.x-15, npcOne.y +130);
						g2.drawString("I will now reward you with the Skill: ",npcOne.x-15, npcOne.y +145);
						g2.drawString("Accept Skill? 'Q'=Yes 'R'=No",npcOne.x-15, npcOne.y +160);
						g2.setColor(Color.CYAN);
						g2.drawString("ICE STORM",npcOne.x+215, npcOne.y +145);

						if(Qtext){
							Player.Quest=false;
							g2.setFont(new Font("Bank Gothic",3,100));
							g2.setStroke(new BasicStroke(1));
							g2.setColor(Color.CYAN);
							g2.drawString("SKILL ACQUIRED!",npcOne.x-350, npcOne.y + 260);
							Player.QuestComplete=true;
						}
						else {
							Player.Quest=false;
						}	
					}
				}
				else if(!Text) {
					g2.setColor(Color.WHITE);
					g2.fillRect(npcOne.x-20, npcOne.y -35,100, 20);
					g2.setColor(Color.BLACK);
					g2.drawRect(npcOne.x-20, npcOne.y -35, 100, 20);
					g2.drawString("Press 'E'",npcOne.x, npcOne.y - 20);
				}
				else {
					g2.setColor(Color.WHITE);
					g2.fillRect(npcOne.x-20, npcOne.y + 115, 400, 60);
					g2.setColor(Color.BLACK);
					g2.drawRect(npcOne.x-20, npcOne.y + 115, 400, 60);
					g2.drawString("I need you to defeat the Primal Minion.",npcOne.x-15, npcOne.y +130);
					g2.drawString("Bring me its head and I'll reward you with Skill:",npcOne.x-15, npcOne.y +145);
					g2.drawString("Accept Quest? 'Q'=Yes 'R'=No",npcOne.x-15, npcOne.y +160);
					g2.setColor(Color.CYAN);
					g2.drawString("ICE STORM",npcOne.x+280, npcOne.y +145);

					if(Qtext){
						Player.Quest=true;
						g2.setFont(new Font("Bank Gothic",3,100));
						g2.setStroke(new BasicStroke(1));
						g2.setColor(Color.GREEN);
						g2.drawString("QUEST ACCEPTED!",npcOne.x-350, npcOne.y - 130);
					}
					else {
						Player.Quest=false;
					}	
				}      
			}
			else Text=false;


		}
		g.drawRect((int)xPosition,(int)yPosition+280 ,250, 150);



	}


	@Override
	public Rectangle getCollision() {
		return npcOne;
	}





}

