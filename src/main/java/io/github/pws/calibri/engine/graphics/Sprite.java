package io.github.pws.calibri.engine.graphics;

import io.github.pws.calibri.engine.core.math.vector.Vector2;

public class Sprite
{
    public String pixels = "";
    public Vector2 position = new Vector2();
    public String background = Color.rgbBG(0, 0, 0);
    public String foreground = Color.rgbFG(255, 255, 255);

    /**
     * Populates the Window with the sprite.
     */
    public void populate() {
        // Ensure the sprite can be displayed even if partially off-screen
        char[][] population = PopulateWith(pixels);
        if(population.length != 0)
        {
            char[][] ray = prepare(population);
            if (ray.length > 0 && ray[0].length > 0) { // Proceed only if there's something to draw
                Window.populatePixels(ray, position);
                Window.populateBackground(background, position, new Vector2(ray[0].length, ray.length));
                Window.populateForeground(foreground, position, new Vector2(ray[0].length, ray.length));
            }
        }
    }

    /**
     * Clips the sprite to fit within the screen bounds.
     *
     * @param original The original character array of the sprite.
     * @return The clipped character array.
     */
    private char[][] prepare(char[][] original) {
        // Determine the starting and ending bounds for clipping
        int startX = Math.max(0, -position.x-original[0].length);
        int startY = Math.max(0, -position.y-original.length);
        int endX = Math.min(original[0].length, Window.width - position.x);
        int endY = Math.min(original.length, Window.height - position.y);

        // Clip only the visible portion of the sprite
        if (startX >= endX || startY >= endY) {
            return new char[0][0]; // Nothing visible
        }

        char[][] clipped = new char[endY - startY][endX - startX];
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                clipped[y - startY][x - startX] = original[y][x];
            }
        }

        return clipped;
    }

    /**
     * Takes in a string and returns a 2D character array for rendering.
     *
     * @param sprite The string that needs transforming.
     * @return 2D character array of the characters in the string.
     */
    public static char[][] PopulateWith(String sprite) {
        String[] lines = sprite.split("\n");

        char[][] graphicArray = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            graphicArray[i] = lines[i].toCharArray();
        }
        return graphicArray;
    }
}
