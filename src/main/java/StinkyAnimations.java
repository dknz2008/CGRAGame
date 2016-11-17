import net.tangentmc.model.MD2.Animation;
import lombok.Getter;

/**
 * Created by sanjay on 25/08/2016.
 */
@Getter
public enum StinkyAnimations {
    //startframe, framecount, size, speed
    WALKING_SLOW(new Animation(12, 0, 100, 0.1f)),
    WALKING(new Animation(12, 0, 100, 0.3f)),
    WALKING_FAST(new Animation(12, 0, 100, 2f)),
    PUSHING(new Animation(10, 22, 100, 0.2f));

    private final Animation animation;

    StinkyAnimations(Animation animation) {
        this.animation = animation;
    }
}
