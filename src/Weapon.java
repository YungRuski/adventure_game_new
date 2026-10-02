public abstract class Weapon extends Item {


    public Weapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }

    public abstract boolean canUse();

    public abstract void attack();

}

