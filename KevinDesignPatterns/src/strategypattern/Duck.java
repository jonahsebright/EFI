package strategypattern;

public class Duck {

    private IFlyBehaviour flyBehaviour;
    private IQuackBehaviour iQuackBehaviour;

    public Duck(IFlyBehaviour flyBehaviour, IQuackBehaviour iQuackBehaviour) {
        this.flyBehaviour = flyBehaviour;
        this.iQuackBehaviour = iQuackBehaviour;
    }

    void fly() {
        flyBehaviour.fly();
    }

    void quack() {
        iQuackBehaviour.quack();
    }
}