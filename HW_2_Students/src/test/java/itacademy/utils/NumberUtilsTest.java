package itacademy.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "1.2342, 1.2",
            "0.03, 0.0",
            "0.987, 1.0",
            "-5.657, -5.7",
            "0.45678, 0.5"
    })
    void roundToOneDecimalPlacesTest(double number, double expected) {
        double result = NumberUtils.roundToOneDecimalPlaces(number);
        assertEquals(expected,result);
    }
}