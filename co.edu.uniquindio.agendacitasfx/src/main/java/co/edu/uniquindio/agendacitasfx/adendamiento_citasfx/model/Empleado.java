package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import lombok.Data;

@Data
public class Empleado {
    private String nombre;
    private String apellido;
    private String idEmpleado;
    private Cita citaAsociada;
}
