/*****************
 * Plane object
 * 
 * @author 翁介誠
 *****************/
import javax.swing.*;

public class Plane extends Vehicle implements Runnable {
	private ImageIcon icon = new ImageIcon("./image/plane.png");// SET image
	private SubmarineMain game;
	PlaneBomb bomb;
	private static boolean reset;

	public Plane(int x, int y, double speed, SubmarineMain game) {
		super(x, y, speed);
		
	
		this.game = game;
		setSize(200, 200);
		bomb = new PlaneBomb(game);
		
		reset = false;
	}

	
	public void run() {
		
		while (true) {
			if(reset)
				break;
			setX(get_X() - (int)getSpeed());
			setY(get_Y() + (int)(Math.random() - 0.51));
			//Randomly dropped Bomb
			if ((int) (Math.random() * 1700) == 1.0 && get_X() < 1000) {
				bomb.addBomb(get_X(), get_Y() + 70);
			}

			if (get_X() <= -100) {
				setX(1000);
				if (get_Y() <= -50)
					setY(50);
			}
			try {
				Thread.sleep(5);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void resetPlane() {
		reset = true;
	}

	@Override
	public void setInitialIcon() {
		// TODO Auto-generated method stub
		setIcon(icon);
	}
}