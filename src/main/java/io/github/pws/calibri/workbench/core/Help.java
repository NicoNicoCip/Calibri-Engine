package io.github.pws.calibri.workbench.core;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.calibri.engine.core.Manager;
import io.github.pws.calibri.engine.graphics.UI;
import io.github.pws.calibri.engine.core.scene.Script;
import io.github.pws.calibri.workbench.ui.Equipment;
import io.github.pws.calibri.workbench.ui.Inventory;
import io.github.pws.calibri.workbench.ui.Options;

public class Help implements Script
{
    @Override
    public void start()
    {
        Manager.input.addMapping(NativeKeyEvent.VC_TAB, "Tab");
    }

    @Override
    public void update()
    {
        String focus = UI.prevFocused[0];
        if(Manager.input.isPressed("Tab"))
        {
            UI.addNewFocus(UI.prevFocused[1]);

            switch (focus)
            {
                case "inv" -> Inventory.open = true;
                case "equ" -> Equipment.open = true;
                case "opt" -> Options.open = true;
                default ->
                {

                }
            }
        }

        if(focus == "null")
        {
            if(Inventory.open) UI.addNewFocus("inv");
            else if(Equipment.open) UI.addNewFocus("equ");
            else if(Options.open) UI.addNewFocus("opt");
        }

//        Window.print
//        (
//            UI.prevFocused[0] + " " + UI.prevFocused[1] + " " + UI.prevFocused[2] + " " + UI.prevFocused[3] + " " +
//            UI.prevFocused[4] + " " + UI.prevFocused[5] + " " + UI.prevFocused[6] + " " + UI.prevFocused[7] + " " +
//            UI.prevFocused[8] + " " + UI.prevFocused[9]
//        );
        /*
        if(Input.check(Commands.help))
        {
            Window.print("-HELP-------------");
            String[] broken = Input.line.split(" ");
            
            if(broken.length == 1)
            {
                Window.print("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.print("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
                return;
            }
            
            if(Commands.inventory.contains(broken[1])) // inventory
            {
                if(broken.length == 2)
                    Window.print("Opens the invenrory");
                else
                {
                    if(broken[3].equals(">>"))
                        Window.print("Goes to the next page in the inventory if it exists.");
                    else if(broken[3].equals("<<"))
                        Window.print("Goes to the previous page in the inventory if it exists.");
                }
            }
            else if(Commands.inv_Next.contains(broken[1])) // >>
            {
                Window.print("Goes to the next page in the inventory if it exists and if the inventory is open");
            }
            else if(Commands.inv_Prev.contains(broken[1])) // <<
            {
                Window.print("Goes to the previous pabge in the inventory if it exists and if the inventory is open.");
            }
            else if(Commands.use.contains(broken[1])) // use
            {
                Window.print( "Uses the item specified. Just write 'use' + the name of the item.");
            }
            else if(Commands.check.contains(broken[1])) // description
            {
                Window.print("Displays the description of the specified item. Just write 'desc' + the name of the item.");
            }
            else if(Commands.commands.contains(broken[1])) // commands
            {
                Window.print("not implemented");
            }
            else
            {
                Window.print("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.print("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
            }
        }
        else if(Input.check(Commands.tab))
        {
            if(Inventory.open == true && Equipment.open == true)
            {
                Inventory.open = false;
                Equipment.open = false;
            } 
            else if(Inventory.open == false && Equipment.open == false)
            {
                Inventory.open = true;
                Equipment.open = true;
            }
            else if(!Inventory.open) 
                Inventory.open = true;
            else if(!Equipment.open)
                Equipment.open = true;
        }
        else if(Input.check(Commands.end))
        {
            Aplication.run = false;
        */
    }

    @Override
    public void end()
    {
        
    }
}
