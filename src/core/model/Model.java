package core.model;

import core.kernel.Loader;
import core.texturing.Texture2D;
import core.util.OBJLoader;

public class Model {

	private Mesh mesh;
	private Texture2D texture;
	
	public Model(Mesh mesh, Texture2D texture) {
		this.mesh = mesh;
		this.texture = texture;
	}
	
	public Model(String meshFile, String texturePath, String textureFile) {
		mesh = OBJLoader.loadObj(meshFile, Loader.getInstance());
		texture = new Texture2D(texturePath, textureFile, Loader.getInstance());
	}

	public Mesh getMesh() {
		return mesh;
	}

	public Texture2D getTexture() {
		return texture;
	}

}
