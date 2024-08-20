package co.edu.uniquindio.agendacitasfx.adendamiento_citasfx.model;
import lombok.Data;

@Data
public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private Cita citaAsociado;

}
