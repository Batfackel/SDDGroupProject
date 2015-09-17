/*
 * This interface represent the weapon level of the ship. The getters and setters
 * that go along with it are in the launcher class. 9/10/2015
 */
package Model;

/**
 *
 * @author Michael McGregor
 */
public interface ShipState extends Ship{
    static final int BASE_LEVEL = 0;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;    
    static final int LEVEL_3 = 3;
    public void setLevelState(int i);
    public int getLevelState();
}
