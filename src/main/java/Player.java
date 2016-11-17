import net.tangentmc.model.MD2.Animation;
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
    String playerDirection = "right";
    int speed = 1;

    double velocityX = 0;
    double velocityY = 0.0;
    double gravity = 0.5;
    boolean onGround = false;
    int jumpNumber = 0;


    MD2Model model;
    Player(Game game, Importer importer) throws IOException {
        model = importer.importModel(new File("stinky.md2"),game.loadImage("File0165.png"),game);
        model.setAnimation(StinkyAnimations.WALKING.getAnimation(), 2f);
    }

    float getHeight() {
        return 80;
    }
    float getWidth(){
        return 80;
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
            if (velocityY > 15.0)       // If character is still ascending in the jump
                velocityY = 15.0;      // Limit the speed of ascent
        }

        position.y += velocityY;

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            if (IntersectsWallFromTop()) {
                position = oldPos;
                shiftDown();
            } else {
                position = oldPos;
            }
            jumpNumber = 0;
        }

    }

    void OnJumpKeyPressed() {
        velocityY = -15;   // Give a vertical boost to the players velocity to start jump
    }


    void shiftDown() {
        //To make sure player is as close to touching block as possible
        position.y++;
        while (!IntersectsWall()) {
            position.y++;
        }
        position.y--;
    }

    public void move(Game game) {

        //saving the old position of the player
        oldPos = this.position.copy();

        if (game.keys[0]) {
            velocityX += speed;
            playerDirection = "right";
        }
        if (game.keys[1]) {
            velocityX -= speed;
            playerDirection = "left";
        }

        if (Math.abs(velocityX) < 5) {
            model.setAnimation(StinkyAnimations.WALKING_SLOW.getAnimation(), 2f);
        } else if ((Math.abs(velocityX) > 8 && (Math.abs(velocityX) < 15))) {
            model.setAnimation(StinkyAnimations.WALKING.getAnimation(), 2f);
        } else {
            model.setAnimation(StinkyAnimations.WALKING_FAST.getAnimation(), 2f);
        }



        if (game.keys[2]) {
            // velocityY += position.y  + speed;
        }
        if (game.keyPressed && (game.key == 'w' || game.key == 'W')) {
            if (jumpNumber < 1) {
                OnJumpKeyPressed();
            } else if (jumpNumber < 120) {
                velocityY -= 0.5;
            } else {

            }
            jumpNumber++;
        }

        if (velocityX > 20) velocityX = 20;
        if (velocityX < -20) velocityX = -20;

        position.x += velocityX;

        //If it intersects a wall move it back
        if (IntersectsWall()) {
            if (IntersectsWallFromTop()) {
                position = oldPos;
                shiftDown();
            } else {
                position = oldPos;
            }

            velocityX = 0;
            jumpNumber = 0;
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
        if (playerDirection.equals("right")) {
        } else if (playerDirection.equals("left")) {
            game.rotateZ((PApplet.radians(-180)));
        }
        model.drawModel();
        game.popMatrix();

    }

}