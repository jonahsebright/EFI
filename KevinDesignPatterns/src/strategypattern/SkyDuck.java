package strategypattern;

public class SkyDuck extends Duck{
    public SkyDuck() {
        super(new FastFlyingBehaviour(), new IQuackBehaviour() {
            @Override
            public void quack() {
                System.out.println("Blabber");
            }
        });
    }
}
