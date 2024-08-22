package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter

public class Cita {
    private LocalDate fecha;
    private Cliente ClienteAsociado;
    private Empleado EmpleadoAsociado;
}
