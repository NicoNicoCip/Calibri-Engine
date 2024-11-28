package io.github.pws.calibri.engine.core.scene;

import io.github.pws.calibri.engine.graphics.Window;

import java.util.*;

public class SceneManager
{
    private static int currentSceneID;
    private static Scene loadedScene = null;
    public static List<Scene> scenes = new ArrayList<>();

    public static void startScene()
    {
        loadedScene.start();
    }

    public static void updateScene()
    {
        loadedScene.update();
    }

    public static void endScene()
    {
        loadedScene.end();
    }

    public static long getCurrentSceneID()
    {
        return currentSceneID;
    }

    public static void setCurrentSceneID(int sceneID)
    {
        currentSceneID = sceneID;
    }

    public static void killProcessOnNoLoadedScene()
    {
        if(loadedScene == null)
        {
            System.err.println("Error!     No scene loaded.");
            Window.kill();
        }
    }

    public static boolean switchSceneOnCurrentChange()
    {
        if(loadedScene.getSceneID() != currentSceneID)
        {
            loadedScene = scenes.get(currentSceneID);
            return true;
        }
        return false;
    }

    public static void setLoadedScene(Scene loadedScene) {
        SceneManager.loadedScene = loadedScene;
    }

    public static Scene getLoadedScene() {
        return loadedScene;
    }
}
