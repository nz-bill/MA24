public abstract class Enemy {

    int health;

    public Enemy(int health){
        this.health = health;
    }

    public  void takeDamage(int damage){
        this.health -= damage;
    }
}
