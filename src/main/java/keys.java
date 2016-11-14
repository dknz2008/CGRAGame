import net.tangentmc.processing.ProcessingRunner;

/**
 * Created by Dylan on 14/11/2016.
 */
public class keys {

    public static Game game = ((Game) ProcessingRunner.instance);

    //storing all the key presses
    boolean[] keys = new boolean[10];

    void keyPressed()
    {
        if (game.key == 'd' || game.key == 'D')
        {
            keys[0]=true;
            game.p.playerDirection = "right";
        }

        if (game.key == 'a' || game.key == 'A' )
        {
            keys[1]=true;
            game.p.playerDirection = "left";
        }

        if (game.key == 's' || game.key == 'S')
        {
            keys[2]=true;
            game.p.playerDirection = "down";
        }

        if (game.key == 'w' || game.key == 'W')
        {
            keys[3]=true;
            game.p.playerDirection = "up";
        }

        if (game.key == 'q')
        {
            keys[4]=true;
        }

        if (game.key == 'e')
        {
            keys[5]=true;
        }

        if (game.keyCode == game.SHIFT) {
            keys[6] = true;
        }

        //Space for boost
        if (game.key == ' ') {
            keys[7] = true;
        }

    }

    void keyReleased()
    {
        if (game.key == 'd' || game.key == 'D')
        {
            keys[0]=false;
        }

        if (game.key == 'a' || game.key == 'A')
        {
            keys[1]=false;
        }

        if (game.key == 's' || game.key == 'S')
        {
            keys[2]=false;
        }

        if (game.key == 'w' || game.key == 'W')
        {
            keys[3]=false;
        }

        if (game.key == 'q')
        {
            keys[4]=false;
        }

        if (game.key == 'e')
        {
            keys[5]=false;
        }

        if (game.keyCode == game.SHIFT) {
            keys[6] = false;
        }

        if (game.key == ' ') {
            keys[7] = false;
        }
    }
}
