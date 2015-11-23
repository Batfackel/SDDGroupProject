package Model;

/**
 * laser weapon for the ship used in the factory pattern. This inherits from
 * Item and is a more specific kind of weapon power up.
 *
 * @author Michael McGregor
 */
public class LaserWeapon extends Item {

    private final int weaponType;

    public LaserWeapon(float x, float y, int ref) {
        super(x, y, ref, 32, 0, 64, 32);
        this.weaponType = ref;
    }

    @Override
    public void setItem(int item) {
        this.itemType = item;
    }

    @Override
    public int getItemType() {
        return this.weaponType;
    }

    @Override
    protected String getText() {
        return "Laser Weapon -Item Pickup.";
    }
}
