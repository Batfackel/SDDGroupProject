package Model;
import Controller.Main;
import Controller.EnemyFlyWeightFactory;
import Controller.EnemyFlyweight;
import View.MainMenu;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameData {

// USE Strategy pattern    
    static final int STATE_EXPLOSIOIN_1 = 1;
    static final int STATE_EXPLOSIOIN_2 = 2;
    static final int STATE_EXPLOSIOIN_3 = 3;
    static final int STATE_EXPLOSIOIN_4 = 4;
    static final int STATE_EXPLOSIOIN_5 = 5;
    static final int STATE_EXPLOSIOIN_6 = 6;
    static final int STATE_EXPLOSIOIN_7 = 7;
    static final int STATE_EXPLOSIOIN_8 = 8;
    static final int STATE_EXPLOSIOIN_9 = 9;
    static final int STATE_EXPLOSIOIN_10 = 10;
    static final int STATE_EXPLOSIOIN_11 = 11;
    static final int STATE_EXPLOSIOIN_12 = 12;
    static final int STATE_EXPLOSIOIN_13 = 13;
    static final int STATE_EXPLOSIOIN_14 = 14;
    static final int STATE_EXPLOSIOIN_15 = 15;
    static final int STATE_EXPLOSIOIN_16 = 16;
    private final String[] shipTypes = {"defaultship", "shipx", "shipy", "shipz", "shipv", "shipw"};
    private final static int RESOLUTION_800X1000 = 1;
    public String shipName = "error";
    
    public List<GameFigure> figures;
    public List<Item> items;
    public List<Ship> ships, enemyShips;
    public List<Background> menu;
    public List<Bullet> friendlyBullets;
    public List<Bullet> enemyBullets;
    
    private final ShipFactory shipMaker = new ShipFactory();
    private EnemyFactory enemyMaker = new EnemyFactory();
    private WeaponPowerFactory weaponMaker = new WeaponPowerFactory();
    private Ship incomingShip;
    private int BASE_LEVEL = -1, counter = 0, spawnTicker, difficulty = 500;
    private EnemyFlyWeightFactory flyweightFactory;
    public static EnemyFlyweight flyweightItems;
    private ShipSelectMenu shipSelectionMenu;  
    private Random rand;  
    public boolean shockOn;
    public static Context enemyBulletsContext;
    public static KineticState kinetic;
    
    public GameData(String sName) {
        
        this.shipName = sName;
        this.shockOn = false;
        menu = Collections.synchronizedList(new ArrayList<Background>());
        figures = Collections.synchronizedList(new ArrayList<GameFigure>());
        ships = Collections.synchronizedList(new ArrayList<Ship>());
        items = Collections.synchronizedList(new ArrayList<Item>());
        enemyShips = Collections.synchronizedList(new ArrayList<Ship>());
        flyweightFactory = new EnemyFlyWeightFactory();
        flyweightItems = flyweightFactory.getFlyweight();
        friendlyBullets = Collections.synchronizedList(new ArrayList<Bullet>());
        enemyBullets = Collections.synchronizedList(new ArrayList<Bullet>());
                     
        menu.add((Background) new ShipSelectMenu(0));        
        ships.add((Ship)shipMaker.getShip(shipName,450,450));        
        
        //represent weapon power-up items        
        // testing items and new item mechanics
        items.add((Item) weaponMaker.getWeapon("KINETIC", 250, 200));
        items.add((Item) weaponMaker.getWeapon("KINETIC", 250, 180));
        items.add((Item) weaponMaker.getWeapon("KINETIC", 250, 1600));
        items.add((Item) weaponMaker.getWeapon("KINETIC", 250, 220));
        items.add((Item) weaponMaker.getWeapon("KINETIC", 250, 240));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("LASER", 400, 200));
        items.add((Item) weaponMaker.getWeapon("MISSILE", 100, 200));

        //enemyShips.add((Ship)enemyMaker.getEnemyShip("defaultship", 200, 200));        
        //figures.add((GameFigure) enemyMaker.getEnemyShip("defaultship", 20, 20));
        Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 100, -300);
        for (int i = 0; i < enemyFormation.length; i++) {
            enemyShips.add(enemyFormation[i]);
        }
        enemyBulletsContext = new Context();
        kinetic = new KineticState();
