package core.scene;

import java.util.HashMap;

import core.math.Transform;
import core.math.Vec3f;

public class Actor {

	private HashMap<String, Component> components;
	private Transform transform;
	
	public Actor() {
		components = new HashMap<String, Component>();
		transform = new Transform();
	}
	
	public void addComponent(String string, Component component) {
		component.setParent(this);
		components.put(string, component);
	}
	
	public void update() {
		for(String key : components.keySet()) {
			components.get(key).update();
		}
	}
	
	public void render() {
		for(String key : components.keySet()) {
			components.get(key).render();
		}
	}
	
	public HashMap<String, Component> getComponents() {
		return components;
	}
	
	public Component getComponent(String component) {
		return this.components.get(component);
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}
	
	public void setTransform(Vec3f location, Vec3f rotation, Vec3f scale) {
		this.transform.setTranslation(location);
		this.transform.setRotation(rotation);
		this.transform.setScaling(scale);
	}
}
