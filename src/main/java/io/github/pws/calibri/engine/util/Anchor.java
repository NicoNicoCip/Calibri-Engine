package io.github.pws.calibri.engine.util;

import io.github.pws.calibri.engine.core.math.vector.Vector2;
import io.github.pws.calibri.engine.graphics.Window;

public class Anchor
{
    public static final Vector2 center = new Vector2(Window.width/2, Window.height/2);

    public static final Vector2 top = new Vector2(Window.width/2, 0);
    public static final Vector2 bottom = new Vector2(Window.width/2, Window.height);
    public static final Vector2 left = new Vector2(0, Window.height/2);
    public static final Vector2 right = new Vector2(Window.width, Window.height/2);

    public static final Vector2 topLeft = new Vector2(0,0);
    public static final Vector2 topRight = new Vector2(Window.width,0);
    public static final Vector2 bottomLeft = new Vector2(0, Window.height);
    public static final Vector2 bottomRight = new Vector2(Window.width, Window.height);
}
