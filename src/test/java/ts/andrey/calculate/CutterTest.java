package ts.andrey.calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutterTest {

    @Test
    void cutFirstNonDigits() {
        //GIVEN
        final var string = "privet17";
        //WHEN
        final var actual = Cutter.cutFirstNonDigits(string);
        //THEN
        assertEquals("17", actual);
    }

    @Test
    void cutLastNonDigits() {
        //GIVEN
        final var string = "privet17privet";
        //WHEN
        final var actual = Cutter.cutLastNonDigits(string);
        //THEN
        assertEquals("privet17", actual);
    }

}
