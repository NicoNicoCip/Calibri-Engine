package io.github.pws.calibri.workbench.ui;

import io.github.pws.calibri.engine.graphics.Sprite;
import io.github.pws.calibri.engine.core.math.vector.Vector2;
import io.github.pws.calibri.engine.graphics.Color;
import io.github.pws.calibri.engine.graphics.Window;

public class Disclaimer
{   
    private String disclaimer = 
    """
    ########################################################################################################################
    # Resize the terminal if this window appears broken.                                                                   #
    #                                                                                                                      #
    #                                                !! DISCLAIMER !!                                                      #
    #                                                                                                                      #
    # For the best experience you should use the Windows Terminal.                                                         #
    # If you don't have it already go to the microsoft store and download it, then, after opening the cmd (type cmd in the #
    # windows search bar, or press WIN + S then cmd) right click the bar at the top of the window and select defaults.     #
    # Then go to Terminal > Default Terminal Application > Windows Terminal then restart the game. If you are done you can #
    # "experience" Unkillable Mini in all its 200 frames of glory.                                                         #
    #                                                                                                                      #
    # Once you have done so, right click the bar at the top again and open the terminal settings.                          #
    # There you can customize anything you want about how the terminal displays. Note that besides the default font none   #
    # are tested and may result in graphical glitches and misaligned elements. One thin i do recommend you do right away   #
    # is to go to Startup, scroll down to startup size and set the rows to at least 38. and columns to 120.                #
    # There is no way to resize the terminal that i know of that i can set trough code.                                    #
    #                                                                                                                      #
    # Otherwise enjoy the MVP for a future game called Unkillable.                                                         #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                        >>  Press any key to continue  <<                                             #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    #                                                                                                                      #
    # Resize the terminal if this window appears broken.                                                                   #
    ########################################################################################################################
    """;
    
    public void build()
    {
        char[][] disclaimerStringses = Sprite.PopulateWith(disclaimer);
        Window.populatePixels(disclaimerStringses,new Vector2());
        Window.populateForeground(Color.rgbFG(255, 255, 255), new Vector2(), new Vector2(120,32));
        Window.populateBackground(Color.rgbBG(88, 194, 88), new Vector2(),  new Vector2(120,32));
        Window.draw();
        Window.pause();
        Window.clear();
        Window.create();
    }
}
