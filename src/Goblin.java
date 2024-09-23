public class Goblin extends Enemy implements MeleeUnit, RangedUnit{
    int range;
    public Goblin() {
        super(30);
        this.range = 10;
    }

    @Override
    public void meleeAttack() {
        System.out.println("Goblin performs melee attack!");
    }

    @Override
    public void rangedAttack() {
        System.out.println("Goblin throws a knife");
    }
}
