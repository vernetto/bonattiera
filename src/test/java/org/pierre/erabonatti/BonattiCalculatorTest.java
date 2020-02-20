package org.pierre.erabonatti;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalField;

import static org.junit.jupiter.api.Assertions.*;

class BonattiCalculatorTest {

    @Test
    void testConvertToNewEra() {
        BonattiCalculator bonattiCalculator = new BonattiCalculator();
        LocalDate mydate1 = LocalDate.of(2020, 02, 18);
        LocalDate result = bonattiCalculator.convertToNewEra(mydate1, BonattiCalculator.BONATTI_DATE);
        assertEquals(65, result.getYear());
        assertEquals(7, result.getMonthValue());
        assertEquals(21, result.getDayOfMonth());

        LocalDate mydate2 = LocalDate.of(1954, 06, 30);
        LocalDate result2 = bonattiCalculator.convertToNewEra(mydate2, BonattiCalculator.BONATTI_DATE);
        assertEquals(-1, result2.getYear());
        assertEquals(12, result2.getMonthValue());
        assertEquals(1, result2.getDayOfMonth());


    }

}