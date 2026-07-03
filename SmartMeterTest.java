import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmartMeterTest {

    @Test
    public void testTokenReopensValve() {
        SmartMeter meter = new SmartMeter("M-101", 10.0);
        meter.recordConsumption(1.0); // Exhausts balance
        
        meter.loadToken(500.0);
        assertTrue(meter.isValveOpen(), "Loading a token must re-open the valve.");
    }

    @Test
    public void testOverconsumptionClosesValve() {
        SmartMeter meter = new SmartMeter("M-202", 100.0);
        boolean dispensed = meter.recordConsumption(3.0); // Cost 150 > 100

        assertFalse(dispensed, "Water should not dispense if credit is insufficient.");
        assertFalse(meter.isValveOpen(), "Valve must close on credit exhaustion.");
    }
}