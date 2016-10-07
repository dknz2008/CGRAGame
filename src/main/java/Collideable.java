import net.tangentmc.processing.ProcessingRunner;

import java.awt.geom.Rectangle2D;

/**
 * Created by TML_TEST on 7/10/2016.
 */
abstract class Collideable {
    abstract float getWidth();
    abstract float getHeight();
    abstract float getX();
    abstract float getY();

    public static Game game = ((Game) ProcessingRunner.instance);

    Rectangle2D getBounds() {
        return new Rectangle2D.Float(getX(), getY(), getWidth(), getHeight());
    }
    boolean RectangleIntersection(Collideable other) {
        return (getBounds().intersects(other.getBounds()));
    }

    boolean IntersectsWall() {
        for (Tile t : game.level.tiles) {
            if (RectangleIntersection(t)) return true;
        }
        return false;
    }

}
