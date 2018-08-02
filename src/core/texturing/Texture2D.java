package core.texturing;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import core.kernel.Loader;

public class Texture2D {

	private int width;
	private int height;
	private int id;
	
	public Texture2D(String path, String file, Loader loader) {
		Texture texture = loader.loadTexture(path, file);
		this.width = texture.getTextureWidth();
		this.height = texture.getTextureHeight();
		this.id = texture.getTextureID();
	}
	
	public void bind() {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}
	
	public void generate() {
		id = GL11.glGenTextures();
	}
	
	public void unbind() {
		GL11.glBindTexture(GL11.GL_PROXY_TEXTURE_2D, 0);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getId() {
		return id;
	}
}