//-----------------------------------------------------------------------------
//----------------------------------------------------------------------
    
        rand = new Random();
        spawnTicker = rand.nextInt(100);        
    }
    

    private float randomize(float in, int offset) {
        float min = in, max = in + offset;        
        float number = rand.nextFloat() * (max - min) + min;

        return number;
    }

    public void update() {
        mainGame();
    }

    public void spawnEnemiesForTest() {
        Ship[] enemyFormation = enemyMaker.getEnemyShipFormation("defaultship", 100, -300);
        for (int i = 0; i < enemyFormation.length; i++) {
            synchronized (enemyShips) {
                enemyShips.add(enemyFormation[i]);
            }
        }
    }    

    void mainGame() {        
        Ship currentShip = (Ship) this.ships.get(0);
        //starts the lightning attack automatically
        if (currentShip.getWeaponState() == 1 && currentShip.getLevelState() > 1 && this.shockOn == false) {
            this.shockOn = true;
            Main.gameData.friendlyBullets.add(new LightningShot(currentShip.getX() - 60, currentShip.getY() - 60, false));
        }
                  
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
// collisions for stuff in the game        
        try {
            //----collision: objectes in figures and player ship-----
            //---------------probably not currently used-----------
            for (int i = 0; i < this.figures.size(); i++) {                
                Rectangle hit = currentShip.getShipHitBox();                
                if (this.figures.get(i) instanceof Ship) {
                    Ship asdf = (Ship) this.figures.get(i);
                    if (hit.intersects(asdf.getShipHitBox())) {
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));
                        items.add((Item) weaponMaker.getWeapon("KINETIC", randomize(asdf.getXofMissileShoot(), 100), randomize(asdf.getYofMissileShoot(), 100)));                        
                        currentShip.setState(4);
                        //   Main.controller = new KeyController(currentShip);
                        System.out.println("Ship state is " + currentShip.getState());                    
                        //ship.setShipState(STATE_DONE);
                        synchronized (figures) {
                            this.figures.remove(asdf);
                        }
                        //currentShip.setLevelState(currentShip.getLevelState());
                    }
                }
            }        
            //----collision: objectes in figures and player ship-----
            //----collision: items vs friendly ships-----        
            for (int i = 0; i < this.items.size(); i++) {
                //Rectangle[] hit = currentShip.getShipHitBox();
                Rectangle hit = currentShip.getShipHitBox();                
                Item item = (Item) this.items.get(i);

                if (hit.intersects(item.getRectangle1())) {                    
                    if (item.getItemType() == currentShip.getWeaponState()) {
                        currentShip.setLevelState(currentShip.getLevelState());
                    } else if (item.getItemType() >= 0 && item.getItemType() <= 2) {
                        currentShip.setWeaponState(item.getItemType());
                        currentShip.setLevelState(BASE_LEVEL);
                    }
                    synchronized (items) {
                        this.items.remove(item);
                    }
                }
            }
            //----collision: items vs friendly ships-----        
            //----collision: enemies vs friendly bullets-----        
            for (int i = 0; i < this.friendlyBullets.size(); i++) {
                Bullet shot = (Bullet) friendlyBullets.get(i);
                for (int j = 0; j < this.enemyShips.size(); j++) {
                    EnemyShip eShip = (EnemyShip) enemyShips.get(j);
                    if (shot.name != "Lightning Shot") {                        
                        if (shot.getHitBox().intersects(eShip.getShipHitBox())) {
                            eShip.getHit();
                            synchronized (friendlyBullets) {
                                this.friendlyBullets.remove(shot);
                            }
                            break;
                        }
                        if (shot.getY() < -15) {
                        System.out.println("bullet = " + shot.getY());
                        synchronized (friendlyBullets) {
                            this.friendlyBullets.remove(shot);
                        }
                        break;
                    } 
                    }
                    else if (shot.name == "Lightning Shot") {
                        if (shot.getHitCircle().intersects(eShip.getShipHitBox())) {
                            this.shockOn = false;
                            Rectangle we = eShip.getShipHitBox();
                            Ellipse2D qw = shot.getHitCircle();
                            eShip.getHit();                               
                            synchronized (friendlyBullets) {
                            //    this.bullets.remove(shot);
                            }
                            break;
                        }                        
                    }                     
                }
            }               
            //----collision: enemies vs friendly bullets-----
            //----collision: enemies vs friendly ship-----
            for (int i = 0; i < this.enemyShips.size(); i++) {
                EnemyShip eShip = (EnemyShip) enemyShips.get(i);
                               
                if (currentShip.getShipHitBox().intersects(eShip.getShipHitBox())) {

                    eShip.getHit();
                    currentShip.setState(Ship.STATE_DAMAGED);

                    eShip.getHit();                    

                }

                if (eShip.getShipState() == 0) {
                    synchronized (enemyShips) {
                        this.enemyShips.remove(eShip);
                    }
                }
            }
            //----collision: enemies vs friendly ship-----
            
            //----collision: player vs enemy bullets-----        
            for (int i = 0; i < this.enemyBullets.size(); i++) {
                Bullet shot = (Bullet) enemyBullets.get(i);
                for (int j = 0; j < this.enemyBullets.size(); j++) {                  
                  if(shot.getY() >= MainMenu.m.getScreenHeight()) {
                      synchronized (enemyBullets) {
                        this.enemyBullets.remove(shot);
                    }
                  }
                  if(currentShip.getShipHitBox().intersects(shot.getHitBox())) {
                      synchronized (enemyBullets) {
                        this.enemyBullets.remove(shot);
                        currentShip.setState(Ship.STATE_DAMAGED);
                      }
                  }
                }                       
            }
            
        } catch (Exception e) {
            System.out.println("Error in collision == Gamedata");
        }
