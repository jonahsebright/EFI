package generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {
    @Test
    public void einTest() throws Exception {
        Provider<String> stringProvider = new Provider<String>() {
            @Override
            public String get() {
                return null;
            }
        };

        Provider<Integer> integerProvider = new Provider<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        };
    }
}