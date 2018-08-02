package core.scene;

import core.model.Model;

public class MeshComponent extends Component {

	private Model model;
	
	public MeshComponent(String meshFile, String texturePath, String textureFile) {
		model = new Model(meshFile, texturePath, textureFile);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
		
	}
}
