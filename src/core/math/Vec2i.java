package core.math;

/**
 * Vector2i implementation
 * @author Lars Bücker
 *
 */
public class Vec2i {

	private int x;
	private int y;
	
	/**
	 * Creates a new empty Vec2i with x,y = 0
	 */
	public Vec2i() {
		setX(0);
		setY(0);
	}
	
	/**
	 * Creates a new Vec2i
	 * @param x The value of the x component
	 * @param y The value of the y component
	 */
	public Vec2i(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Creates a new Vec2f
	 * @param v The Vec2i containing the values of the new Vector
	 */
	public Vec2i(Vec2i v) {
		setX(v.getX());
		setY(v.getY());
	}
	
	/**
	 * Return the length of the Vector
	 * Calculation: i = sqrt(x*x + y*y)
	 * @return The length of the Vector
	 */
	public int length() {
		return (int) Math.sqrt(x * x + y * y);
	}
	
	/**
	 * Return the dot product of two Vectors
	 * Calculation: i = x*x + y*y
	 * @param v The second Vector
	 * @return The dot product of two vectors
	 */
	public int dot(Vec2i v) {
		return x * v.getX() + y * v.getY();
	}
	
	/**
	 * Normalize the Vector
	 * @return The normalized vector
	 */
	public Vec2i normalize() {
		int length = length();
		x /= length;
		y /= length;
		
		return this;
	}
	
	/**
	 * Adds another vector to this
	 * @param r The value to add
	 * @return A new vector with the result
	 */
	public Vec2i add(int r) {
		return new Vec2i(x + r, y + r);
	}
	
	/**
	 * Adds another vector to this
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2i add(Vec2i v) {
		return new Vec2i(x + v.getX(), y + v.getY());
	}
	
	/**
	 * Subtract a value of both components
	 * @param r The value to substract
	 * @return A new vector with the result
	 */
	public Vec2i sub(int r) {
		return new Vec2i(x - r, y - r);
	}
	
	/**
	 * Subtract another vector of this
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2i sub(Vec2i v) {
		return new Vec2i(x - v.getX(), y - v.getY());
	}
	
	/**
	 * Multiply both components with a value
	 * @param r The value to multiply
	 * @return A new vector with the result
	 */
	public Vec2i mul(int r) {
		return new Vec2i(x * r, y * r);
	}
	
	/**
	 * Multiply this and another vector
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2i mul(Vec2i v) {
		return new Vec2i(x * v.getX(), y * v.getY());
	}
	
	/**
	 * Divide both components by one value
	 * @param r The value to divide
	 * @return A new vector with the result
	 */
	public Vec2i div(int r) {
		return new Vec2i(x / r, y / r);
	}
	
	/**
	 * Divide this with another vector
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2i div(Vec2i v) {
		return new Vec2i(x / v.getX(), y / v.getY());
	}

	/**
	 * Returns a new vector with the absolut value of this
	 * @return The absolut values of both components
	 */
	public Vec2i abs() {
		return new Vec2i(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * Check if the other vector is equal to this
	 * @param v The vector to check against
	 * @return The result as boolean
	 */
	public boolean equal(Vec2i v) {
		if(x == v.getX() && y == v.getY())
			return true;
		return false;
	}
	
	/**
	 * Converts the vector to a String
	 */
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}
	
	/**
	 * Return the x component
	 * @return The value of the x component
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x component
	 * @param x The value to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the y component
	 * @return The value of the y component
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y component
	 * @param y The value to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}