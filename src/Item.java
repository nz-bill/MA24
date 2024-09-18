public class Item {

    private String id;
    private String name;
    private int damage;
    private int armor;
    private int healthBoost;

    public Item(String id, String name, int damage, int armor, int healthBoost) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.armor = armor;
        this.healthBoost = healthBoost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealthBoost() {
        return healthBoost;
    }
}
