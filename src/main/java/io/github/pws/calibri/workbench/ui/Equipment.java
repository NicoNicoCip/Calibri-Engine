/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.calibri.workbench.ui;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.calibri.engine.core.Manager;
import io.github.pws.calibri.engine.core.inventory.Item;
import io.github.pws.calibri.engine.util.Toolbox;
import io.github.pws.calibri.engine.graphics.Sprite;
import io.github.pws.calibri.engine.core.math.vector.Vector2;
import io.github.pws.calibri.engine.graphics.Color;
import io.github.pws.calibri.engine.graphics.UI;
import io.github.pws.calibri.engine.graphics.Window;
import io.github.pws.calibri.resources.assets.sprites.spr_equipment;

public class Equipment extends UI
{
    public static boolean open;
    public static boolean charms = false;
    private static final Sprite spr = new spr_equipment();

    private static Vector2 dir = new Vector2(1,1);
    public static Item[] equippedItems = new Item[7];

    @Override
    public void start() 
    {
        Manager.input.addMapping(NativeKeyEvent.VC_R, "Equipment");
    }

    @Override
    public void update()
    {
        //boolean larm = false, rarm = false, legs = false, chest = false, head = false, weapon = false;
        
        if(Manager.input.isPressed("Equipment"))
        {
            open = !open;
            if(open) addNewFocus("equ");
            else addNewFocus("null");
            
            /*
            if(open && Input.check(Commands.check + " left arm"))
                larm = true;
            else if(open && Input.check(Commands.check + " right arm"))
                rarm = true;
            else if(open && Input.check(Commands.check + " legs"))
                legs = true;    
            else if(open && Input.check(Commands.check + " chest"))
                chest = true;
            else if(open && Input.check(Commands.check + " head"))
                head = true;
            else if(open && Input.check(Commands.check + " weapon"))
                weapon = true;
            else if(open && Input.check(Commands.check + " charms"))
                charms = true;
            else if(open && Input.check(Commands.check))
            {
                Window.print("-Checks------------");
                Window.print("left arm, right arm, chest, legs, head, weapon and charms");
            */
        }

        spr.position.x = 23;
        spr.position.y = 28;
        spr.background = Color.rgbBG(126, 167, 168);

        if(open && prevFocused[0].equals("equ"))
        {
            if(Manager.input.isPressed("Left"))
            {
                dir.x--;
                if(dir.y == 0) dir.y = 1;
            }
            else if (Manager.input.isPressed("Right"))
            {
                dir.x++;
                if(dir.y == 0) dir.y = 1;
            }
            else if(Manager.input.isPressed("Down"))
            {
                dir.y++;

            }
            else if(Manager.input.isPressed("Up"))
            {
                dir.y--;
            }

            dir.x = Toolbox.ClampInt(dir.x, 0,3);
            dir.y = Toolbox.ClampInt(dir.y, 0,3);

            spr.pixels = spr_equipment.buttonPressed;
            spr.foreground = Color.rgbFG(255, 255, 255);
            spr.populate();
            
            spr.position.y = 5;
            spr.pixels = spr_equipment.eqBorder;
            spr.populate();
            
            spr.position.x = 25;
            spr.position.y = 7;
            spr.pixels = spr_equipment.eqSlots;
            spr.foreground = Color.rgbFG(201, 212, 212);
            spr.populate();
            
            char cBor = ' ';
            String borderBG = Color.rgbBG(133, 185, 186);
            String borderFG = Color.rgbFG(255, 255, 255);
            
            String selectBG = Color.rgbBG(133, 185, 186);
            String selectFG = Color.rgbFG(255, 255, 255);

            if(dir.x == 2 && dir.y == 1)
            {
                String area =     
                """
                *%@@@@@@@@@@&/
                *%@@@@@@@@@@&/
                *%@@@@@@@@@@&/
                """;

                selectArea(area, 65, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[0], "left arm");
            }
            else if(dir.x == 0 && dir.y == 1)
            {
                String area =
                """
                .(@@@@@@@@@@@#,
                .(@@@@@@@@@@@#,
                .(@@@@@@@@@@@#,
                """;

                selectArea(area, 27, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[1], "right arm");
            }
            else if(dir.x == 1 && dir.y == 2)
            {
                String area =
                """
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                *%@@@#,   *%@@@#,
                """;

                selectArea(area, 45, 21, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[2], "legs");
            }
            else if(dir.x == 1 && dir.y == 1)
            {
                String area =
                """
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                *%@@@@@@@@@@@@@#,
                """;

                selectArea(area, 45, 12, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[3], "chest");
            }
            else if(dir.y == 0)
            {
                String area =
                """
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                .(@@@@@@@@&/
                """;

                selectArea(area, 47, 7, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[4], "head");
            }
            else if(dir.x == 2 && dir.y == 2)
            {
                String area =
                "           /&%*\n"+
                "           /&%*\n"+
                "        *%@@@%*\n"+
                ".(@#,.(@@@@@@%*\n"+
                ".(@@@@@@@@&/   \n"+
                "   *%@@@#,     \n"+
                ".(@#,.(@@@&/   \n";

                selectArea(area, 67, 18, cBor, borderBG, borderFG, selectBG, selectFG);
                appendCheck(equippedItems[5], "weapon");
            }
            else if(dir.x == 0 && dir.y == 2)
            {
                String area =
                "     *%&/     \n"+
                "  .(@#,.(@#,  \n"+
                "*%@@@#,.(@@@&/\n"+
                "*%&/ *%&/ *%&/\n"+
                "*%&/      *%&/\n"+
                "  .(@#,.(@#,  \n"+
                "     *%&/     \n";

                selectArea(area, 25, 18, cBor, borderBG, borderFG, selectBG, selectFG);
                appendTotem();
            }
        }
        else 
        {
            spr.pixels = spr_equipment.button;
            spr.foreground = Color.rgbFG(0, 0, 0);
            spr.populate();
        }
    }

