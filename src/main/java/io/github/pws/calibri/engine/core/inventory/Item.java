package io.github.pws.calibri.engine.core.inventory;


import io.github.pws.calibri.engine.core.scene.Script;

public class Item
{
    public String name;
    public String description;
    public Stats stats;
    public Script runner;
    
    public Item(String name, String description, Stats stats, Script runner)
    {
        this.name = name;
        this.description = description;
        this.stats = stats;
        this.runner = runner;
    }
    
    public static class Stats
    {
        public int count = 1;
        public String equipmentSlots;
        
        public Stats(int count, String equipmentSlots)
        {
            this.count = count;
            this.equipmentSlots = equipmentSlots;
        }
    }
}
