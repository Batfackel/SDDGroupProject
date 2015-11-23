package Model;

/**
 * Kinetic weapon for the ships used in the factory pattern. This inherits from
 * Item and is a more specific kind of weapon power up.
 *
 * @author Michael McGregor
 */
public class KineticWeapon extends Item {

    private final int weaponType;

    public KineticWeapon(float x, float y, int ref) {
        super(x, y, ref, 0, 0, 32, 32);
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
        return "Projectile Weapon -Item Pickup.";
    }
}
