package io.github.pws.calibri.workbench.scenes;

import io.github.pws.calibri.engine.core.scene.SceneManager;
import io.github.pws.calibri.workbench.ui.Disclaimer;

public class DisclaimerScene
{
    private static final Disclaimer disclaimer = new Disclaimer();

    public DisclaimerScene()
    {
        disclaimer.build();
        SceneManager.setCurrentSceneID(1);
    }
}
