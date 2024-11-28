package io.github.pws.calibri.engine.core.math.matrix;

import io.github.pws.calibri.engine.util.Toolbox;

public class Matrix2
{
    public int x1, y1;
    public int x2, y2;

    @Override
    public String toString() {
        return "Matrix2{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public Matrix2()
    {
        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
    }

    public Matrix2(int x1, int y1,
                   int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Matrix2 rotate(int angle)
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
                return new Matrix2(
                        this.x2,this.x1,
                        this.y2,this.y1
                );
            }
            case 180 ->
            {
                return new Matrix2(
                        this.y2, this.x2,
                        this.y1, this.x1
                );
            }
            case 270 ->
            {
                return new Matrix2(
                        this.y1,this.y2,
                        this.x1, this.x2
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
