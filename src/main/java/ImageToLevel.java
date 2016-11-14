import processing.core.PImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by TML_TEST on 7/10/2016.
 */
import java.awt.Color;
import java.util.ArrayList;

public class ImageToLevel {

    ArrayList<Tile> tiles = new ArrayList<Tile>();

    private static final int WALL = new Color(0, 0, 0).getRGB();
    private static final int PICKUP = new Color(255,0,0).getRGB();

    public ImageToLevel(Game game, String fName) {
        PImage image = game.loadImage(fName);
        image.loadPixels();
        for (int y = 0; y < image.height; y++) {
            for(int x  = 0; x  < image.width; x++){
                int colour = image.pixels[y*image.width+x];
                if (colour == WALL) {
                    tiles.add(new Tile(x, y, "wall"));
                }
                if (colour == PICKUP) {
                    tiles.add(new Tile(x, y, "pickup"));
                }
            }
        }
    }

}
