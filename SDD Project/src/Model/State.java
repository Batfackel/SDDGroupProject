package Model;

/**
 * used with the weapon state design pattern. This simply allows the fire method
 * to be called in other classes.
 *
 * @author Michael McGregor
 */
public interface State {

    int xLeftOffset = -5;
    int xRightOffset = 35;
    int xCenter = 20;
    int yOffset = 51;

    public void fire(Context bullet, int wls, int x, int y);
}
