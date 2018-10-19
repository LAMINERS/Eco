package core.math;

public class Maths {

	public static Mat4f createTransformationMatrix(Vec3f position, Vec3f rotation, Vec3f scale) {
		Mat4f matrix = new Mat4f();
		matrix.Translation(position);
		matrix.Rotation(rotation);
		matrix.Scaling(scale);
		return matrix;
	}
	
	public static Mat4f createTransformationMatrix(Transform transform) {
		Mat4f matrix = new Mat4f();
		matrix.Translation(transform.getTranslation());
		matrix.Rotation(transform.getRotation());
		matrix.Scaling(transform.getScaling());
		return matrix;
	}
}
