package io.github.pws.calibri.workbench.inventory.items;

import io.github.pws.calibri.engine.core.scene.Script;
import io.github.pws.calibri.engine.graphics.Window;
public class Jumper implements Script
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.print("used Jumper.");
    }

    @Override
    public void end() 
    {
    }
}
