package fr.lacombedulionvert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Date {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String now() {
        return LocalDate.now().format(DATE_FORMATTER);
    }
}
