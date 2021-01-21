package strategypattern;

public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck(new IFlyBehaviour() {
            @Override
            public void fly() {

            }
        }, new IQuackBehaviour() {
            @Override
            public void quack() {

            }
        });
    }
}
