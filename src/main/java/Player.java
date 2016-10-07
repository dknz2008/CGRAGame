import net.tangentmc.model.MD2.Importer;
import net.tangentmc.model.MD2.MD2Model;
import processing.core.PVector;

import java.io.File;
import java.io.IOException;

/**
 * Created by TML_TEST on 7/10/2016.
 */
public class Player extends Collideable{
    PVector position = new PVector(100,100);

    MD2Model model;
    Player(Game game, Importer importer) throws IOException {
        model = importer.importModel(new File("stinky.md2"),game.loadImage("File0165.png"),game);
        model.setAnimation(StinkyAnimations.PUSHING.getAnimation(),2f);
    }

    float getHeight() {
        return 100;
    }
    float getWidth(){
        return 100;
    }

    float getX() {
        return position.x;
    }

    float getY() {
        return position.y;
    }

    public void move(Game game) {

        //saving the old position of the player
        PVector oldPos = this.position.copy();


        if(game.keyPressed && game.key == 'w') {
            position.y = position.y - 10;
        }
        if(game.keyPressed && game.key == 'a') {
            position.x = position.x - 10;
        }
        if(game.keyPressed && game.key == 's') {
            position.y = position.y + 10;
        }
        if(game.keyPressed && game.key == 'd') {
            position.x = position.x + 10;
        }

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            position = oldPos;
        }
    }
    public void draw(Game game){
        game.pushMatrix();
        game.translate(position.x,position.y);
        model.drawModel();
        game.popMatrix();

    }

    }



