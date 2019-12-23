package fr.lacombedulionvert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Date {

    String now() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.now().format(formatter);
    }
}
