package core.scene;

import java.util.ArrayList;
import java.util.List;

import core.model.Model;

public class Scene {

	//TODO Add other types of Renderable Class
	private List<Model> models = new ArrayList<Model>();
	
	public void addModel(Model model) {
		models.add(model);
	}
	
	public boolean removeModel(Model model) {
		return models.remove(model);
	}
	
	public List<Model> getModels() {
		return models;
	}
	
	public void setModels(List<Model> models) {
		this.models = models;
	}
}
