package ts.andrey.calculate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void openStaplesVar1() {
        //GIVEN
        final var string = "30-(6+(8-2)*2+2)*2";
        //WHEN
        final var actual = Operation.openStaples(string);
        //THEN
        assertEquals("8-2", actual);
    }

    @Test
    void hardCalculatingVar1() {
        //GIVEN
        final var string = "30-(6+8-2*2+2)*2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("6.0", actual);
    }

    @Test
    void hardCalculatingVar2() {
        //GIVEN
        final var string = "30-(6+(8-2)*2+2)*2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-10.0", actual);
    }

    @Test
    void hardCalculatingVar3() {
        //GIVEN
        final var string = "(32+52/4)+3-((3+4)/7)";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("47.0", actual);
    }

    @Test
    void hardCalculatingVar4() {
        //GIVEN
        final var string = "(-10/2)";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-5.0", actual);
    }

    @Test
    void hardCalculatingVar5() {
        //GIVEN
        final var string = "-1/2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-0.5", actual);
    }

    @Test
    void hardCalculatingVar6() {
        //GIVEN
        final var string = "3+(-1/2)*4";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("1.0", actual);
    }

    @Test
    void hardCalculatingVar7() {
        //GIVEN
        final var string = "-2.5*5+(0.5/3)+3";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-9.33333", actual);
    }

    @Test
    void simpleCalculatingVar1() {
        //GIVEN
        final var string = "5+5+2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("12.0", actual);
    }

    @Test
    void simpleCalculatingVar2() {
        //GIVEN
        final var string = "7-3*2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("1.0", actual);
    }

    @Test
    void simpleCalculatingVar3() {
        //GIVEN
        final var string = "-7";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-7", actual);
    }

    @Test
    void simpleCalculatingVar4() {
        //GIVEN
        final var string = "2*2+2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("6.0", actual);
    }

    @Test
    void simpleCalculatingVar5() {
        //GIVEN
        final var string = "-3/2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-1.5", actual);
    }

    @Test
    void simpleCalculatingVar6() {
        //GIVEN
        final var string = "-3/0.00";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("0.0", actual);
    }

    @Test
    void simpleCalculatingVar7() {
        //GIVEN
        final var string = "0/1";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("0.0", actual);
    }

    @Test
    void simpleCalculatingVar8() {
        //GIVEN
        final var string = "0.30/-2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("-0.15", actual);
    }

    @Test
    void simpleCalculatingVar9() {
        //GIVEN
        final var string = "0.30/2.5";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("0.12", actual);
    }

    @Test
    void calcString() {
        //GIVEN
        final var string = "100+8-2+6/2";
        //WHEN
        final var actual = Operation.calcString(string);
        //THEN
        assertEquals("109.0", actual);
    }

    @Test
    void multiplyAtStringRealCase() {
        //GIVEN
        final var string = "100+8-2+6*2";
        //WHEN
        final var actual = Operation.countAtString(string, '*');
        //THEN
        assertEquals("100+8-2+12.0", actual);
    }

    @Test
    void openStaplesCase() {
        //GIVEN
        final var string = "100+(8-2+6)*2";
        //WHEN
        final var actual = Operation.openStaples(string);
        //THEN
        assertEquals("8-2+6", actual);
    }

    @Test
    void multiplyAtStringGoodCase() {
        //GIVEN
        final var string = "privet2*5popanafig";
        //WHEN
        final var actual = Operation.countAtString(string, '*');
        //THEN
        assertEquals("privet10.0popanafig", actual);
    }

    @Test
    @Disabled
    void multiplyAtStringBadCase() {
        //GIVEN
        final var string = "privet2sd*df5popanafig";
        //WHEN
        final var actual = Operation.countAtString(string, '*');
        //THEN
        assertEquals("10", actual);
    }

    @Test
    void divideAtStringGoodCase() {
        //GIVEN
        final var string = "privet10/5popanafig";
        //WHEN
        final var actual = Operation.countAtString(string, '/');
        //THEN
        assertEquals("privet2.0popanafig", actual);
    }

    @Test
    @Disabled
    void divideAtStringBadCase() {
        //GIVEN
        final var string = "privet10sd/df5popanafig";
        //WHEN
        final var actual = Operation.countAtString(string, '/');
        //THEN
        assertEquals("2", actual);
    }

    @Test
    void SumAtStringGoodCase() {
        //GIVEN
        final var string = "3-privet10+5popanafig-1";
        //WHEN
        final var actual = Operation.countAtString(string, '+');
        //THEN
        assertEquals("3-privet15.0popanafig-1", actual);
    }

    @Test
    @Disabled
    void SumAtStringBadCase() {
        //GIVEN
        final var string = "privet10sd+df5popanafig";
        //WHEN
        final var actual = Operation.countAtString(string, '+');
        //THEN
        assertEquals("15.0", actual);
    }

    @Test
    void countSum() {
        final var actual = Operation.count(5, 2, '+');
        assertEquals("7.0", actual);
    }

    @Test
    void countDif() {
        final var actual = Operation.count(5, 2, '-');
        assertEquals("3.0", actual);
    }

    @Test
    void countMul() {
        final var actual = Operation.count(5, 2, '*');
        assertEquals("10.0", actual);
    }

    @Test
    void countDim() {
        final var actual = Operation.count(6, 2, '/');
        assertEquals("3.0", actual);
    }

    @Test
    void countDimONZero() {
        final var actual = Operation.count(5, 0, '/');
        assertEquals("0.0", actual);
    }

}
