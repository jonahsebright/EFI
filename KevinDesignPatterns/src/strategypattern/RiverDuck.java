package strategypattern;

public class RiverDuck implements Duck{
    @Override
    public void fly() {
        System.out.println("Flying slow");
    }

    @Override
    public void quack() {
        System.out.println("Quacking loud");
    }
}
