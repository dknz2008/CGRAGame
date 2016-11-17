import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import net.tangentmc.model.MD2.Importer;
import net.tangentmc.model.MD2.MD2Model;
import net.tangentmc.processing.ProcessingRunner;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by TML_TEST on 7/10/2016.
 */
public class Tile extends Collideable{

    String type;
    float x;
    float y;

    float width;
    float height;


    MD2Model model;
    static Game game = ((Game) ProcessingRunner.instance);
    static Importer importer = game.getImporter();


    public Tile(float x, float y, String type) {

        try {
            model = importer.importModel(new File("block.md2"), game.loadImage("block.png"), game);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
        this.type = type;
        this.width = 100;
        this.height = 100;
    }

    float getHeight() {
        return this.height;
    }

    float getWidth() {
        return this.width;
    }

    float getX(){
        return this.x * width;
    }

    float getY(){
        return this.y * height;
    }

    public void draw() {
        game.pushMatrix();
        game.translate(x*width, y*height);

        //if wall is close enough to player draw it
        //&& (game.p.position.dist(new PVector(this.x, this.y)) < 1000)
        PApplet.print((game.p.position.dist(new PVector(this.x, this.y))) + "\n");
        if (type.equals("wall")) {
            //game.box(width, width, width);
            model.drawModel();
        }
        game.popMatrix();
    }

}

