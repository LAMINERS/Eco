package core.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import core.math.Mat4f;
import core.math.Maths;
import core.model.Mesh;
import core.scene.Entity;
import core.shaders.StaticShader;

public class Renderer {

	public void prepare() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(1, 0, 0, 1);
		
	}
	
	public void render(Entity entity, StaticShader shader) {
		Mesh mesh = entity.getModel().getMesh();
		GL30.glBindVertexArray(mesh.getVaoId());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		Mat4f tM = Maths.createTransformationMatrix(entity.getTransform());
		shader.loadTM(tM);
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, entity.getModel().getTexture().getId());
		
		GL11.glDrawElements(GL11.GL_TRIANGLES, mesh.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
	}
}
