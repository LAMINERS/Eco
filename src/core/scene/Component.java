package core.scene;

import core.math.Transform;

public class Component {

	private Actor parent;
	
	public void update() {};
	
	public void render() {};
	
	public Actor getParent() {
		return parent;
	}
	
	public void setParent(Actor parent) {
		this.parent = parent;
	}
	
	public Transform getTransform() {
		return getParent().getTransform();
	}
}
