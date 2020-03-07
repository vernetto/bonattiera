package org.pierre.erabonatti;


import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BonattiCalculator {
    public static final LocalDate BONATTI_DATE = LocalDate.of(1954, 07, 31);
    public static final Map<Integer, String> BONATTI_MONTHS = new ConcurrentHashMap<>();

    public BonattiCalculator() {
        BONATTI_MONTHS.put(1, "Gashembronio");
        BONATTI_MONTHS.put( 2, "Cappuccinio");
        BONATTI_MONTHS.put(3, "Cappaduo");
        BONATTI_MONTHS.put(4, "Petidruo");
        BONATTI_MONTHS.put(5, "Grangiurassico");
        BONATTI_MONTHS.put(6, "Aiguillenoirio");
        BONATTI_MONTHS.put(7, "Freneo");
        BONATTI_MONTHS.put(8, "Nordlavaredio");
        BONATTI_MONTHS.put(9, "Cervinio");
        BONATTI_MONTHS.put(10, "Patagonio");
        BONATTI_MONTHS.put(11, "Yukonio");
        BONATTI_MONTHS.put(12, "Pigmeio");

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

    /**
     * Convert to BonattiEra date an input given as YYYYMMDD
     * @param from the input date (example: 20200221)
     * @return
     */
    public String convertToNewEraAsStringFromString(String from) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate fromDate = LocalDate.parse(from, formatter);
        return convertToNewEraAsString(fromDate);
    }

    private String lookupMonth(int monthValue) {
        return BONATTI_MONTHS.get(monthValue);
    }

}
