public class Murloc extends Enemy implements RangedUnit{

    int range;
    public Murloc() {
        super(50);
        this.range = 50;
    }

    @Override
    public void rangedAttack() {
        System.out.println("Murloc shoots an arrow");
    }


}
