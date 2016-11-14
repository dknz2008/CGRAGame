import net.tangentmc.model.MD2.Importer;
import net.tangentmc.model.MD2.MD2Model;
import processing.core.PVector;

import java.io.File;
import java.io.IOException;

/**
 * Created by TML_TEST on 7/10/2016.
 */
public class Player extends Collideable{

    PVector position = new PVector(500,1500);
    String playerDirection = "up";
    int speed = 10;

    MD2Model model;
    Player(Game game, Importer importer) throws IOException {
        model = importer.importModel(new File("stinky.md2"),game.loadImage("File0165.png"),game);
        model.setAnimation(StinkyAnimations.PUSHING.getAnimation(),2f);
    }

    float getHeight() {
        return 80;
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


        if (game.k.keys[0]==true) position.x = position.x + speed;
        if (game.k.keys[1]==true) position.x = position.x - speed;
        if (game.k.keys[2]==true) position.y = position.y  + speed;
        if (game.k.keys[3]==true) position.y  = position.y  - speed;

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            position = oldPos;
        }
    }
    public void draw(Game game){
        game.pushMatrix();
        game.translate(position.x,position.y);
        game.rotateX(game.radians(90));
        model.drawModel();
        game.popMatrix();

    }

    }



