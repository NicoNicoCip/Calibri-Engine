package io.github.pws.calibri.engine.graphics;

import io.github.pws.calibri.engine.util.Toolbox;
import io.github.pws.calibri.engine.core.math.vector.Vector3;

public class Color {
    /**
     * A string representing ANSI reset character.
     */
    public static final String RESET = "\033[0m";

    /**
     * @return A string representing the ANSI character for the inputted rgb color, for the foreground specifically.
     */
    public static String rgbFG(int r, int g, int b) 
    {
        Vector3 col = clampClolors(r,g,b);
        return String.format("\u001B[38;2;%d;%d;%dm", col.x, col.y, col.z);
    }

    /**
     * @return A string representing the ANSI character for the inputted rgb color, for the background specifically.
     */
    public static String rgbBG(int r, int g, int b) 
    {
        Vector3 col = clampClolors(r,g,b);
        return String.format("\u001B[48;2;%d;%d;%dm", col.x, col.y, col.z);
    }

    /**
     * @return the clamped characters between 0 and 255 as a {@link Vector3}.
     */
    public static Vector3 clampClolors(int r, int g, int b)
    {
        r = Toolbox.ClampInt(r, 0, 255);
        g = Toolbox.ClampInt(g, 0, 255);
        b = Toolbox.ClampInt(b, 0, 255);
        return new Vector3(r,g,b);
    }
}
