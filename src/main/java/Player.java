import net.tangentmc.model.MD2.Importer;
import net.tangentmc.model.MD2.MD2Model;
import processing.core.PApplet;
import processing.core.PVector;

import java.io.File;
import java.io.IOException;

/**
 * Created by TML_TEST on 7/10/2016.
 */
public class Player extends Collideable{

    PVector oldPos;
    PVector position = new PVector(500,1500);
    String playerDirection = "up";
    int speed = 1;

    double velocityX = 0;
    double velocityY = 0.0;
    double gravity = 0.5;
    boolean onGround = false;


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


    void update() {
        //saving the old position of the player
        oldPos = this.position.copy();

        //if doesn't intersect wall turn on gravity
        if (!IntersectsWall()) {
            velocityY += gravity;
            if (velocityY < -6.0f)       // If character is still ascending in the jump
                velocityY = -6.0f;      // Limit the speed of ascent

        }

        position.y += velocityY;

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            position = oldPos;
        }

    }

    void OnJumpKeyPressed() {
        velocityY = -12.0f;   // Give a vertical boost to the players velocity to start jump
    }


    public void move(Game game) {

        //saving the old position of the player
        oldPos = this.position.copy();

        if (game.keys[0]) {
            velocityX += speed;
        }
        if (game.keys[1]) {
            velocityX -= speed;
        }

        if (game.keys[2]) {
            // velocityY += position.y  + speed;
        }
        if (game.keys[3]) {
            OnJumpKeyPressed();
        }

        if (velocityX > 10) velocityX = 10;
        if (velocityX < -10) velocityX = -10;

        position.x += velocityX;

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            position = oldPos;
            velocityX = 0;
        }
    }

    public void loop(Game game) {
        update();
        move(game);
        draw(game);
    }

    public void draw(Game game){
        game.pushMatrix();
        game.translate(position.x,position.y);
        game.rotateX(PApplet.radians(90));
        model.drawModel();
        game.popMatrix();

    }

}