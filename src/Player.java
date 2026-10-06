import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private final ArrayList<Item> inventory;
    private Item items;
    private int health;
    private final ArrayList<Weapon> equipped;


    public Player(Room firstRoom) {
        this.currentRoom = firstRoom;
        this.inventory = new ArrayList<>();
        this.health = 100;
        this.equipped = new ArrayList<>();
    }

    public String lookAround() {
        if (currentRoom.getItems().isEmpty()) {
            return String.format("""
                    %s
                    %s
                    available items: none
                    %s
                    """, currentRoom.getName(), currentRoom.getDescription(), currentRoom.printEnemies());
        } else {
            return String.format("""
                    %s
                    %s
                    available items: %s
                    %s
                    """, currentRoom.getName(), currentRoom.getDescription(), currentRoom.getItems(), currentRoom.printEnemies());
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        } else {
            return false;
        }
    }

    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        } else {
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        } else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Weapon> getEquipped() {
        return equipped;
    }

    public boolean takeItem(String itemName) {
        Item item = findItemRoom(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            return true;
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        Item item = findItemInventory(itemName);

        if (item != null) {
            if (item instanceof Weapon weapon) {
                equipped.remove(weapon);
            }

            currentRoom.addItem(item);
            inventory.remove(item);
            return true;
        }

        return false;
    }


    public int getHealth() {
        return health;
    }

    public String getHealthDescription() {
        if (health >= 100) {
            return "You have " + health + " hp and is healthy.";
        } else if (health >= 80) {
            return "You have " + health + " hp, try to eat something to gain full health again.";
        } else if (health >= 50) {
            return "You have " + health + " hp, try to find a safe spot and heal up";
        } else if (health >= 30) {
            return "You have " + health + " hp and should avoid fighting.";
        } else if (health >= 1) {
            return "You have " + health + " hp and is close to dying.";
        } else {
            return "You have died";
        }
    }

    public Item findItemInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item findItemRoom(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    public EatResult eat(String itemName) {
        Item item = findItemInventory(itemName);
        if (item instanceof Food food) {
            health += food.getHealthPoints();
            inventory.remove(item);
            return EatResult.EATEN;
        }
        if (item != null) {
            return EatResult.NOT_FOOD;
        } else {
            return EatResult.NOT_FOUND;
        }

    }

    public WeaponEquip equip(String itemName) {
        Item item = findItemInventory(itemName);
        if (item instanceof Weapon weapon) {
            equipped.clear();
            equipped.add(weapon);
            return WeaponEquip.EQUIPPED;
        }
        if (item != null) {
            return WeaponEquip.NO_WEAPON;
        } else {
            return WeaponEquip.CANNOT_ATTACK;
        }

    }

    public int attack(String enemyName) {

        if (equipped.isEmpty()) {
            return -2;
        }
        Weapon weapon = equipped.get(0);

        if (!weapon.canUse()) {
            return 0;
        }
        Enemy enemy = findEnemyRoom(enemyName);
        if (enemy == null) {
            return weapon.attack();
        }

        int result = weapon.attack();
        enemy.hit(weapon.getDamage());
        return result;
    }

    public Enemy findEnemyRoom(String enemyName) {
        for (Enemy enemy : currentRoom.getEnemies()) {
            if (enemy.getEnemyName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    public int getEnemyHealth() {
        Enemy enemy = currentRoom.getEnemies().get(0);
        return enemy.getEnemyHealth();
    }

    public String getEnemyName() {
        Enemy enemy = currentRoom.getEnemies().get(0);
        return enemy.getEnemyName();
    }
}
