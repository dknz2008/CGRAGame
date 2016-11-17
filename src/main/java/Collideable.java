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


    public boolean topSide(Collideable other) {

        double centerX = getX() + getWidth() / 2;
        double centerY = getY() + getHeight() / 2;

        double centerXother = other.getX() + (other.getWidth() / 2);
        double centerYother = other.getY() + (other.getHeight() / 2);

        double w = 0.5 * (getWidth() + other.getWidth());
        double h = 0.5 * (getHeight() + other.getHeight());
        double dx = centerX - centerXother;
        double dy = centerY - centerYother;

        if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
            /* collision! */
            double wy = w * dy;
            double hx = h * dx;

            if (wy > hx) {
                if (wy > -hx) {
                    return false;
                    /* collision at the bottom */
                } else {
                    return false;
                }
                    /* on the left */
            } else {
                return wy <= -hx;
            }

        }
        return false;
    }


    boolean IntersectsWallFromTop() {
        for (Tile t : game.level.tiles) {
            if (topSide(t)) return true;
        }
        return false;
    }

    boolean IntersectsWall() {
        for (Tile t : game.level.tiles) {
            if (RectangleIntersection(t)) return true;
        }
        return false;
    }

}

