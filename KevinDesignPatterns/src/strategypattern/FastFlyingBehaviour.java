package strategypattern;

public class FastFlyingBehaviour implements IFlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Flying fast");
    }
}
