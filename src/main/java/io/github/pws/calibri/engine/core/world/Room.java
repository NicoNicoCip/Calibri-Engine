package io.github.pws.calibri.engine.core.world;

import io.github.pws.calibri.engine.core.math.vector.Vector2;
import io.github.pws.calibri.engine.graphics.Color;
import io.github.pws.calibri.engine.graphics.Sprite;

import java.util.Arrays;

public class Room
{
    public Sprite spr = new Sprite();
    public Vector2 startingPosition = new Vector2();
    public Vector2 globalPosition = startingPosition;
    public char[][] roomMap;
    private int width = 3;
    private int height = 3;
    private String background = Color.rgbBG(0, 0, 0);
    private String foreground = Color.rgbFG(255, 255, 255);

    /**
     * Set the width of the room.
     * @param width min 3
     */
    public final void setWidth(int width) {
        this.width = Math.max(width, 3);
    }

    /**
     * Set height of the room.
     * @param height min 3
     */
    public final void setHeight(int height) {
        this.height = Math.max(height, 3);
    }

    /**
     * Set the background color of the room.
     * @param color string from the Color class.
     */
    public final void setBackground(String color) {
        this.background = color;
    }

    /**
     * Set the foreground color of the room.
     * @param color string from the Color class.
     */
    public final void setForeground(String color) {
        this.foreground = color;
    }

    /**
     * Creates the room and prints it to the screen (supports negative positions).
     */
    public final void createRoom() {
        StringBuilder sb = new StringBuilder();

        for (int yy = 0; yy < roomMap.length; yy++) {
            for (int xx = 0; xx < roomMap[yy].length; xx++) {
                // Render the character or space
                if (roomMap[yy][xx] == '.' || roomMap[yy][xx] == ':') {
                    sb.append(" ");
                } else {
                    sb.append(roomMap[yy][xx]);
                }
            }

            sb.append("\n");
        }

        // Assign the rendered room to the sprite
        this.spr.pixels = sb.toString();
        this.spr.background = this.background;
        this.spr.foreground = this.foreground;
        this.spr.position = this.globalPosition.add(this.startingPosition);
        this.spr.populate();
    }

    /**
     * Merges two rooms and supports negative positions for the second room.
     * @param other The room to merge with.
     */
    public final void merge(Room other) {
        // Determine bounds of the merged room
        int mergedStartX = Math.min(0, other.startingPosition.x);
        int mergedStartY = Math.min(0, other.startingPosition.y);

        int mergedEndX = Math.max(this.width, other.startingPosition.x + other.width);
        int mergedEndY = Math.max(this.height, other.startingPosition.y + other.height);

        int mergedWidth = mergedEndX - mergedStartX;
        int mergedHeight = mergedEndY - mergedStartY;

        // Create merged room map
        char[][] mergedRoom = new char[mergedHeight][mergedWidth];
        for (char[] row : mergedRoom) {
            Arrays.fill(row, '¬');
        }

        // Copy this room into the merged map
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int targetX = x - mergedStartX;
                int targetY = y - mergedStartY;
                mergedRoom[targetY][targetX] = this.roomMap[y][x];
            }
        }

        // Copy other room into the merged map
        for (int y = 0; y < other.height; y++) {
            for (int x = 0; x < other.width; x++) {
                int targetX = x + other.startingPosition.x - mergedStartX;
                int targetY = y + other.startingPosition.y - mergedStartY;

                if (mergedRoom[targetY][targetX] == '¬') {
                    mergedRoom[targetY][targetX] = other.roomMap[y][x];
                }
            }
        }

        // Smooth the merged room (example logic for adjusting details)
        for (int y = 1; y < mergedHeight - 1; y++) {
            for (int x = 1; x < mergedWidth - 1; x++) {
                int dotCount = 0;
                if (mergedRoom[y - 1][x] == '.') dotCount++;
                if (mergedRoom[y + 1][x] == '.') dotCount++;
                if (mergedRoom[y][x - 1] == '.') dotCount++;
                if (mergedRoom[y][x + 1] == '.') dotCount++;

                if (dotCount >= 2 && mergedRoom[y][x] == '#') {
                    mergedRoom[y][x] = ':';
                }
            }
        }

        this.width = mergedWidth;
        this.height = mergedHeight;
        roomMap = mergedRoom;
    }

    /**
     * Generates the base room map.
     */
    public final void generateRoomMap() {
        roomMap = new char[this.height][this.width];

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (y > 0 && y < this.height - 1 && x > 0 && x < this.width - 1) {
                    roomMap[y][x] = '.';
                } else {
                    roomMap[y][x] = '#';
                }
            }
        }
    }
}
