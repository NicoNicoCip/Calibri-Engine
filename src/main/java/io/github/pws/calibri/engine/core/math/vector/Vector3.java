package io.github.pws.calibri.engine.core.math.vector;

public class Vector3 
{
    public int x;
    public int y;
    public int z;

    public Vector3(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public String toString() {
        return "Vector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Vector2 toVector2()
    {
        return new Vector2(this.x, this.y);
    }

    public Vector2f toVector2f()
    {
        return new Vector2f((float)this.x, (float)this.y);
    }

    public Vector3f toVector3f()
    {
        return new Vector3f((float)this.x, (float)this.y, (float)this.z);
    }

    public Vector3 negate()
    {
        return new Vector3(-this.x, -this.y, -this.z);
    }
    /**
     * @return retruns a new {@link Vector3}
     */
    public static Vector3 zero()
    {
        return new Vector3();
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(1, 1, 1)
     */
    public static Vector3 one()
    {
        return new Vector3(1,1,1);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(1, 0, 0)
     */
    public static Vector3 right()
    {
        return new Vector3(1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(-1, 0, 0)
     */
    public static Vector3 left()
    {
        return new Vector3(-1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 1, 0)
     */
    public static Vector3 down()
    {
        return new Vector3(0,1,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, -1, 0)
     */
    public static Vector3 up()
    {
        return new Vector3(0,-1,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 0, 1)
     */
    public static Vector3 forward()
    {
        return new Vector3(0,0,1);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 0, -1)
     */
    public static Vector3 backward()
    {
        return new Vector3(0,0,-1);
    }

    /**
     * @return the sum of this Vector3 with the other Vector3.
     */
    public Vector3 add(Vector3 other)
    {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    /**
     * @return the rest of this Vector3 with the other Vector3.
     */
    public Vector3 rest(Vector3 other)
    {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    /**
     * @return the division of this Vector3 with the other Vector3.
     */
    public Vector3 div(Vector3 other)
    {
        return new Vector3(this.x / other.x, this.y / other.y, this.z / other.z);
    }

    /**
     * @return the multiplication of this Vector3 with the other Vector3.
     */
    public Vector3 mul(Vector3 other)
    {
        return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    /**
     * @return the module of this Vector3 with the other Vector3.
     */
    public Vector3 mod(Vector3 other)
    {
        return new Vector3(this.x % other.x, this.y % other.y, this.z % other.z);
    }

    /**
     * Compares two vectors togeter.
     * @return
     *      <b>s</b> if both the x, y and z of other are larger than this vector's <br>
     *      <b>e</b> if both the x, y and z of other are equal to this vector's <br>
     *      <b>l</b> if both the x, y and z of other are smaller than this vector's <br>
     *      <b>null</b> if none of the above are met.
     */
    public String compareWith(Vector3 other)
    {
        if(this.x < other.x && this.y < other.y && this.z < other.z) return "s";
        else if(this.x == other.x && this.y == other.y && this.z == other.z) return "e";
        else if(this.x > other.x && this.y > other.y && this.z > other.z) return "l";
        else return null;
    }
}
