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
    keys k;
    ImageToLevel level;

    public void draw() {


        print(level.tiles.size());

        clear();
        pushMatrix();




        translate(width/2, (float)(1.5*(height/2)));
        translate(-p.position.x, -p.position.y);



        p.move(this);
        p.draw(this);


        for(int i = 0; i < level.tiles.size(); i++) {
            level.tiles.get(i).draw();
        }

        popMatrix();
    }
    public void setup() {

        level = new ImageToLevel(this, "Level1.png");

        noStroke();
        try {
            importer=new Importer();
            p = new Player(this,importer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void settings() {
        size(600,600,P3D);
    }

}

