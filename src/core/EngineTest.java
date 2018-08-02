package core;

import core.kernel.Loader;
import core.kernel.Window;
import core.model.Mesh;
import core.model.Model;
import core.renderer.Renderer;
import core.shaders.StaticShader;
import core.texturing.Texture2D;

public class EngineTest {

	public static void main(String[] args) {
		Window window = Window.getInstance();
		
		window.createWindow(1280, 720);
		window.setTitle("Eco Game");
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
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
	
		while(!window.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			
			renderer.render(model);
			
			shader.stop();
			
			window.update();
		}
		
		loader.cleanUp();
		window.close();
	}

}
