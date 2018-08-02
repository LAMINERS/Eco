package core.kernel;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.PixelFormat;

import core.math.Vec2f;

/**
 * lwjgl Display implementation
 * @author Lars Bücker
 * @version 1.1
 */
public class Window {

	private static Window instance = null;
	
	private String title = "Eco Engine";
	private int width = 1280;
	private int height = 720;
	private boolean resizable = true;
	private boolean fullscreen = false;
	private boolean vsync = false;
	
	private static final int FPS_CAP = 144;
	
	/**
	 * Makes sure that only one Window exist
	 * @return Returns a instance of the Window
	 */
	public static Window getInstance() {
		if(instance == null)
			instance = new Window();
		return instance;
	}
	
	/**
	 * Creates a new Window
	 * @param width The width of the Window - Default: 1280
	 * @param height The height of the Window - Default: 720
	 */
	public void createWindow(int width, int height) {
		this.width = width;
		this.height = height;
		
		ContextAttribs attribs = new ContextAttribs(3, 3)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(getWidth(), getHeight()));
			Display.create(new PixelFormat().withSamples(8).withDepthBits(24), attribs);
			Display.setTitle(title);
			GL11.glEnable(GL13.GL_MULTISAMPLE);
			Display.setResizable(resizable);
			Display.setVSyncEnabled(vsync);
		} catch (LWJGLException e) {
			System.err.println("ERROR: Window creation failed");
			e.printStackTrace();
			System.exit(1);
		}
		
		GL11.glViewport(0, 0, width, height);
	}
	
	/**
	 * Updates the Window 
	 */
	public void update() {
		if(Display.wasResized()) {
			setWidth(Display.getWidth());
			setHeight(Display.getHeight());
			GL11.glViewport(0, 0, getWidth(), getHeight());
		}
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	/**
	 * Destroys the Window
	 */
	public void close() {
		Display.destroy();
	}
	
	/**
	 * Returns true when the close button is pressed
	 * @return The state of the close window button
	 */
	public boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	
	/**
	 * 
	 * @return The current Window title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the Window
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		if(title != this.title && title != "") {
			this.title = title;
			Display.setTitle(title);
		}
	}
	
	/**
	 * Returns the Size of the window
	 * @return The size of the window as Vec2f
	 */
	public Vec2f getSize() {
		return new Vec2f(width, height);
	}
	
	/**
	 * Sets the Size of the Window
	 * @param width The width to set
	 * @param height The height to set
	 */
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Returns the width of the window
	 * @return The width of the window
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the window to a new Width
	 * @param width The width to set
	 * @return The accuracy of the input
	 */
	public boolean setWidth(int width) {
		if(width > 0) {
			this.width = width;
			return true;
		}
		return false;
	}

	/**
	 * Return the height of the window
	 * @return The height of the window
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the window to a new Height
	 * @param height The height to set
	 * @return The accuracy of the input
	 */
	public boolean setHeight(int height) {
		if(height > 0) {
			this.height = height;
			return true;
		}
		return false;
	}

	/**
	 * Returns the resizability of the window
	 * @return The resizeability of the window
	 */
	public boolean isResizable() {
		return resizable;
	}

	/**
	 * Set the Resizeability of the window
	 * @param resizable The new state
	 */
	public void setResizable(boolean resizable) {
		if(resizable != this.resizable) {
			this.resizable = resizable;
			Display.setResizable(resizable);
		}
		
	}

	/**
	 * Returns true when the window is in fullscreen
	 * @return True when the window is in fullscreen
	 */
	public boolean isFullscreen() {
		return fullscreen;
	}

	/**
	 * Set if the window should be in fullscreen
	 * @param fullscreen The new state
	 */
	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
		try {
			Display.setFullscreen(fullscreen);
		} catch (LWJGLException e) {
			System.err.println("ERROR: Failed to set Window to Fullscreen");
			e.printStackTrace();
		}
	}

	/**
	 * FpsCap is necessary for the Display.update function
	 * @return The uses FpsCap
	 */
	public static int getFpsCap() {
		return FPS_CAP;
	}
}