package io.github.pws.calibri.workbench.core;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.calibri.engine.core.Manager;
import io.github.pws.calibri.engine.core.scene.Script;

public class DefaultMappings implements Script
{
    @Override
    public void start()
    {
        Manager.input.addMapping(NativeKeyEvent.VC_W, "Move Forward");
        Manager.input.addMapping(NativeKeyEvent.VC_S, "Move Backward");
        Manager.input.addMapping(NativeKeyEvent.VC_A, "Move Left");
        Manager.input.addMapping(NativeKeyEvent.VC_D, "Move Right");
        Manager.input.addMapping(NativeKeyEvent.VC_SHIFT, "Sprint");

        Manager.input.addMapping(NativeKeyEvent.VC_UP, "Up");
        Manager.input.addMapping(NativeKeyEvent.VC_DOWN, "Down");
        Manager.input.addMapping(NativeKeyEvent.VC_LEFT, "Left");
        Manager.input.addMapping(NativeKeyEvent.VC_RIGHT, "Right");

        Manager.input.addMapping(NativeKeyEvent.VC_P, "testP");
    }

    @Override
    public void update()
    {

    }

    @Override
    public void end()
    {

    }
}
