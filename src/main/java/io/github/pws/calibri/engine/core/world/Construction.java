package io.github.pws.calibri.engine.core.world;

import java.util.ArrayList;
import java.util.List;

public abstract class Construction
{
    public List<Room> rooms = new ArrayList<>();
    //doors
    //tile entities
    //construction collision manager.

    public abstract void build();
}
