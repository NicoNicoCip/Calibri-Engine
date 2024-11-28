package io.github.pws.calibri.workbench.ui;

import io.github.pws.calibri.engine.graphics.Color;
import io.github.pws.calibri.engine.graphics.Window;

public class Border
{

    public void createBorder()
    {
        for (int yy = 0; yy < Window.height; yy++)
        {
            for (int xx = 0; xx < Window.width; xx++)
            {
                if(!(yy > 0 && yy < Window.height-1 && xx > 0 && xx < Window.width -1))
                {
                    Window.pixels[yy][xx] = '#';
                    Window.backgroundColors[yy][xx] = Color.rgbBG(126, 167, 168);
                    Window.foregroundColors[yy][xx] = Color.rgbFG(184, 214, 214);
                }
            }
        }
    }

    public void createBackgorund()
    {
        for (int yy = 0; yy < Window.height; yy++)
        {
            for (int xx = 0; xx < Window.width; xx++)
            {
                if(yy > 0 && yy < Window.height-1 && xx > 0 && xx < Window.width -1)
                {
                    Window.pixels[yy][xx] = ' ';
                    Window.backgroundColors[yy][xx] = Window.defaultBackground;
                    Window.foregroundColors[yy][xx] = Window.defaultForeground;
                }
            }
        }
    }
}

