package io.github.pws.calibri.engine.core.math.matrix;

import io.github.pws.calibri.engine.util.Toolbox;

public class Matrix2b
{
    public boolean x1, y1;
    public boolean x2, y2;

    @Override
    public String toString() {
        return "Matrix2{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public Matrix2b()
    {
        this.x1 = false;
        this.x2 = false;
        this.y1 = false;
        this.y2 = false;
    }

    public Matrix2b(boolean x1, boolean y1,
                    boolean x2, boolean y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public static Matrix2b True()
    {
        return new Matrix2b(true,true,true,true);
    }

    public static Matrix2b False()
    {
        return new Matrix2b(false,false,false,false);
    }

    public Matrix2b rotate(int angle)
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
                return new Matrix2b(
                        this.x2,this.x1,
                        this.y2,this.y1
                );
            }
            case 180 ->
            {
                return new Matrix2b(
                        this.y2, this.x2,
                        this.y1, this.x1
                );
            }
            case 270 ->
            {
                return new Matrix2b(
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
