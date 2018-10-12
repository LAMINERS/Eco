package core.math;

public class Vec3i {

	private int x;
	private int y;
	private int z;
	
	public Vec3i() {
		setX(0);
		setY(0);
		setZ(0);
	}
	
	public Vec3i(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public Vec3i(Vec3i v) {
		setX(v.getX());
		setY(v.getY());
		setZ(v.getZ());
	}
	
	public int length() {
		return (int) Math.sqrt(x * x + y * y + z * z);
	}
	
	public int dot(Vec3i v) {
		return x * v.getX() + y * v.getY() + z * v.getZ();
	}
	
	public Vec3i normalize() {
		int length = length();
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	
	public Vec3i add(int r) {
		return new Vec3i(x + r, y + r, z + r);
	}
	
	public Vec3i add(Vec3i v) {
		return new Vec3i(x + v.getX(), y + v.getY(), z + v.getZ());
	}
	
	public Vec3i sub(int r) {
		return new Vec3i(x - r, y - r, z - r);
	}
	
	public Vec3i sub(Vec3i v) {
		return new Vec3i(x - v.getX(), y - v.getY(), z - v.getZ());
	}
	
	public Vec3i mul(int r) {
		return new Vec3i(x * r, y * r, z * r);
	}
	
	public Vec3i mul(Vec3i v) {
		return new Vec3i(x * v.getX(), y * v.getY(), z * v.getZ());
	}
	
	public Vec3i div(int r) {
		return new Vec3i(x / r, y / r, z / r);
	}
	
	public Vec3i div(Vec3i v) {
		return new Vec3i(x / v.getX(), y / v.getY(), z / v.getZ());
	}

	public Vec3i abs() {
		return new Vec3i(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	
	public boolean equal(Vec3i v) {
		if(x == v.getX() && y == v.getY() && z == v.getZ())
			return true;
		return false;
	}
	
	public String toString() {
		return "[" + this.x + "," + this.y + "," + this.z + "]";
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
