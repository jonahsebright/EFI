package test;

import main.OtherBaseToDecimalFloatingPointConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherBaseToDecimalFloatingPointConverterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertFloatingPoint() {
        OtherBaseToDecimalFloatingPointConverter converter = new OtherBaseToDecimalFloatingPointConverter(2, 40);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("3", converter.convert("11"));
        Assertions.assertEquals("1.5", converter.convert("1.1"));
        Assertions.assertEquals("1.125", converter.convert("1.001"));
        Assertions.assertEquals("1.75", converter.convert("1.11"));
        Assertions.assertEquals("10.625", converter.convert("1010.101"));

        Assertions.assertEquals("298.6611328125", converter.convert("100101010.10101001010"));

        converter = new OtherBaseToDecimalFloatingPointConverter(16, 20);
        assertEquals("581654483500669133.73634592699727363653", converter.convert("81273ABC71218CD.BC812AAAFF"));
    }

    @Test
    public void limitsNumDecPlacesIfResultWithRecursion() throws Exception {
        OtherBaseToDecimalFloatingPointConverter converter = new OtherBaseToDecimalFloatingPointConverter(3, 4);
        assertEquals("0.3333", converter.convert("0.1"));
        converter.setScale(10);
        assertEquals("0.3333333333", converter.convert("0.1"));
    }
}