package io.github.pws.calibri.workbench.scenes;

import io.github.pws.calibri.engine.core.scene.Script;
import io.github.pws.calibri.engine.core.scene.Scene;
import io.github.pws.calibri.engine.util.Anchor;
import io.github.pws.calibri.engine.core.math.matrix.Matrix2b;
import io.github.pws.calibri.engine.core.math.vector.Vector2;
import io.github.pws.calibri.engine.core.math.vector.Vector2f;
import io.github.pws.calibri.engine.core.world.Construction;
import io.github.pws.calibri.engine.core.world.Room;
import io.github.pws.calibri.engine.graphics.Sprite;
import io.github.pws.calibri.engine.graphics.Color;
import io.github.pws.calibri.engine.graphics.Window;
import io.github.pws.calibri.engine.core.entities.Player;
import io.github.pws.calibri.workbench.core.DefaultMappings;
import io.github.pws.calibri.workbench.ui.Equipment;
import io.github.pws.calibri.workbench.core.Help;
import io.github.pws.calibri.workbench.ui.Inventory;
import io.github.pws.calibri.workbench.ui.Options;

import java.util.ArrayList;
import java.util.List;

public class TestScene extends Scene
{
    public List<Room> rooms = new ArrayList<>();
    public List<Player> myPlayers = new ArrayList<>();
    public Vector2 globalPosition = Anchor.center;

    public TestScene()
    {
        this.setSceneID(1);
        this.create();

        this.addScript(func);
        this.addScript(new DefaultMappings());
        this.addScript(new Inventory());
        this.addScript(new Equipment());
        this.addScript(new Options());
        this.addScript(new Help());
    }

    Script func = new Script()
    {
        @Override
        public void start()
        {
            Player p1 = new Player() {
                @Override
                public void create() {
                    this.spr = new Sprite();
                    this.globalPosition = new Vector2f();
                    this.moveSpeed = 10f;
                    this.motionMatrix = new Matrix2b();

                    this.spr.pixels = "M";
                    this.spr.foreground = Color.rgbFG(57, 219, 33);
                    this.spr.background = "";
                }
            };

            myPlayers.add(p1);

            Construction construct1 = new Construction() {
                @Override
                public void build() {
                    Room room1 = new Room();
                    Room room2 = new Room();

                    rooms.add(room1);
                    rooms.add(room2);

                    // Create the first room
                    room1.setWidth(40);
                    room1.setHeight(10);
                    room1.generateRoomMap();
                    room1.startingPosition = new Vector2(40, 9);
                    room1.setBackground(Color.rgbBG(90, 156, 152));

                    // Create the second room
                    room2.setWidth(30);
                    room2.setHeight(10);
                    room2.generateRoomMap();
                    room2.startingPosition = new Vector2(20,7);

                    // Merge room2 into room1
                    room1.merge(room2);
                }
            };

            rooms.add(construct1.rooms.getFirst());

            Construction construct2 = new Construction() {
                @Override
                public void build() {
                    Room room1 = new Room();
                    Room room2 = new Room();

                    rooms.add(room1);
                    rooms.add(room2);

                    // Create the first room
                    room1.setWidth(10);
                    room1.setHeight(10);
                    room1.generateRoomMap();
                    room1.startingPosition = new Vector2(5, 5);
                    room1.setBackground(Color.rgbBG(90, 156, 152));

                    // Create the second room
                    room2.setWidth(10);
                    room2.setHeight(10);
                    room2.generateRoomMap();
                    room2.startingPosition = new Vector2(3,3);

                    // Merge room2 into room1
                    room1.merge(room2);
                }
            };

            rooms.add(construct2.rooms.getFirst());
        }

        @Override
        public void update()
        {
            if(myPlayers.toArray().length == 0)
            {
                Window.print("Player not provided for the playable area.");
                return;
            }

            for (int i = 0; i < myPlayers.toArray().length; i++)
            {
                Player player = myPlayers.get(i);
                if(i == 0)
                {
                    player.spr.position = Anchor.center;

                    for(Room r : rooms) {
                        globalPosition = new Vector2(Math.round(player.globalPosition.x), Math.round(player.globalPosition.y));
                        r.globalPosition = globalPosition;
                        r.createRoom();
                    }
                }
                else
                {
                    player.spr.position = globalPosition.add(player.globalPosition.toVector2().negate());
                }

                if(i == 0) player.handleInput();

                player.spr.populate();
                myPlayers.set(i,player);
            }
        }

        @Override
        public void end()
        {

        }
    };
}
