public class RangedWeapon extends Weapon{
    int ammunition;

    public RangedWeapon(String itemName, String itemDescription, int ammunition) {
        super(itemName, itemDescription);
        this.ammunition = ammunition;

    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }
    @Override
    public void attack() {
        ammunition--;
        IO.println("POW!");
    }
}
