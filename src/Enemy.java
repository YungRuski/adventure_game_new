public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyWeapon;
    private Room enemyRoom;
    private Player player;


    public Enemy(String enemyName, String enemyDescription, int enemyHealth, Weapon enemyWeapon){
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
        this.enemyRoom = enemyRoom;
    }


    public String toString(){
        return enemyName;
    }

    public int enemyAttack(){

        return player.getHealth() -= enemyWeapon.attack();
    }

}
