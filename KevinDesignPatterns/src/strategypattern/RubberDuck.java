package strategypattern;

public class RubberDuck implements Duck{
    @Override
    public void fly() {

    }

    @Override
    public void quack() {
        System.out.println("Sqeeking..");
    }
}
