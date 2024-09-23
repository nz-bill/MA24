public class Orc extends Enemy implements MeleeUnit{


    public Orc() {
        super(100);
    }

    @Override
    public void meleeAttack() {
        System.out.println(" Orc performs melee attack");
    }
}
