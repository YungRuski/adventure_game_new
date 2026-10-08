public class MeleeWeapon extends Weapon {

public MeleeWeapon(String itemName, String itemDescription, int damage){
    super(itemName, itemDescription, damage);
}
@Override
    public boolean canUse(){

    return true;
}
    @Override
    public int attack(){
        return -1;
    }
}
