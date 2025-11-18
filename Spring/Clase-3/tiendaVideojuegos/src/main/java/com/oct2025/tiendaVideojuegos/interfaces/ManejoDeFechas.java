package com.oct2025.tiendaVideojuegos.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ManejoDeFechas {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    default LocalDate formatearFecha(String fecha) {
        LocalDate date = LocalDate.parse(fecha, formatter);
        return date;
    }
}