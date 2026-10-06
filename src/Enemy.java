public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyWeapon;
    private Room enemyRoom;
    private Player player;


    public Enemy(String enemyName, String enemyDescription, int enemyHealth, Weapon enemyWeapon, Room enemyRoom) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
        this.enemyRoom = enemyRoom;
    }


    public String toString() {
        return enemyName;
    }
    //Attack skal få fat i player, og players liv.
    public int attack() {
        int result = enemyWeapon.attack();
        player.hit(enemyWeapon.getDamage());
        return result;
    }

    public int hit(int damage) {
        return enemyHealth -= damage;

    }

    public int getEnemyHealth() {
        return enemyHealth;
    }
    public String getEnemyName(){
        return enemyName;
    }
}
