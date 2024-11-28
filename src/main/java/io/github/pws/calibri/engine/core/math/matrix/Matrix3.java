package io.github.pws.calibri.engine.core.math.matrix;

import io.github.pws.calibri.engine.util.Toolbox;

public class Matrix3
{
    public int x1, y1, z1;
    public int x2, y2, z2;
    public int x3, y3, z3;

    @Override
    public String toString()
    {
        return "Matrix3{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", z1=" + z1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", z2=" + z2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", z3=" + z3 +
                '}';
    }

    public Matrix3()
    {
        this.x1 = 0;
        this.x2 = 0;
        this.x3 = 0;
        this.y1 = 0;
        this.y2 = 0;
        this.y3 = 0;
        this.z1 = 0;
        this.z2 = 0;
        this.z3 = 0;
    }

    public Matrix3(int x1, int y1, int z1,
                   int x2, int y2, int z2,
                   int x3, int y3, int z3)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.z1 = z1;
        this.z2 = z2;
        this.z3 = z3;
    }

    public Matrix3 rotate(int angle)
    {
        angle = Toolbox.ClampInt(angle, 0, 360);
        angle = Toolbox.step(angle, new float[] {0.0f,90.0f,180.0f,270.0f});

        switch (angle)
        {
            case 0 ->
            {
                return this;
            }
            case 90 ->
            {
                return new Matrix3(
                        x3, x2, x1,
                        y3, y2, y1,
                        z3, z2, z1
                );
            }
            case 180 ->
            {
                return new Matrix3(
                        z3, y3, x3,
                        z2, y2, x2,
                        z1, y1, x1
                );
            }
            case 270 ->
            {
                return new Matrix3(
                        z1, z2, z3,
                        y1, y2, y3,
                        x1, x2, x3
                );
            }
            default ->
            {
                System.err.println("Error    provided angle is not a positive int between 0 and 360");
            }
        }

        return null;
    }
}
