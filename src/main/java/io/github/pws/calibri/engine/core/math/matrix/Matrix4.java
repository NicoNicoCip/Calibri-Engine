package io.github.pws.calibri.engine.core.math.matrix;

import io.github.pws.calibri.engine.util.Toolbox;

public class Matrix4
{
    public int x1, y1, z1, w1;
    public int x2, y2, z2, w2;
    public int x3, y3, z3, w3;
    public int x4, y4, z4, w4;

    @Override
    public String toString() {
        return "Matrix4{" +
                "x1=" + x1 + ", y1=" + y1 + ", z1=" + z1 + ", w1=" + w1 +
                ", x2=" + x2 + ", y2=" + y2 + ", z2=" + z2 + ", w2=" + w2 +
                ", x3=" + x3 + ", y3=" + y3 + ", z3=" + z3 + ", w3=" + w3 +
                ", x4=" + x4 + ", y4=" + y4 + ", z4=" + z4 + ", w4=" + w4 +
                '}';
    }

    public Matrix4()
    {
        this.x1 = 0; this.x2 = 0; this.x3 = 0; this.x4 = 0;
        this.y1 = 0; this.y2 = 0; this.y3 = 0; this.y4 = 0;
        this.z1 = 0; this.z2 = 0; this.z3 = 0; this.z4 = 0;
        this.w1 = 0; this.w2 = 0; this.w3 = 0; this.w4 = 0;
    }

    public Matrix4(int x1, int y1, int z1, int w1,
                   int x2, int y2, int z2, int w2,
                   int x3, int y3, int z3, int w3,
                   int x4, int y4, int z4, int w4)
    {
        this.x1 = x1; this.x2 = x2; this.x3 = x3; this.x4 = x4;
        this.y1 = y1; this.y2 = y2; this.y3 = y3; this.y4 = y4;
        this.z1 = z1; this.z2 = z2; this.z3 = z3; this.z4 = z4;
        this.w1 = w1; this.w2 = w2; this.w3 = w3; this.w4 = w4;
    }

    public Matrix4 rotate(int angle)
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
                return new Matrix4(
                x4, x3, x2, x1,
                y4, y3, y2, y1,
                z1, z3, z2, z1,
                w4, w3, w2, w1
                );
            }
            case 180 ->
            {
                return new Matrix4(
                w1, z4, y4, x4,
                w3, z3, y3, x3,
                w1, z2, y2, x2,
                w1, z1, y1, x1
                );
            }
            case 270 ->
            {
                return new Matrix4(
                w1, w2, w3, w4,
                z1, z2, z3, z4,
                y1, y2, y3, y4,
                x1, x2, x3, x4
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