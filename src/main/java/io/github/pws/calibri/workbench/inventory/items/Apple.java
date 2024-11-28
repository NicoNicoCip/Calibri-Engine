package io.github.pws.calibri.workbench.inventory.items;

import io.github.pws.calibri.engine.core.scene.Script;
import io.github.pws.calibri.engine.graphics.Window;
public class Apple implements Script
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.print("used Apple.");
    }

    @Override
    public void end() 
    {
    }
}
