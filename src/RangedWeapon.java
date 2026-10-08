public class RangedWeapon extends Weapon {
    private int ammunition;

    public RangedWeapon(String itemName, String itemDescription, int ammunition, int damage) {
        super(itemName, itemDescription, damage);
        this.ammunition = ammunition;

    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public int attack() {
        if(ammunition == 0){
            return 0;
        }
        return ammunition--;
    }
}
