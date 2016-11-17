import net.tangentmc.model.MD2.Animation;
import net.tangentmc.model.MD2.Importer;
import net.tangentmc.model.MD2.MD2Model;
import net.tangentmc.processing.ProcessingRunner;
import processing.core.PApplet;

import java.io.File;
import java.io.IOException;

public class Game extends PApplet {
    public static void main(String[] args) {
        ProcessingRunner.run(new Game());
    }

    private Importer importer;
    Player p;
    //storing all the key presses
    boolean[] keys = new boolean[10];
    ImageToLevel level;

    public void draw() {


        clear();

        //background(255,255,0);
        pushMatrix();

        //translate to middle with slight offset
        translate(width/2, (float)(1.5*(height/2)));
        translate(-p.position.x, -p.position.y);

        p.loop(this);

        for(int i = 0; i < level.tiles.size(); i++) {
            level.tiles.get(i).draw();
        }

        popMatrix();

        //fill(255, 0, 0);
        text(frameRate, 20, 20);

    }
    public void setup() {

        frameRate(60);

        importer = new Importer();
        level = new ImageToLevel(this, "Level1.png");

        noStroke();
        try {
            p = new Player(this,importer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void settings() {
        size(1600, 700, P3D);
    }

    public Importer getImporter() {
        return importer;
    }


    //KEY PRESSES
    public void keyPressed()
    {
        if (key == 'd' || key == 'D')
        {
            keys[0]=true;
            p.playerDirection = "right";
        }

        if (key == 'a' || key == 'A' )
        {
            keys[1]=true;
            p.playerDirection = "left";
        }

        if (key == 's' || key == 'S')
        {
            keys[2]=true;
            p.playerDirection = "down";
        }

        if (key == 'w' || key == 'W')
        {
            keys[3]=true;
            p.playerDirection = "up";
        }

        if (key == 'q')
        {
            keys[4]=true;
        }

        if (key == 'e')
        {
            keys[5]=true;
        }

        if (keyCode == SHIFT) {
            keys[6] = true;
        }

        //Space for boost
        if (key == ' ') {
            keys[7] = true;
        }

    }

    public void keyReleased()
    {
        if (key == 'd' || key == 'D')
        {
            keys[0]=false;
        }

        if (key == 'a' || key == 'A')
        {
            keys[1]=false;
        }

        if (key == 's' || key == 'S')
        {
            keys[2]=false;
        }

        if (key == 'w' || key == 'W')
        {
            keys[3]=false;
        }

        if (key == 'q')
        {
            keys[4]=false;
        }

        if (key == 'e')
        {
            keys[5]=false;
        }

        if (keyCode == SHIFT) {
            keys[6] = false;
        }

        if (key == ' ') {
            keys[7] = false;
        }


    }

}
