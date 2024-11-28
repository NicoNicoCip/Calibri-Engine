package io.github.pws.calibri.engine.core.math.vector;

public class Vector2 
{
    public int x;
    public int y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2()
    {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2f toVector2f()
    {
        return new Vector2f((float)this.x, (float)this.y);
    }

    public Vector3 toVector3()
    {
        return new Vector3(this.x, this.y, 0);
    }

    public Vector3f toVector3f()
    {
        return new Vector3f((float)this.x, (float)this.y, 0);
    }

    public Vector2 negate()
    {
        return new Vector2(-this.x, -this.y);
    }
    /**
     * @return a new empty {@link Vector2}.
     */
    public static Vector2 zero()
    {
        return new Vector2();
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(1, 1).
     */
    public static Vector2 one()
    {
        return new Vector2(1,1);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(1, 0).
     */
    public static Vector2 right()
    {
        return new Vector2(1,0);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(-1, 0).
     */
    public static Vector2 left()
    {
        return new Vector2(-1,0);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(0, 1).
     */
    public static Vector2 down()
    {
        return new Vector2(0,1);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(0, -1).
     */
    public static Vector2 up()
    {
        return new Vector2(0,-1);
    }

    /**
     * @return the sum of this Vector2 with the other Vector2.
     */
    public Vector2 add(Vector2 other)
    {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    /**
     * @return the rest of this Vector2 with the other Vector2.
     */
    public Vector2 rest(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * @return the division of this Vector2 with the other Vector2.
     */
    public Vector2 div(Vector2 other)
    {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    /**
     * @return the multiplication of this Vector2 with the other Vector2.
     */
    public Vector2 mul(Vector2 other)
    {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    /**
     * @return the module of this Vector2 with the other Vector2.
     */
    public Vector2 mod(Vector2 other)
    {
        return new Vector2(this.x % other.x, this.y % other.y);
    }

    /**
     * Compares two vectors togeter.
     * @return
     *      <b>s</b> if both the x and y of other are larger than this vector's <br>
     *      <b>e</b> if both the x and y of other are equal to this vector's <br>
     *      <b>l</b> if both the x and y  of other are smaller than this vector's <br>
     *      <b>null</b> if none of the above are met.
     */
    public String compareWith(Vector2 other)
    {
        if(this.x < other.x && this.y < other.y) return "s";
        else if(this.x == other.x && this.y == other.y ) return "e";
        else if(this.x > other.x && this.y > other.y) return "l";
        else return null;
    }
}
