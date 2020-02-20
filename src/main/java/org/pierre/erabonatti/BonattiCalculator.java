package org.pierre.erabonatti;


import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BonattiCalculator {
    public static final LocalDate BONATTI_DATE = LocalDate.of(1954, 07, 31);
    public static final String[] BONATTI_MONTHS = new String[] {""};

    public BonattiCalculator() {
    }

    public LocalDate convertToNewEra(LocalDate from, LocalDate base) {
        long p2 = ChronoUnit.DAYS.between(base, from);
        Period period = Period.between(base, from);
        LocalDate zero = LocalDate.of(0, 1, 1);
        LocalDate newDate = zero.plusDays(p2);
        return newDate;
    }

    public String convertToNewEraAsString(LocalDate from) {
        LocalDate result = convertToNewEra(from, BONATTI_DATE);
        StringBuilder sb = new StringBuilder();
        sb.append(result.getDayOfMonth() + " " + lookupMonth(result.getMonthValue()) + " " + result.getYear());
        return sb.toString();
    }

    private String lookupMonth(int monthValue) {

    }

}
