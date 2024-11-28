package io.github.pws.calibri.engine.core.math.vector;

public class Vector2f
{
    public float x;
    public float y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2f()
    {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2 toVector2()
    {
        return new Vector2((int)this.x, (int)this.y);
    }

    public Vector3 toVector3()
    {
        return new Vector3((int)this.x, (int)this.y, 0);
    }

    public Vector3f toVector3f()
    {
        return new Vector3f(this.x, this.y, 0);
    }

    public Vector2f negate()
    {
        return new Vector2f(-this.x, -this.y);
    }

    /**
     * @return a new empty {@link Vector2f}.
     */
    public static Vector2f zero()
    {
        return new Vector2f();
    }

    /**
     * @return a new {@link Vector2f} equivalent to Vector2(1, 1).
     */
    public static Vector2f one()
    {
        return new Vector2f(1,1);
    }

    /**
     * @return a new {@link Vector2f} equivalent to Vector2(1, 0).
     */
    public static Vector2f right()
    {
        return new Vector2f(1,0);
    }

    /**
     * @return a new {@link Vector2f} equivalent to Vector2(-1, 0).
     */
    public static Vector2f left()
    {
        return new Vector2f(-1,0);
    }

    /**
     * @return a new {@link Vector2f} equivalent to Vector2(0, 1).
     */
    public static Vector2f down()
    {
        return new Vector2f(0,1);
    }

    /**
     * @return a new {@link Vector2f} equivalent to Vector2(0, -1).
     */
    public static Vector2f up()
    {
        return new Vector2f(0,-1);
    }

    /**
     * @return the sum of this Vector2 with the other Vector2.
     */
    public Vector2f add(Vector2f other)
    {
        return new Vector2f(this.x + other.x, this.y + other.y);
    }

    /**
     * @return the rest of this Vector2 with the other Vector2.
     */
    public Vector2f rest(Vector2f other)
    {
        return new Vector2f(this.x - other.x, this.y - other.y);
    }

    /**
     * @return the division of this Vector2 with the other Vector2.
     */
    public Vector2f div(Vector2f other)
    {
        return new Vector2f(this.x / other.x, this.y / other.y);
    }

    /**
     * @return the multiplication of this Vector2 with the other Vector2.
     */
    public Vector2f mul(Vector2f other)
    {
        return new Vector2f(this.x * other.x, this.y * other.y);
    }

    /**
     * @return the module of this Vector2 with the other Vector2.
     */
    public Vector2f mod(Vector2f other)
    {
        return new Vector2f(this.x % other.x, this.y % other.y);
    }

    /**
     * Compares two vectors togeter.
     * @return
     *      <b>s</b> if both the x and y of other are larger than this vector's <br>
     *      <b>e</b> if both the x and y of other are equal to this vector's <br>
     *      <b>l</b> if both the x and y  of other are smaller than this vector's <br>
     *      <b>null</b> if none of the above are met.
     */
    public String compareWith(Vector2f other)
    {
        if(this.x < other.x && this.y < other.y) return "s";
        else if(this.x == other.x && this.y == other.y ) return "e";
        else if(this.x > other.x && this.y > other.y) return "l";
        else return null;
    }
}
