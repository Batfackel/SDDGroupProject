/*
 * Part of the factory design pattern that is intended to create weapon power
 * ups when enemy ships are destroyed. 
 */
package Model;

/**
 *
 * @author Michael McGregor
 */
public class WeaponPowerFactory {
        //Default constructor  
  private AbstractItem leItem;   
  
  void AbstractItem() {
     leItem = null; 
  }
  
  public AbstractItem getWeapon(String weaponSelection, float x, float y) {
        if(weaponSelection.equalsIgnoreCase("KINETIC")) {
            leItem = new KineticWeapon(x, y, 0);
            return leItem;
        }
        else if(weaponSelection.equalsIgnoreCase("LASER")) {
            leItem = new LaserWeapon(x, y, 1);
            return leItem;
        }
        else if(weaponSelection.equalsIgnoreCase("MISSILE")) {
            leItem = new MissileWeapon(x, y, 2);
            return leItem;
        }
        if(weaponSelection.equalsIgnoreCase("HEALTH")) {
            leItem = new HealthItem(x, y, 0);
            return leItem;
        }
        else {
            throw new IllegalArgumentException("NO SUCH WEAPON");
        }
    }    
}
