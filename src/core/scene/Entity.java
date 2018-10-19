package core.scene;

import core.math.Transform;
import core.math.Vec3f;
import core.model.Model;

/**
 * Entities represents all static actors in the scene
 * @author Lars Bücker
 *
 */
public class Entity extends Actor {

	private Model model;
	
	/**
	 * Creates a new Entity at 0,0,0 
	 * @param model The model of the entity
	 */
	public Entity(Model model) {
		super();
		this.model = model;
	}
	
	/**
	 * Creates a new Entity 
	 * @param transform The transform of the entity
	 * @param model The model of the entity
	 */
	public Entity(Transform transform, Model model) {
		super();
		setTransform(transform);
		setModel(model);
	}
	
	/**
	 * Creates a new Entity
	 * @param location The location of the entity
	 * @param rotation The rotation of the entity
	 * @param scale The scale of the entitiy
	 * @param model The model of the entity
	 */
	public Entity(Vec3f location, Vec3f rotation, Vec3f scale, Model model) {
		super();
		setTransform(location, rotation, scale);
		setModel(model);
	}

	/**
	 * Getter for the model
	 * @return The model of the entity
	 */
	public Model getModel() {
		return model;
	}
	
	/**
	 * Setter for the model
	 * @param model The model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
