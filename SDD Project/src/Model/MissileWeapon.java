package Model;

/**
 * Missile weapon for the ship used in factory pattern. This inherits from Item
 * and is a more specific kind of weapon power up.
 *
 * @author Michael McGregor
 */
public class MissileWeapon extends Item {

    public final int weaponType;

    public MissileWeapon(float x, float y, int ref) {
        super(x, y, ref, 0, 128, 32, 160);
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
        return "Missile Weapon -Item Pickup.";
    }
}
