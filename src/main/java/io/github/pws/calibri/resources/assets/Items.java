/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.calibri.resources.assets;

import io.github.pws.calibri.engine.core.inventory.Item;
import io.github.pws.calibri.workbench.inventory.items.Apple;
import io.github.pws.calibri.workbench.inventory.items.Jumper;
import io.github.pws.calibri.workbench.inventory.items.Kale;
import io.github.pws.calibri.workbench.inventory.items.Qween;

import java.util.ArrayList;
import java.util.List;

public class Items 
{
    public static List<Item> list = new ArrayList<>()
    {{
        add(new Item("Apple", "Just an apple.", new Item.Stats(1,""),new Apple()));
        add(new Item("Bean", "Just a bean.",  new Item.Stats(10,""),new Apple()));
        add(new Item("Crab", "Crab!",  new Item.Stats(1,""),new Apple()));
        add(new Item("Dust", "An usless pile of dust.",  new Item.Stats(1,"6"),new Apple()));
        add(new Item("Elephant", "Dont step in it, its pretty small.",  new Item.Stats(1,""),new Apple()));
        add(new Item("Fork", "Use it as a weapon.", new Item.Stats(1,"5"),new Apple()));
        add(new Item("Ghost", "Boo!",  new Item.Stats(1,""),new Apple()));
        add(new Item("Horse", "Neigh",  new Item.Stats(1,""),new Apple()));
        add(new Item("Isaac", "Isaac and his mother...",  new Item.Stats(1,"2 3"),new Apple()));
        add(new Item("Jumper", "Soft and flexible. Perfect for high movment tasks.",  new Item.Stats(1,"0 1 2 3"),new Jumper()));
        add(new Item("Kale", "The moost overpowered weapon in the universe.",  new Item.Stats(1,"5"),new Kale()));
        add(new Item("Light", "It exists, and you have it. I dont know why.",  new Item.Stats(99,"4"),new Apple()));
        add(new Item("Mutton", "Either chops or someones weirdly shaped beard.",  new Item.Stats(2,""),new Apple()));
        add(new Item("Note", "Not the death kind.",  new Item.Stats(1,"6"),new Apple()));
        add(new Item("Orange", "Acidic and bitter. Perfect to throw at your enemies.",  new Item.Stats(99,"5"),new Apple()));
        add(new Item("Piano", "Have you ever seen a looney tunes animation?",  new Item.Stats(10,"5"),new Apple()));
        add(new Item("Qween", "The strongest piece in chess. Equip it to get a boost on all your stats.",  new Item.Stats(10,"6"),new Qween()));
        add(new Item("Rabbit", "Its dead. But, it does taste pretty good.",  new Item.Stats(10,""),new Apple()));
        add(new Item("Saber", "Just a sword.",  new Item.Stats(1,"5"),new Apple()));
        add(new Item("Telephone", "No signal...", new Item.Stats(1,""),new Apple()));
        add(new Item("Ubercharge", "The medic has been working hard!",  new Item.Stats(3,""),new Apple()));
        add(new Item("Vat of acid", "Whatever you do, dont jump in it.", new Item.Stats(1,""),new Apple()));
        add(new Item("Word", "word...",  new Item.Stats(99,"5"),new Apple()));
        add(new Item("X coordinate", "Why do you have this? Give me it.", new Item.Stats(1,""),new Apple()));
        add(new Item("Gun", "The fuck is a kilometer. *eagle sounds*", new Item.Stats(1,"5"),new Apple()));
        add(new Item("Sword", "mhm",  new Item.Stats(1,"5"),new Apple()));
        add(new Item("Paper", "Burn it.", new Item.Stats(10,""),new Apple()));
    }};
}
