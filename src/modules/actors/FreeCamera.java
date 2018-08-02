package modules.actors;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import core.kernel.Camera;
import core.math.Vec3f;

public class FreeCamera extends Camera {

	private static float moveSpeed = 20;
	private Vec3f speed = new Vec3f();
	
	@Override
	public void move() {
		super.move();
		calculateYaw();
		calculatePitch();
		float forawrdDistance = speed.getX() * 
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}

	@Override
	protected void input() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) 
			speed.setX(moveSpeed);
		else if(Keyboard.isKeyDown(Keyboard.KEY_S))
			speed.setX(-moveSpeed);
		else
			speed.setX(0);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
			speed.setZ(moveSpeed);
		else if(Keyboard.isKeyDown(Keyboard.KEY_A))
			speed.setZ(-moveSpeed);
		else speed.setZ(0);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			speed.setY(moveSpeed);
		else if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			speed.setY(-moveSpeed );
		else
			speed.setY(0);
	}
	
	private void calculatePitch() {
		if(Mouse.isButtonDown(1)) {
			float pitchChange = Mouse.getDY() * 0.2f;
			Vec3f newRot = getRotation();
			newRot.setX(-pitchChange);
			if(newRot.getX() < 0) {
				newRot.setX(0);
			} else if(newRot.getX() > 90) {
				newRot.setX(90);
			}
			setRotation(newRot);
		}
	}
	
	private void calculateYaw() {
		if(Mouse.isButtonDown(1)) {
			float yawChange = Mouse.getDX() * 0.2f;
			Vec3f newRot = getRotation();
			newRot.setY(newRot.getY() + yawChange);
			setRotation(newRot);
		}
	}

}
