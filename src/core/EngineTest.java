package core;

import core.kernel.Game;
import core.kernel.Loader;
import core.kernel.RenderingEngine;
import core.model.Mesh;
import core.model.Model;
import core.scene.Entity;
import core.texturing.Texture2D;

public class EngineTest {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.init();		
		
		Loader loader = Loader.getInstance();

		float[] vertices = { -0.5f, 0.5f, 0f,
							-0.5f, -0.5f, 0f,
							0.5f, -0.5f, 0f,
							0.5f, 0.5f, 0f
		};
		int[] indices = { 0, 1, 3, 3, 1, 2};
		
		float[] textureCoords = {
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		Mesh mesh = loader.loadToVAO(vertices, textureCoords, indices);
		Texture2D texture = new Texture2D("textures/", "box", loader);
		Model model = new Model(mesh, texture);
		Entity entity = new Entity(model);
		
		RenderingEngine.addEntity(entity);
		
		game.launch();
	
	}

}