import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FirstStepTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/normal.csv", numLinesToSkip = 1)
    public void testCosOnNormalData(double input, double expected){
        Assertions.assertEquals(expected, Math.round(FirstStep.cos(input) * 1000.0) / 1000.0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/wrong.csv", numLinesToSkip = 1)
    public void testCosOnWrongData(double input, double expected){
        Assertions.assertEquals(expected, FirstStep.cos(input));
    }
}
