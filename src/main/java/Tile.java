import java.lang.reflect.Array;
import java.util.ArrayList;

import net.tangentmc.processing.ProcessingRunner;
import processing.core.PApplet;

/**
 * Created by TML_TEST on 7/10/2016.
 */
public class Tile extends Collideable{

    String type;
    float x;
    float y;

    float width;
    float height;

    public Tile(float x, float y, String type) {
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

        if(type.equals("wall")) {
            game.box(width, width, width);
        }
        game.popMatrix();
    }

}