    @Override
    public void end() 
    {
    }
    
    private static void appendTotem()
    {
        if(equippedItems[6] == null)
        {
            Window.print("There are no currently equiped totems.");
        }
        else
        {
            String area = 
            """
            ######################
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            ######################
            """;
            
            selectArea(area, 51, 8, ' ', 
            Color.rgbBG(133, 185, 186), Color.rgbFG(0, 0, 0), 
            Color.rgbBG(133, 185, 186), Color.rgbFG(255, 255, 255));
            /*
            it will add the item into a list of totems that works like the inventory items when the command is done.
            it will print an inventory right in the middle of the equipment tab and will work just like the inventory,
            except with other commands and wi stay on as long as that command is not "eq. ch. totems" or another ch command
            */
            if(dir.equals(new Vector2(0,2)))
            {
                
            }
        }
    }
    
    private static void appendCheck(Item it, String slot)
    {
        if(it == null)
        {
            //Window.print("There is no currently equiped item on the " + slot);
        }
        else
        {
            //Window.print(it.name + " | " + it.description);
        }
    }
    
    private static void selectArea(String area, int poX, int poY, char cBor, String borderBG, String borderFG, String selectBG, String selectFG)
    {
        String[] lamda = new String[area.split("\n").length + 2];
        String[] temp = area.split("\n");
        
        for(int s = 0; s < lamda.length; s++) 
        {
            if(s == 0 || s == lamda.length-1)
            {
                lamda[s] = String.valueOf(cBor);
                for(@SuppressWarnings("unused") char c : temp[0].toCharArray())
                {
                    lamda[s] += String.valueOf(cBor);
                }
                lamda[s] += cBor +"\n";
            }
            else
            {
                lamda[s] = cBor + temp[s-1] + cBor + "\n";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : lamda) sb.append(s);
        
        spr.background = borderBG;
        spr.foreground = borderFG;
        spr.position.x = poX-1;
        spr.position.y = poY-1;
        spr.pixels = sb.toString();
        spr.populate();
        
        spr.background = selectBG;
        spr.foreground = selectFG;
        spr.position.x = poX;
        spr.position.y = poY;
        spr.pixels = area;
        spr.populate();
    }
}
