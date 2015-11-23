package Model;

/**
 * used with the state design pattern. This is used to change the state of the
 * bullet that is to be shot. It operates almost as an independent system of the
 * ships. Values stored in the ships are passed to the bullet through this
 * context.
 *
 * @author Michael McGregor
 */
public class Context {

    private State bullet;
    private int weaponLevelState;

    public Context() {
        bullet = null;
        weaponLevelState = -1;
    }

    public void setState(State bullet, int wls) {
        this.weaponLevelState = wls;
        this.bullet = bullet;
    }

    public State getState() {
        return bullet;
    }

    public int getWeaponLevel() {
        return weaponLevelState;
    }

    public void fire(int x, int y) {
        this.bullet.fire(this, weaponLevelState, x, y);
    }
}
