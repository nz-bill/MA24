import java.util.Random;

public class Player {

    private String name;

    private int health;

    private int damage;

    private Item weapon;

    public Player(String name){
        this.name = name;
        this.health = 100;
        this.damage = 10;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }

    public void attack(Player enemy){

        Random r = new Random();

        int variance = r.nextInt(0,11);
        int totalDamage = this.damage+variance+weapon.getDamage()-enemy.weapon.getArmor();
        if (totalDamage < 1){
            totalDamage = 1;
        }
        enemy.takeDamage(totalDamage);

        System.out.println(this.name + " hits " + enemy.name + " for " + totalDamage + " points of damage");
    }

    public void takeDamage(int damageTaken){
        this.health = this.health - damageTaken;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }
}
