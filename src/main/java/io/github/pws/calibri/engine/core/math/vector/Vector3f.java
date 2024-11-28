package io.github.pws.calibri.engine.core.math.vector;

public class Vector3f
{
    public float x;
    public float y;
    public float z;

    public Vector3f(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public String toString() {
        return "Vector3f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Vector2 toVector2()
    {
        return new Vector2((int)this.x, (int)this.y);
    }

    public Vector2f toVector2f()
    {
        return new Vector2f(this.x, this.y);
    }

    public Vector3 toVector3()
    {
        return new Vector3((int)this.x, (int)this.y, (int)this.z);
    }

    public Vector3f negate()
    {
        return new Vector3f(-this.x, -this.y, -this.z);
    }

    /**
     * @return retruns a new {@link Vector3f}
     */
    public static Vector3f zero()
    {
        return new Vector3f();
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(1, 1, 1)
     */
    public static Vector3f one()
    {
        return new Vector3f(1,1,1);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(1, 0, 0)
     */
    public static Vector3f right()
    {
        return new Vector3f(1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(-1, 0, 0)
     */
    public static Vector3f left()
    {
        return new Vector3f(-1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(0, 1, 0)
     */
    public static Vector3f down()
    {
        return new Vector3f(0,1,0);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(0, -1, 0)
     */
    public static Vector3f up()
    {
        return new Vector3f(0,-1,0);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(0, 0, 1)
     */
    public static Vector3f forward()
    {
        return new Vector3f(0,0,1);
    }

    /**
     * @return retruns a new {@link Vector3f} equivalent to Vector3(0, 0, -1)
     */
    public static Vector3f backward()
    {
        return new Vector3f(0,0,-1);
    }

    /**
     * @return the sum of this Vector3 with the other Vector3.
     */
    public Vector3f add(Vector3f other)
    {
        return new Vector3f(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    /**
     * @return the rest of this Vector3 with the other Vector3.
     */
    public Vector3f rest(Vector3f other)
    {
        return new Vector3f(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    /**
     * @return the division of this Vector3 with the other Vector3.
     */
    public Vector3f div(Vector3f other)
    {
        return new Vector3f(this.x / other.x, this.y / other.y, this.z / other.z);
    }

    /**
     * @return the multiplication of this Vector3 with the other Vector3.
     */
    public Vector3f mul(Vector3f other)
    {
        return new Vector3f(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    /**
     * @return the module of this Vector3 with the other Vector3.
     */
    public Vector3f mod(Vector3f other)
    {
        return new Vector3f(this.x % other.x, this.y % other.y, this.z % other.z);
    }

    /**
     * Compares two vectors togeter.
     * @return
     *      <b>s</b> if both the x, y and z of other are larger than this vector's <br>
     *      <b>e</b> if both the x, y and z of other are equal to this vector's <br>
     *      <b>l</b> if both the x, y and z of other are smaller than this vector's <br>
     *      <b>null</b> if none of the above are met.
     */
    public String compareWith(Vector3f other)
    {
        if(this.x < other.x && this.y < other.y && this.z < other.z) return "s";
        else if(this.x == other.x && this.y == other.y && this.z == other.z) return "e";
        else if(this.x > other.x && this.y > other.y && this.z > other.z) return "l";
        else return null;
    }
}
