package core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.EXTTextureFilterAnisotropic;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ImageLoader {

	public static Texture loadTexture(String path, String fileName) {
		Texture texture = null;
		
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream("res/" + path + fileName + ".png"));
			GL30.glGenerateMipmap(GL11.GL_PROXY_TEXTURE_2D);
			GL11.glTexParameteri(GL11.GL_PROXY_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL14.GL_TEXTURE_LOD_BIAS, 0);
			if(GLContext.getCapabilities().GL_EXT_texture_filter_anisotropic) {
				float amount = Math.min(4f,GL11.glGetFloat(EXTTextureFilterAnisotropic.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT));
				GL11.glTexParameterf(GL11.GL_TEXTURE_2D, EXTTextureFilterAnisotropic.GL_TEXTURE_MAX_ANISOTROPY_EXT, amount);
			} else {
				System.out.print("WARNING: Anisotropic Filtering is not supported in Driver!");
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Texture " + fileName + ".png could not be found at " + path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: Failed to read file " + fileName + ".png");
			e.printStackTrace();
		}
		return texture;
	}
}
