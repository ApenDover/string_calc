package ts.andrey.calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDigitsTest {

    @Test
    void findFirstVar1() {
        //GIVEN
        final var string = "privet200poka500";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("200", actual);
    }

    @Test
    void findLastVar1() {
        //GIVEN
        final var string = "privet200poka500popa";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("500", actual);
    }

    @Test
    void findFirstVar2() {
        //GIVEN
        final var string = "200*500";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("200", actual);
    }

    @Test
    void findLastVar2() {
        //GIVEN
        final var string = "200*500";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("500", actual);
    }

    @Test
    void findFirstVar3() {
        //GIVEN
        final var string = "200";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("200", actual);
    }

    @Test
    void findLastVar3() {
        //GIVEN
        final var string = "500";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("500", actual);
    }

    @Test
    void findFirstVar4() {
        //GIVEN
        final var string = "50.5";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("50.5", actual);
    }

    @Test
    void findLastVar4() {
        //GIVEN
        final var string = "25.5";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("25.5", actual);
    }

    @Test
    void findFirstVar5() {
        //GIVEN
        final var string = "-5.1";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("-5.1", actual);
    }

    @Test
    void findLastVar5() {
        //GIVEN
        final var string = "-5.1";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("-5.1", actual);
    }

    @Test
    void findFirstVar6() {
        //GIVEN
        final var string = "-0.83333+0.00047";
        //WHEN
        final var actual = FindDigits.findFirst(string);
        //THEN
        assertEquals("-0.83333", actual);
    }

    @Test
    void findLastVar6() {
        //GIVEN
        final var string = "-0.83333+0.00047";
        //WHEN
        final var actual = FindDigits.findLast(string);
        //THEN
        assertEquals("0.00047", actual);
    }

}