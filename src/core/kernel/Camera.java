package core.kernel;

import core.math.Transform;
import core.math.Vec3f;

public class Camera {

	private static Camera instance = null;
	
	private float fov = 70f;
	private float near = 0.001f;
	private float far = 10000f;
	
	private Transform transform;
	
	public static Camera getInstance() {
		if(instance == null)
			instance = new Camera();
		return instance;
	}
	
	public void move() {
		input();
	}
	
	public void update() {};
	
	protected void input() {}
	

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public float getNear() {
		return near;
	}

	public void setNear(float near) {
		this.near = near;
	}

	public float getFar() {
		return far;
	}

	public void setFar(float far) {
		this.far = far;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	};
	
	public void setLocation(Vec3f location) {
		transform.setTranslation(location);
	}
	
	public void setRotation(Vec3f rotation) {
		transform.setRotation(rotation);
	}
	
	public void setScale(Vec3f scale) {
		transform.setScaling(scale);
	}
	
	public Vec3f getLocation() {
		return transform.getTranslation();
	}
	
	public Vec3f getRotation() {
		return transform.getRotation();
	}
	
	public Vec3f getScale() {
		return transform.getScaling();
	}
}
