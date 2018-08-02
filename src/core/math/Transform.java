package core.math;

public class Transform {

	private Vec3f translation;
	private Vec3f rotation;
	private Vec3f scaling;
	
	public Transform() {
		setTranslation(new Vec3f());
		setRotation(new Vec3f());
		setScaling(new Vec3f(1, 1, 1));
	}
	
	public Mat4f getWorldMatrix() {
		Mat4f translationMatrix = new Mat4f().Translation(translation);
		Mat4f rotationMatrix = new Mat4f().Rotation(rotation);
		Mat4f scalingMatrix = new Mat4f().Scaling(scaling);
		
		return translationMatrix.mul(scalingMatrix.mul(rotationMatrix));
	}
	
	public Mat4f getModelMatrix() {
		Mat4f rotationMatrix = new Mat4f().Rotation(rotation);
		
		return rotationMatrix;
	}
	//TODO getModelViewMatrix() Function unfinished
	/*public Matrix4f getModelViewProjectionMatrix() 
	{
		return Camera.getInstance().getViewProjectionMatrix().mul(getWorldMatrix());
	}*/


	public Vec3f getTranslation() {
		return translation;
	}

	public void setTranslation(Vec3f translation) {
		this.translation = translation;
	}

	public Vec3f getRotation() {
		return rotation;
	}

	public void setRotation(Vec3f rotation) {
		this.rotation = rotation;
	}

	public Vec3f getScaling() {
		return scaling;
	}

	public void setScaling(Vec3f scaling) {
		this.scaling = scaling;
	}
	
}
