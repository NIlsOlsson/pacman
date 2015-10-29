package my.tdl.MovableObjects;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import my.project.gop.main.Vector2F;
import my.tdl.main.Main;

public class Player implements KeyListener {

	Vector2F pos;
	private int width = 42;
	private int height = 42;
	private static boolean up, down, left, right;
	private float maxSpeed = 3F;
	
	private float speedUp = 0;
	private float speedDown = 0;
	private float speedLeft = 0;
	private float speedRight = 0;
	
	private float fixDt= 47f/60f;

	public Player() {
		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
	}

	public void init() {

	}

	public void tick(double deltaTime) {
		
		System.out.println("Tick");
		
		float moveAmountu = (float) (speedUp * fixDt);
		float moveAmountd = (float) (speedDown * fixDt);
		float moveAmountl = (float) (speedLeft * fixDt);
		float moveAmountr = (float) (speedRight * fixDt);

		if (up) {
			
			if(speedUp < maxSpeed){
				speedUp += .05F;
			}else{
				speedUp = maxSpeed;
			}
			
			System.out.println("increase y speed - move up with " + moveAmountu);

			pos.ypos-=moveAmountu;
		}else{
			
			if(speedUp != 0){
				speedUp -= .05F;
				
				if(speedUp < 0){
					speedUp = 0;
				}
			}

			System.out.println("decrease y speed move up with " + moveAmountu);

			pos.ypos-=moveAmountu;
			
		}
		
		
		
		
		
		

		if (down) {
			
			if(speedDown < maxSpeed){
				speedDown += .05F;
			}else{
				speedDown = maxSpeed;
			}

			
			pos.ypos+=moveAmountd;

		}else{
			
			if(speedDown != 0){
				speedDown -= .05F;
				
				if(speedDown < 0){
					speedDown = 0;
				}
			}
			
			pos.ypos+=moveAmountd;
		}

		if (left) {
			
			if(speedLeft < maxSpeed){
				speedLeft += .05F;
			}else{
				speedLeft = maxSpeed;
			}
			pos.xpos-=moveAmountl;

		}else{
			
			if(speedLeft != 0){
				speedLeft -= .05F;
				
				if(speedLeft < 0){
					speedLeft = 0;
				}
			}
			
			pos.xpos-=moveAmountl;
		}

		if (right) {
			
			if(speedRight < maxSpeed){
				speedRight += .05F;
			}else{
				speedRight = maxSpeed;
			}
			pos.xpos+=moveAmountr;

		}else{
			
			if(speedRight != 0){
				speedRight -= .05F;
				
				if(speedRight < 0){
					speedRight = 0;
				}
			}
			
			pos.xpos+=moveAmountr;
		}

	}

	public void render(Graphics2D g) {
		g.fillRect((int) pos.xpos, (int) pos.ypos, width, height);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = true;
			
			System.out.println("Up");
		}

		if (key == KeyEvent.VK_S) {
			down = true;
		}

		if (key == KeyEvent.VK_A) {
			left = true;
		}

		if (key == KeyEvent.VK_D) {
			right = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = false;
		}

		if (key == KeyEvent.VK_S) {
			down = false;
		}

		if (key == KeyEvent.VK_A) {
			left = false;
		}

		if (key == KeyEvent.VK_D) {
			right = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
