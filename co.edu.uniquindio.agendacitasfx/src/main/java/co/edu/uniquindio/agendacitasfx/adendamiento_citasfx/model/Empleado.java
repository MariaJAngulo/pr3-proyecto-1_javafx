package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Empleado {
    private String nombre;
    private String apellido;
    private String idEmpleado;
    private Cita citaAsociada;
}
