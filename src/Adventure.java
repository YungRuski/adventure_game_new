import java.util.ArrayList;

public class Adventure {

    Map map = new Map();
    Room firstRoom = map.getFirstRoom();

    Player player = new Player(firstRoom);


    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goWest() {
        return player.goWest();
    }

    public String lookAround() {
        return player.lookAround();
    }

    public boolean takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public boolean dropItem(String itemName) {
        return player.dropItem(itemName);
    }


    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public ArrayList<Weapon> getEquipped() {
        return player.getEquipped();
    }

    public String printHealth() {
        return player.getHealthDescription();
    }

    public EatResult eat(String itemName) {
        return player.eat(itemName);

    }

    public WeaponEquip equip(String itemName) {
        return player.equip(itemName);
    }

    public int attack(String enemyName) {
        return player.attack(enemyName);
    }

    public int getEnemyHealth() {
        return player.getEnemyHealth();
    }

    public String getEnemyName() {
        return player.getEnemyName();
    }

    public int enemyAttack(){
        return 0;
    }

    public Weapon getEnemyWeapon(){
        return player.getEnemyWeapon();
    }

}