//-----------------------------------------------------------------------------                           
//-----------------------------------------------------------------------------                                       
        //remove objects as follows
        //-------------figures---------------
        List<GameFigure> removeGameFigures = new ArrayList<GameFigure>();
        GameFigure f;

        synchronized (figures) {
            for (int i = 0; i < figures.size(); i++) {
                f = figures.get(i);
                f.update();
                if (f.getState() == GameFigure.STATE_DONE) {
                    removeGameFigures.add(f);
                }
            }
            figures.removeAll(removeGameFigures);
        }
        //-------------figures---------------
        //-------------ships---------------
        List<Ship> removeShips = new ArrayList<Ship>();
        Ship s;

        synchronized (ships) {
            for (int i = 0; i < ships.size(); i++) {
                s = ships.get(i);
                s.update();
//                if (s.getState() == Ship.STATE_FINISHED) {
//                    removeShips.add(s);
//                }
            }
            ships.removeAll(removeShips);
        }
        //-------------ships---------------
        //-------------items---------------
        List<Item> removeItems = new ArrayList<Item>();
        Item it;

        synchronized (items) {
            for (int i = 0; i < items.size(); i++) {
                it = items.get(i);
                it.update();
                if (it.getState() == Item.STATE_DONE) {
                    removeItems.add(it);
                }
            }
            items.removeAll(removeItems);
        }
        //-------------items---------------
        //---------FriendlyBullets-------------
        List<Bullet> removeFriendlyBullets = new ArrayList<Bullet>();
        Bullet bft;

        synchronized (friendlyBullets) {
            for (int i = 0; i < friendlyBullets.size(); i++) {
                bft = friendlyBullets.get(i);
                bft.update();
                if (bft.getState() == Bullet.STATE_DONE) {
                    removeFriendlyBullets.add(bft);
                }
            }
            friendlyBullets.removeAll(removeFriendlyBullets);
        }
        //---------FriendlyBullets-------------
        //-----------EnemyBullets-------------
        List<Bullet> removeEnemyBullets = new ArrayList<Bullet>();
        Bullet bet;

        synchronized (enemyBullets) {
            for (int i = 0; i < enemyBullets.size(); i++) {
                bet = enemyBullets.get(i);
                bet.update();
                if (bet.getState() == Bullet.STATE_DONE) {
                    removeEnemyBullets.add(bet);
                }
            }
            enemyBullets.removeAll(removeEnemyBullets);
        }
        //-----------EnemyBullets-------------
        if(counter != spawnTicker) {
            counter++;
        }
        else {
            counter = 0;
            spawnTicker = rand.nextInt(difficulty);
            spawnEnemiesForTest();
        }
    }
    
    public void clearData() {
        enemyBullets.clear();
        friendlyBullets.clear();
        items.clear();
        figures.clear();
        enemyShips.clear();
    }
}
