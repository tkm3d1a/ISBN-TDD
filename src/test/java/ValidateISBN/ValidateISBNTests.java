package ValidateISBN;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTests {

    private static ValidateISBN validateISBN;

    @BeforeAll
    public static void setup() {
        validateISBN = new ValidateISBN();
    }

    @Test
    public void checkISBNLengthIsTenOrThirteen() {
        assertThrows(NumberFormatException.class, () -> validateISBN.checkISBN("12345"));
    }

    @Test
    public void checkISBNIsNumeric() {
        assertThrows(NumberFormatException.class, () -> validateISBN.checkISBN("helloworld"));
    }

    @Test
    public void checkValidISBNTen(){
        boolean result1 = validateISBN.checkISBN("0140449116");
        assertTrue(result1);
    }

    @Test
    public void checkInvalidISBNTen() {
        boolean result = validateISBN.checkISBN("1234567890");
        assertFalse(result);
    }

    @Test
    public void checkValidISBNThirteen() {
        boolean result = validateISBN.checkISBN("9781566199094");
        assertTrue(result);
    }

    @Test
    public void checkInvalidISBNThirteen() {
        boolean result = validateISBN.checkISBN("1234567890123");
        assertFalse(result);
    }

    @Test
    public void checkValidISBNWithX() {
        boolean result = validateISBN.checkISBN("080442957X");
        assertTrue(result);
    }

    @Test
    public void checkInvalidISBNWithX() {
        boolean result = validateISBN.checkISBN("123456789X");
        assertTrue(result);
    }
}
