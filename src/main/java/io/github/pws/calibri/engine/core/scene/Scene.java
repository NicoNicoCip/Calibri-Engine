package io.github.pws.calibri.engine.core.scene;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene extends SceneManager
{
    private long sceneID = 0;
    public List<Script> scripts = new ArrayList<>();

    public void addScript(Script script)
    {
        this.scripts.add(script);
    }

    public void create()
    {
        if(getLoadedScene() == null) setLoadedScene(this);
        scenes.add(this);
    }

    public void start()
    {
        for (Script s : this.scripts)
            s.start();
    }

    public void update()
    {
        for (Script s : this.scripts)
            s.update();
    }

    public void end()
    {
        for (Script s : this.scripts)
            s.end();
    }

    public long getSceneID()
    {
        return this.sceneID;
    }

    public void setSceneID(long sceneID)
    {
        this.sceneID = sceneID;
    }
}
