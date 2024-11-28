package io.github.pws.calibri;

import io.github.pws.calibri.engine.core.Manager;
import io.github.pws.calibri.engine.graphics.Window;
import io.github.pws.calibri.workbench.scenes.DisclaimerScene;
import io.github.pws.calibri.workbench.scenes.TestScene;

public class Main
{
    private static final String version = "0.1.8";

    public static void main(String[] args)
    {
        Window.create();

        new DisclaimerScene();
        new TestScene();

        Manager.loop();
    }
}
