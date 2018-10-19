package core.kernel;

/**
 * Game implementation
 * @author Lars Bücker
 * @version 1.0
 */
public class Game {

	CoreEngine engine;
	
	public Game() {
		engine = new CoreEngine();
	}
	
	public void init() {
		engine.init();
	}
	
	public void launch() {
		engine.run();
	}

	public CoreEngine getEngine() {
		return engine;
	}

	public void setEngine(CoreEngine engine) {
		this.engine = engine;
	}
	
	
}
