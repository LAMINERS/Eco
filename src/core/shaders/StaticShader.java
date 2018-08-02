package core.shaders;

import core.math.Mat4f;

public class StaticShader extends Shader{

	public StaticShader() {
		super();
		
		addVertexShader(Shader.loadShader("shaders/vertexShader"));
		addFragmentShader(Shader.loadShader("shaders/fragmentShader"));
		
		bindAttribues();
		compileShader();
		
		addUniform("tM");
	}

	@Override
	protected void bindAttribues() {
		super.bindAttribte(0, "position");
		super.bindAttribte(1, "textureCoords");
	}
	
	public void loadTM(Mat4f matrix) {
		setUniformMat4("tM", matrix);
	}
}
