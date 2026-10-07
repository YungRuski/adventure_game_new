public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyWeapon;
    private Room enemyRoom;

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
    public int attack(Player player) {
        int result = enemyWeapon.attack();
        int playerHit = player.hit(enemyWeapon.getDamage());
        if(playerHit <= 0){
            return -3;
        }
        return result;
    }

    public int hit(int damage) {
        enemyHealth -= damage;

        if (enemyHealth <= 0) {
            enemyRoom.addItem(enemyWeapon);
            enemyRoom.removeEnemy(this);
        }
        return enemyHealth;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public Weapon getEnemyWeapon(){
        return enemyWeapon;
    }
}
