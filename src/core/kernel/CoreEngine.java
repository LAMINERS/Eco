package core.kernel;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL43;

public class CoreEngine {
	
	Window window;
	Loader loader;
	
	RenderingEngine renderEngine;
		
	protected CoreEngine() {
		window = Window.getInstance();
		window.createWindow(1280, 720);
		
		loader = new Loader();

		renderEngine = RenderingEngine.getInstance();
	}

	public void init() {
		getDeviceProperties();

		window.setTitle("Eco Engine");
	}
	
	public void run() {
		
		while(!window.isCloseRequested()) {
			
			renderEngine.render();
			
			window.update();
		}
		
		loader.cleanUp();
		window.close();
	}
	
	private void getDeviceProperties() {
		System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION) + " bytes");
		System.out.println("Max Geometry Uniform Blocks: " + GL31.GL_MAX_GEOMETRY_UNIFORM_BLOCKS+ " bytes");
		System.out.println("Max Geometry Shader Invocations: " + GL40.GL_MAX_GEOMETRY_SHADER_INVOCATIONS + " bytes");
		System.out.println("Max Uniform Buffer Bindings: " + GL31.GL_MAX_UNIFORM_BUFFER_BINDINGS + " bytes");
		System.out.println("Max Uniform Block Size: " + GL31.GL_MAX_UNIFORM_BLOCK_SIZE + " bytes");
		System.out.println("Max SSBO Block Size: " + GL43.GL_MAX_SHADER_STORAGE_BLOCK_SIZE + " bytes");	
	}
}
