import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegesteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 100_060;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegesteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 100_000_060;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoneregesteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 200_060;
        boolean registered = false;
        long expected = 20;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoneregesteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 200_000_060;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}