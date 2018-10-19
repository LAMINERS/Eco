package core.kernel;

import java.util.ArrayList;
import java.util.List;

import core.model.Model;
import core.renderer.Renderer;
import core.shaders.StaticShader;

public class RenderingEngine {
	
	private static RenderingEngine instance = null;
	
	public static RenderingEngine getInstance() {
		if(instance == null)
			instance = new RenderingEngine();
		return instance;
	}

	private List<Model> models = new ArrayList<Model>();
	
	//TODO Add new Renderers to the Engine
	Renderer renderer; 
	
	//TODO Add new Shaders to the Engine
	StaticShader staticShader;
	
	public RenderingEngine() {
		renderer = new Renderer();
		staticShader = new StaticShader();
		
		System.out.println("INFO: RenderingEngine created...");
	}
	
	public void render() {
		// Render all Static Objects
		staticShader.start();
		for(Model model : models) {
			renderer.render(model);
		}
		staticShader.stop();
	}
}
