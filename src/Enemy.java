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

    public int attack(){
        return enemyWeapon.attack();
    }

    public void hit(int damage){
        enemyHealth-=damage;

    }
    public int getEnemyHealth(){
        return enemyHealth;
    }
}
