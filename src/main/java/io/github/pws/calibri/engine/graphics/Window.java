package io.github.pws.calibri.engine.graphics;

import io.github.pws.calibri.engine.core.math.vector.Vector2;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class Window {
    public static final int width = 120;
    public static final int height = 32;
    public static final String apkName = "Unkillable Mini";

    public static final char[][] pixels = new char[height][width];
    public static final String[][] foregroundColors = new String[height][width];
    public static final String[][] backgroundColors = new String[height][width];

    public static final String defaultBackground = Color.rgbBG(15, 0, 3);
    public static final String defaultForeground = Color.rgbFG(255, 255, 255);

    private static final char EMPTY_PIXEL = ' ';
    private static Terminal terminal;

    private static Vector2 terminalSize = new Vector2();
    private static String footer = "";

    /**
     * Initializes the terminal and window buffers.
     */
    public static void create()
    {
        try {
            terminal = TerminalBuilder.builder().system(true).build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize terminal", e);
        }

        setWindowTitle(apkName);
        clearBuffers();
    }

    /**
     * Clears all buffers and resets pixel data.
     */
    private static void clearBuffers()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                pixels[y][x] = EMPTY_PIXEL;
                foregroundColors[y][x] = defaultForeground;
                backgroundColors[y][x] = defaultBackground;
            }
        }
    }

    /**
     * Draws the screen by flushing all buffers to the terminal.
     */
    public static void draw()
    {
        fixConsoleOnResize();
        terminal.writer().write("\033[?7l");

        StringBuilder output = new StringBuilder("\033[0;0H"); // Move cursor to top-left
        String[] footerLines = footer.split("<br>");
        for (int y = 0; y < height + footerLines.length; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (y < height)
                {
                    output.append(foregroundColors[y][x])
                            .append(backgroundColors[y][x])
                            .append(pixels[y][x]);
                }
                else
                {
                    output.append(defaultForeground)
                            .append(defaultBackground)
                            .append(x < footerLines[y-height].length() ? footerLines[y-height].charAt(x) : EMPTY_PIXEL);
                }
            }
            output.append("\033[0m\n"); // Reset color and newline
        }

        footer = ""; // Reset footer
        terminal.writer().write(output.toString());
        terminal.writer().flush();
    }

    /**
     * Removes all the '_' characters from the screen.
     * usefull for anything that needs generating that has empty space in the sprite.
     */
    public static void removeScaffolding()
    {
        for (int yy = 0; yy < Window.height; yy++)
        {
            for (int xx = 0; xx < Window.width; xx++)
            {
                if (Window.pixels[yy][xx] == '¬')
                {
                    Window.pixels[yy][xx] = ' ';
                    Window.backgroundColors[yy][xx] = defaultBackground;
                    Window.foregroundColors[yy][xx] = defaultForeground;
                }
            }
        }
    }

    /**
     * Clears the terminal screen using ANSI escape codes.
     */
    private static void clearScreen()
    {
        System.out.print("\033[2J\033[H"); // Clear screen and move cursor to top-left
    }

    /**
     * Populates a section of the pixel buffer with the provided data.
     *
     * @param source 2D array of characters to populate
     * @param pos    Starting position in the buffer
     */
    public static void populatePixels(char[][] source, Vector2 pos)
    {
        for (int y = 0; y < source.length; y++)
        {
            for (int x = 0; x < source[y].length; x++)
            {
                int targetX = pos.x + x;
                int targetY = pos.y + y;
                if (isWithinBounds(targetX, targetY))
                {
                    pixels[targetY][targetX] = source[y][x];
                }
            }
        }
    }

    /**
     * Populates the foreground color buffer.
     *
     * @param color Color to apply
     * @param pos   Starting position
     * @param size  Size of the region
     */
    public static void populateForeground(String color, Vector2 pos, Vector2 size)
    {
        for (int y = 0; y < size.y; y++)
        {
            for (int x = 0; x < size.x; x++)
            {
                int targetX = pos.x + x;
                int targetY = pos.y + y;
                if (isWithinBounds(targetX, targetY))
                {
                    foregroundColors[targetY][targetX] = color;
                }
            }
        }
    }

    /**
     * Populates the background color buffer.
     *
     * @param color Color to apply
     * @param pos   Starting position
     * @param size  Size of the region
     */
    public static void populateBackground(String color, Vector2 pos, Vector2 size)
    {
        for (int y = 0; y < size.y; y++)
        {
            for (int x = 0; x < size.x; x++)
            {
                int targetX = pos.x + x;
                int targetY = pos.y + y;
                if (isWithinBounds(targetX, targetY))
                {
                    backgroundColors[targetY][targetX] = color;
                }
            }
        }
    }

    /**
     * Checks if the given position is within the buffer bounds.
     */
    private static boolean isWithinBounds(int x, int y)
    {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Sets a footer message to be displayed below the main window.
     */
    public static void print(String message)
    {
        footer += message + "<br>";
    }

    /**
     * Sets the terminal title.
     */
    public static void setWindowTitle(String title)
    {
        System.out.print("\033]0;" + title + "\007");
    }

    /**
     * Hides the terminal cursor.
     */
    public static void hideCursor()
    {
        System.out.print("\033[?25l");
    }

    /**
     * Shows the terminal cursor.
     */
    public static void showCursor()
    {
        System.out.print("\033[?25h");
    }

    /**
     * Pauses terminal execution until a key is pressed.
     */
    public static void pause()
    {
        try { new ProcessBuilder("cmd", "/c", "PAUSE").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}
    }

    /**
     * Completely clears the terminal from its characters.
     */
    public static void clear()
    {
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}
    }

    /**
     * Completely kills all program execution.
     */
    public static void kill()
    {
        try { new ProcessBuilder("cmd", "/c", "exit").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ignored) {}
    }


    /**
     * Shows the terminal cursor.
     */
    public static void fixConsoleOnResize()
    {
        if(terminalSize.x != terminal.getWidth() || terminalSize.y != terminal.getHeight())
        {
            clear();
        }
        terminalSize = new Vector2(terminal.getWidth(), terminal.getHeight());
    }
}
