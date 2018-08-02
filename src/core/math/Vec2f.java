package core.math;

/**
 * Vector2f implementation
 * @author Lars Bücker
 *
 */
public class Vec2f {

	private float x;
	private float y;
	
	/**
	 * Creates a new empty Vec2f with x,y = 0
	 */
	public Vec2f() {
		setX(0);
		setY(0);
	}
	
	/**
	 * Creates a new Vec2f
	 * @param x The value of the x component 
	 * @param y The value of the y component
	 */
	public Vec2f(float x, float y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Creates a new Vec2f
	 * @param v The Vec2f containing the values of the new Vec2f
	 */
	public Vec2f(Vec2f v) {
		setX(v.getX());
		setY(v.getY());
	}
	
	/**
	 * Return the length of the Vector
	 * @return The length of the Vector
	 */
	private float length() {
		return (float) Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Return the dot product of two Vectors
	 * @param r The secound Vector
	 * @return The dot product of two vectors is calculated as v1.x * v2.x + v1.y * v2.y
	 */
	public float dot(Vec2f r) {
		return x * r.getX() + y * r.getY();
	}
	
	/**
	 * Normalize the Vector
	 * @return The normalized vector
	 */
	public Vec2f normalize() {
		float length = length();
		x /= length;
		y /= length;
		
		return this;
	}
	
	/**
	 * Adds another vector to this
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2f add(Vec2f v) {
		return new Vec2f(getX() + v.getX(), getY() + v.getY());
	}
	
	/**
	 * Adds a value to both components of the vector
	 * @param r The value to add
	 * @return A new vector with the result
	 */
	public Vec2f add(float r) {
		return new Vec2f(getX() + r, getY() + r);
	}
	
	/**
	 * Substract another vector of this
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2f sub(Vec2f v) {
		return new Vec2f(getX() - v.getX(), getY() - v.getY());
	}
	
	/**
	 * Substract a value of both components of the vector
	 * @param r The value to substract
	 * @return A new vector with the result
	 */
	public Vec2f sub(float r) {
		return new Vec2f(getX() - r, getY() - r);
	}
	
	/**
	 * Divide this and another vector
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2f div(Vec2f v) {
		return new Vec2f(getX() / v.getX(), getY() / v.getY());
	}
	
	/**
	 * Divide both components by a value
	 * @param r The value to the vector is divided by
	 * @return A new vector with the result
	 */
	public Vec2f div(float r) {
		return new Vec2f(getX() / r, getY() / r);
	}
	
	/**
	 * Multiply this and another vector
	 * @param v The other vector
	 * @return A new vector with the result
	 */
	public Vec2f mul(Vec2f v) {
		return new Vec2f(getX() * v.getX(), getY() * v.getY());
	}
	
	/**
	 * Multiply both components with a value
	 * @param r The value to multiply
	 * @return A new vector with the result
	 */
	public Vec2f mul(float r) {
		return new Vec2f(getX() * r, getY() * r);
	}
	
	/**
	 * Returns a new vector with the absolute values of both components
	 * @return The absolute values of both components
	 */
	public Vec2f abs() {
		return new Vec2f(Math.abs(x), Math.abs(y));
	}
	
	/**
	 * Check if the input vector is equal to this
	 * @param v The vector to check against
	 * @return The result as boolean
	 */
	public boolean equal(Vec2f v) {
		if(x == v.getX() && y == v.getY()) 
			return true;
		return false;
	}
	
	/**
	 * Converts the Vector to a String
	 */
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}

	/**
	 * Return the x component
	 * @return The value of the x component
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x component
	 * @param x The value to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Return the y component
	 * @return The value of the y component
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y component
	 * @param y The value to set
	 */
	public void setY(float y) {
		this.y = y;
	}
}